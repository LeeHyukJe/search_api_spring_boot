package com.wisenut.domain.application.impl;

import com.wisenut.domain.ISearch;
import com.wisenut.domain.application.SearchService;
import com.wisenut.domain.application.commands.SearchCommand;
import com.wisenut.domain.common.WNSearchInfo;
import com.wisenut.domain.model.SearchManagement;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SearchServiceImpl implements SearchService {
    public WNSearchInfo searchInfo;
    public SearchManagement searchManagement;
    public ISearch iSearch;

    public SearchServiceImpl(WNSearchInfo wnSearchInfo, SearchManagement searchManagement, ISearch iSearch) {
        this.searchInfo = wnSearchInfo;
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
