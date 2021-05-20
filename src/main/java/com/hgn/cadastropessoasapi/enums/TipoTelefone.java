package com.hgn.cadastropessoasapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoTelefone {


    CASA("casa"),
    CELULAR("celular"),
    COMERCIAL("comercial");

    private final String descricao;
}
