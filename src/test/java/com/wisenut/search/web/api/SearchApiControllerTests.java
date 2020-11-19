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
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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
        payload.setQuery("test");
        payload.setCollection("apvl");

        Map<String, List<Map<String, Object>>> result = new HashMap<>();
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String,Object> temp = new HashMap<>();
        temp.put("DOCID","1234");
        temp.put("Content","test");
        list.add(temp);
        result.put("apvl", list);

        // given
        given(searchServiceMock.search(payload.toCommand(payload))).willReturn(result);


        // when
        final ResultActions actions = mvc.perform(
                get("/api/search")
                .contentType(MediaType.APPLICATION_JSON)
                //.param(JsonUtils.toJson(payload))
                .content(JsonUtils.toJson(payload))
        ).andExpect(status().is(200))
                .andDo(print());

        // then
        actions
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                //.andExpect(jsonPath("$.DOCID", is("1234")))
                .andDo(print());
    }
}
