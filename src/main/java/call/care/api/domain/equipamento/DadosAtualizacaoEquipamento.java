package call.care.api.domain.equipamento;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoEquipamento(


        @NotNull
        Long id,

        String modelo,

        String idunidade,

        String tipoequipamento,

        String fabricante,

        String modalidade,

        String numeroserie,

        String codigoequipamento,

        String datainstalacao,

        Boolean ativo) {
}
