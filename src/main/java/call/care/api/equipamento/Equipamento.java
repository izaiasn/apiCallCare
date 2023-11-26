package call.care.api.equipamento;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "equipamento")
@Entity(name = "Equipamento")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Equipamento {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String idunidade;
    private String modelo;
    private String tipoequipamento;
    private String fabricante;
    private String modalidade;
    private String numeroserie;
    private String codigoequipamento;
    private String datainstalacao;
    private String hora;
    private Boolean ativo;

    public Equipamento(DadosCadastrarEquipamento dados) {
        this.ativo = true;
        this.idunidade = dados.idunidade();
        this.id = dados.id();
        this.modelo = dados.modelo();
        this.tipoequipamento = dados.tipoequipamento();
        this.fabricante = dados.fabricante();
        this.modalidade = dados.modalidade();
        this.numeroserie = dados.numeroserie();
        this.codigoequipamento = dados.codigoequipamento();
        this.hora = dados.hora();
        this.datainstalacao = dados.datainstalacao();

    }

    public void atualizarInformacoes(DadosAtualizacaoEquipamento dados) {
        if (dados.ativo() != null) {
            this.ativo = dados.ativo();
        }
        if (dados.idunidade() != null) {
            this.idunidade = dados.idunidade();
        }


        if (dados.modelo() != null) {
            this.modelo = dados.modelo();

        }
        if (dados.tipoequipamento() != null) {
            this.tipoequipamento = dados.tipoequipamento();

        }
        if (dados.fabricante() != null) {
            this.fabricante = dados.fabricante();

        }
        if (dados.modalidade() != null) {
            this.modalidade = dados.modalidade();

        }
        if (dados.numeroserie() != null) {
            this.numeroserie = dados.numeroserie();

        }
        if (dados.codigoequipamento() != null) {
            this.codigoequipamento = dados.codigoequipamento();

        }
        if (dados.datainstalacao() != null) {
            this.datainstalacao = dados.datainstalacao();

        }

    }

    public void excluir() {
        this.ativo = false;
    }
}
