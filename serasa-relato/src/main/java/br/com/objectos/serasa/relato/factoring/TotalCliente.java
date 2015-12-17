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

import br.com.objectos.flat.IsRecord;
import br.com.objectos.flat.pojo.Fill;
import br.com.objectos.flat.pojo.Fixed;
import br.com.objectos.flat.pojo.IntegerFormat;
import br.com.objectos.flat.pojo.Prefix;
import br.com.objectos.pojo.Pojo;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
@Pojo
public abstract class TotalCliente implements IsRecord {

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