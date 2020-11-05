package com.wisenut.search.domain.model;


import com.wisenut.search.domain.ISearch;
import com.wisenut.search.domain.application.commands.SearchCommand;
import com.wisenut.search.domain.common.WNDefine;
import com.wisenut.search.domain.common.WNSearchInfo;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@Getter
public class ApvlSearch implements ISearch {

    private List<Map<String, Object>> result;

    @Override
    public List<Map<String, Object>> search(WNSearchInfo wnSearchInfo, SearchCommand command) {
        List<Map<String, Object>> list = new ArrayList<>();
        String[] documentFields = wnSearchInfo.getCollectionInfoValue("apvl", WNDefine.RESULT_FIELD).split(",");
        int count = wnSearchInfo.getResultCount("apvl");
        int thisTotalCount = wnSearchInfo.getResultTotalCount("apvl");
        if (thisTotalCount > 0) {
            for (int i = 0; i < count; i++) {
                Map<String,Object> result = new HashMap<>();
                for(String value : documentFields) {
                    result.put(value,wnSearchInfo.getField("apvl", value, i ,false));
                }
                list.add(result);
            }
        }

        return result = list;
    }
}
