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

import static br.com.objectos.testing.MoreMatchers.isEqualTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.testng.annotations.Test;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class TituloNumeroTest {

  @Test
  public void cheque() {
    ChequeNumero cheque = ChequeNumero.builder()
        .banco(237)
        .agencia(4567)
        .numero(12345)
        .conta(987)
        .build();
    TituloNumero res = cheque.toTituloNumero();
    TituloNumero ans = TituloNumero.builder()
        .numero("")
        .hashD("#D")
        .numeroLongo("237456700000123450000000009870  ")
        .build();
    assertThat(res, isEqualTo(ans));
  }

  @Test
  public void cheque_truncate() {
    ChequeNumero cheque = ChequeNumero.builder()
        .banco(237)
        .agencia(456789)
        .numero(1234567)
        .conta(1234567890)
        .build();
    TituloNumero res = cheque.toTituloNumero();
    TituloNumero ans = TituloNumero.builder()
        .numero("")
        .hashD("#D")
        .numeroLongo("237456700001234560012345678900  ")
        .build();
    assertThat(res, isEqualTo(ans));
  }

  @Test
  public void duplicata() {
    TituloNumero res = TituloNumero.outros("1234567890");
    TituloNumero ans = TituloNumero.builder()
        .numero("1234567890")
        .hashD("")
        .numeroLongo("")
        .build();
    assertThat(res, isEqualTo(ans));
  }

  @Test
  public void duplicata_longo() {
    TituloNumero res = TituloNumero.outros("12345678901");
    TituloNumero ans = TituloNumero.builder()
        .numero("")
        .hashD("#D")
        .numeroLongo("12345678901")
        .build();
    assertThat(res, isEqualTo(ans));
  }

}