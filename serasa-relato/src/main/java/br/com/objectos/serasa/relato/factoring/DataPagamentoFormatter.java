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

import java.time.LocalDate;

import br.com.objectos.flat.CustomFormatter;
import br.com.objectos.flat.pojo.LocalDatePattern;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class DataPagamentoFormatter implements CustomFormatter<DataPagamento> {

  @Override
  public DataPagamento parse(String text) {
    switch (text.trim()) {
    case "":
    case "99999999":
      return DataPagamento.empty();

    default:
      LocalDate value = LocalDatePattern.YYYYMMDD.parse(text);
      return DataPagamento.of(value);

    }
  }

  @Override
  public String write(DataPagamento value) {
    return value.write();
  }

}