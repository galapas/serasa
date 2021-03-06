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

import br.com.objectos.flat.FlatFile;
import br.com.objectos.flat.WritableFlatFile;
import br.com.objectos.pojo.Pojo;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
@Pojo
public abstract class RemessaNormal implements FlatFile, WritableFlatFile {

  abstract HeaderNormal header();

  abstract List<TempoRelacionamento> tempoRelacionamentoList();

  abstract List<TituloNormal> tituloList();

  abstract TrailerNormal trailer();

  RemessaNormal() {
  }

  public static RemessaNormalBuilder builder() {
    return new RemessaNormalBuilderPojo();
  }

}