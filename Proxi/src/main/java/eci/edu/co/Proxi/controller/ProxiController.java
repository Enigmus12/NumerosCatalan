package eci.edu.co.Proxi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@RestController
public class ProxiController {

    private static final String USER_AGENT = "Mozilla/5.0";

    private static final String ACTIVE_URL = "http://18.234.215.214";
    private static final String PASSIVE_URL = "http://34.228.20.128";

    private static boolean activeIsPrimary = true;

    @GetMapping("/Api-catalan")
    public String catalan(@RequestParam(value = "value") int value) {
        String response;
        String active = activeIsPrimary ? ACTIVE_URL : PASSIVE_URL;
        String noActive = activeIsPrimary ? PASSIVE_URL : ACTIVE_URL;

        try {
            response = sendGet(active + "/Api-catalan?value=" + value);
            System.out.println(" Servicio activo funcionando: " + active);
        } catch (Exception e) {
            System.out.println(" Servicio activo caido: " + active);
            activeIsPrimary = !activeIsPrimary; 
            try {
                response = sendGet(noActive + "/Api-catalan?value=" + value);
                System.out.println(" Ahora estamos en el servicio pasivo: " + noActive);
            } catch (Exception ex) {
                System.out.println(" Ambos servicios caídos");
                response = "{\"error\":\"Ningun servicio disponible\"}";
            }
        }
        return response;
    }

    private String sendGet(String urlStr) throws Exception {
        URL obj  = new URL(urlStr);
        HttpURLConnection con = (HttpURLConnection) obj .openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }

        in.close();
        con.disconnect();
        return content.toString();
    }
}



