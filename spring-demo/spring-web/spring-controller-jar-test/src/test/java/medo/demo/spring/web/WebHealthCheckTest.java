package medo.demo.spring.web;

import medo.demo.spring.web.controller.WebHealthCheckController;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebHealthCheckTest {

    private MockMvc mockMvc;

    @Before
    public void setUp(){

        mockMvc = MockMvcBuilders.standaloneSetup(new WebHealthCheckController()).build();
    }

    @Test
    public void testWeb() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/demo/web/health"))
                .andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        Assert.assertTrue("hello web!".equals(result));
    }

}
