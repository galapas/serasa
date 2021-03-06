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
import br.com.objectos.flat.pojo.Fill;
import br.com.objectos.flat.pojo.Fixed;
import br.com.objectos.flat.pojo.LocalDateFormat;
import br.com.objectos.flat.pojo.LocalDatePattern;
import br.com.objectos.flat.pojo.Prefix;
import br.com.objectos.flat.pojo.Text;
import br.com.objectos.pojo.Pojo;
import br.com.objectos.serasa.format.CnpjFormatter;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
@Pojo
public abstract class HeaderConciliacao implements IsRecord {

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
  public abstract String reservado();

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