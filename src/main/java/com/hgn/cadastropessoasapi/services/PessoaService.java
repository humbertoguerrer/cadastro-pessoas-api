package com.hgn.cadastropessoasapi.services;

import com.hgn.cadastropessoasapi.DTO.request.PessoaDTO;
import com.hgn.cadastropessoasapi.DTO.response.MessageResponseDTO;
import com.hgn.cadastropessoasapi.entities.Pessoa;
import com.hgn.cadastropessoasapi.exception.PessoaNaoEncontradaException;
import com.hgn.cadastropessoasapi.mapper.PessoaMapper;
import com.hgn.cadastropessoasapi.repositories.PessoaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PessoaService {

  private final PessoaMapper pessoaMapper = PessoaMapper.INSTANCE;

  private PessoaRepository pessoaRepository;

  public MessageResponseDTO criarPessoa(PessoaDTO pessoaDTO) {
    Pessoa pessoa = pessoaMapper.toModel(pessoaDTO);
    Pessoa pessoaSalva = pessoaRepository.save(pessoa);
    return CriarMessageResponse(pessoaSalva.getId(), "Criada pessoa com o ID ");
  }

  public List<PessoaDTO> listarTodas() {
    List<Pessoa> todasPessoas = pessoaRepository.findAll();
    return todasPessoas.stream().map(pessoaMapper::toDTO).collect(Collectors.toList());
  }

  public PessoaDTO buscarPorId(Long id) throws PessoaNaoEncontradaException {
    Pessoa pessoa = verificarSeExiste(id);
    return pessoaMapper.toDTO(pessoa);
  }

  public void apagarPorId(Long id) throws PessoaNaoEncontradaException {
    verificarSeExiste(id);
    pessoaRepository.deleteById(id);
  }

  public MessageResponseDTO atualizarPorId(Long id, PessoaDTO pessoaDTO)
      throws PessoaNaoEncontradaException {
    verificarSeExiste(id);
    Pessoa pessoa = pessoaMapper.toModel(pessoaDTO);
    Pessoa pessoaAtualizada = pessoaRepository.save(pessoa);
    return CriarMessageResponse(pessoaAtualizada.getId(), "Atualizada pessoa com o ID ");
  }

  private MessageResponseDTO CriarMessageResponse(Long id, String mensagem) {
    return MessageResponseDTO.builder().mensagem(mensagem + id).build();
  }

  private Pessoa verificarSeExiste(Long id) throws PessoaNaoEncontradaException {
    return pessoaRepository.findById(id).orElseThrow(() -> new PessoaNaoEncontradaException(id));
  }
}
