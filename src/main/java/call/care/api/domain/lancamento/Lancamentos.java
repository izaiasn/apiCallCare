package call.care.api.domain.lancamento;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Table(name = "lancamentos")
@Entity(name = "Lancamento")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idlancamentos")

public class Lancamentos {


    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idlancamentos;
    private String idchamados;
    private String lancamento;
    private String datalacamento;
    private String horaiolacamento;
    private Boolean ativo;

    public Lancamentos(DadosCadastroLancamento dados) {



        this.ativo = true;
        this.idchamados = dados.idchamados();
        this.idlancamentos = dados.idlancamentos();
        this.lancamento =  dados.lancamento();
        this.datalacamento = dados.datalacamento();
        this.horaiolacamento = dados.horaiolacamento();

    }


    public void atulizarInformacoes(DadosAtualizacaoLancamento dados) {



        if(dados.lancamento()!= null){
            this.lancamento = dados.lancamento();
        }

        if(dados.datalacamento()!= null){
            this.datalacamento = dados.datalacamento();
        }

        if(dados.horaiolacamento()!= null){
            this.horaiolacamento = dados.horaiolacamento();
        }

    }

    public void excluir() {
        this.ativo = false;
    }
}
