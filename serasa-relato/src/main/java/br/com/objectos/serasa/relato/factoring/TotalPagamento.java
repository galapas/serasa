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
import br.com.objectos.flat.pojo.DecimalFormat;
import br.com.objectos.flat.pojo.DecimalOption;
import br.com.objectos.flat.pojo.Fill;
import br.com.objectos.flat.pojo.Fixed;
import br.com.objectos.flat.pojo.IntegerFormat;
import br.com.objectos.flat.pojo.Prefix;
import br.com.objectos.pojo.Pojo;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
@Pojo
public abstract class TotalPagamento implements IsRecord {

  @Prefix
  @Fixed("05")
  abstract String id();

  @IntegerFormat(length = 8)
  abstract int quantidade();

  @DecimalFormat(precision = 18, scale = 2, options = { DecimalOption.ZEROFILL })
  abstract double soma();

  @Fill(character = ' ', length = 162)
  abstract String brancos();

  TotalPagamento() {
  }

  public static TotalPagamentoBuilder builder() {
    return new TotalPagamentoBuilderPojo();
  }

}