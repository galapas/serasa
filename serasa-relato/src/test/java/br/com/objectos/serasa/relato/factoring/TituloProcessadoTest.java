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

import static br.com.objectos.testing.MoreMatchers.isEqualTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class TituloProcessadoTest {

  @DataProvider
  public Object[][] toRegistroSinteticoProvider() {
    return new Object[][] {
        { TituloProcessadoFake.TITULO_ERRO_FREE, ErroFake.ERRO_LIST_02, RegistroSinteticoFake.TITULO_ERRO_FREE },
        { TituloProcessadoFake.TITULO_ERRO_243_317, ErroFake.ERRO_LIST_02, RegistroSinteticoFake.TITULO_ERRO_243_317 }
    };
  }

  @Test(dataProvider = "toRegistroSinteticoProvider")
  public void to_registro_sintetico(TituloProcessado titulo, List<Erro> erroList, RegistroSintetico expected) {
    ErroMap erroMap = ErroMap.mapOf(erroList);
    RegistroSintetico res = titulo.toRegistroSintetico(erroMap);
    assertThat(res, isEqualTo(expected));
  }

}