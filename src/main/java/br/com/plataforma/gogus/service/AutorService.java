package br.com.plataforma.gogus.service;

import br.com.plataforma.gogus.dto.AutorDTO;
import br.com.plataforma.gogus.model.Autor;
import br.com.plataforma.gogus.repository.AutorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AutorService {

    @Autowired
    private AutorRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public List<AutorDTO> obterTodos(){
        return repository
                .findAll()
                .stream()
                .map(p -> modelMapper.map(p, AutorDTO.class))
                .collect(Collectors.toList());
    }

    public AutorDTO obterPorId(Long id){
        Autor autor = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Autor não cadastrado"));

        return modelMapper.map(autor, AutorDTO.class);
    }

    /*public AutorDTO porPorNome(String nome){
        Autor autor = repository.findBy()
    }*/

    public AutorDTO cadastrarAutor(AutorDTO dto){
        Autor autor = modelMapper.map(dto, Autor.class);
        repository.save(autor);

        return modelMapper.map(autor, AutorDTO.class);
    }

    public AutorDTO atualizarAutor(Long id, AutorDTO dto){
        Autor autor = modelMapper.map(dto, Autor.class);
        autor = repository.save(autor);

        return modelMapper.map(autor, AutorDTO.class);
    }

    public void exluirAutor(Long id) { repository.deleteById(id); }


}
