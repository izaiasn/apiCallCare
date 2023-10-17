package call.care.api.pessoa;

public record DadosListagemPessoa(Long id,String nome, String email, String telefone, Especialidade especialidade) {
    public  DadosListagemPessoa( Pessoa pessoa){
        this(pessoa.getId(), pessoa.getNome(), pessoa.getEmail(), pessoa.getTelefone(),  pessoa.getEspecialidade());

    }
}


