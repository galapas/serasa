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
package br.com.objectos.serasa.util;

import static br.com.objectos.way.core.testing.WayMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import br.com.objectos.serasa.format.CnpjFormatter;
import br.com.objectos.way.base.br.Cnpj;

import org.testng.annotations.Test;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class CnpjFormatterTest {

  private final CnpjFormatter formatter = CnpjFormatter.get();

  @Test
  public void write() {
    Cnpj cnpj = Cnpj.valueOf(7430629000110l);
    String res = formatter.write(cnpj);
    assertThat(res, equalTo("07430629000110"));
  }

}