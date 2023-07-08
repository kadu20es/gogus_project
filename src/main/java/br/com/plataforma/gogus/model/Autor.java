package br.com.plataforma.gogus.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "autor")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAutor;

    @NotBlank
    @Size(max = 20)
    private String nome;

    @NotBlank
    @Size(max = 60)
    private String sobrenome;

    @OneToMany(mappedBy = "autorIdautor")
    private List<AutorLivro> autores = new ArrayList<>();


}
