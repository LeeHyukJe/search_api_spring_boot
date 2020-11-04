package com.wisenut.domain.application.commands;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
public class SearchCommand {
    private final int startCount;
    private final String mode;
    private final String sort;
    private final String collection;
    private final String range;
    private final String startDate;
    private final String endDate;
    private final String searchField;
    private final String reQuery;
    private final String realQuery;
    private final String printView;
    private final String exquery;
    private final String query;
    private final String paging;
    private final int listCount;


}
