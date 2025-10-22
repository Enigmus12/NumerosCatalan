package eci.edu.co.Catalan.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.RequestParam; 
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController 
public class CatalanController {

    @GetMapping("/Api-catalan")
    public String getCatalan(@RequestParam(value = "value") int n) {
        if (n < 0) {
            return "{\"error\":\"Ingrese un numero > 0\"}";
        }

        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i <= n; i++) {
            long catalan = calcularCatalan(i);
            resultado.append(catalan);
            if (i < n) {
                resultado.append(", ");
            }
        }

        return "{ \"service\": \"Back\", " +
                "\"operation\": \"Secuencia de Catalan\", " +
                "\"input\": " + n + ", " +
                "\"output\": \"" + resultado + "\" }";
    }

    private long calcularCatalan(int n) {
        if (n == 0 || n == 1) return 1;

        long catalan = 0;
        for (int i = 0; i < n; i++) {
            catalan += calcularCatalan(i) * calcularCatalan(n - 1 - i);
        }
        return catalan;
    }
    
}

