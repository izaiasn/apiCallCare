package call.care.api.chamados;



public record DadosListagemChamados(


        Long idchamados,

        String idunidade,

        String unidade,

        String idpessoa,

        String nome,

        String email,

        String telefone,

        String especialidade,

        String idequipamento,

        String modelo,

        String tipoequipamento,

        String fabricante,

        String modalidade,

        String numeroserie,

        String codigoequipamento,

        String dataabertura,

        String horaioabertura,

        String datafechamento,

        String horaiofechamento,

        Boolean ativo

) {

    public DadosListagemChamados(Chamados chamados){
        this(chamados.getIdchamados(), chamados.getIdunidade(),chamados.getUnidade(),chamados.getIdpessoa(),
                chamados.getNome(), chamados.getEmail(),chamados.getTelefone(), chamados.getEspecialidade(),
                chamados.getIdequipamento(), chamados.getModelo(), chamados.getTipoequipamento(),
                chamados.getFabricante(), chamados.getModalidade(),chamados.getNumeroserie(),
                chamados.getCodigoequipamento(), chamados.getDataabertura(),chamados.getHoraioabertura(),
                chamados.getDatafechamento(), chamados.getHoraiofechamento(),chamados.getAtivo());
    }
}
