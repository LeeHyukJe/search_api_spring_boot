package com.wisenut.search.domain.application;

import com.wisenut.search.domain.application.commands.SearchCommand;

import java.util.List;
import java.util.Map;

public interface SearchService {

    Map<String, List<Map<String, Object>>> search(SearchCommand command);
}
