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

import java.time.LocalDate;
import java.util.List;

import br.com.objectos.way.base.br.Cnpj;
import br.com.objectos.way.base.br.Cpf;

import com.google.common.collect.ImmutableList;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class TempoRelacionamentoFake {

  public static final TempoRelacionamento SACADO_PJ_0001 = TempoRelacionamento.builder()
      .cadastroSacado(Cnpj.valueOf(14853210000137l))
      .tipo(TempoRelacionamentoTipo.CNPJ)
      .clienteDesde(LocalDate.of(2014, 8, 15))
      .tipoCliente(TipoCliente.MENOS_UM_ANO)
      .build();

  public static final TempoRelacionamento SACADO_PF_0001 = TempoRelacionamento.builder()
      .cadastroSacado(Cpf.valueOf(8261431649l))
      .tipo(TempoRelacionamentoTipo.CPF)
      .clienteDesde(LocalDate.of(2010, 1, 1))
      .tipoCliente(TipoCliente.ANTIGO)
      .build();
  public static final TempoRelacionamento SACADO_PF_0002 = TempoRelacionamento.builder()
      .cadastroSacado(Cpf.valueOf(8261431649l))
      .tipo(TempoRelacionamentoTipo.CPF)
      .clienteDesde(LocalDate.of(2012, 1, 1))
      .tipoCliente(TipoCliente.ANTIGO)
      .build();

  private static final List<TempoRelacionamento> list = ImmutableList.<TempoRelacionamento> builder()
      .add(SACADO_PJ_0001)
      .add(SACADO_PF_0001)
      .add(SACADO_PF_0002)
      .build();

  private TempoRelacionamentoFake() {
  }

  public static List<TempoRelacionamento> list() {
    return list;
  }

}