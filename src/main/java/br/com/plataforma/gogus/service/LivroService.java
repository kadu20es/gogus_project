package br.com.plataforma.gogus.service;

import br.com.plataforma.gogus.dto.LivroDTO;
import br.com.plataforma.gogus.model.Livro;
import br.com.plataforma.gogus.repository.LivroRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class LivroService {

    @Autowired
    private LivroRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    /* Aqui começam as operações */

    /* pega todos os livros e mapeia */
    public Page<LivroDTO> obterTodos(Pageable paginacao){
        return repository.findAll(paginacao).map(p -> modelMapper.map(p, LivroDTO.class));
    }

    /* obter livro por id */
    public LivroDTO obterPorId(Long id){
        Livro livro = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Livro não localizado"));

        /* mapeia o objeto para o dto e o retorna para a classe LivroController */
        return modelMapper.map(livro, LivroDTO.class);
    }

    public LivroDTO cadastrarLivro(LivroDTO dto){
        Livro livro = modelMapper.map(dto, Livro.class);
        repository.save(livro);

        return modelMapper.map(livro, LivroDTO.class);
    }

    public LivroDTO atualizarLivro(Long id, LivroDTO dto){
        Livro livro = modelMapper.map(dto, Livro.class);
        livro = repository.save(livro);
        return modelMapper.map(livro, LivroDTO.class);
    }

    public void excluirLivro(Long id){
        repository.deleteById(id);
    }



}
