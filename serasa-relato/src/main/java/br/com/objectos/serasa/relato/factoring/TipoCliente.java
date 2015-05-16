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
import java.time.Period;

import br.com.objectos.io.flat.FlatEnum;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public enum TipoCliente implements FlatEnum {

  ANTIGO("1"),

  MENOS_UM_ANO("2"),

  INATIVO("3");

  private final String flatValue;

  private TipoCliente(String flatValue) {
    this.flatValue = flatValue;
  }

  public static TipoCliente of(LocalDate clienteDesde, LocalDate dataBase) {
    Period period = Period.between(clienteDesde, dataBase);
    int years = period.getYears();
    return years < 1
        ? MENOS_UM_ANO
        : ANTIGO;
  }

  @Override
  public String flatValue() {
    return flatValue;
  }

}