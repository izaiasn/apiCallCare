package call.care.api.controller;


import call.care.api.endereco.Endereco;
import call.care.api.pessoa.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pessoa")
public class PessoaController {
    @Autowired
    private PessoaRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroPessoa dados){
        repository.save(new Pessoa(dados));
    }

    @GetMapping
    public Page<DadosListagemPessoa> listar(@PageableDefault(size= 10, sort={"Nome"}) Pageable paginacao){
        return repository.findAllByativoTrue(paginacao).map(DadosListagemPessoa::new);

    }
    @Transactional
    @PutMapping
    public void atualizar(@RequestBody @Valid DadosAtualizacaoPessoa dados){
        var pessoa = repository.getReferenceById(dados.id());
        pessoa.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void  excluir(@PathVariable Long id){
        var pessoa = repository.getReferenceById(id);
        pessoa.excluir();


    }
}
