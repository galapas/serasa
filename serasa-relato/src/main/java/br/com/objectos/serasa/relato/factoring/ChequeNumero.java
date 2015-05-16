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
import br.com.objectos.io.flat.annotation.IntegerFormat;
import br.com.objectos.io.flat.annotation.RecordPojo;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
@RecordPojo
public abstract class ChequeNumero {

  @IntegerFormat(length = 3)
  abstract int banco();

  @IntegerFormat(length = 4)
  abstract int agencia();

  @Fill(character = ' ', length = 4)
  abstract String filler0();

  @IntegerFormat(length = 6)
  abstract int numero();

  @Fill(character = ' ', length = 2)
  abstract String filler1();

  @IntegerFormat(length = 10)
  abstract int conta();

  @Fill(character = ' ', length = 1)
  abstract String filler2();

  @Fill(character = ' ', length = 2)
  abstract String filler3();

  ChequeNumero() {
  }

  public static ChequeNumeroBuilder builder() {
    return new ChequeNumeroBuilderPojo();
  }

  public TituloNumero toTituloNumero() {
    return TituloNumero.cheque(this);
  }

}