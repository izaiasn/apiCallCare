package call.care.api.domain.lancamento;



public record DadosDetalhamentoLancamento(Long idlancamentos,
                                          String idchamados,
                                          String lancamento,
                                          String datalacamento,
                                          String horaiolacamento,
                                          Boolean ativo) {

    public DadosDetalhamentoLancamento(Lancamentos lancamentos){
        this(lancamentos.getIdlancamentos(), lancamentos.getIdchamados(), lancamentos.getLancamento(),lancamentos.getDatalacamento(), lancamentos.getHoraiolacamento(),lancamentos.getAtivo());
    }

}
