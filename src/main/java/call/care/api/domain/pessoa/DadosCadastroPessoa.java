package call.care.api.domain.pessoa;

import call.care.api.domain.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroPessoa(
                                  @NotBlank
                                  String idunidade,
                                  @NotBlank
                                  String nome,
                                  @NotBlank
                                  @Email
                                  String email,
                                  @NotBlank (message = "Telefone é obrigatorio ou faltando digitos")
                                  @Pattern(regexp = "\\d{10,11}")
                                  String telefone,
                                  @NotBlank(message = "CPF é obrigatótio !")
                                  @Pattern(regexp = "\\d{11}", message = "Formato do CPF é inválido ou faltando Digito")
                                  String cpf,
                                  @NotNull
                                  Especialidade especialidade,
                                  @Valid
                                  DadosEndereco endereco ) {
}
