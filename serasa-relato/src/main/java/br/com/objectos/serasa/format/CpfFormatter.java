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

import br.com.objectos.br.Cpf;
import br.com.objectos.flat.CustomFormatter;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class CpfFormatter implements CustomFormatter<Cpf> {

  private static final CpfFormatter INSTANCE = new CpfFormatter();

  public static CpfFormatter get() {
    return INSTANCE;
  }

  @Override
  public Cpf parse(String text) {
    String core = text.substring(0, 11);
    long value = Long.parseLong(core, 10);
    return Cpf.valueOf(value);
  }

  @Override
  public String write(Cpf value) {
    return String.format("%011d", value.longValue()) + "000";
  }

}