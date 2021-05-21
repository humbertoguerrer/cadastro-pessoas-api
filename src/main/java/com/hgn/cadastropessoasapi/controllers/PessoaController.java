package com.hgn.cadastropessoasapi.controllers;

import com.hgn.cadastropessoasapi.DTO.request.PessoaDTO;
import com.hgn.cadastropessoasapi.DTO.response.MessageResponseDTO;
import com.hgn.cadastropessoasapi.exception.PessoaNaoEncontradaException;
import com.hgn.cadastropessoasapi.services.PessoaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pessoas")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PessoaController {

  private PessoaService pessoaService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public MessageResponseDTO criarPessoa(@RequestBody @Valid PessoaDTO pessoaDTO) {
    return pessoaService.criarPessoa(pessoaDTO);
  }

  @GetMapping
  public List<PessoaDTO> listarTodas() {
    return pessoaService.listarTodas();
  }

  @GetMapping("/{id}")
  public PessoaDTO buscarPorId(@PathVariable Long id) throws PessoaNaoEncontradaException {
    return pessoaService.buscarPorId(id);
  }

  @PutMapping("/{id}")
  public MessageResponseDTO atualizarPorId(@PathVariable Long id, @RequestBody PessoaDTO pessoaDTO)
      throws PessoaNaoEncontradaException {
    return pessoaService.atualizarPorId(id, pessoaDTO);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void apagarPorId(@PathVariable Long id) throws PessoaNaoEncontradaException {
    pessoaService.apagarPorId(id);
  }
}
