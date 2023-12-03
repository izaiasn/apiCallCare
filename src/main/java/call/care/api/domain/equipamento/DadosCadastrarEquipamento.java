package call.care.api.domain.equipamento;

import jakarta.validation.constraints.NotBlank;
import org.antlr.v4.runtime.misc.NotNull;

public record DadosCadastrarEquipamento(


         Long id,
         @NotBlank
         String idunidade,
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
         String datainstalacao,
         @NotBlank
         String hora,

         Boolean ativo) {
}
