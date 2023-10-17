package call.care.api.unidade;

public record DadosListagemUnidade(Long id, String unidade, String telefone, String centrodecusto , Modelo modelo, Boolean ativo) {

    public DadosListagemUnidade(Unidade unidade){
        this( unidade.getId() ,unidade.getUnidade(), unidade.getTelefone(), unidade.getCentrodecusto(), unidade.getModelo(), unidade.getAtivo());
    }

}
