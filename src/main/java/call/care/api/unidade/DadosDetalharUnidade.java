package call.care.api.unidade;

import call.care.api.endereco.Endereco;


public record DadosDetalharUnidade(Long id,
                                   String unidade,
                                   String telefone,
                                   String centrodecusto ,
                                   Modelo modelo,
                                   Endereco endereco) {
    public DadosDetalharUnidade (Unidade unidade){
        this(unidade.getId(), unidade.getUnidade(), unidade.getTelefone(), unidade.getCentrodecusto(), unidade.getModelo(), unidade.getEndereco());
    }
}
