package br.com.plataforma.gogus.repository;

import br.com.plataforma.gogus.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}
