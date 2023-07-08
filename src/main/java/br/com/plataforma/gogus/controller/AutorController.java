package br.com.plataforma.gogus.controller;

import br.com.plataforma.gogus.dto.AutorDTO;
import br.com.plataforma.gogus.dto.LivroDTO;
import br.com.plataforma.gogus.service.AutorService;
import br.com.plataforma.gogus.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {

    /* Insere os serviços cadastrados em LivroService neste classe */
    @Autowired
    private AutorService service;

    /*@GetMapping()
    public Page<AutorDTO> listar(@PageableDefault(size = 10) Pageable paginacao){
        return service.obterTodos(paginacao);
    } */

    @GetMapping("/listar")
    public List<AutorDTO> listar(){
        return service.obterTodos();
    }

    /* aqui, por passar o ID no caminho do endpoint, é necessário adicionar
     * a notação @PathVariable e identificar o quem receberá o parâmetro */
    @GetMapping("/{id}")
    public ResponseEntity<AutorDTO> detalhar(@PathVariable @NotNull Long id){
        AutorDTO dto = service.obterPorId(id);

        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<AutorDTO> cadastrarAutor(@RequestBody @Valid AutorDTO dto, UriComponentsBuilder builder){
        AutorDTO autor = service.cadastrarAutor(dto);
        URI endereco = builder.path("/autores/{id}").buildAndExpand(autor.getIdAutor()).toUri();

        return ResponseEntity.created(endereco).body(autor);
    }

    @PutMapping
    public ResponseEntity<AutorDTO> atualizar(@PathVariable @NotNull Long id, @RequestBody @Valid AutorDTO dto){
        AutorDTO atualizacao = service.atualizarAutor(id, dto);

        return ResponseEntity.ok(atualizacao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AutorDTO> remover(@PathVariable @NotNull Long id){
        service.exluirAutor(id);

        return ResponseEntity.noContent().build();
    }

}
