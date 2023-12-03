package call.care.api.lancamento;

public record DadosDetalhamentoLancamento(Long idlancamentos,
                                          String lancamento,
                                          String datalacamento,
                                          String horaiolacamento,
                                          Boolean ativo) {

    public DadosDetalhamentoLancamento(Lancamentos lancamentos){
        this(lancamentos.getIdlancamentos(), lancamentos.getLancamento(),lancamentos.getDatalacamento(), lancamentos.getHoraiolacamento(),lancamentos.getAtivo());
    }
}
