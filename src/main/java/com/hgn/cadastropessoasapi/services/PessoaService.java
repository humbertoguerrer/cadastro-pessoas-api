package com.hgn.cadastropessoasapi.services;

import com.hgn.cadastropessoasapi.DTO.MessageResponseDTO;
import com.hgn.cadastropessoasapi.entities.Pessoa;
import com.hgn.cadastropessoasapi.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PessoaService {

    private PessoaRepository pessoaRepository;

    @Autowired
    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }


    public MessageResponseDTO criarPessoa(Pessoa pessoa) {
        Pessoa pessoaSalva = pessoaRepository.save(pessoa);
        return MessageResponseDTO.builder()
                .mensagem("Criada pessoa com o ID " + pessoaSalva.getId())
                .build();
    }
}
