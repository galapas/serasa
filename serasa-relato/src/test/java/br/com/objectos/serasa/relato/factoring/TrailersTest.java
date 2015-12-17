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

import static br.com.objectos.assertion.TestableAssertion.assertThat;

import java.util.List;

import org.testng.annotations.Test;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class TrailersTest {

  @Test
  public void normal() {
    List<TempoRelacionamento> tempoRelacionamentoList = TempoRelacionamentoFake.list();
    List<TituloNormal> tituloList = TituloNormalFake.list();
    TrailerNormal res = Trailers.normal(tempoRelacionamentoList, tituloList);
    TrailerNormal ans = TrailerNormal.builder()
        .tempoRelacionamentoPj(1)
        .titulosPj(2)
        .tempoRelacionamentoPf(2)
        .titulosPf(1)
        .build();
    assertThat(res).isEqualTo(ans);
  }

}