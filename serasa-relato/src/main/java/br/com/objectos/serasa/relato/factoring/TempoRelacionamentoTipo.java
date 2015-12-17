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

import br.com.objectos.br.CadastroRFB;
import br.com.objectos.br.Cnpj;
import br.com.objectos.flat.FlatEnum;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public enum TempoRelacionamentoTipo implements FlatEnum {

  CNPJ("01") {
    @Override
    void addTo(TrailerNormalHelper helper) {
      helper.tempoRelacionamentoPj();
    }
  },

  CPF("08") {
    @Override
    void addTo(TrailerNormalHelper helper) {
      helper.tempoRelacionamentoPf();
    }
  };

  private final String flatValue;

  private TempoRelacionamentoTipo(String flatValue) {
    this.flatValue = flatValue;
  }

  public static TempoRelacionamentoTipo of(CadastroRFB cadastroRfb) {
    return cadastroRfb instanceof Cnpj ? CNPJ : CPF;
  }

  @Override
  public String flatValue() {
    return flatValue;
  }

  abstract void addTo(TrailerNormalHelper helper);

}