package call.care.api.controller;

import call.care.api.unidade.*;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("unidade")
public class UnidadeController {
    @Autowired
    private UnidadeRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroUnidade dados){
        repository.save(new Unidade(dados));
    }

    @GetMapping
    public Page<DadosListagemUnidade> listar(@PageableDefault(size = 10, sort = {"unidade"}) Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListagemUnidade::new);

    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoUnidade dados){
        var unidade = repository.getReferenceById(dados.id());
        unidade.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void Excluir(@PathVariable Long id){
        var unidade = repository.getReferenceById(id);
        unidade.desativar();
    }


}
