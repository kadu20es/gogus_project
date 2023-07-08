package br.com.plataforma.gogus.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "autor_livro")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AutorLivro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAutor_livro")
    private Long idAutorLivro;

    @ManyToOne
    @JoinColumn(name = "livro_isbn", nullable = false)
    private Livro livro;

    @ManyToOne
    private Autor autorIdautor;

}
