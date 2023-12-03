package call.care.api.controller;

import call.care.api.chamados.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("chamados")
public class ChamadoController {

    @Autowired
    private ChamadoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroChamados dados,
                                    UriComponentsBuilder uriBilder)
    {
        var chamados = new Chamados(dados);
        repository.save(chamados);
        var uri = uriBilder.path("/chamados/{idchamados}").buildAndExpand(chamados.getIdchamados()).toUri();
        return ResponseEntity.created(uri).body(new  DadosDetalhamentoChamados(chamados));

    }
    @GetMapping
    public ResponseEntity<Page<DadosListagemChamados>> Listar(@PageableDefault(size = 20, sort = {"idchamados"}) Pageable paginacao){
        var page =  repository.findAll(paginacao).map(DadosListagemChamados::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoChamados dados){
        var chamados = repository.getReferenceById(dados.idchamados());
        chamados.atualizarInformacoes(dados);

        return ResponseEntity.ok(new  DadosDetalhamentoChamados(chamados));
    }
    @DeleteMapping("/{idchamados}")
    @Transactional
    public ResponseEntity fechar(@PathVariable Long idchamados){
        var chamado = repository.getReferenceById(idchamados);
        chamado.fechar();

        return  ResponseEntity.noContent().build();

    }

    @GetMapping("/{id}")
    public ResponseEntity dedetalhar(@PathVariable Long id) {
        var chamados = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoChamados(chamados));
    }
}
