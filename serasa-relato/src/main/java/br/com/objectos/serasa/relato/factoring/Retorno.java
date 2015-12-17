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

import java.io.Reader;
import java.util.List;
import java.util.stream.Collectors;

import br.com.objectos.flat.FlatFile;
import br.com.objectos.pojo.Pojo;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
@Pojo
public abstract class Retorno implements FlatFile {

  abstract Processamento processamento();

  abstract List<Relatorio> relatorioList();

  abstract List<Erro> erroList();

  abstract HeaderProcessado headerProcessado();

  abstract List<TituloProcessado> tituloProcessadoList();

  abstract List<TotalCliente> totalCliente();

  abstract List<TotalPagamento> totalPagamento();

  Retorno() {
  }

  public static RetornoBuilder builder() {
    return new RetornoBuilderPojo();
  }

  public static Retorno parse(Reader input) throws RetornoParseException {
    return RetornoParser.get().parse(input);
  }

  public static Retorno parse(String input) throws RetornoParseException {
    return RetornoParser.get().parse(input);
  }

  public RetornoSintetico toRetornoSintetico() {
    List<Erro> erroList = erroList();
    ErroMap erroMap = ErroMap.mapOf(erroList);
    return RetornoSintetico.builder()
        .valido(processamento().numero().equals("01"))
        .processamento(processamento().mensagem())
        .relatorioList(relatorioList().stream()
            .map(Relatorio::texto)
            .collect(Collectors.toList()))
        .erroList(erroList())
        .header(headerProcessado().toRegistroSintetico(erroMap))
        .tituloList(tituloProcessadoList().stream()
            .map(it -> it.toRegistroSintetico(erroMap))
            .collect(Collectors.toList()))
        .build();
  }

}