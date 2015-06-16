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

import java.util.ArrayList;
import java.util.List;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public abstract class RegistroProcessado {

  public abstract String registro();

  abstract int erro00();

  abstract int erro01();

  abstract int erro02();

  abstract int erro03();

  abstract int erro04();

  abstract int erro05();

  abstract int erro06();

  abstract int erro07();

  abstract int erro08();

  abstract int erro09();

  abstract int erro10();

  abstract int erro11();

  abstract int erro12();

  abstract int erro13();

  abstract int erro14();

  abstract int erro15();

  abstract int erro16();

  abstract int erro17();

  abstract int erro18();

  abstract int erro19();

  RegistroProcessado() {
  }

  @Override
  public String toString() {
    return registro();
  }

  RegistroSintetico toRegistroSintetico(ErroMap erroMap) {
    List<Erro> erroList = new ArrayList<>();
    addErro(erro00(), erroMap, erroList);
    addErro(erro01(), erroMap, erroList);
    addErro(erro02(), erroMap, erroList);
    addErro(erro03(), erroMap, erroList);
    addErro(erro04(), erroMap, erroList);
    addErro(erro05(), erroMap, erroList);
    addErro(erro06(), erroMap, erroList);
    addErro(erro07(), erroMap, erroList);
    addErro(erro08(), erroMap, erroList);
    addErro(erro09(), erroMap, erroList);
    addErro(erro10(), erroMap, erroList);
    addErro(erro11(), erroMap, erroList);
    addErro(erro12(), erroMap, erroList);
    addErro(erro13(), erroMap, erroList);
    addErro(erro14(), erroMap, erroList);
    addErro(erro15(), erroMap, erroList);
    addErro(erro16(), erroMap, erroList);
    addErro(erro17(), erroMap, erroList);
    addErro(erro18(), erroMap, erroList);
    addErro(erro19(), erroMap, erroList);
    return RegistroSintetico.builder()
        .registro(registro())
        .erroList(erroList)
        .build();
  }

  private void addErro(int numero, ErroMap erroMap, List<Erro> erroList) {
    if (numero != 0) {
      erroMap.addTo(numero, erroList);
    }
  }

}