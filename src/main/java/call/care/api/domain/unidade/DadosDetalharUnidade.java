package call.care.api.domain.unidade;

import call.care.api.domain.endereco.Endereco;


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
