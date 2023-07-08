package br.com.plataforma.gogus.dto;

import br.com.plataforma.gogus.model.AutorLivro;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class AutorDTO {

    private Long idAutor;
    private String nome;
    private String sobrenome;
    //private List<AutorLivro> autores = new ArrayList<>();

}
