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

import com.google.common.collect.ImmutableList;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class RelatorioFake {

  public static final Relatorio REMESSA_OK = Relatorio.builder()
      .texto("Remessa OK")
      .build();

  public static final List<Relatorio> RELATORIO_02 = ImmutableList.<Relatorio> builder()
      .add(relatorio("CNPJ DA CONVENIADA   : 07430629/0001-10      GRUPO RELATO: 028"))
      .add(relatorio("CODIGO DE CLIENTE    : 00000  DATA DO RECEBIMENTO:  12.06.2015"))
      .add(relatorio("DATA  INFORMACAO  DE : 11062015"))
      .add(relatorio("DATA  INFORMACAO ATE : 11062015  PERIODICIDADE  FONTE :"))
      .add(relatorio("REMESSA TESTE - TOTALMENTE DESPREZADA      (AMB - EXT     )"))
      .add(relatorio("TOTAL INFORMADO PELA CONVENIADA:"))
      .add(relatorio("CLIENTES                     :         54"))
      .add(relatorio("TITULOS                      :         68"))
      .add(relatorio("COM DATA DE PAGTOS         :         43"))
      .add(relatorio("SEM DATA DE PAGTOS         :         22"))
      .add(relatorio("TOTAL REGISTROS EXCLUIDOS      :          3"))
      .add(relatorio("TOTAL REGISTROS ENVIADOS       :        122"))
      .add(relatorio("QTDE  EMPRESAS ENVIADAS        :         54"))
      .add(relatorio("TOTAL REGISTROS INCONSISTIDOS  :         60"))
      .add(relatorio("% INCONSISTENCIA DA REMESSA    :      49,18%"))
      .add(relatorio("% INCONSISTENCIA LIMITE        :      20,00%"))
      .add(relatorio("COD  DESCRICAO DA MENSAGEM/CONSISTENCIA                      QTDE"))
      .add(relatorio("---  ------------------------------------------------------- ----------"))
      .build();

  private RelatorioFake() {
  }

  private static Relatorio relatorio(String texto) {
    return Relatorio.builder()
        .texto(texto)
        .build();
  }

}