package eci.edu.co.Catalan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CatalanController {

    @GetMapping("/catalancito")
    public String catalan(@RequestParam(value = "value") int n) {
        if (n < 0) return "{\"error\":\"Ingrese un número > 0\"}";
        List<BigInteger> List = new ArrayList<>();
        List.add(BigInteger.ONE);

        for (int i = 1; i <= n; i++) {
            BigInteger b = BigInteger.ZERO;
            for (int j = 0; j < i; j++) {
                b = b.add(List.get(j).multiply(List.get(i - 1 - j)));
            }
            List.add(b);
        }

        StringBuilder result = new StringBuilder();
        for (BigInteger c : List) {
            result.append(c.toString()).append(", ");
        }

        String output = result.substring(0, result.length() - 2);

        return "{ \"operation\": \"Secuencia de Catalan\", " +
               "\"input\": " + n + ", " +
               "\"output\": \"" + output + "\" }";
    }

}

