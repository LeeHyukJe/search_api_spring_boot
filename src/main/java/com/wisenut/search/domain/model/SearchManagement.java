package com.wisenut.search.domain.model;

import com.wisenut.search.domain.ISearch;
import com.wisenut.search.domain.application.commands.SearchCommand;
import com.wisenut.search.domain.common.WNCollection;
import com.wisenut.search.domain.common.WNDefine;
import com.wisenut.search.domain.common.WNSearchInfo;
import com.wisenut.search.domain.common.security.SecurityCheck;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class SearchManagement {

    public static int TOTALVIEWCOUNT = 5; // 통합검색시 기본적으로 보여주는 갯
    public static int COLLECTIONVIEWCOUNT = 3; // 컬렉션 검색시 기본적으로 보여주는 갯수

    public WNSearchInfo searchInfo;

    public String START_DATE = "1970.01.01"; //

    public int totalCount = 0;
    public int startCount = 0;

    public String strOperation = "";

    // 실시간 검색어 화면 출력 여부 체크
    public boolean isRealTimeKeyword = false;

    // 오타 후 추천 검색어 화면 출력 여부 체크
    public boolean useSuggestedQuery = true;
    public String suggestQuery = "";

    // 디버깅 보기 설정
    public boolean isDebug = true;

    List<ISearch> searchTargetList;

    public SearchManagement(List<ISearch> searchTargetList) {
        this.searchTargetList = searchTargetList;
    }

    public WNSearchInfo setting(SearchCommand value){
        String[] searchFields = null;
        if (value.getSearchField() != null)
            searchFields = value.getSearchField().split(",");



        String[] collections = null;

        if (value.getCollection().equals("ALL")) {
            collections = WNCollection.COLLECTIONS;
        } else {
            collections = new String[] { value.getCollection() };
        }



        //wnsearch = new WNSearch(isDebug, false, collections, searchFields);
        searchInfo = new WNSearchInfo.WNSearchBuilder().isDebug(isDebug).isUidSrch(false).collections(collections).searchFields(searchFields).Build();

        int viewResultCount = value.getListCount();

        if (value.getCollection().equals("ALL") || value.getCollection().equals(""))
            viewResultCount = TOTALVIEWCOUNT;

        for (int i = 0; i < collections.length; i++) {

            searchInfo.setCollectionInfoValue(collections[i], WNDefine.PAGE_INFO, value.getStartCount() + "," + viewResultCount);

            if (!value.getQuery().equals("")) {
                searchInfo.setCollectionInfoValue(collections[i], WNDefine.SORT_FIELD, value.getSort() + "/DESC");
                //wnSearchInfo.setCollectionInfoValue(collections[i], WNDefine.SORT_FIELD, "RANK/DESC");
            } else {
                searchInfo.setCollectionInfoValue(collections[i], WNDefine.DATE_RANGE,
                        START_DATE.replaceAll("[.]", "/") + ",2030/01/01,-");
                searchInfo.setCollectionInfoValue(collections[i], WNDefine.SORT_FIELD, "DATE/DESC");
            }

            // searchField 값이 있으면 설정, 없으면 기본검색필드
            if (!value.getSearchField().equals("") && value.getSearchField().indexOf("ALL") == -1) {
                searchInfo.setCollectionInfoValue(collections[i], WNDefine.SEARCH_FIELD, value.getSearchField());
            }

            // operation 설정
            if (!strOperation.equals("")) {
                searchInfo.setCollectionInfoValue(collections[i], WNDefine.FILTER_OPERATION, strOperation);
            }

            // exquery 설정
            if (!value.getExquery().equals("")) {
                searchInfo.setCollectionInfoValue(collections[i], WNDefine.EXQUERY_FIELD, value.getExquery());
            }
            // 기간 설정 , 날짜가 모두 있을때
            if (!value.getStartDate().equals("") && !value.getEndDate().equals("")) {
                searchInfo.setCollectionInfoValue(collections[i], WNDefine.DATE_RANGE,
                        value.getStartDate().replaceAll("[.]", "/") + "," + value.getEndDate().replaceAll("[.]", "/")
                                + ",-");
            }
        }
        System.out.println("현재VO " + value.toString());
        searchInfo.search(value.getRealQuery(), isRealTimeKeyword, WNDefine.CONNECTION_CLOSE, useSuggestedQuery);

        String debugMsg = searchInfo.printDebug() != null ? searchInfo.printDebug().trim() : "";
        System.out.println(debugMsg);

//		if (!value.getCollection().equals("ALL")) {
//			String paging = wnSearchInfo.getPageLinks(wnSearchInfo, 10, 10, 10);
//			value.setPaging(paging);
//		}

        return searchInfo;
    }

    @SecurityCheck
    public Map<String, List<Map<String, Object>>> doSearch(WNSearchInfo searchInfo, SearchCommand command) {

        String[] collections = command.getCollection().split(",");
        Map<String, List<Map<String, Object>>> result = new HashMap<>();

        // 통합검색이 아닐경우
        if(!command.getCollection().equals("ALL")){
            for(String collection: collections) {
               for(ISearch iSearch : searchTargetList) {
                   if(iSearch.getClass().getName().toUpperCase().endsWith(collection.toUpperCase()+"SEARCH")){
                       result.put(collection,iSearch.search(searchInfo,command));
                   }
               }
            }
            return result;
         // 통합검색일 경우
        }else {
            for(int i=0; i<searchTargetList.size();i++) {
                result.put(WNCollection.COLLECTIONS[i], searchTargetList.get(i).search(searchInfo,command));
            }
            return result;
        }
    }
}
