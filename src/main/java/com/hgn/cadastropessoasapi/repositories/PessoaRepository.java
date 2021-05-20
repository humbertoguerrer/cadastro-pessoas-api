package com.hgn.cadastropessoasapi.repositories;

import com.hgn.cadastropessoasapi.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {


}
