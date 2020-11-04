package com.wisenut.search.domain.model;

import com.wisenut.search.domain.ISearch;
import com.wisenut.search.domain.application.commands.SearchCommand;
import com.wisenut.search.domain.common.WNSearchInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoardSearch implements ISearch {
    private List<Map<String, Object>> result;

    @Override
    public List<Map<String, Object>> search(WNSearchInfo wnSearchInfo, SearchCommand command) {
        List<Map<String, Object>> list = new ArrayList<>();
        int count = wnSearchInfo.getResultCount(command.getCollection());
        int thisTotalCount = wnSearchInfo.getResultTotalCount(command.getCollection());
        if (thisTotalCount > 0) {
            for (int i = 0; i < count; i++) {
                Map<String,Object> result = new HashMap<>();

                list.add(result);
            }
        }

        return result = list;
    }
}