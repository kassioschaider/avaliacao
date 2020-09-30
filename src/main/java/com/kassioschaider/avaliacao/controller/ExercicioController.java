package com.kassioschaider.avaliacao.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

@RestController
public class ExercicioController {

    @PostMapping("/exercicio/{numero}")
    public int obterMaiorNumeroIrmao(@PathVariable String numero) {
        if ((numero.length() > 9) || (Integer.parseInt(numero) > 100000000)) return -1;

        ArrayList<Character> charArray = new ArrayList<>();
        for (char c : numero.toCharArray()) {
            charArray.add(c);
        }

        charArray.sort(Collections.reverseOrder());

        int resultado = 0;
        int j = charArray.size()-1;
        for (Character character : charArray) resultado = resultado + (int) ((character - 48) * Math.pow(10, j--));

        return resultado;
    }
}
