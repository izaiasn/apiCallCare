package call.care.api.unidade;

import call.care.api.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroUnidade(

        @NotBlank
        String unidade,
        @NotBlank
        @Pattern(regexp = "\\d{14}")
        String cnpj,
        @NotBlank
        @Pattern(regexp = "\\d{4,14}")
        String centrodecusto,
        @NotBlank
        @Pattern(regexp = "\\d{9,11}")
        String telefone,
        @NotNull
        Modelo modelo,
        @NotNull
        @Valid
        DadosEndereco endereco) {

}
