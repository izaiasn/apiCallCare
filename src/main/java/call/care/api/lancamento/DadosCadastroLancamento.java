package call.care.api.lancamento;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroLancamento(



        Long idlancamentos,

        @NotBlank
        String idchamados,

        @NotBlank
        String lancamento,

        @NotBlank
        String datalacamento,

        @NotBlank
        String horaiolacamento,

        @NotNull
        Boolean ativo ) {
}





