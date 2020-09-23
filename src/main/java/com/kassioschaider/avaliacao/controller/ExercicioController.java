package com.kassioschaider.avaliacao.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
public class ExercicioController {

    @PostMapping("/exercicio/{numero}")
    public int obterMaiorNumeroIrmao(@PathVariable String numero) {
        if ((numero.length() > 9) || (Integer.parseInt(numero) > 100000000)) return -1;

        char[] charArray = numero.toCharArray();
        Integer[] intArray = new Integer[charArray.length];

        for (int i=0; i < charArray.length; i++) intArray[i] = (int) charArray[i];
        Arrays.sort(intArray, Collections.reverseOrder());

        int resultado = 0;
        int j = intArray.length-1;
        for (Integer integer : intArray) resultado = resultado + (int) ((integer - 48) * Math.pow(10, j--));

        if (resultado > 100000000) return -1;

        return resultado;
    }
}
