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

import br.com.objectos.io.flat.annotation.Fill;
import br.com.objectos.io.flat.annotation.Fixed;
import br.com.objectos.io.flat.annotation.IntegerFormat;
import br.com.objectos.io.flat.annotation.Prefix;
import br.com.objectos.io.flat.annotation.RecordPojo;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
@RecordPojo
public abstract class TotalCliente {

  @Prefix
  @Fixed("01")
  abstract String id();

  @IntegerFormat(length = 6)
  abstract int quantidade();

  @Fill(character = ' ', length = 182)
  abstract String brancos();

  TotalCliente() {
  }

  public static TotalClienteBuilder builder() {
    return new TotalClienteBuilderPojo();
  }

}