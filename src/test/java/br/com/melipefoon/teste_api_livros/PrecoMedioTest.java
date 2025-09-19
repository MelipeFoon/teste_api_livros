package br.com.melipefoon.teste_api_livros;

import br.com.melipefoon.teste_api_livros.model.Livro;
import br.com.melipefoon.teste_api_livros.service.LivroService;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PrecoMedioTest {

    //para simular as requisições
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void test() throws Exception {
        //construção dos dois livros
        Livro l1 = new Livro(1l, "Livro1", "Fulano1", 1, 200);
        Livro l2 = new Livro(2l, "Livro2", "Fulano2", 2, 300);

        //valor esperado
        double valorMedioEsperado = 250;

        //usando a biblioteca JACKSON para converter de objeto Java para JSON textual
        ObjectWriter objectWriter = new ObjectMapper().writer();

        //armazenando o primeiro livro
        mockMvc.perform(
            MockMvcRequestBuilders
            .post("/livros/salvar")
            //observe como o método writeValueAsString converte o objeto Java para JSON
            .content(objectWriter.writeValueAsString(l1))
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
        )
        .andExpect(status().isOk());

        //armazenando o segundo livro
        mockMvc.perform(
            MockMvcRequestBuilders
            .post("/livros/salvar", l2)
            .content(objectWriter.writeValueAsString(l2))
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
        )
        .andExpect(status().isOk());
        //obtendo o valor médio
        mockMvc
        //realiza a requisição
        .perform(
                get("/livros/precoMedio")
        )
        //isOk: 200 OK
        .andExpect(status().isOk())
        //comparando o resultado obtido com o resultado esperado
.andExpect(content().string(containsString(Double.toString(valorMedioEsperado))));
    }
}





        

