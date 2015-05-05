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
package br.com.objectos.serasa.format;

import br.com.objectos.io.flat.CustomFormatter;
import br.com.objectos.way.base.br.CadastroRFB;
import br.com.objectos.way.base.br.Cnpj;
import br.com.objectos.way.base.br.Cpf;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class CadastroRfbFormatter implements CustomFormatter<CadastroRFB> {

  private static final CadastroRfbFormatter INSTANCE = new CadastroRfbFormatter();

  private static final CnpjFormatter CNPJ = CnpjFormatter.get();
  private static final CpfFormatter CPF = CpfFormatter.get();

  public static CadastroRfbFormatter get() {
    return INSTANCE;
  }

  @Override
  public CadastroRFB parse(String text) {
    return null;
  }

  @Override
  public String write(CadastroRFB value) {
    return value instanceof Cnpj
        ? CNPJ.write((Cnpj) value)
        : CPF.write((Cpf) value);
  }

}