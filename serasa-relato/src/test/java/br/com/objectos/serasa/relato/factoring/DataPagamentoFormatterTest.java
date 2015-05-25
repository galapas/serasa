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

import static br.com.objectos.way.core.testing.WayMatchers.isEqualTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.testng.annotations.Test;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class DataPagamentoFormatterTest {

  private final DataPagamentoFormatter formatter = new DataPagamentoFormatter();

  @Test
  public void blank() {
    DataPagamento res = formatter.parse("");
    assertThat(res, isEqualTo(DataPagamento.empty()));
  }

  @Test
  public void empty() {
    DataPagamento res = formatter.parse("99999999");
    assertThat(res, isEqualTo(DataPagamento.empty()));
  }

  @Test
  public void present() {
    DataPagamento res = formatter.parse("20150525");
    assertThat(res, isEqualTo(DataPagamento.of(2015, 5, 25)));
  }

}