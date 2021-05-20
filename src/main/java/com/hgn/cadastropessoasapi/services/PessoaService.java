package com.hgn.cadastropessoasapi.services;

import com.hgn.cadastropessoasapi.DTO.request.PessoaDTO;
import com.hgn.cadastropessoasapi.DTO.response.MessageResponseDTO;
import com.hgn.cadastropessoasapi.entities.Pessoa;
import com.hgn.cadastropessoasapi.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    private PessoaRepository pessoaRepository;

    @Autowired
    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }


    public MessageResponseDTO criarPessoa(PessoaDTO pessoaDTO) {

        Pessoa pessoaSalvar = Pessoa.builder()
                .nome(pessoaDTO.getNome())
                .sobrenome(pessoaDTO.getSobrenome())
                .nascimento(pessoaDTO.getNascimento())
                .build();

        Pessoa pessoaSalva = pessoaRepository.save(pessoaDTO);
        return MessageResponseDTO.builder()
                .mensagem("Criada pessoa com o ID " + pessoaSalva.getId())
                .build();
    }
}
