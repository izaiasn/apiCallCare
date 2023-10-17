package call.care.api.equipamento;

import jakarta.validation.constraints.NotBlank;

// Inserir os campos que queremos devolver para API
public record DadosListaEquipamento(Long id,

                                    String modelo,

                                    String tipoequipamento,

                                    String fabricante,

                                    String modalidade,

                                    String numeroserie,

                                    String codigoequipamento,

                                    String datainstalacao,

                                    String hora,

                                    Boolean ativo) {

    public DadosListaEquipamento (Equipamento equipamento){
        this(equipamento.getId(), equipamento.getModelo(), equipamento.getTipoequipamento(), equipamento.getFabricante(),
                equipamento.getModalidade(), equipamento.getNumeroserie(), equipamento.getCodigoequipamento(),
                equipamento.getDatainstalacao(), equipamento.getHora(), equipamento.getAtivo());
    }
}




