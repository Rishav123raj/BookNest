import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@SpringBootTest
@AutoConfigureMockMvc
public class AuthControllerTest {

    @Autowired private MockMvc mockMvc;

    @Test
    public void testSuccessfulRegistration() throws Exception {
        mockMvc.perform(post("/auth/register")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\"name\":\"John\",\"email\":\"john@example.com\",\"password\":\"pass\"}"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.email").value("john@example.com"));
    }

    @Test
    public void testDuplicateRegistration() throws Exception {
        String user = "{\"name\":\"John\",\"email\":\"john@example.com\",\"password\":\"pass\"}";
        mockMvc.perform(post("/auth/register").contentType(MediaType.APPLICATION_JSON).content(user));
        mockMvc.perform(post("/auth/register").contentType(MediaType.APPLICATION_JSON).content(user))
            .andExpect(status().is5xxServerError());
    }

    @Test
    public void testSuccessfulLogin() throws Exception {
        mockMvc.perform(post("/auth/register")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\"name\":\"John\",\"email\":\"john2@example.com\",\"password\":\"pass\"}"));

        mockMvc.perform(post("/auth/login")
            .param("email", "john2@example.com")
            .param("password", "pass"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.email").value("john2@example.com"));
    }

    @Test
    public void testInvalidLogin() throws Exception {
        mockMvc.perform(post("/auth/login")
            .param("email", "unknown@example.com")
            .param("password", "wrong"))
            .andExpect(status().is5xxServerError());
    }
}
