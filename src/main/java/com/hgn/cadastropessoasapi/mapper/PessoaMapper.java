package com.hgn.cadastropessoasapi.mapper;

import com.hgn.cadastropessoasapi.DTO.request.PessoaDTO;
import com.hgn.cadastropessoasapi.entities.Pessoa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PessoaMapper {

  PessoaMapper INSTANCE = Mappers.getMapper(PessoaMapper.class);

  @Mapping(target = "nascimento", source = "nascimento", dateFormat = "dd-MM-yyyy")
  Pessoa toModel(PessoaDTO pessoaDTO);

  PessoaDTO toDTO(Pessoa pessoa);
}
