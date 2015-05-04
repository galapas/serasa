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
import br.com.objectos.io.flat.annotation.FlatEnumFormat;
import br.com.objectos.io.flat.annotation.LocalDateFormat;
import br.com.objectos.io.flat.annotation.LocalDatePattern;
import br.com.objectos.io.flat.annotation.Prefix;
import br.com.objectos.io.flat.annotation.RecordPojo;
import br.com.objectos.serasa.format.CadastroRfbFormatter;
import br.com.objectos.way.base.br.CadastroRFB;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
@RecordPojo
public abstract class TempoRelacionamento {

  @Prefix
  @Fixed("01")
  abstract String id();

  @CustomFormat(length = 14, formatter = CadastroRfbFormatter.class)
  abstract CadastroRFB cadastroSacado();

  @FlatEnumFormat(length = 2)
  abstract TempoRelacionamentoTipo tipo();

  @LocalDateFormat(LocalDatePattern.YYYYMMDD)
  abstract LocalDate clienteDesde();

  @FlatEnumFormat(length = 1)
  abstract TipoCliente tipoCliente();

  @Fill(character = ' ', length = 38)
  abstract String brancos0();

  @Fill(character = ' ', length = 34)
  abstract String brancos1();

  @Fill(character = ' ', length = 1)
  abstract String brancos2();

  @Fill(character = ' ', length = 30)
  abstract String brancos3();

  TempoRelacionamento() {
  }

  public static TempoRelacionamentoBuilder builder() {
    return new TempoRelacionamentoBuilderPojo();
  }

}