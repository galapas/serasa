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
import java.time.format.DateTimeFormatter;

import br.com.objectos.core.testing.Testable;
import br.com.objectos.core.testing.Testables;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class DataPagamento implements Testable<DataPagamento> {

  private final LocalDate value;

  private DataPagamento(LocalDate value) {
    this.value = value;
  }

  public static DataPagamento empty() {
    return new DataPagamento(null);
  }

  public static DataPagamento of(int year, int month, int day) {
    LocalDate value = LocalDate.of(year, month, day);
    return new DataPagamento(value);
  }

  public static DataPagamento of(LocalDate value) {
    return new DataPagamento(value);
  }

  @Override
  public boolean isEqual(DataPagamento o) {
    return Testables.isEqualHelper()
        .equal(value, o.value)
        .result();
  }

  public boolean isPresent() {
    return value != null;
  }

  public String write() {
    return value != null
        ? DateTimeFormatter.BASIC_ISO_DATE.format(value)
        : "        ";
  }

}