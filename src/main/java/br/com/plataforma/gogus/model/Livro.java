package br.com.plataforma.gogus.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "livro")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLivro;

    @NotBlank
    @Size(max = 13)
    private String isbn;

    @NotBlank
    @Size(max = 100)
    private String titulo;

    @Size(max = 100)
    private String subtitulo;

    @NotNull
    private Integer edicao;

    @OneToMany
    private List<Autor> autores = new ArrayList<>();

    private void adicionarAutor(AutorLivro autor){
        autor.setLivro(this);
        this.autores.add(autor.getAutorIdautor());
    }

    /*@Enumerated(EnumType.STRING)
    @NotNull
    private Genero genero;*/

    /*@NotNull
    @OneToMany
    @JoinColumn(name = "idAutor")
    /*@JoinTable(
            name = "autor_livro",
            joinColumns = {@JoinColumn(name = "codigo_livro", referencedColumnName = "LIVRO_ISBN")},
            inverseJoinColumns = {@JoinColumn(name = "codigo_autor", referencedColumnName = "AUTOR_idAutor")})*/
    //private List<Autor> autores;
    //private Set<Autor> autor = new HashSet<>();




    /*@NotNull
    @ManyToOne
    @JoinTable(name = "livro_editora",
        joinColumns = {@JoinColumn(name = "livro_isbn")},
        inverseJoinColumns = {@JoinColumn(name = "ideditora")})
    private Editora editora;*/


}
