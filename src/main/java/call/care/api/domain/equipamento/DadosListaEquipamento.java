package call.care.api.domain.equipamento;

// Inserir os campos que queremos devolver para API
public record DadosListaEquipamento(Long id,

                                    String modelo,

                                    String idunidade,

                                    String tipoequipamento,

                                    String fabricante,

                                    String modalidade,

                                    String numeroserie,

                                    String codigoequipamento,

                                    String datainstalacao,

                                    String hora,

                                    Boolean ativo) {

    public DadosListaEquipamento (Equipamento equipamento){
        this(equipamento.getId(),  equipamento.getModelo(), equipamento.getIdunidade() , equipamento.getTipoequipamento(), equipamento.getFabricante(),
                equipamento.getModalidade(), equipamento.getNumeroserie(), equipamento.getCodigoequipamento(),
                equipamento.getDatainstalacao(), equipamento.getHora(), equipamento.getAtivo());
    }
}




