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

import java.util.List;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class Trailers {

  private Trailers() {
  }

  public static TrailerConciliacaoBuilder conciliacao() {
    return TrailerConciliacao.builder();
  }

  public static TrailerConciliacao conciliacao(List<TituloConciliacao> tituloList) {
    TrailerConciliacaoHelper helper = new TrailerConciliacaoHelper();
    for (TituloConciliacao titulo : tituloList) {
      titulo.addTo(helper);
    }
    return helper.build();
  }

  public static TrailerNormalBuilder normal() {
    return TrailerNormal.builder();
  }

  public static TrailerNormal normal(List<TempoRelacionamento> tempoList, List<TituloNormal> tituloList) {
    TrailerNormalHelper helper = new TrailerNormalHelper();
    for (TempoRelacionamento tempo : tempoList) {
      tempo.addTo(helper);
    }
    for (TituloNormal titulo : tituloList) {
      titulo.addTo(helper);
    }
    return helper.build();
  }

}