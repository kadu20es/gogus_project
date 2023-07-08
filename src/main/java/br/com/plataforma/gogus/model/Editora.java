package br.com.plataforma.gogus.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.ComponentScan;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "editora")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Editora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEditora")
    private Long id;

    @NotBlank
    @Size(max = 45)
    private String nome;

}
