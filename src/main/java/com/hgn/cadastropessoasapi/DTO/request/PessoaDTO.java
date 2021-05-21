package com.hgn.cadastropessoasapi.DTO.request;

import com.hgn.cadastropessoasapi.entities.Telefone;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDTO {

  private Long id;

  @NotEmpty
  @Size(min = 2, max = 100)
  private String nome;

  private String sobrenome;

  @CPF
  private String cpf;

  private String nascimento;

  @NotEmpty
  @Valid
  private List<Telefone> telefones = new ArrayList<>();
}
