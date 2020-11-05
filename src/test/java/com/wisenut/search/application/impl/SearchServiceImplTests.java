package com.wisenut.search.application.impl;

import com.wisenut.search.domain.application.commands.SearchCommand;
import com.wisenut.search.domain.application.impl.SearchServiceImpl;
import com.wisenut.search.domain.common.WNSearchInfo;
import com.wisenut.search.domain.model.SearchManagement;
import com.wisenut.search.web.payload.SearchPayload;
import lombok.extern.log4j.Log4j2;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Log4j2
public class SearchServiceImplTests {

    private SearchManagement searchManagementMock;
    private SearchServiceImpl instance;

    @Before
    public void setup(){
        searchManagementMock = mock(SearchManagement.class);
        instance = new SearchServiceImpl(searchManagementMock);
    }

    @Test
    public void searchManagement_should_success_And_return_list() throws Exception {
        SearchPayload payload = new SearchPayload();
        payload.setStartCount(0);
        payload.setMode("");
        payload.setSort("DATE");
        payload.setCollection("ALL");
        payload.setRange("");
        payload.setStartDate("");
        payload.setEndDate("");
        payload.setSearchField("");
        payload.setReQuery("2");
        payload.setRealQuery("");
        payload.setPrintView("");
        payload.setExquery("");
        payload.setQuery("검색");
        payload.setPaging("");
        payload.setListCount(3);

        String[] collections = new String[] {"apvl"};
        WNSearchInfo searchInfo = new WNSearchInfo.WNSearchBuilder().isDebug(false).isUidSrch(false).collections(collections).searchFields(null).Build();

        Map<String, List<Map<String, Object>>> result = new HashMap<>();
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String,Object> temp = new HashMap<>();
        temp.put("DOCID","1234");
        temp.put("Content","test");
        list.add(temp);

        result.put("sample", list);

        SearchCommand command = new SearchCommand(payload.getStartCount(), payload.getMode(), payload.getSort(), payload.getCollection()
                ,payload.getRange(), payload.getStartDate(), payload.getEndDate(), payload.getSearchField(), payload.getReQuery(),
                payload.getRealQuery(), payload.getPrintView(), payload.getExquery(),payload.getQuery(), payload.getPaging(), payload.getListCount());

        when(searchManagementMock.doSearch(searchInfo, payload.toCommand(payload))).thenReturn(result);



        log.info("@@@search list....  "+instance.search(command));
    }

}
