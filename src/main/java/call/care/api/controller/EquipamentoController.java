package call.care.api.controller;
import call.care.api.domain.equipamento.*;
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
@RequestMapping("equipamento")

public class EquipamentoController {

    @Autowired
    private EquipamentoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastrarEquipamento dados, UriComponentsBuilder uriBuilder) {
        var equipamento = new Equipamento(dados);
        repository.save(new Equipamento(dados));
        var uri = uriBuilder.path(("equipamento/{id}")).buildAndExpand(equipamento.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoEquipamento(equipamento));
    }
// Por ser um metodo de listar não utiliza o post mas Page
//    Para fazer a consulta http://localhost:8080/equipamento?size=1&page=2
    @GetMapping
    public ResponseEntity <Page<DadosListaEquipamento>> listar(@PageableDefault (size = 30, sort = {"id"}) Pageable paginacao){
        var page = repository.findAll(paginacao).map(DadosListaEquipamento::new );
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoEquipamento dados){
        var equipamento = repository.getReferenceById(dados.id());
        equipamento.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoEquipamento(equipamento));



    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity desativar(@PathVariable Long id){
        var equipamento = repository.getReferenceById(id);
        equipamento.excluir();
        return  ResponseEntity.noContent().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity dedetalhar(@PathVariable Long id) {
        var equipamento = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoEquipamento(equipamento));
    }


}
