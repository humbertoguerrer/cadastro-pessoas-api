package com.hgn.cadastropessoasapi.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.yaml.snakeyaml.util.ArrayUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {

    private Long id;
    private String nome;
    private String sobrenome;
    private String cpf;
    private LocalDate nascimento;
    private List<Telefone> telefones = new ArrayList<>();



}
