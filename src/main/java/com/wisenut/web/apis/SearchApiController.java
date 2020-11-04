package com.wisenut.web.apis;

import com.wisenut.domain.ISearch;
import com.wisenut.domain.application.SearchService;
import com.wisenut.domain.common.WNSearchInfo;
import com.wisenut.web.payload.SearchPayload;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class SearchApiController {

    private final SearchService searchService;

    public SearchApiController(SearchService searchService) {
        this.searchService = searchService;
    }

    @PostMapping("api/search")
    public ResponseEntity<List<Map<String, Object>>> search(@RequestBody SearchPayload payload) {
        try{
            List<Map<String, Object>> iSearch = searchService.search(payload.toCommand(payload));
            return new ResponseEntity<>(iSearch, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
