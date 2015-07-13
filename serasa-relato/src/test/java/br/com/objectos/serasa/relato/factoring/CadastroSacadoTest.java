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

import static br.com.objectos.testing.MoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import br.com.objectos.way.base.br.CadastroRFB;
import br.com.objectos.way.base.br.Cnpj;
import br.com.objectos.way.base.br.Cpf;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class CadastroSacadoTest {

  @DataProvider
  public Object[][] parseProvider() {
    return new Object[][] { //
        { "2188517539600009", Cpf.valueOf(21885175396l) },
        { "0743062900011005", Cnpj.valueOf(7430629000110l) }
    };
  }

  @Test(dataProvider = "parseProvider")
  public void parse(String text, CadastroRFB expected) {
    CadastroRFB res = CadastroSacado.parse(text).cadastroRfb();
    assertThat(res, equalTo(expected));
  }

}