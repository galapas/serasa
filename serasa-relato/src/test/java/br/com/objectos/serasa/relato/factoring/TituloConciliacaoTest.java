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

import static br.com.objectos.way.core.testing.WayMatchers.equalTo;
import static br.com.objectos.way.core.testing.WayMatchers.hasToString;
import static org.hamcrest.MatcherAssert.assertThat;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class TituloConciliacaoTest {

  @DataProvider
  public Object[][] numeroProvider() {
    return new Object[][] {
        { TituloConciliacaoFake.TITULO_0001, "0001" },
        { TituloConciliacaoFake.TITULO_0002, "DUPLICATA-0002" },
        { TituloConciliacaoFake.TITULO_0003, " 12345" }
    };
  }

  @Test(dataProvider = "numeroProvider")
  public void numero(TituloConciliacao titulo, String expected) {
    String res = titulo.numero();
    assertThat(res, hasToString(expected));
  }

  @Test
  public void size() {
    String res = TituloConciliacaoFake.TITULO_0001.toString();
    assertThat(res.length(), equalTo(130 + 1));
  }

}