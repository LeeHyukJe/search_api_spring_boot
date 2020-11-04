package com.wisenut.search.application.impl;

import com.wisenut.search.domain.model.SearchManagement;
import org.junit.Before;

import static org.mockito.Mockito.mock;

public class SearchServiceImplTests {

    private SearchManagement searchManagementMock;

    @Before
    public void setup(){
        searchManagementMock = mock(SearchManagement.class);
    }


}
