package call.care.api.lancamento;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoLancamento(

        @NotNull
        Long idlancamentos,
        String lancamento,
        String datalacamento,
        String horaiolacamento,
        Boolean ativo) {
}


