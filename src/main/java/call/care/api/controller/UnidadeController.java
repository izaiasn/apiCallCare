package call.care.api.controller;

import call.care.api.chamados.DadosDetalhamentoChamados;
import call.care.api.unidade.*;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("unidade")
public class UnidadeController {
    @Autowired
    private UnidadeRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroUnidade dados, UriComponentsBuilder uriBuilder){
        var unidade = new Unidade(dados);
        repository.save(unidade);


        var uri  = uriBuilder.path("/unidade/{id}").buildAndExpand(unidade.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalharUnidade(unidade));
    }

    @GetMapping
    public ResponseEntity <Page<DadosListagemUnidade>> listar(@PageableDefault(size = 10, sort = {"unidade"}) Pageable paginacao){
        var page = repository.findAll(paginacao).map(DadosListagemUnidade::new);
        return ResponseEntity.ok(page);

    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoUnidade dados){
        var unidade = repository.getReferenceById(dados.id());
        unidade.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalharUnidade(unidade));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity Excluir(@PathVariable Long id){
        var unidade = repository.getReferenceById(id);
        unidade.desativar();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity dedetalhar(@PathVariable Long id) {
        var unidade = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalharUnidade(unidade));
    }


}
