package br.com.melipefoon.teste_api_livros;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.AssertionsForClassType.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ConteudoRaizTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void textoraizTest() throws Exception {
        assertThat(
                testRestTemplate.getForObject(
                    String.format(
                        "http://localhost:%d",
                        port
                    ),
                    //devolve string
                    String.class
                )
        ).contains("Salve");
    }
}
