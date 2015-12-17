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
import br.com.objectos.flat.pojo.Fixed;
import br.com.objectos.flat.pojo.IntegerFormat;
import br.com.objectos.flat.pojo.Prefix;
import br.com.objectos.flat.pojo.Text;
import br.com.objectos.pojo.Pojo;
import br.com.objectos.testable.Testable;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
@Pojo
public abstract class Erro implements IsRecord, Testable {

  @Prefix
  @Fixed("88")
  abstract String id();

  @IntegerFormat(length = 3)
  public abstract int numero();

  @Fill(character = ' ', length = 2)
  abstract String brancos0();

  @Text(length = 55)
  public abstract String descricao();

  @Fill(character = ' ', length = 1)
  abstract String brancos1();

  @IntegerFormat(length = 9)
  public abstract int quantidade();

  @Fill(character = ' ', length = 118)
  abstract String brancos2();

  Erro() {
  }

  public static ErroBuilder builder() {
    return new ErroBuilderPojo();
  }

}