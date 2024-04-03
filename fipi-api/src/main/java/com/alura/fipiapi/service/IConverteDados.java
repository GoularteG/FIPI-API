package com.alura.fipiapi.service;

import java.util.List;

public interface IConverteDados {
    <T> T obterdados(String json, Class<T> classe );

    <T>List<T> obterLista(String json, Class<T> classe);
}
