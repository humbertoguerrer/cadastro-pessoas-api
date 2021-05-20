package com.hgn.cadastropessoasapi.controllers;

import com.hgn.cadastropessoasapi.DTO.MessageResponseDTO;
import com.hgn.cadastropessoasapi.entities.Pessoa;
import com.hgn.cadastropessoasapi.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

  private PessoaService pessoaService;

  @Autowired
  public PessoaController(PessoaService pessoaService) {
    this.pessoaService = pessoaService;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public MessageResponseDTO criarPessoa(@RequestBody Pessoa pessoa) {
    return pessoaService.criarPessoa(pessoa);
  }
}
