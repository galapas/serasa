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

import java.io.StringReader;

import br.com.objectos.br.CadastroRFB;
import br.com.objectos.flat.FlatFileReader;
import br.com.objectos.flat.IsRecord;
import br.com.objectos.flat.pojo.FlatEnumFormat;
import br.com.objectos.flat.pojo.Text;
import br.com.objectos.pojo.Pojo;
import br.com.objectos.serasa.format.CadastroRfbFormatter;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
@Pojo
public abstract class CadastroSacado implements IsRecord {

  @Text(length = 14)
  abstract String valor();

  @FlatEnumFormat(length = 2)
  abstract TituloTipo tipo();

  CadastroSacado() {
  }

  public static CadastroSacadoBuilder builder() {
    return new CadastroSacadoBuilderPojo();
  }

  public static CadastroSacado of(CadastroRFB cadastro) {
    return CadastroSacado.builder()
        .valor(CadastroRfbFormatter.get().write(cadastro))
        .tipo(TituloTipo.of(cadastro))
        .build();
  }

  public static CadastroSacado parse(String text) {
    FlatFileReader reader = FlatFileReader.get(new StringReader(text));
    return reader.parseOne(CadastroSacadoParser.get()).get();
  }

  public CadastroRFB cadastroRfb() {
    return tipo().cadastroRfb(valor());
  }

}