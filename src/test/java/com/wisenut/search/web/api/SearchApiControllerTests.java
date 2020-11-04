package com.wisenut.search.web.api;

import com.wisenut.search.domain.application.SearchService;
import com.wisenut.search.utils.JsonUtils;
import com.wisenut.search.web.apis.SearchApiController;
import com.wisenut.search.web.payload.SearchPayload;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {SearchApiController.class})
@WebMvcTest
public class SearchApiControllerTests {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private SearchService searchServiceMock;

    @Test
    public void search_validPayload_shoudSuccessAndReturn201() throws Exception {
        SearchPayload payload = new SearchPayload();
        payload.setStartCount(0);
        payload.setMode("");
        payload.setSort("DATE");
        payload.setCollection("ALL");
        payload.setRange("");
        payload.setStartDate("");
        payload.setEndDate("");
        payload.setSearchField("");
        payload.setReQuery("2");
        payload.setRealQuery("");
        payload.setPrintView("");
        payload.setExquery("");
        payload.setQuery("검색");
        payload.setPaging("");
        payload.setListCount(3);

        when(searchServiceMock.search(payload.toCommand(payload)))
                .thenReturn(new ArrayList<>());

        mvc.perform(
                post("/api/search")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtils.toJson(payload))
        ).andExpect(status().is(200))
                .andDo(print());

    }
}
