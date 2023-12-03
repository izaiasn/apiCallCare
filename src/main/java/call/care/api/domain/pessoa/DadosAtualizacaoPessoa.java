package call.care.api.domain.pessoa;

import call.care.api.domain.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoPessoa(
        @NotNull
        Long id,
        String idunidade,
        String email,
        String nome,
        String telefone,
        DadosEndereco endereco) {


}
