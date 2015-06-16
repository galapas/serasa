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
import br.com.objectos.io.flat.annotation.WhenZero;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
@RecordPojo
public abstract class HeaderProcessado extends RegistroProcessado {

  @Prefix
  @Fixed("00")
  abstract String id();

  @Override
  @Text(length = 128)
  public abstract String registro();

  @Override
  @IntegerFormat(length = 3)
  @WhenZero("   ")
  abstract int erro00();

  @Override
  @IntegerFormat(length = 3)
  @WhenZero("   ")
  abstract int erro01();

  @Override
  @IntegerFormat(length = 3)
  @WhenZero("   ")
  abstract int erro02();

  @Override
  @IntegerFormat(length = 3)
  @WhenZero("   ")
  abstract int erro03();

  @Override
  @IntegerFormat(length = 3)
  @WhenZero("   ")
  abstract int erro04();

  @Override
  @IntegerFormat(length = 3)
  @WhenZero("   ")
  abstract int erro05();

  @Override
  @IntegerFormat(length = 3)
  @WhenZero("   ")
  abstract int erro06();

  @Override
  @IntegerFormat(length = 3)
  @WhenZero("   ")
  abstract int erro07();

  @Override
  @IntegerFormat(length = 3)
  @WhenZero("   ")
  abstract int erro08();

  @Override
  @IntegerFormat(length = 3)
  @WhenZero("   ")
  abstract int erro09();

  @Override
  @IntegerFormat(length = 3)
  @WhenZero("   ")
  abstract int erro10();

  @Override
  @IntegerFormat(length = 3)
  @WhenZero("   ")
  abstract int erro11();

  @Override
  @IntegerFormat(length = 3)
  @WhenZero("   ")
  abstract int erro12();

  @Override
  @IntegerFormat(length = 3)
  @WhenZero("   ")
  abstract int erro13();

  @Override
  @IntegerFormat(length = 3)
  @WhenZero("   ")
  abstract int erro14();

  @Override
  @IntegerFormat(length = 3)
  @WhenZero("   ")
  abstract int erro15();

  @Override
  @IntegerFormat(length = 3)
  @WhenZero("   ")
  abstract int erro16();

  @Override
  @IntegerFormat(length = 3)
  @WhenZero("   ")
  abstract int erro17();

  @Override
  @IntegerFormat(length = 3)
  @WhenZero("   ")
  abstract int erro18();

  @Override
  @IntegerFormat(length = 3)
  @WhenZero("   ")
  abstract int erro19();

  HeaderProcessado() {
  }

  public static HeaderProcessadoBuilder builder() {
    return new HeaderProcessadoBuilderPojo();
  }

}