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

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public abstract class RegistroProcessado {

  public abstract String registro();

  abstract int erro00();

  abstract int erro01();

  abstract int erro02();

  abstract int erro03();

  abstract int erro04();

  abstract int erro05();

  abstract int erro06();

  abstract int erro07();

  abstract int erro08();

  abstract int erro09();

  abstract int erro10();

  abstract int erro11();

  abstract int erro12();

  abstract int erro13();

  abstract int erro14();

  abstract int erro15();

  abstract int erro16();

  abstract int erro17();

  abstract int erro18();

  abstract int erro19();

  RegistroProcessado() {
  }

  @Override
  public String toString() {
    return registro();
  }

}