package call.care.api.chamados;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoChamados(

        @NotNull
        Long idchamados,

        String nome,

        String email,

        String telefone,

        Boolean ativo
) {
}
