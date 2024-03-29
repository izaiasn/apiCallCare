package call.care.api.controller;



import call.care.api.domain.lancamento.*;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("lancamentos")

public class LancamentosChamadoController {

    @Autowired
    private LancamentosRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar (@RequestBody @Valid DadosCadastroLancamento dados, UriComponentsBuilder uriBuilder){

        var lancamento = new Lancamentos(dados);
        repository.save(new Lancamentos(dados));

        var uri = uriBuilder.path("/lancamentos/{idlancamentos}").buildAndExpand(lancamento.getIdlancamentos()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoLancamento(lancamento));
    }

    @GetMapping
    public ResponseEntity <Page<DadosListagemLancamento>> listar(@PageableDefault(size = 10)Pageable paginacao){
        var page =  repository.findAll(paginacao).map(DadosListagemLancamento::new);
        return ResponseEntity.ok(page);
    }


    @Transactional
    @PutMapping
    public ResponseEntity  atualizar(@RequestBody @Valid DadosAtualizacaoLancamento dados){
        var lancamento = repository.getReferenceById(dados.idlancamentos());
        lancamento.atulizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoLancamento(lancamento));

    }

    @DeleteMapping("/{idlancamentos}")
    @Transactional
    public ResponseEntity  excluir(@PathVariable Long idlancamentos){
        var lancamento = repository.getReferenceById(idlancamentos);
        lancamento.excluir();
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/{id}")
    public ResponseEntity dedetalhar(@PathVariable Long id) {
        var lancamentos = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoLancamento(lancamentos));
    }


}

