package call.care.api.pessoa;

import call.care.api.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroPessoa(

                                  @NotBlank
                                  String nome,
                                  @NotBlank
                                  @Email
                                  String email,
                                  @NotBlank
                                  @Pattern(regexp = "\\d{10,11}")
                                  String telefone,
                                  @NotBlank
                                  @Pattern(regexp = "\\d{11}")
                                  String cpf,
                                  @NotNull
                                  Especialidade especialidade,
                                  @Valid
                                  DadosEndereco endereco ) {
}
