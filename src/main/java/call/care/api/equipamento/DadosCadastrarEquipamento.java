package call.care.api.equipamento;

public record DadosCadastrarEquipamento(


         Long id,

         String modelo,

         String tipoequipamento,

         String fabricante,

         String modalidade,

         String numeroserie,

         String codigoequipamento,

         String datainstalacao,

         String hora,

         Boolean ativo) {
}
