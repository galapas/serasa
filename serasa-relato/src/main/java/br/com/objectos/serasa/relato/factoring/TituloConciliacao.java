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
import br.com.objectos.flat.IsRecord;
import br.com.objectos.flat.pojo.CustomFormat;
import br.com.objectos.flat.pojo.DecimalFormat;
import br.com.objectos.flat.pojo.DecimalOption;
import br.com.objectos.flat.pojo.Fill;
import br.com.objectos.flat.pojo.Fixed;
import br.com.objectos.flat.pojo.FlatEnumFormat;
import br.com.objectos.flat.pojo.LocalDateFormat;
import br.com.objectos.flat.pojo.LocalDatePattern;
import br.com.objectos.flat.pojo.Prefix;
import br.com.objectos.flat.pojo.Text;
import br.com.objectos.pojo.Pojo;
import br.com.objectos.serasa.format.CadastroSacadoFormatter;
import br.com.objectos.serasa.format.CnpjFormatter;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
@Pojo
public abstract class TituloConciliacao implements IsRecord {

  @Prefix
  @Fixed("01")
  abstract String id();

  @CustomFormat(length = 16, formatter = CadastroSacadoFormatter.class)
  public abstract CadastroSacado cadastroSacado();

  @Text(length = 10)
  public abstract String numeroTitulo();

  @LocalDateFormat(LocalDatePattern.YYYYMMDD)
  public abstract LocalDate dataEmissao();

  @DecimalFormat(precision = 13, scale = 2, options = { DecimalOption.ZEROFILL })
  public abstract double valorNominal();

  @LocalDateFormat(LocalDatePattern.YYYYMMDD)
  public abstract LocalDate dataVencimento();

  @CustomFormat(length = 8, formatter = DataPagamentoFormatter.class)
  abstract DataPagamento dataPagamento();

  @Text(length = 2)
  public abstract String hashD();

  @Text(length = 32)
  public abstract String numeroTituloLongo();

  @Fill(character = ' ', length = 1)
  abstract String brancos0();

  @Fixed("0")
  abstract String ajusteCnpjCedente();

  @CustomFormat(length = 14, formatter = CnpjFormatter.class)
  public abstract Cnpj cnpjCedente();

  @FlatEnumFormat(length = 2)
  public abstract TipoTitulo tipoTitulo();

  @Fill(character = ' ', length = 1)
  abstract String reservado0();

  @Fixed("CO")
  abstract String tipoNegocio();

  @FlatEnumFormat(length = 2)
  public abstract TipoInformacao tipoInformacao();

  @Fixed("CS")
  abstract String tipoCarteira();

  @Fill(character = ' ', length = 2)
  abstract String reservado1();

  @Fill(character = ' ', length = 1)
  abstract String reservado2();

  @Fill(character = ' ', length = 1)
  abstract String reservado3();

  @Fill(character = ' ', length = 2)
  abstract String reservado4();

  TituloConciliacao() {
  }

  public static TituloConciliacaoBuilder builder() {
    return new TituloConciliacaoBuilderPojo();
  }

  public String numero() {
    return tipoTitulo().tituloNumeroConciliacao(this);
  }

  void addTo(TrailerConciliacaoHelper helper) {
    cadastroSacado().tipo().addTo(helper);
  }

}