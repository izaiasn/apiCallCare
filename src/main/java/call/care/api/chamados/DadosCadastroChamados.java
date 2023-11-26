package call.care.api.chamados;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroChamados(

        String idchamados,
        @NotBlank
        String idunidade,
        @NotBlank
        String unidade,
        @NotBlank
        String idpessoa,
        @NotBlank
        String nome,
        @NotBlank
        String email,
        @NotBlank
        String telefone,
        @NotNull
        Statusatendimento statusatendimento,
        @NotBlank
        String especialidade,
        @NotBlank
        String idequipamento,
        @NotBlank
        String modelo,
        @NotBlank
        String tipoequipamento,
        @NotNull
        Statuschamado statuschamado,
        @NotBlank
        String fabricante,
        @NotBlank
        String modalidade,
        @NotBlank
        String numeroserie,
        @NotBlank
        String codigoequipamento,

        String dataabertura,

        String horaioabertura,
        @NotBlank
        String datafechamento,
        @NotBlank
        String horaiofechamento,
        @NotBlank
        String descricao,
        @NotBlank
        String ativo
)
{




}
