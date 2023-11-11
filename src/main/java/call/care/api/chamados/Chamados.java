package call.care.api.chamados;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

@Table(name = "chamados")
@Entity(name= "Chamados")

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idchamados")
public class Chamados {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idchamados;

    private String idunidade;

    private String unidade;

    private String idpessoa;

    private String nome;

    private String email;

    private String telefone;

    private String especialidade;

    private String idequipamento;

    private String modelo;

    private String tipoequipamento;

    private String fabricante;

    private String modalidade;

    private String numeroserie;

    private String codigoequipamento;

    private String dataabertura;

    private String horaioabertura;

    private String datafechamento;

    private String horaiofechamento;

    private Boolean ativo;

    public Chamados(DadosCadastroChamados dados) {
        this.ativo = true;
        this.idunidade = dados.idunidade();
        this.unidade = dados.unidade();
        this.idpessoa = dados.idpessoa();
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.especialidade = dados.especialidade();
        this.idequipamento = dados.idequipamento();
        this.modelo = dados.modelo();
        this.tipoequipamento = dados.tipoequipamento();
        this.fabricante = dados.fabricante();
        this.modalidade = dados.modalidade();
        this.numeroserie = dados.numeroserie();
        this.codigoequipamento = dados.codigoequipamento();
        this.dataabertura = dados.dataabertura();
        this.horaioabertura = dados.horaioabertura();
        this.datafechamento = dados.datafechamento();
        this.horaiofechamento = dados.horaiofechamento();

    }

    public void atualizarInformacoes(DadosAtualizacaoChamados dados) {


        if (dados.nome()!= null){
            this.nome = dados.nome();
        }

        if (dados.email()!= null){
            this.email = dados.email();
        }

        if (dados.telefone()!= null){
            this.telefone = dados.telefone();
        }
    }

    public void fechar() {

        this.ativo=false;
        this.datafechamento= LocalDate.now().toString();
        this.horaiofechamento = LocalTime.now().toString();



    }
}
