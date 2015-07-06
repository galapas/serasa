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

import br.com.objectos.io.flat.annotation.CustomFormat;
import br.com.objectos.io.flat.annotation.Fill;
import br.com.objectos.io.flat.annotation.Fixed;
import br.com.objectos.io.flat.annotation.LocalDateFormat;
import br.com.objectos.io.flat.annotation.LocalDatePattern;
import br.com.objectos.io.flat.annotation.Prefix;
import br.com.objectos.io.flat.annotation.RecordPojo;
import br.com.objectos.io.flat.annotation.Text;
import br.com.objectos.serasa.format.CnpjFormatter;
import br.com.objectos.way.base.br.Cnpj;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
@RecordPojo
public abstract class HeaderConciliacao {

  @Prefix
  @Fixed("00")
  abstract String id();

  @Fixed("RELATO COMP NEGOCIOS")
  abstract String identificacao();

  @CustomFormat(length = 14, formatter = CnpjFormatter.class)
  public abstract Cnpj cnpj();

  @Fixed("CONCILIA")
  abstract String concilia();

  @LocalDateFormat(LocalDatePattern.YYYYMMDD)
  public abstract LocalDate dataFinal();

  @Fixed("D")
  abstract String periodicidade();

  @Text(length = 15)
  abstract String reservado();

  @Fixed("028")
  abstract String segmentoFactoring();

  @Fill(character = ' ', length = 29)
  abstract String brancos0();

  @Fixed("V.")
  abstract String identificacaoVersao();

  @Fixed("01")
  abstract String versao();

  @Fill(character = ' ', length = 26)
  abstract String brancos1();

  HeaderConciliacao() {
  }

  public static HeaderConciliacaoBuilder builder() {
    return new HeaderConciliacaoBuilderPojo();
  }

}