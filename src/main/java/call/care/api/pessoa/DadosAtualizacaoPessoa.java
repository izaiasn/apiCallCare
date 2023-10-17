package call.care.api.pessoa;

import call.care.api.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoPessoa(
        @NotNull
        Long id,

        String nome,
        String telefone,
        DadosEndereco endereco) {


}
