package call.care.api.domain.pessoa;

import call.care.api.domain.endereco.Endereco;

public record DadosDetalhamentoPessoa(Long id,
                                      String idunidade,
                                      String email,
                                      String nome,
                                      String telefone,
                                      Especialidade especialidade,
                                      Endereco endereco) {

    public DadosDetalhamentoPessoa(Pessoa pessoa){
        this(pessoa.getId(), pessoa.getIdunidade(), pessoa.getEmail(), pessoa.getNome(), pessoa.getTelefone(),
                pessoa.getEspecialidade(),pessoa.getEndereco());
    }
}
