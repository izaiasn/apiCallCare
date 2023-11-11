package call.care.api.controller;

import call.care.api.chamados.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("chamados")
public class ChamadoController {

    @Autowired
    private ChamadoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroChamados dados)
    {
        repository.save(new Chamados(dados));

    }
    @GetMapping
    public Page<DadosListagemChamados> Listar(@PageableDefault(size = 10, sort = {"idchamados"}) Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListagemChamados::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoChamados dados){
        var chamado = repository.getReferenceById(dados.idchamados());
        chamado.atualizarInformacoes(dados);
    }
    @DeleteMapping("/{idchamados}")
    @Transactional
    public void  fechar(@PathVariable Long idchamados){
        var chamado = repository.getReferenceById(idchamados);
        chamado.fechar();



    }
}
