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

import br.com.objectos.io.flat.annotation.Fixed;
import br.com.objectos.io.flat.annotation.IntegerFormat;
import br.com.objectos.io.flat.annotation.Prefix;
import br.com.objectos.io.flat.annotation.RecordPojo;
import br.com.objectos.io.flat.annotation.Text;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
@RecordPojo
public abstract class HeaderProcessado {

  @Prefix
  @Fixed("00")
  abstract String id();

  @Text(length = 128)
  abstract String registro();

  @IntegerFormat(length = 3)
  abstract int erro00();

  @IntegerFormat(length = 3)
  abstract int erro01();

  @IntegerFormat(length = 3)
  abstract int erro02();

  @IntegerFormat(length = 3)
  abstract int erro03();

  @IntegerFormat(length = 3)
  abstract int erro04();

  @IntegerFormat(length = 3)
  abstract int erro05();

  @IntegerFormat(length = 3)
  abstract int erro06();

  @IntegerFormat(length = 3)
  abstract int erro07();

  @IntegerFormat(length = 3)
  abstract int erro08();

  @IntegerFormat(length = 3)
  abstract int erro09();

  @IntegerFormat(length = 3)
  abstract int erro10();

  @IntegerFormat(length = 3)
  abstract int erro11();

  @IntegerFormat(length = 3)
  abstract int erro12();

  @IntegerFormat(length = 3)
  abstract int erro13();

  @IntegerFormat(length = 3)
  abstract int erro14();

  @IntegerFormat(length = 3)
  abstract int erro15();

  @IntegerFormat(length = 3)
  abstract int erro16();

  @IntegerFormat(length = 3)
  abstract int erro17();

  @IntegerFormat(length = 3)
  abstract int erro18();

  @IntegerFormat(length = 3)
  abstract int erro19();

  HeaderProcessado() {
  }

  public static HeaderProcessadoBuilder builder() {
    return new HeaderProcessadoBuilderPojo();
  }

}