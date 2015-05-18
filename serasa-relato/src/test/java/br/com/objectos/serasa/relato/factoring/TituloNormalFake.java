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
import java.util.Optional;

import br.com.objectos.way.base.br.Cnpj;
import br.com.objectos.way.base.br.Cpf;

import com.google.common.collect.ImmutableList;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class TituloNormalFake {

  public static final TituloNormal TITULO_0001 = TituloNormal.builder()
      .cadastroSacado(Cpf.valueOf(8261431649l))
      .tipo(TituloTipo.CPF)
      .numeroTitulo("0001")
      .dataEmissao(LocalDate.of(2015, 2, 14))
      .valorNominal(123.45)
      .dataVencimento(LocalDate.of(2015, 5, 31))
      .dataPagamento(Optional.<LocalDate> empty())
      .hashD("")
      .numeroTituloLongo("")
      .cnpjCedente(Cnpj.valueOf(80161698000166l))
      .tipoTitulo(TipoTitulo.DUPLICATA)
      .tipoInformacao(TipoInformacao.SACADO_CEDENTE)
      .build();
  public static final TituloNormal TITULO_0002 = TituloNormal.builder()
      .cadastroSacado(Cnpj.valueOf(14853210000137l))
      .tipo(TituloTipo.CNPJ)
      .numeroTitulo("0002")
      .dataEmissao(LocalDate.of(2015, 2, 14))
      .valorNominal(123.45)
      .dataVencimento(LocalDate.of(2015, 5, 31))
      .dataPagamento(Optional.<LocalDate> empty())
      .hashD("")
      .numeroTituloLongo("")
      .cnpjCedente(Cnpj.valueOf(80161698000166l))
      .tipoTitulo(TipoTitulo.DUPLICATA)
      .tipoInformacao(TipoInformacao.SACADO_CEDENTE)
      .build();
  public static final TituloNormal TITULO_0003 = TituloNormal.builder()
      .cadastroSacado(Cnpj.valueOf(23442693000178l))
      .tipo(TituloTipo.CNPJ)
      .numeroTitulo("0003")
      .dataEmissao(LocalDate.of(2015, 2, 14))
      .valorNominal(123.45)
      .dataVencimento(LocalDate.of(2015, 5, 31))
      .dataPagamento(Optional.<LocalDate> empty())
      .hashD("")
      .numeroTituloLongo("")
      .cnpjCedente(Cnpj.valueOf(80161698000166l))
      .tipoTitulo(TipoTitulo.DUPLICATA)
      .tipoInformacao(TipoInformacao.SACADO_CEDENTE)
      .build();

  private static final List<TituloNormal> list = ImmutableList.<TituloNormal> builder()
      .add(TITULO_0001)
      .add(TITULO_0002)
      .add(TITULO_0003)
      .build();

  private TituloNormalFake() {
  }

  public static List<TituloNormal> list() {
    return list;
  }

}