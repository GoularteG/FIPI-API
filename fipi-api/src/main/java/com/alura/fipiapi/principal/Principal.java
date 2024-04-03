package com.alura.fipiapi.principal;

import com.alura.fipiapi.model.Dados;
import com.alura.fipiapi.model.Modelos;
import com.alura.fipiapi.model.Veiculo;
import com.alura.fipiapi.service.ConsumirApi;
import com.alura.fipiapi.service.ConverteDados;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Principal {
    Scanner ler = new Scanner(System.in);
    private ConsumirApi consumirApi= new ConsumirApi();
    private ConverteDados conversor= new ConverteDados();
    private final String urlBase= "https://parallelum.com.br/fipe/api/v1/";

    public void exibeMenu(){
        var menu= """
                
                *** OPÇÕES ***
                 Carro
                 Moto
                 Caminhão
                 
                Digite uma das opções para consultar :
                """;
        System.out.println(menu);
        String opção= ler.nextLine();

        String endereco;

        if(opção.toLowerCase().contains("carr")){
           endereco= urlBase+ "carros/marcas";
        }else if (opção.toLowerCase().contains("mot")){
            endereco= urlBase+ "motos/marcas";
        }else {
            endereco= urlBase+ "caminhoes/marcas";
        }

        var json = consumirApi.obterDados(endereco);
        System.out.println(json);
        var marcas = conversor.obterLista(json, Dados.class);
        marcas.stream().sorted(Comparator.comparing(Dados::codigo))
                .forEach(System.out::println);


        System.out.println("Informe o código da marca para consulta: ");
        var codigoMarca = ler.nextLine();

        endereco = endereco + "/" + codigoMarca + "/modelos";
        json = consumirApi.obterDados(endereco);
        var modeloLista = conversor.obterdados(json, Modelos.class);

        System.out.println("\nModelos dessa marca: ");
        modeloLista.modelos().stream()
                .sorted(Comparator.comparing(Dados::codigo))
                .forEach(System.out::println);


        System.out.println("\n Digite um trecho do nome do carro a ser buscado:");
        var nomeVeiculo= ler.nextLine();

        List<Dados> modeloFiltrados = modeloLista.modelos().stream().filter(m -> m.nome().toLowerCase().contains(nomeVeiculo.toLowerCase()))
                .collect(Collectors.toList());

        System.out.println("\n Modelos Filtrados: ");
        modeloFiltrados.forEach(System.out::println);

        System.out.println("Digite o código do modelo para buscar os valores de avaliação: ");
        var codigoModelo= ler.nextLine();

        endereco= endereco+"/" + codigoModelo + "/anos";
        json = consumirApi.obterDados(endereco);
        List<Dados> anos = conversor.obterLista(json, Dados.class);
        List<Veiculo> veiculos= new ArrayList<>();

        for (int i = 0; i < anos.size(); i++) {
            var enderecoAnos = endereco+ "/"+ anos.get(i).codigo();
            json = consumirApi.obterDados(enderecoAnos);
            Veiculo veiculo= conversor.obterdados(json, Veiculo.class);
            veiculos.add(veiculo);
        }

        System.out.println("\nTodos veiculos filtrados com avaliações por ano: ");
        veiculos.forEach(System.out::println);


    }

}
