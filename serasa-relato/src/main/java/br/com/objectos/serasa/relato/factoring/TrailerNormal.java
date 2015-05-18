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

import br.com.objectos.io.flat.annotation.Fill;
import br.com.objectos.io.flat.annotation.Fixed;
import br.com.objectos.io.flat.annotation.IntegerFormat;
import br.com.objectos.io.flat.annotation.IntegerOption;
import br.com.objectos.io.flat.annotation.Prefix;
import br.com.objectos.io.flat.annotation.RecordPojo;
import br.com.objectos.way.core.testing.Testable;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
@RecordPojo
public abstract class TrailerNormal implements Testable<TrailerNormal> {

  @Prefix
  @Fixed("99")
  abstract String id();

  @IntegerFormat(length = 11, options = { IntegerOption.ZEROFILL })
  abstract int tempoRelacionamentoPj();

  @Fill(character = ' ', length = 44)
  abstract String brancos0();

  @IntegerFormat(length = 11, options = { IntegerOption.ZEROFILL })
  abstract int titulosPj();

  @IntegerFormat(length = 11, options = { IntegerOption.ZEROFILL })
  abstract int tempoRelacionamentoPf();

  @IntegerFormat(length = 11, options = { IntegerOption.ZEROFILL })
  abstract int titulosPf();

  @Fill(character = ' ', length = 10)
  abstract String reservado();

  @Fill(character = ' ', length = 30)
  abstract String brancos1();

  TrailerNormal() {
  }

  public static TrailerNormalBuilder builder() {
    return new TrailerNormalBuilderPojo();
  }

}