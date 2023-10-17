package call.care.api.unidade;
import call.care.api.endereco.DadosEndereco;
import call.care.api.endereco.Endereco;
import call.care.api.pessoa.DadosAtualizacaoPessoa;
import jakarta.persistence.*;
import lombok.*;


@Table(name = "unidade")
@Entity(name = "Unidade")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Unidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String unidade;
    private String cnpj;
    private String telefone;
    private String centrodecusto;

    @Enumerated(EnumType.STRING)
    private Modelo modelo;

    @Embedded
    private Endereco endereco;

    private Boolean ativo;

    public Unidade(DadosCadastroUnidade dados) {

        this.unidade = dados.unidade();
        this.cnpj = dados.cnpj();
        this.telefone = dados.telefone();
        this.centrodecusto = dados.centrodecusto();
        this.modelo = dados.modelo();
        this.endereco = new Endereco(dados.endereco());
        this.ativo = true;

    }

    public void atualizarInformacoes(DadosAtualizacaoUnidade dados) {
        if (dados.unidade()!= null  ){
            this.unidade= dados.unidade();

        }
        if (dados.telefone()!= null  ){
            this.telefone= dados.telefone();
        }

        if (dados.endereco() != null  ){
            this.endereco = dados.endereco();

        }

    }

    public void desativar() {
        this.ativo = false;
    }
}
