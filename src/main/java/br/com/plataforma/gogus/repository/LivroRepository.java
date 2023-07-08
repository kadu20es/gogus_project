package br.com.plataforma.gogus.repository;

import br.com.plataforma.gogus.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LivroRepository extends JpaRepository<Livro, Long> {

}