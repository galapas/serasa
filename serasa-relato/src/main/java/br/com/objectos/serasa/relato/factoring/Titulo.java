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

import br.com.objectos.io.flat.annotation.CustomFormat;
import br.com.objectos.io.flat.annotation.DecimalFormat;
import br.com.objectos.io.flat.annotation.DecimalOption;
import br.com.objectos.io.flat.annotation.Fill;
import br.com.objectos.io.flat.annotation.Fixed;
import br.com.objectos.io.flat.annotation.FlatEnumFormat;
import br.com.objectos.io.flat.annotation.LocalDateFormat;
import br.com.objectos.io.flat.annotation.LocalDatePattern;
import br.com.objectos.io.flat.annotation.Prefix;
import br.com.objectos.io.flat.annotation.RecordPojo;
import br.com.objectos.io.flat.annotation.Text;
import br.com.objectos.io.flat.annotation.WhenAbsent;
import br.com.objectos.serasa.format.CadastroRfbFormatter;
import br.com.objectos.serasa.format.CnpjFormatter;
import br.com.objectos.way.base.br.CadastroRFB;
import br.com.objectos.way.base.br.Cnpj;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
@RecordPojo
public abstract class Titulo {

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

  @CustomFormat(length = 14, formatter = CnpjFormatter.class)
  abstract Cnpj cnpjCedente();

  @Fixed("0")
  abstract String ajusteCnpjCedente();

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

  Titulo() {
  }

  public static TituloBuilder builder() {
    return new TituloBuilderPojo();
  }

}