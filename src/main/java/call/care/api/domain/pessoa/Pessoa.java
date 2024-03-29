package call.care.api.domain.pessoa;

import call.care.api.domain.endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "pessoa")
@Entity(name = "Pessoa")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pessoa {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String idunidade;
    private String nome;
    private String telefone;
    private String email;
    private String cpf;
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
    @Embedded
    private Endereco endereco;
    private Boolean ativo;

    public Pessoa(DadosCadastroPessoa dados) {

        this.ativo = true;
        this.idunidade = dados.idunidade();
        this.nome = dados.nome();
        this.telefone = dados.telefone();
        this.email = dados.email();
        this.cpf = dados.cpf();
        this.especialidade = dados.especialidade();
        this.endereco = new Endereco(dados.endereco());

    }

    public void atualizarInformacoes(DadosAtualizacaoPessoa dados) {
        if (dados.nome()!= null  ){
            this.nome= dados.nome();
        }

        if (dados.email()!= null  ){
            this.email= dados.email();
        }

        if (dados.idunidade()!= null  ){
            this.idunidade= dados.idunidade();
        }

        if (dados.telefone()!= null  ){
            this.telefone= dados.telefone();

        }

        if (dados.endereco()!= null  ){
            this.endereco.atualizarInformacoes(dados.endereco());

        }

    }

    public void excluir() {
        this.ativo = false;
    }
}
