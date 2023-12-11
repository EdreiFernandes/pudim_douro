//package br.com.mountainfortress.pudimdouroapi;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.hamcrest.Matchers.containsString;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//class PudimDouroApiApplicationTests {
//
//	@Autowired
//	private MockMvc mockMvc;
//
//	@Test
//	void contextLoads() throws Exception {
//		String url = "/api/scoreboard";
//
//		this.mockMvc
//				.perform(get(url))
//				.andDo(print())
//				.andExpect(status().isOk())
//				.andExpect(content().string(containsString("silver_medal")));
//	}
//}
