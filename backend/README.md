# Projeto para a disciplina "Arquitetura Java" da Pós-Graduação "MIT em Arquitetura de Software" da Infnet

Esta é a primeira entrega do projeto em Spring. 

Trata-se de uma API básica para registrar as despesas que pilotos possuem com suas motocicletas.
Os dados são carregados de um arquivo CSV.

## Tecnologias Utilizadas

- Java 17
- Spring Boot 3.3.4
- Maven

## Arquitetura
O projeto utiliza a Arquitetura Hexagonal.

## Como Executar

> mvn clean install
>
> mvn spring-boot:run

## Endpoints

- "/historico"
  - Lista todos os históricos de despesas cadastrados.

## Diagrama de Classes UML
```mermaid
classDiagram
  direction BT
  class Abastecimento
  class AbastecimentoLoader
  class AbastecimentoRepository {
    <<Interface>>

  }
  class AbastecimentoRepositoryImpl
  class AbastecimentosResponse
  class AlterarAbastecimento
  class AlterarAbastecimentoController
  class AlterarManutencao
  class AlterarManutencaoController
  class AlterarMoto
  class AlterarMotoController
  class AppDataLoader
  class Application
  class ApplicationTests
  class Despesa
  class DespesasResponse
  class Endereco
  class EnderecoClient {
    <<Interface>>

  }
  class EntidadeNaoEncontradaException
  class EntityLoader {
    <<Interface>>

  }
  class ExcluirAbastecimento
  class ExcluirAbastecimentoController
  class ExcluirManutencao
  class ExcluirManutencaoController
  class ExcluirMoto
  class ExcluirMotoController
  class FeignEnderecoClient {
    <<Interface>>

  }
  class FeignEnderecoClientImpl
  class GlobalExceptionHandler
  class Historico
  class HistoricoRepository {
    <<Interface>>

  }
  class HistoricoRepositoryImpl
  class HistoricosResponse
  class IncluirAbastecimento
  class IncluirAbastecimentoController
  class IncluirManutencao
  class IncluirManutencaoController
  class IncluirMoto
  class IncluirMotoController
  class LeitorCsv
  class ListarAbastecimentos
  class ListarAbastecimentosController
  class ListarHistoricos
  class ListarHistoricosController
  class ListarManutencoes
  class ListarManutencoesController
  class ListarMotos
  class ListarMotosController
  class Manutencao
  class ManutencaoLoader
  class ManutencaoRepository {
    <<Interface>>

  }
  class ManutencaoRepositoryImpl
  class ManutencoesResponse
  class Moto
  class MotoLoader
  class MotoRepository {
    <<Interface>>

  }
  class MotoRepositoryImpl
  class MotosResponse
  class SalvarHistorico
  class SpringDataAbastecimentoRepository {
    <<Interface>>

  }
  class SpringDataHistoricoRepository {
    <<Interface>>

  }
  class SpringDataManutencaoRepository {
    <<Interface>>

  }
  class SpringDataMotoRepository {
    <<Interface>>

  }
  class SwaggerConfig

  Abastecimento  -->  Despesa
  Abastecimento "1" *--> "endereco 1" Endereco
  AbastecimentoLoader  ..>  Abastecimento : «create»
  AbastecimentoLoader  ..>  Endereco : «create»
  AbastecimentoLoader  ..>  EntityLoader
  AbastecimentoLoader "1" *--> "incluirAbastecimento 1" IncluirAbastecimento
  AbastecimentoLoader "1" *--> "leitorCsv 1" LeitorCsv
  AbastecimentoRepositoryImpl  ..>  AbastecimentoRepository
  AbastecimentoRepositoryImpl "1" *--> "springDataAbastecimentoRepository 1" SpringDataAbastecimentoRepository
  AbastecimentosResponse "1" *--> "abastecimentos *" Abastecimento
  AlterarAbastecimento "1" *--> "abastecimentoRepository 1" AbastecimentoRepository
  AlterarAbastecimento "1" *--> "enderecoClient 1" EnderecoClient
  AlterarAbastecimentoController "1" *--> "alterarAbastecimento 1" AlterarAbastecimento
  AlterarManutencao "1" *--> "manutencaoRepository 1" ManutencaoRepository
  AlterarManutencaoController "1" *--> "alterarManutencao 1" AlterarManutencao
  AlterarMoto "1" *--> "motoRepository 1" MotoRepository
  AlterarMotoController "1" *--> "alterarMoto 1" AlterarMoto
  AppDataLoader "1" *--> "entityLoaders *" EntityLoader
  DespesasResponse "1" *--> "despesas *" Despesa
  ExcluirAbastecimento "1" *--> "historicoRepository 1" HistoricoRepository
  ExcluirAbastecimentoController "1" *--> "excluirAbastecimento 1" ExcluirAbastecimento
  ExcluirManutencao "1" *--> "historicoRepository 1" HistoricoRepository
  ExcluirManutencaoController "1" *--> "excluirManutencao 1" ExcluirManutencao
  ExcluirMoto "1" *--> "historicoRepository 1" HistoricoRepository
  ExcluirMoto "1" *--> "motoRepository 1" MotoRepository
  ExcluirMotoController "1" *--> "excluirMoto 1" ExcluirMoto
  FeignEnderecoClientImpl  ..>  EnderecoClient
  FeignEnderecoClientImpl "1" *--> "feignEnderecoClient 1" FeignEnderecoClient
  Historico "1" *--> "despesas *" Despesa
  Historico "1" *--> "moto 1" Moto
  HistoricoRepositoryImpl  ..>  HistoricoRepository
  HistoricoRepositoryImpl "1" *--> "springDataHistoricoRepository 1" SpringDataHistoricoRepository
  HistoricosResponse "1" *--> "historicos *" Historico
  IncluirAbastecimento "1" *--> "enderecoClient 1" EnderecoClient
  IncluirAbastecimento "1" *--> "historicoRepository 1" HistoricoRepository
  IncluirAbastecimentoController "1" *--> "incluirAbastecimento 1" IncluirAbastecimento
  IncluirManutencao "1" *--> "historicoRepository 1" HistoricoRepository
  IncluirManutencaoController "1" *--> "incluirManutencao 1" IncluirManutencao
  IncluirMoto  ..>  Historico : «create»
  IncluirMoto "1" *--> "historicoRepository 1" HistoricoRepository
  IncluirMoto "1" *--> "motoRepository 1" MotoRepository
  IncluirMotoController "1" *--> "incluirMoto 1" IncluirMoto
  ListarAbastecimentos "1" *--> "abastecimentoRepository 1" AbastecimentoRepository
  ListarAbastecimentos  ..>  AbastecimentosResponse : «create»
  ListarAbastecimentosController "1" *--> "listarAbastecimentos 1" ListarAbastecimentos
  ListarHistoricos "1" *--> "historicoRepository 1" HistoricoRepository
  ListarHistoricos  ..>  HistoricosResponse : «create»
  ListarHistoricosController "1" *--> "listarHistoricos 1" ListarHistoricos
  ListarManutencoes "1" *--> "manutencaoRepository 1" ManutencaoRepository
  ListarManutencoes  ..>  ManutencoesResponse : «create»
  ListarManutencoesController "1" *--> "listarManutencoes 1" ListarManutencoes
  ListarMotos "1" *--> "motoRepository 1" MotoRepository
  ListarMotos  ..>  MotosResponse : «create»
  ListarMotosController "1" *--> "listarMotos 1" ListarMotos
  Manutencao  -->  Despesa
  ManutencaoLoader  ..>  EntityLoader
  ManutencaoLoader "1" *--> "incluirManutencao 1" IncluirManutencao
  ManutencaoLoader "1" *--> "leitorCsv 1" LeitorCsv
  ManutencaoLoader  ..>  Manutencao : «create»
  ManutencaoRepositoryImpl  ..>  ManutencaoRepository
  ManutencaoRepositoryImpl "1" *--> "springDataManutencaoRepository 1" SpringDataManutencaoRepository
  ManutencoesResponse "1" *--> "manutencoes *" Manutencao
  MotoLoader  ..>  EntityLoader
  MotoLoader "1" *--> "incluirMoto 1" IncluirMoto
  MotoLoader "1" *--> "leitorCsv 1" LeitorCsv
  MotoLoader  ..>  Moto : «create»
  MotoRepositoryImpl  ..>  MotoRepository
  MotoRepositoryImpl "1" *--> "springDataMotoRepository 1" SpringDataMotoRepository
  MotosResponse "1" *--> "motos *" Moto
  SalvarHistorico "1" *--> "historicoRepository 1" HistoricoRepository

```