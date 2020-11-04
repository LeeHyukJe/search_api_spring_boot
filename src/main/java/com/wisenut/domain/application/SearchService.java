package com.wisenut.domain.application;

import com.wisenut.domain.ISearch;
import com.wisenut.domain.application.commands.SearchCommand;
import com.wisenut.domain.common.WNSearchInfo;

import java.util.List;
import java.util.Map;

public interface SearchService {

    List<Map<String, Object>> search(SearchCommand command);
}
