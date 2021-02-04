package test.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import test.TestApplication;

@AutoConfigureMockMvc
@SpringBootTest(classes = TestApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles
public class DomainApiIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void test() throws Exception {
        String result = mockMvc.perform(get("/v3/api-docs/") //
                .contentType(MediaType.APPLICATION_JSON)) //
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
        System.out.println(result);
    }

}
