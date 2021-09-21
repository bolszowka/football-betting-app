package com.example.footballbettingapp.matches;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class MatchControllerTestIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldCreateMatch() throws Exception {
        CreateMatchDto request = CreateMatchDto.builder()
            .homeTeam("Germany")
            .awayTeam("Brazil")
            .build();

        MockHttpServletResponse response = mockMvc.perform(post("/match")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
            .andExpect(status().isCreated())
            .andReturn().getResponse();

        assertThat(response.getContentAsString(), is(notNullValue()));
    }

    @Test
    void shouldGetMatchDetails() throws Exception {
        CreateMatchDto request = CreateMatchDto.builder()
            .homeTeam("Germany")
            .awayTeam("Brazil")
            .build();

        String matchId = mockMvc.perform(post("/match")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
            .andReturn().getResponse().getContentAsString();

        mockMvc.perform(get("/match/" + matchId))
            .andExpect(status().isOk())
            .andExpect(jsonPath("homeTeam", is("Germany")))
            .andExpect(jsonPath("awayTeams", is("Brazil")));
    }
}