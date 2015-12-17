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
import br.com.objectos.flat.pojo.Fixed;
import br.com.objectos.flat.pojo.Prefix;
import br.com.objectos.flat.pojo.Text;
import br.com.objectos.pojo.Pojo;
import br.com.objectos.testable.Testable;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
@Pojo
public abstract class Processamento implements IsRecord, Testable {

  @Prefix
  @Fixed("77")
  abstract String id();

  @Text(length = 2)
  public abstract String numero();

  @Text(length = 186)
  public abstract String mensagem();

  Processamento() {
  }

  public static ProcessamentoBuilder builder() {
    return new ProcessamentoBuilderPojo();
  }

}