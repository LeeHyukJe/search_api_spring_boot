package com.wisenut.search.domain;

import com.wisenut.search.domain.application.commands.SearchCommand;
import com.wisenut.search.domain.common.WNSearchInfo;

import java.util.List;
import java.util.Map;

public interface ISearch {

    List<Map<String, Object>> search(WNSearchInfo wnSearchInfo, SearchCommand command);
}
