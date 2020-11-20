package com.wisenut.search.domain.model.search;


import com.wisenut.search.domain.application.commands.SearchCommand;
import com.wisenut.search.domain.model.WNDefine;
import com.wisenut.search.domain.model.WNSearchInfo;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@Getter
public class ApvlSearch implements ISearch {

    private List<Map<String, Object>> result;

    @Override
    public List<Map<String, Object>> search(WNSearchInfo wnSearchInfo, SearchCommand command) {
        result = new ArrayList<>();
        String[] documentFields = wnSearchInfo.getCollectionInfoValue("apvl", WNDefine.RESULT_FIELD).split(",");
        int count = wnSearchInfo.getResultCount("apvl");
        int thisTotalCount = wnSearchInfo.getResultTotalCount("apvl");
        if (thisTotalCount > 0) {
            for (int i = 0; i < count; i++) {
                Map<String,Object> document = new HashMap<>();
                for(String value : documentFields) {
                    document.put(value,wnSearchInfo.getField("apvl", value, i ,false));
                }
                result.add(document);
            }
        }

        return result;
    }
}
