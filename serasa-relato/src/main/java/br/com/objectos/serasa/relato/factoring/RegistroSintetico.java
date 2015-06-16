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

import br.com.objectos.core.auto.AutoPojo;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
@AutoPojo
public abstract class RegistroSintetico {

  public abstract String registro();

  public abstract List<Erro> erroList();

  RegistroSintetico() {
  }

  public static RegistroSinteticoBuilder builder() {
    return new RegistroSinteticoBuilderPojo();
  }

}