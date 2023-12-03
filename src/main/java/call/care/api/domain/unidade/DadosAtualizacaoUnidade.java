package call.care.api.domain.unidade;

import call.care.api.domain.endereco.Endereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoUnidade(
        @NotNull
        Long id,
        String unidade,
        String telefone,
        String centrodecusto ,
        Modelo modelo,
        Endereco endereco) {
}





