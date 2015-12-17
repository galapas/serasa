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
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

import br.com.objectos.br.Cnpj;
import br.com.objectos.flat.FlatFile;
import br.com.objectos.flat.WritableFlatFile;
import br.com.objectos.pojo.Pojo;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
@Pojo
public abstract class RemessaConciliacao implements FlatFile, WritableFlatFile {

  abstract HeaderConciliacao header();

  abstract List<TituloConciliacao> tituloList();

  abstract TrailerConciliacao trailer();

  RemessaConciliacao() {
  }

  public static RemessaConciliacaoBuilder builder() {
    return new RemessaConciliacaoBuilderPojo();
  }

  public static RemessaConciliacao parse(Reader input) throws RemessaConciliacaoParseException {
    return RemessaConciliacaoParser.get().parse(input);
  }

  public static RemessaConciliacao parse(String input) throws RemessaConciliacaoParseException {
    return RemessaConciliacaoParser.get().parse(input);
  }

  public Cnpj cnpj() {
    return header().cnpj();
  }

  public LocalDate dataFinal() {
    return header().dataFinal();
  }

  public String reservado() {
    return header().reservado();
  }

  public Stream<TituloConciliacao> tituloStream() {
    return tituloList().stream();
  }

  public int titulosPf() {
    return trailer().titulosPf();
  }

  public int titulosPj() {
    return trailer().titulosPj();
  }

}