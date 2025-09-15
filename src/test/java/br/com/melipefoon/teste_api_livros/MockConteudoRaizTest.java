package br.com.melipefoon.teste_api_livros;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.cotainsString;

import static org.springframework.test.web.servlet.request.mockmvcrequestbuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MockContentRaizTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void textoRaizTest() throws Exception {
        mockMvc
        //realiza a requesição
        .perform(
            get("/")
        )
        //exive detalher
        .andDo(print())
        //verifica se o status é igual a 200
        .andExpect(status().isOk())
        //verifica se o corpo da resposta contém a palavra Salve
        .andExpect(content().string(containsString("Salve")));
    }
}
