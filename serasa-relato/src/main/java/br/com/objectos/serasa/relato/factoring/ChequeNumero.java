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

import br.com.objectos.flat.IsRecord;
import br.com.objectos.flat.pojo.Fill;
import br.com.objectos.flat.pojo.IntegerFormat;
import br.com.objectos.flat.pojo.IntegerOption;
import br.com.objectos.pojo.Pojo;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
@Pojo
public abstract class ChequeNumero implements IsRecord {

  @IntegerFormat(length = 3, options = { IntegerOption.ZEROFILL })
  abstract int banco();

  @IntegerFormat(length = 4, options = { IntegerOption.ZEROFILL })
  abstract int agencia();

  @Fill(character = '0', length = 4)
  abstract String filler0();

  @IntegerFormat(length = 6, options = { IntegerOption.ZEROFILL })
  abstract int numero();

  @Fill(character = '0', length = 2)
  abstract String filler1();

  @IntegerFormat(length = 10, options = { IntegerOption.ZEROFILL })
  abstract int conta();

  @Fill(character = '0', length = 1)
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