package com.wisenut.search.web.apis;

import com.wisenut.search.domain.application.SearchService;
import com.wisenut.search.web.payload.SearchPayload;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("api/search")
    public ResponseEntity<Map<String, List<Map<String, Object>>>> search(@RequestBody SearchPayload payload) {
        try{
            Map<String, List<Map<String, Object>>> iSearch = searchService.search(payload.toCommand(payload));
            return new ResponseEntity<>(iSearch, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
