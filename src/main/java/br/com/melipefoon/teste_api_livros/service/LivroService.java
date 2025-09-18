package br.com.melipefoon.teste_api_livros.service;

import br.com.melipefoon.teste_api_livros.model.Livro;
import br.com.melipefoon.teste_api_livros.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LivroService {
    
    //injeção de dependência
    @Autowired
    private LivroRepository livroRepository;

    //acessa a base usando o livroRepository
    //save é um método que foi implementado automaticamente
    //ele faz um insert numa vase relacional
    public void salvar(Livro livro) {
        this.livroRepository.save(livro);
    }

    //findAll é um método que foi implementado automaticamente
    //ele faz um SELECT * numa base relacional
    public List<Livro> listar() {
        return this.livroRepository.findAll();
    }

    public double precoMedio() {
        return 
            this.listar()
            .stream()
            .mapToDouble(Livro::getPreco)
            .average()
            .getAsDouble();
    }
}
