package br.com.melipefoon.teste_api_livros.repository;

import br.com.melipefoon.teste_api_livros.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository <Livro, Long> {}
