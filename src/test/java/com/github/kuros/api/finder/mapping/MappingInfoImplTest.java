package com.github.kuros.api.finder.mapping;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-kuros-api-finder-context.xml")
public class MappingInfoImplTest {

    @Autowired
    private MappingInfo mappingInfo;


    @Test
    public void name() throws Exception {
        mappingInfo.listAll();

    }
}