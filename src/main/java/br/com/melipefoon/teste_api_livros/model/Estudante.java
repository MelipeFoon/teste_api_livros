package br.com.melipefoon.teste_api_livros.model;

import br.com.melipefoon.teste_api_livros.model.Pessoa;

import lombok.*;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//construtor padrão
@NoArgsConstructor
//construtor com todos os parâmetros, na ordem de declaração
@AllArgsConstructor
//quando aplicados a uma classe 
//geram getters/setters para todos os campos não marcados como static
@Getter
@Setter
@Entity
public class Estudante implements Pessoa {
    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private String sobrenome;
    private int idade;

    public void algumaCoisa(){
        System.out.println("Alguma coisa.");
    }
}