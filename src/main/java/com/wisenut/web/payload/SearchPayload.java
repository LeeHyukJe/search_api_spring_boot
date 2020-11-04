package com.wisenut.web.payload;

import com.wisenut.domain.application.commands.SearchCommand;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SearchPayload {

    private int startCount;
    private String mode;
    private String sort;
    private String collection;
    private String range;
    private String startDate;
    private String endDate;
    private String searchField;
    private String reQuery;
    private String realQuery;
    private String printView;
    private String exquery;
    private String query;
    private String paging;
    private int listCount;

    public SearchPayload() {
        this.startCount = 0;
        this.mode = "";
        this.sort = "DATE";
        this.collection = "ALL";
        this.range = "";
        this.startDate = "";
        this.endDate = "";
        this.searchField = "";
        this.reQuery = "2";
        this.realQuery = "";
        this.printView = "";
        this.exquery = "";
        this.query = "";
        this.paging = "";
        this.listCount=3;
    }

    public SearchCommand toCommand(SearchPayload payload) {
        if (payload.getReQuery().equals("1")) {
            this.realQuery = payload.getQuery() + " " + payload.getRealQuery();
        } else if (payload.getReQuery().equals("2")) {
            this.realQuery = payload.getQuery();
        }

        return new SearchCommand(this.startCount, this.mode,this.sort, this.collection, this.range, this.startDate, this.endDate,this.searchField, this.reQuery,
                this.realQuery, this.printView, this.exquery, this.query, this.paging, this.listCount);

    }

}
