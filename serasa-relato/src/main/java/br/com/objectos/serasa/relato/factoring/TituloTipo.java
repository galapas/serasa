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
import br.com.objectos.serasa.format.CnpjFormatter;
import br.com.objectos.serasa.format.CpfFormatter;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public enum TituloTipo implements FlatEnum {

  CNPJ("05") {
    @Override
    void addTo(TrailerConciliacaoHelper helper) {
      helper.titulosPj();
    }

    @Override
    void addTo(TrailerNormalHelper helper) {
      helper.titulosPj();
    }

    @Override
    CadastroRFB cadastroRfb(String valor) {
      return CnpjFormatter.get().parse(valor);
    }
  },

  CPF("09") {
    @Override
    void addTo(TrailerConciliacaoHelper helper) {
      helper.titulosPf();
    }

    @Override
    void addTo(TrailerNormalHelper helper) {
      helper.titulosPf();
    }

    @Override
    CadastroRFB cadastroRfb(String valor) {
      return CpfFormatter.get().parse(valor);
    }
  };

  private final String flatValue;

  private TituloTipo(String flatValue) {
    this.flatValue = flatValue;
  }

  public static TituloTipo of(CadastroRFB cadastroRfb) {
    return cadastroRfb instanceof Cnpj ? CNPJ : CPF;
  }

  @Override
  public String flatValue() {
    return flatValue;
  }

  abstract void addTo(TrailerConciliacaoHelper helper);

  abstract void addTo(TrailerNormalHelper helper);

  abstract CadastroRFB cadastroRfb(String valor);

}