package narif.lp.openbanking.integration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class TestControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Given an account number, return the list of all transactions associated with it.")
    public void testGetAllTransactions() throws Exception {
        final long accNumber = 123456789l;
        mockMvc.perform(MockMvcRequestBuilders.get("/transactions/"+accNumber))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }
}
