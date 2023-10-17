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
}
