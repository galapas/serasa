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
class TituloProcessadoFake {

  public static final TituloProcessado TITULO_ERRO_FREE= TituloProcessado.builder()
      .registro("Sem erros")
      .erro00(0)
      .erro01(0)
      .erro02(0)
      .erro03(0)
      .erro04(0)
      .erro05(0)
      .erro06(0)
      .erro07(0)
      .erro08(0)
      .erro09(0)
      .erro10(0)
      .erro11(0)
      .erro12(0)
      .erro13(0)
      .erro14(0)
      .erro15(0)
      .erro16(0)
      .erro17(0)
      .erro18(0)
      .erro19(0)
      .build();

  public static final TituloProcessado TITULO_ERRO_243_317 = TituloProcessado.builder()
      .registro("Erros 243 e 317")
      .erro00(243)
      .erro01(317)
      .erro02(0)
      .erro03(0)
      .erro04(0)
      .erro05(0)
      .erro06(0)
      .erro07(0)
      .erro08(0)
      .erro09(0)
      .erro10(0)
      .erro11(0)
      .erro12(0)
      .erro13(0)
      .erro14(0)
      .erro15(0)
      .erro16(0)
      .erro17(0)
      .erro18(0)
      .erro19(0)
      .build();

  private TituloProcessadoFake() {
  }

}