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
class Abastecimento {
  + Abastecimento(LocalDate, float, float) 
  - float litrosAbastecidos
  + toString() String
   float litrosAbastecidos
}
class AbastecimentoObserver {
  + AbastecimentoObserver() 
  + criarDespesa(String[], HistoricoDespesas) void
}
class Application {
  + Application() 
  + main(String[]) void
}
class ApplicationTests {
  + ApplicationTests() 
  ~ contextLoads() void
}
class Despesa {
  + Despesa(LocalDate, float) 
  - float valor
  - LocalDate data
  + toString() String
   LocalDate data
   float valor
}
class DespesaObserver {
<<Interface>>
  + criarDespesa(String[], HistoricoDespesas) void
}
class HistoricoDespesas {
  + HistoricoDespesas(Moto) 
  - Moto moto
  - List~Despesa~ despesas
  + adicionarDespesa(Despesa) void
  + toString() String
   Moto moto
   List~Despesa~ despesas
}
class HistoricoDespesasRepository {
  + HistoricoDespesasRepository() 
  + incluir(HistoricoDespesas) void
  + obterTodos() List~HistoricoDespesas~
}
class HistoricoDespesasRepository {
<<Interface>>
  + obterTodos() List~HistoricoDespesas~
  + incluir(HistoricoDespesas) void
}
class ListarHistoricos {
  + ListarHistoricos(HistoricoDespesasRepository) 
  + listar() List~HistoricoDespesas~
}
class ListarHistoricosController {
  + ListarHistoricosController(ListarHistoricos) 
  + listar() List~HistoricoDespesas~
}
class Loader {
  + Loader(List~DespesaObserver~, HistoricoDespesasRepository) 
  - carregarHistorico() void
  - obterOuCriarHistorico(Map~Integer, HistoricoDespesas~, int) HistoricoDespesas
  - notificarObservers(String[], HistoricoDespesas) void
  - incluir(Collection~HistoricoDespesas~) void
  + run(ApplicationArguments) void
}
class Manutencao {
  + Manutencao(LocalDate, float, String) 
  - String tipo
  + toString() String
   String tipo
}
class ManutencaoObserver {
  + ManutencaoObserver() 
  + criarDespesa(String[], HistoricoDespesas) void
}
class Moto {
  + Moto(int) 
  - int id
  + toString() String
   int id
}
class MotoLoader {
  + MotoLoader() 
}

Abastecimento  -->  Despesa 
AbastecimentoObserver  ..>  Abastecimento : «create»
AbastecimentoObserver  ..>  DespesaObserver 
HistoricoDespesas "1" *--> "despesas *" Despesa 
HistoricoDespesas "1" *--> "moto 1" Moto 
HistoricoDespesasRepository "1" *--> "historicos *" HistoricoDespesas 
HistoricoDespesasRepository  ..>  HistoricoDespesasRepository 
ListarHistoricos "1" *--> "historicoRepository 1" HistoricoDespesasRepository 
ListarHistoricosController "1" *--> "listarHistoricos 1" ListarHistoricos 
Loader "1" *--> "observers *" DespesaObserver 
Loader  ..>  HistoricoDespesas : «create»
Loader "1" *--> "historicoRepository 1" HistoricoDespesasRepository 
Loader  ..>  Moto : «create»
Manutencao  -->  Despesa 
ManutencaoObserver  ..>  DespesaObserver 
ManutencaoObserver  ..>  Manutencao : «create»
```