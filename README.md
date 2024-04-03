# Projeto Consulta FIPE

Este projeto consiste em uma aplicação Java para consultar informações sobre veículos utilizando a API da FIPE (Fundação Instituto de Pesquisas Econômicas). A aplicação permite consultar informações sobre carros, motos e caminhões, incluindo marcas, modelos, anos e valores de avaliação.

## Funcionalidades

- Consulta de marcas de veículos (carros, motos e caminhões)
- Consulta de modelos de veículos de uma determinada marca
- Filtragem de modelos por nome
- Consulta de valores de avaliação por ano de um modelo específico

## Requisitos

- Java 8 ou superior
- Dependências gerenciadas pelo Maven
- Acesso à internet para consultar a API da FIPE

## Instruções de Uso

1. Clone o repositório do projeto para sua máquina local.
2. Abra o projeto em sua IDE Java de preferência.
3. Execute a classe `Principal` para iniciar a aplicação.
4. Siga as instruções exibidas no menu para realizar as consultas desejadas.

## Dependências Utilizadas

- `Scanner`: Para entrada de dados pelo usuário.
- `ConsumirApi`: Classe responsável por fazer requisições HTTP para a API da FIPE.
- `ConverteDados`: Classe para conversão de dados JSON em objetos Java.
- `urlBase`: URL base da API da FIPE utilizada para construir os endpoints de consulta.
-  `Jackson`: Biblioteca para serialização/deserialização de objetos JSON em Java.

## Observações

- Certifique-se de ter uma conexão com a internet ativa durante a execução da aplicação para consultar os dados da API da FIPE.
