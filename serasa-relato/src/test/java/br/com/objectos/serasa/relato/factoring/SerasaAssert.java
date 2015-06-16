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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import br.com.objectos.core.testing.Testable;
import br.com.objectos.io.flat.FlatFileReader;
import br.com.objectos.io.flat.RecordMatcher;
import br.com.objectos.io.flat.RecordParser;
import br.com.objectos.io.flat.Result;
import br.com.objectos.testing.TestResources;

import com.google.common.base.Throwables;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class SerasaAssert {

  private final String dir;

  private SerasaAssert(String dir) {
    this.dir = dir;
  }

  public static SerasaAssert at(String dir) {
    return new SerasaAssert(dir);
  }

  public ParseList parseList(String name) {
    return new ParseList(name);
  }

  public ParseOne parseOne(String name) {
    return new ParseOne(name);
  }

  public class ParseList {

    private final String name;

    public ParseList(String name) {
      this.name = name;
    }

    public <T extends Testable<T>> ParseListWith<T> with(RecordMatcher recordMatcher, RecordParser<T> recordParser) {
      return new ParseListWith<>(recordMatcher, recordParser);

    }

    public class ParseListWith<T extends Testable<T>> {

      private final RecordMatcher recordMatcher;
      private final RecordParser<T> recordParser;

      public ParseListWith(RecordMatcher recordMatcher, RecordParser<T> recordParser) {
        this.recordMatcher = recordMatcher;
        this.recordParser = recordParser;
      }

      public void resultIsEqualTo(List<T> expectedList) {
        File file = TestResources.getFile(dir + "/" + name);
        try (FileReader reader = new FileReader(file)) {
          Result<List<T>> result = FlatFileReader.get(reader).parseList(recordMatcher, recordParser);
          assertThat(result.get(), isEqualTo(expectedList));
        } catch (FileNotFoundException e) {
          Throwables.propagate(e);
        } catch (IOException e) {
          Throwables.propagate(e);
        }
      }

    }

  }

  public class ParseOne {

    private final String name;

    public ParseOne(String name) {
      this.name = name;
    }

    public <T extends Testable<T>> ParseOneWith<T> with(RecordParser<T> recordParser) {
      return new ParseOneWith<>(recordParser);

    }

    public class ParseOneWith<T extends Testable<T>> {

      private final RecordParser<T> recordParser;

      public ParseOneWith(RecordParser<T> recordParser) {
        this.recordParser = recordParser;
      }

      public void resultIsEqualTo(T expected) {
        File file = TestResources.getFile(dir + "/" + name);
        try (FileReader reader = new FileReader(file)) {
          Result<T> result = FlatFileReader.get(reader).parseOne(recordParser);
          assertThat(result.get(), isEqualTo(expected));
        } catch (FileNotFoundException e) {
          Throwables.propagate(e);
        } catch (IOException e) {
          Throwables.propagate(e);
        }
      }

    }

  }

}