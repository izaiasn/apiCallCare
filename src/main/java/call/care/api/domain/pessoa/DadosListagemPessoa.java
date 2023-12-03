package call.care.api.domain.pessoa;

import jakarta.validation.constraints.NotBlank;

public record DadosListagemPessoa(Long id, @NotBlank
String idunidade, String nome, String email, String telefone, Especialidade especialidade) {
    public  DadosListagemPessoa( Pessoa pessoa){
        this(pessoa.getId(),pessoa.getIdunidade(), pessoa.getNome(), pessoa.getEmail(), pessoa.getTelefone(),  pessoa.getEspecialidade());

    }
}


