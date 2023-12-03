package call.care.api.domain.chamados;

public record DadosDetalhamentoChamados(Long idchamados,

                                        String idunidade,

                                        String unidade,

                                        String idpessoa,

                                        String nome,

                                        String email,

                                        String telefone,

                                        Statusatendimento statusatendimento,

                                        String especialidade,

                                        String idequipamento,

                                        String modelo,

                                        String tipoequipamento,

                                        Statuschamado statuschamado,

                                        String fabricante,

                                        String modalidade,

                                        String numeroserie,

                                        String codigoequipamento,

                                        String dataabertura,

                                        String horaioabertura,

                                        String datafechamento,

                                        String horaiofechamento,
                                        String descricao,
                                        Boolean ativo ) {

    public  DadosDetalhamentoChamados(Chamados chamados){
        this(chamados.getIdchamados(), chamados.getIdunidade(),chamados.getUnidade(), chamados.getIdpessoa(), chamados.getNome()
        ,chamados.getEmail(), chamados.getTelefone(), chamados.getStatusatendimento(), chamados.getEspecialidade(), chamados.getIdequipamento(),
         chamados.getModelo(), chamados.getTipoequipamento(), chamados.getStatuschamado(),chamados.getFabricante(), chamados.getModalidade(),
         chamados.getNumeroserie(), chamados.getCodigoequipamento(), chamados.getDataabertura(), chamados.getHoraioabertura(), chamados.getDatafechamento(),
         chamados.getHoraiofechamento(), chamados.getDescricao(),chamados.getAtivo() );
    }
}
