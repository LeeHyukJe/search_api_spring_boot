package com.wisenut.domain;

import com.wisenut.domain.application.commands.SearchCommand;
import com.wisenut.domain.common.WNSearchInfo;

import java.util.List;
import java.util.Map;

public interface ISearch {

    List<Map<String, Object>> search(WNSearchInfo wnSearchInfo, SearchCommand command);
}
