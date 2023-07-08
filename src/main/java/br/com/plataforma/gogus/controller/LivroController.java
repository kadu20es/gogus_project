package br.com.plataforma.gogus.controller;

import br.com.plataforma.gogus.dto.LivroDTO;
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

@RestController
@RequestMapping("/livraria")
public class LivroController {

    /* Insere os serviços cadastrados em LivroService neste classe */
    @Autowired
    private LivroService service;

    @GetMapping
    public Page<LivroDTO> listar(@PageableDefault(size = 10) Pageable paginacao){
        return service.obterTodos(paginacao);
    }

    /* aqui, por passar o ID no caminho do endpoint, é necessário adicionar
     * a notação @PathVariable e identificar o quem receberá o parâmetro */
    @GetMapping("/{id}")
    public ResponseEntity<LivroDTO> detalhar(@PathVariable @NotNull Long id){
        LivroDTO dto = service.obterPorId(id);

        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<LivroDTO> cadastrarLivro(@RequestBody @Valid LivroDTO dto, UriComponentsBuilder builder){
        LivroDTO livro = service.cadastrarLivro(dto);
        URI endereco = builder.path("/livraria/{id}").buildAndExpand(livro.getId()).toUri();

        return ResponseEntity.created(endereco).body(livro);
    }

    @PutMapping
    public ResponseEntity<LivroDTO> atualizar(@PathVariable @NotNull Long id, @RequestBody @Valid LivroDTO dto){
        LivroDTO atualizacao = service.atualizarLivro(id, dto);

        return ResponseEntity.ok(atualizacao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<LivroDTO> remover(@PathVariable @NotNull Long id){
        service.excluirLivro(id);

        return ResponseEntity.noContent().build();
    }

}
