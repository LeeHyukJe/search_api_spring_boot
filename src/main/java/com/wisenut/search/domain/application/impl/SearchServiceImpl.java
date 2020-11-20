package com.wisenut.search.domain.application.impl;

import com.wisenut.search.domain.application.SearchService;
import com.wisenut.search.domain.application.commands.SearchCommand;
import com.wisenut.search.domain.model.WNSearchInfo;
import com.wisenut.search.domain.model.search.SearchManagement;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SearchServiceImpl implements SearchService {
    public SearchManagement searchManagement;

    public SearchServiceImpl(SearchManagement searchManagement) {
        this.searchManagement = searchManagement;
    }
    @Override
    public Map<String, List<Map<String, Object>>> search(SearchCommand command) {
        // TODO command 파라미터는 domain 영역과 분리되도록 수정할 것!
        WNSearchInfo info = searchManagement.setting(command);
        Map<String, List<Map<String, Object>>> result = searchManagement.doSearch(info, command);
        return result;
    }
}
