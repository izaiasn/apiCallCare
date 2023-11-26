package call.care.api.controller;



import call.care.api.lancamento.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("lancamentos")

public class LancamentosChamadoController {

    @Autowired
    private LancamentosRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar (@RequestBody @Valid DadosCadastroLancamento dados){
        repository.save(new Lancamentos(dados));
    }

    @GetMapping
    public Page<DadosListagemLancamento> listar(@PageableDefault(size = 10)Pageable paginacao){
        return  repository.findAll(paginacao).map(DadosListagemLancamento::new);
    }


    @Transactional
    @PutMapping
    public void atualizar(@RequestBody @Valid DadosAtualizacaoLancamento dados){
        var lancamento = repository.getReferenceById(dados.idlancamentos());
        lancamento.atulizarInformacoes(dados);

    }

    @DeleteMapping("/{idlancamentos}")
    @Transactional
    public void excluir(@PathVariable Long idlancamentos){
        var lancamento = repository.getReferenceById(idlancamentos);
        lancamento.excluir();
    }

}
