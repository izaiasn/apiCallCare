package call.care.api.chamados;

import jakarta.validation.constraints.NotBlank;

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
        @NotBlank
        String especialidade,
        @NotBlank
        String idequipamento,
        @NotBlank
        String modelo,
        @NotBlank
        String tipoequipamento,
        @NotBlank
        String fabricante,
        @NotBlank
        String modalidade,
        @NotBlank
        String numeroserie,
        @NotBlank
        String codigoequipamento,
        @NotBlank
        String dataabertura,
        @NotBlank
        String horaioabertura,
        @NotBlank
        String datafechamento,
        @NotBlank
        String horaiofechamento,
        @NotBlank
        String ativo
)
{




}
