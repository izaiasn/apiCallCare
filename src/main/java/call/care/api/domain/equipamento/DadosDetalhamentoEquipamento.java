package call.care.api.domain.equipamento;

public record DadosDetalhamentoEquipamento(Long id,

                                           String modelo,

                                           String idunidade,

                                           String tipoequipamento,

                                           String fabricante,

                                           String modalidade,

                                           String numeroserie,

                                           String codigoequipamento,

                                           String datainstalacao,

                                           Boolean ativo) {
    public DadosDetalhamentoEquipamento (Equipamento equipamento){
        this(equipamento.getId(), equipamento.getModelo(), equipamento.getIdunidade(), equipamento.getTipoequipamento(),
                equipamento.getFabricante(), equipamento.getModalidade(), equipamento.getNumeroserie(), equipamento.getCodigoequipamento(),
                equipamento.getDatainstalacao(), equipamento.getAtivo());
    }
}
