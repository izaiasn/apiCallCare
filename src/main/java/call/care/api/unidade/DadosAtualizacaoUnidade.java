package call.care.api.unidade;

import call.care.api.endereco.Endereco;
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





