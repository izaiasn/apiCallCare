package call.care.api.lancamento;



public record DadosListagemLancamento( Long Idlancamentos, String idchamados,  String lancamento, String datalacamento, String horaiolacamento, Boolean ativo ) {

    public DadosListagemLancamento (Lancamentos lancamentos){
        this(lancamentos.getIdlancamentos(), lancamentos.getIdchamados(),  lancamentos.getLancamento(), lancamentos.getDatalacamento(), lancamentos.getHoraiolacamento(), lancamentos.getAtivo());
    }
}
