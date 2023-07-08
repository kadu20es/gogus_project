package br.com.plataforma.gogus.dto;

import br.com.plataforma.gogus.model.Autor;
import br.com.plataforma.gogus.model.Editora;
import br.com.plataforma.gogus.model.Genero;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LivroDTO {

    private Long id;
    private String isbn;
    private String titulo;
    private String subtitulo;
    private Integer edicao;
    private Autor autor;
    private Genero genero;
    private Editora editora;

}
