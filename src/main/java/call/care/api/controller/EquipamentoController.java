package call.care.api.controller;
import call.care.api.equipamento.*;
import call.care.api.pessoa.DadosAtualizacaoPessoa;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("equipamento")

public class EquipamentoController {

    @Autowired
    private EquipamentoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastrarEquipamento dados) {
        repository.save(new Equipamento(dados));
    }
// Por ser um metodo de listar não utiliza o post mas Page
//    Para fazer a consulta http://localhost:8080/equipamento?size=1&page=2
    @GetMapping
    public  Page<DadosListaEquipamento> listar(@PageableDefault (size = 30, sort = {"id"}) Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListaEquipamento::new );
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoEquipamento dados){
        var equipamento = repository.getReferenceById(dados.id());
        equipamento.atualizarInformacoes(dados);



    }
    @DeleteMapping("/{id}")
    @Transactional
    public void desativar(@PathVariable Long id){
        var equipamento = repository.getReferenceById(id);
        equipamento.excluir();





    }


}
