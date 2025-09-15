package br.com.melipefoon.teste_api_livros;

import br.com.melipefoon.teste_api_livros.controller.HomeController;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class TesteApiLivrosApplicationTests {

    @Autowired
    private HomeController homeController;
    @Test
    void contexLoads() {
        assertThat(homeController).isNotNull();
    }


	@Test
	void contextLoads() {
	}

}
