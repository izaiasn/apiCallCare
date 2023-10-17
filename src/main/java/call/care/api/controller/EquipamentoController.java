package call.care.api.controller;
import call.care.api.equipamento.*;
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
// Por ser um metodo de listar não utiliza o post mas List
    @GetMapping
    public List<DadosListaEquipamento> listar(){
        return repository.findAll().stream().map(DadosListaEquipamento::new ).toList();


    }
}
