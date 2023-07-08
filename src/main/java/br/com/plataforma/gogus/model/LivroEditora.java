package br.com.plataforma.gogus.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "livro_editora")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class LivroEditora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLIVRO_EDITORA;

    @ManyToOne
    @JoinColumn(name = "livro_isbn", nullable = false)
    private Livro livro;

    @ManyToOne
    private Editora idEditora;


}
