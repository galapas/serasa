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

import br.com.objectos.br.Cnpj;
import br.com.objectos.br.Cpf;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class TituloConciliacaoFake {

  public static final TituloConciliacao TITULO_0001 = TituloConciliacao.builder()
      .cadastroSacado(CadastroSacado.of(Cpf.valueOf(8261431649l)))
      .numeroTitulo("0001")
      .dataEmissao(LocalDate.of(2015, 2, 14))
      .valorNominal(123.45)
      .dataVencimento(LocalDate.of(2015, 5, 31))
      .dataPagamento(DataPagamento.empty())
      .hashD("")
      .numeroTituloLongo("")
      .cnpjCedente(Cnpj.valueOf(80161698000166l))
      .tipoTitulo(TipoTitulo.DUPLICATA)
      .tipoInformacao(TipoInformacao.SACADO_CEDENTE)
      .build();
  public static final TituloConciliacao TITULO_0002 = TituloConciliacao.builder()
      .cadastroSacado(CadastroSacado.of(Cpf.valueOf(8261431649l)))
      .numeroTitulo("")
      .dataEmissao(LocalDate.of(2015, 2, 14))
      .valorNominal(123.45)
      .dataVencimento(LocalDate.of(2015, 5, 31))
      .dataPagamento(DataPagamento.empty())
      .hashD("#D")
      .numeroTituloLongo("DUPLICATA-0002")
      .cnpjCedente(Cnpj.valueOf(80161698000166l))
      .tipoTitulo(TipoTitulo.DUPLICATA)
      .tipoInformacao(TipoInformacao.SACADO_CEDENTE)
      .build();
  public static final TituloConciliacao TITULO_0003 = TituloConciliacao.builder()
      .cadastroSacado(CadastroSacado.of(Cpf.valueOf(8261431649l)))
      .numeroTitulo("")
      .dataEmissao(LocalDate.of(2015, 2, 14))
      .valorNominal(123.45)
      .dataVencimento(LocalDate.of(2015, 5, 31))
      .dataPagamento(DataPagamento.empty())
      .hashD("#D")
      .numeroTituloLongo("2374567     12345         987   ")
      .cnpjCedente(Cnpj.valueOf(80161698000166l))
      .tipoTitulo(TipoTitulo.CHEQUE)
      .tipoInformacao(TipoInformacao.SACADO_CEDENTE)
      .build();

  private TituloConciliacaoFake() {
  }

}