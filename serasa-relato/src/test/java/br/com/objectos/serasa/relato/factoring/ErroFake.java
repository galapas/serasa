/*
 * Copyright 2015 Objectos, Fábrica de Software LTDA.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package br.com.objectos.serasa.relato.factoring;

import java.util.List;

import com.google.common.collect.ImmutableList;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class ErroFake {

  public static final List<Erro> ERRO_02 = ImmutableList.<Erro> builder()
      .add(erro(243, "TITULO INFORMADO EM DUPLICIDADE", 3))
      .add(erro(309, "CNPJ E DIG DO CEDENTE NAO CONFEREM", 57))
      .add(erro(317, "CODIGO CMC7 INVALIDO PARA O TIPO DOCTO CHEQUE", 9))
      .add(erro(336, "CMC7 INVALIDO - BANCO INEXISTENTE", 7))
      .add(erro(337, "CMC7 INVALIDO - NUMERO DO BANCO ZERADO", 1))
      .build();

  public static final Erro ERRO_99 = Erro.builder()
      .numero(99)
      .descricao("Algum erro genérico número 99")
      .quantidade(1)
      .build();

  private ErroFake() {
  }

  private static Erro erro(int n, String desc, int qtd) {
    return Erro.builder()
        .numero(n)
        .descricao(desc)
        .quantidade(qtd)
        .build();
  }

}