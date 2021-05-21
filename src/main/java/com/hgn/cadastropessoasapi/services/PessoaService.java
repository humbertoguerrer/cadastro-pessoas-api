package com.hgn.cadastropessoasapi.services;

import com.hgn.cadastropessoasapi.DTO.request.PessoaDTO;
import com.hgn.cadastropessoasapi.DTO.response.MessageResponseDTO;
import com.hgn.cadastropessoasapi.entities.Pessoa;
import com.hgn.cadastropessoasapi.mapper.PessoaMapper;
import com.hgn.cadastropessoasapi.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PessoaService {

  private final PessoaMapper pessoaMapper = PessoaMapper.INSTANCE;

  private PessoaRepository pessoaRepository;

  @Autowired
  public PessoaService(PessoaRepository pessoaRepository) {
    this.pessoaRepository = pessoaRepository;
  }

  public MessageResponseDTO criarPessoa(PessoaDTO pessoaDTO) {
    Pessoa pessoa = pessoaMapper.toModel(pessoaDTO);
    Pessoa pessoaSalva = pessoaRepository.save(pessoa);
    return MessageResponseDTO.builder()
        .mensagem("Criada pessoa com o ID " + pessoaSalva.getId())
        .build();
  }


  public List<PessoaDTO> listarTodas() {
    List<Pessoa> todasPessoas = pessoaRepository.findAll();
    return todasPessoas.stream()
            .map(pessoaMapper::toDTO)
            .collect(Collectors.toList());
  }
}
