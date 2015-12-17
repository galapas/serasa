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
import java.util.Optional;

import br.com.objectos.br.CadastroRFB;
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
import br.com.objectos.flat.pojo.WhenAbsent;
import br.com.objectos.flat.pojo.WhenZero;
import br.com.objectos.pojo.Pojo;
import br.com.objectos.serasa.format.CadastroRfbFormatter;
import br.com.objectos.serasa.format.CnpjFormatter;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
@Pojo
public abstract class TituloNormal implements IsRecord {

  @Prefix
  @Fixed("01")
  abstract String id();

  @CustomFormat(length = 14, formatter = CadastroRfbFormatter.class)
  abstract CadastroRFB cadastroSacado();

  @FlatEnumFormat(length = 2)
  abstract TituloTipo tipo();

  @Text(length = 10)
  abstract String numeroTitulo();

  @LocalDateFormat(LocalDatePattern.YYYYMMDD)
  abstract LocalDate dataEmissao();

  @DecimalFormat(precision = 13, scale = 2, options = { DecimalOption.ZEROFILL })
  @WhenZero("9999999999999")
  abstract double valorNominal();

  @LocalDateFormat(LocalDatePattern.YYYYMMDD)
  abstract LocalDate dataVencimento();

  @LocalDateFormat(LocalDatePattern.YYYYMMDD)
  @WhenAbsent("        ")
  abstract Optional<LocalDate> dataPagamento();

  @Text(length = 2)
  abstract String hashD();

  @Text(length = 32)
  abstract String numeroTituloLongo();

  @Fill(character = ' ', length = 1)
  abstract String brancos0();

  @Fixed("0")
  abstract String ajusteCnpjCedente();

  @CustomFormat(length = 14, formatter = CnpjFormatter.class)
  abstract Cnpj cnpjCedente();

  @FlatEnumFormat(length = 2)
  abstract TipoTitulo tipoTitulo();

  @Fill(character = ' ', length = 1)
  abstract String reservado0();

  @Fixed("CO")
  abstract String tipoNegocio();

  @FlatEnumFormat(length = 2)
  abstract TipoInformacao tipoInformacao();

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

  TituloNormal() {
  }

  public static TituloNormalBuilder builder() {
    return new TituloNormalBuilderPojo();
  }

  void addTo(TrailerNormalHelper helper) {
    tipo().addTo(helper);
  }

}