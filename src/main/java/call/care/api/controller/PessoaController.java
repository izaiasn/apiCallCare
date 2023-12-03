package call.care.api.controller;


import call.care.api.chamados.DadosDetalhamentoChamados;
import call.care.api.chamados.DadosListagemChamados;
import call.care.api.endereco.Endereco;
import call.care.api.pessoa.*;
import call.care.api.unidade.DadosDetalharUnidade;
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

import java.util.List;

@RestController
@RequestMapping("pessoa")
public class PessoaController {
    @Autowired
    private PessoaRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroPessoa dados, UriComponentsBuilder uriBuilder){

        var pessoa = new Pessoa(dados);
        repository.save(pessoa);

        var uri = uriBuilder.path("pessoa/{id}").buildAndExpand(pessoa.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoPessoa(pessoa));
    }

    @GetMapping
    public ResponseEntity <Page<DadosListagemPessoa>> listar(@PageableDefault(size= 10, sort={"id"}) Pageable paginacao){
        var page =  repository.findAll(paginacao).map(DadosListagemPessoa::new);

        return ResponseEntity.ok(page);

    }
    @Transactional
    @PutMapping
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoPessoa dados){
        var pessoa = repository.getReferenceById(dados.id());
        pessoa.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoPessoa(pessoa));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        var pessoa = repository.getReferenceById(id);
        pessoa.excluir();
        return  ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity dedetalhar(@PathVariable Long id) {
        var pessoa = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoPessoa (pessoa));
    }
}
