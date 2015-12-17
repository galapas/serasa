# objectos :: serasa 

objectos :: serasa é uma API Java 8 para importação e exportação dos 
arquivos de troca Serasa Experian.

Arquivos de troca implementados:

- RELATO (segmento Factoring)

## RELATO

No sistema RELATO há 3 arquivos de troca:

- remessa normal: lote de títulos a serem enviados para a Serasa
- retorno: arquivo recebido da Serasa com os resultados do processamento 
- remessa conciliação: arquivo recebido da Serasa com títulos abertos. O mesmo formato de arquivo deve ser enviado para a Serasa com as atualizações ou confirmações dos títulos.

Para utilização siga os exemplos abaixo:

(obs: os exemplos utilizam a biblioteca do segmento Factoring)

### Remessa normal

O código seguinte permite o envio de uma remessa normal:

```java
HeaderNormal header = Headers.normal()
    .cnpj(Cnpj.valueOf(7430629000110l))
    .dataInicio(LocalDate.of(2015, 4, 28))
    .dataFinal(LocalDate.of(2015, 4, 29))
    .build();

TituloNormal titulo = Titulos.normal()
    .cadastroSacado(Cpf.valueOf(8261431649l))
    .tipo(TituloTipo.CPF)
    .numeroTitulo("0001")
    .dataEmissao(LocalDate.of(2015, 2, 14))
    .valorNominal(123.45)
    .dataVencimento(LocalDate.of(2015, 5, 31))
    .dataPagamento(Optional.<LocalDate> empty())
    .hashD("")
    .numeroTituloLongo("")
    .cnpjCedente(Cnpj.valueOf(80161698000166l))
    .tipoTitulo(TipoTitulo.DUPLICATA)
    .tipoInformacao(TipoInformacao.SACADO_CEDENTE)
    .build();
    
List<TituloNormal> tituloList = ImmutableList.of(titulo);
    
TrailerNormal trailer = Trailers.normal()
    .tempoRelacionamentoPj(0)
    .titulosPj(0)
    .tempoRelacionamentoPf(0)
    .titulosPf(1)
    .build();
    
RemessaNormal remessa = Remessas.normal()
    .header(header)
    .tituloList(tituloList)
    .trailer(trailer)
    .build();
``` 

## Maven

objectos :: serasa está na central Maven.

```xml
<dependency>
    <groupId>br.com.objectos</groupId>
    <artifactId>serasa-{{modulo}}</artifactId>
    <version>0.2.5</version>
</dependency>
```

## Licença de uso

Copyright 2015 [objectos, fábrica de software LTDA](http://www.objectos.com.br)

Licensed under the Apache License, Version 2.0 (the "License"); 
you may not use this file except in compliance with the License. 
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, 
software distributed under the License is distributed on an "AS IS" BASIS, 
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
See the License for the specific language governing permissions 
and limitations under the License.