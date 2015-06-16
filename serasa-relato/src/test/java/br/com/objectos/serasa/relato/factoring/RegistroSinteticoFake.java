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

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class RegistroSinteticoFake {

  public static final RegistroSintetico TITULO_ERRO_FREE = RegistroSintetico.builder()
      .registro("Sem erros")
      .erroList()
      .build();

  public static final RegistroSintetico TITULO_ERRO_243_317 = RegistroSintetico.builder()
      .registro("Erros 243 e 317")
      .erroList(ErroFake.ERRO_243, ErroFake.ERRO_317)
      .build();

  private RegistroSinteticoFake() {
  }

}