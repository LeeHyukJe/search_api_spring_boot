package com.wisenut.search.domain.application.impl;

import com.wisenut.search.domain.ISearch;
import com.wisenut.search.domain.application.SearchService;
import com.wisenut.search.domain.application.commands.SearchCommand;
import com.wisenut.search.domain.common.WNSearchInfo;
import com.wisenut.search.domain.model.SearchManagement;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SearchServiceImpl implements SearchService {
    public SearchManagement searchManagement;
    public ISearch iSearch;

    public SearchServiceImpl(SearchManagement searchManagement, ISearch iSearch) {
        this.searchManagement = searchManagement;
        this.iSearch = iSearch;
    }
    @Override
    public List<Map<String, Object>> search(SearchCommand command) {
        WNSearchInfo info = searchManagement.setting(command);
        List<Map<String, Object>> result = searchManagement.doSearch(info, command);
        return result;
    }
}
