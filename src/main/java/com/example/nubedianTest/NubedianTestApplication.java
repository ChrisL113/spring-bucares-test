package com.example.nubedianTest;

import com.example.nubedianTest.model.Processor;
import com.example.nubedianTest.repository.ProcessorRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class NubedianTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(NubedianTestApplication.class, args);
    }

    @Bean
    public CommandLineRunner demoData(ProcessorRepository repo) {
        return args -> {
            JSONObject jsonObject = new JSONObject();
            try {

                jsonObject = new JSONObject("{\n" +
                        "    \"Sheet1\": [\n" +
                        " {\n" +
                        "   \"model\": \"Ryzen 5 3600\",\n" +
                        "   \"brand\": \"AMD\",\n" +
                        "   \"socket\": \" AM4\",\n" +
                        "   \"clockSpeed\": \"3.6 to 4.2 GHz\",\n" +
                        "   \"numberOfCores\": 6,\n" +
                        "   \"numberOfThreads\": 12,\n" +
                        "   \"TDP\": 65,\n" +
                        "   \"EUR\": 400\n" +
                        " },\n" +
                        " {\n" +
                        "   \"model\": \"Ryzen 5 5600G\",\n" +
                        "   \"brand\": \"AMD\",\n" +
                        "   \"socket\": \" AM4\",\n" +
                        "   \"clockSpeed\": \"3.9 to 4.4 GHz\",\n" +
                        "   \"numberOfCores\": 6,\n" +
                        "   \"numberOfThreads\": 12,\n" +
                        "   \"TDP\": 65,\n" +
                        "   \"EUR\": 331\n" +
                        " },\n" +
                        " {\n" +
                        "   \"model\": \"Ryzen 5 5600X\",\n" +
                        "   \"brand\": \"AMD\",\n" +
                        "   \"socket\": \" AM4\",\n" +
                        "   \"clockSpeed\": \"3.7 to 4.6 GHz\",\n" +
                        "   \"numberOfCores\": 6,\n" +
                        "   \"numberOfThreads\": 12,\n" +
                        "   \"TDP\": 65,\n" +
                        "   \"EUR\": 248\n" +
                        " },\n" +
                        " {\n" +
                        "   \"model\": \"Core i5-10400F\",\n" +
                        "   \"brand\": \"INTEL\",\n" +
                        "   \"socket\": \"1200\",\n" +
                        "   \"clockSpeed\": \"2.9 to 4.3 GHz\",\n" +
                        "   \"numberOfCores\": 6,\n" +
                        "   \"numberOfThreads\": 12,\n" +
                        "   \"TDP\": 65,\n" +
                        "   \"EUR\": 465\n" +
                        " },\n" +
                        " {\n" +
                        "   \"model\": \"Ryzen 7 3700X\",\n" +
                        "   \"brand\": \"AMD\",\n" +
                        "   \"socket\": \" AM4\",\n" +
                        "   \"clockSpeed\": \"3.6 to 4.4 GHz\",\n" +
                        "   \"numberOfCores\": 8,\n" +
                        "   \"numberOfThreads\": 16,\n" +
                        "   \"TDP\": 65,\n" +
                        "   \"EUR\": 597\n" +
                        " },\n" +
                        " {\n" +
                        "   \"model\": \"Ryzen 7 5800X\",\n" +
                        "   \"brand\": \"AMD\",\n" +
                        "   \"socket\": \" AM4\",\n" +
                        "   \"clockSpeed\": \"3.8 to 4.7 GHz\",\n" +
                        "   \"numberOfCores\": 8,\n" +
                        "   \"numberOfThreads\": 16,\n" +
                        "   \"TDP\": 105,\n" +
                        "   \"EUR\": 485\n" +
                        " },\n" +
                        " {\n" +
                        "   \"model\": \"Core i5-10400\",\n" +
                        "   \"brand\": \"INTEL\",\n" +
                        "   \"socket\": \"1200\",\n" +
                        "   \"clockSpeed\": \"2.9 to 4.3 GHz\",\n" +
                        "   \"numberOfCores\": 6,\n" +
                        "   \"numberOfThreads\": 12,\n" +
                        "   \"TDP\": 65,\n" +
                        "   \"EUR\": 532\n" +
                        " },\n" +
                        " {\n" +
                        "   \"model\": \"Ryzen 7 5700G\",\n" +
                        "   \"brand\": \"AMD\",\n" +
                        "   \"socket\": \" AM4\",\n" +
                        "   \"clockSpeed\": \"3.8 to 4.6 GHz\",\n" +
                        "   \"numberOfCores\": 8,\n" +
                        "   \"numberOfThreads\": 16,\n" +
                        "   \"TDP\": 65,\n" +
                        "   \"EUR\": 589\n" +
                        " },\n" +
                        " {\n" +
                        "   \"model\": \"Core 2 Duo E8400\",\n" +
                        "   \"brand\": \"INTEL\",\n" +
                        "   \"socket\": \"775\",\n" +
                        "   \"clockSpeed\": \"3 GHz\",\n" +
                        "   \"numberOfCores\": 2,\n" +
                        "   \"numberOfThreads\": 2,\n" +
                        "   \"TDP\": 65,\n" +
                        "   \"EUR\": 469\n" +
                        " },\n" +
                        " {\n" +
                        "   \"model\": \"Ryzen 5 2600\",\n" +
                        "   \"brand\": \"AMD\",\n" +
                        "   \"socket\": \" AM4\",\n" +
                        "   \"clockSpeed\": \"3.4 to 3.9 GHz\",\n" +
                        "   \"numberOfCores\": 6,\n" +
                        "   \"numberOfThreads\": 12,\n" +
                        "   \"TDP\": 65,\n" +
                        "   \"EUR\": 351\n" +
                        " },\n" +
                        " {\n" +
                        "   \"model\": \"Core i5-3470\",\n" +
                        "   \"brand\": \"INTEL\",\n" +
                        "   \"socket\": \"1155\",\n" +
                        "   \"clockSpeed\": \"3.2 to 3.6 GHz\",\n" +
                        "   \"numberOfCores\": 4,\n" +
                        "   \"numberOfThreads\": 4,\n" +
                        "   \"TDP\": 77,\n" +
                        "   \"EUR\": 288\n" +
                        " },\n" +
                        " {\n" +
                        "   \"model\": \"Ryzen 5 3500X\",\n" +
                        "   \"brand\": \"AMD\",\n" +
                        "   \"socket\": \" AM4\",\n" +
                        "   \"clockSpeed\": \"3.6 to 4.1 GHz\",\n" +
                        "   \"numberOfCores\": 6,\n" +
                        "   \"numberOfThreads\": 6,\n" +
                        "   \"TDP\": 65,\n" +
                        "   \"EUR\": 514\n" +
                        " },\n" +
                        " {\n" +
                        "   \"model\": \"FX-8350\",\n" +
                        "   \"brand\": \"INTEL\",\n" +
                        "   \"socket\": \" AM3+\",\n" +
                        "   \"clockSpeed\": \"4 to 4.2 GHz\",\n" +
                        "   \"numberOfCores\": 8,\n" +
                        "   \"numberOfThreads\": 8,\n" +
                        "   \"TDP\": 125,\n" +
                        "   \"EUR\": 389\n" +
                        " },\n" +
                        " {\n" +
                        "   \"model\": \"Ryzen 3 3200G\",\n" +
                        "   \"brand\": \"AMD\",\n" +
                        "   \"socket\": \" AM4\",\n" +
                        "   \"clockSpeed\": \"3.6 to 4 GHz\",\n" +
                        "   \"numberOfCores\": 4,\n" +
                        "   \"numberOfThreads\": 4,\n" +
                        "   \"TDP\": 65,\n" +
                        "   \"EUR\": 203\n" +
                        " },\n" +
                        " {\n" +
                        "   \"model\": \"Core i7-2600\",\n" +
                        "   \"brand\": \"INTEL\",\n" +
                        "   \"socket\": \"1155\",\n" +
                        "   \"clockSpeed\": \"3.4 to 3.8 GHz\",\n" +
                        "   \"numberOfCores\": 4,\n" +
                        "   \"numberOfThreads\": 8,\n" +
                        "   \"TDP\": 95,\n" +
                        "   \"EUR\": 202\n" +
                        " },\n" +
                        " {\n" +
                        "   \"model\": \"Ryzen 9 5900X\",\n" +
                        "   \"brand\": \"AMD\",\n" +
                        "   \"socket\": \" AM4\",\n" +
                        "   \"clockSpeed\": \"3.7 to 4.8 GHz\",\n" +
                        "   \"numberOfCores\": 12,\n" +
                        "   \"numberOfThreads\": 24,\n" +
                        "   \"TDP\": 105,\n" +
                        "   \"EUR\": 280\n" +
                        " },\n" +
                        " {\n" +
                        "   \"model\": \"Ryzen 3 3100\",\n" +
                        "   \"brand\": \"AMD\",\n" +
                        "   \"socket\": \" AM4\",\n" +
                        "   \"clockSpeed\": \"3.6 to 3.9 GHz\",\n" +
                        "   \"numberOfCores\": 4,\n" +
                        "   \"numberOfThreads\": 8,\n" +
                        "   \"TDP\": 65,\n" +
                        "   \"EUR\": 207\n" +
                        " },\n" +
                        " {\n" +
                        "   \"model\": \"Ryzen 9 5950X\",\n" +
                        "   \"brand\": \"AMD\",\n" +
                        "   \"socket\": \" AM4\",\n" +
                        "   \"clockSpeed\": \"3.4 to 4.9 GHz\",\n" +
                        "   \"numberOfCores\": 16,\n" +
                        "   \"numberOfThreads\": 32,\n" +
                        "   \"TDP\": 105,\n" +
                        "   \"EUR\": 379\n" +
                        " },\n" +
                        " {\n" +
                        "   \"model\": \"Ryzen 5 3400G\",\n" +
                        "   \"brand\": \"AMD\",\n" +
                        "   \"socket\": \" AM4\",\n" +
                        "   \"clockSpeed\": \"3.7 to 4.2 GHz\",\n" +
                        "   \"numberOfCores\": 4,\n" +
                        "   \"numberOfThreads\": 8,\n" +
                        "   \"TDP\": 65,\n" +
                        "   \"EUR\": 494\n" +
                        " },\n" +
                        " {\n" +
                        "   \"model\": \"Core i3-10105F\",\n" +
                        "   \"brand\": \"INTEL\",\n" +
                        "   \"socket\": \"1200\",\n" +
                        "   \"clockSpeed\": \"3.7 to 4.4 GHz\",\n" +
                        "   \"numberOfCores\": 4,\n" +
                        "   \"numberOfThreads\": 8,\n" +
                        "   \"TDP\": 65,\n" +
                        "   \"EUR\": 395\n" +
                        " },\n" +
                        " {\n" +
                        "   \"model\": \"Pentium G4400\",\n" +
                        "   \"brand\": \"INTEL\",\n" +
                        "   \"socket\": \"1151\",\n" +
                        "   \"clockSpeed\": \"3.3 GHz\",\n" +
                        "   \"numberOfCores\": 2,\n" +
                        "   \"numberOfThreads\": 2,\n" +
                        "   \"TDP\": 51,\n" +
                        "   \"EUR\": 286\n" +
                        " },\n" +
                        " {\n" +
                        "   \"model\": \"Ryzen 7 5800H\",\n" +
                        "   \"brand\": \"AMD\",\n" +
                        "   \"socket\": \" FP6\",\n" +
                        "   \"clockSpeed\": \"3.2 to 4.4 GHz\",\n" +
                        "   \"numberOfCores\": 8,\n" +
                        "   \"numberOfThreads\": 16,\n" +
                        "   \"TDP\": 54,\n" +
                        "   \"EUR\": 380\n" +
                        " },\n" +
                        " {\n" +
                        "   \"model\": \"Ryzen 5 5500U\",\n" +
                        "   \"brand\": \"AMD\",\n" +
                        "   \"socket\": \" FP6\",\n" +
                        "   \"clockSpeed\": \"2.1 to 4 GHz\",\n" +
                        "   \"numberOfCores\": 6,\n" +
                        "   \"numberOfThreads\": 12,\n" +
                        "   \"TDP\": 25,\n" +
                        "   \"EUR\": 583\n" +
                        " },\n" +
                        " {\n" +
                        "   \"model\": \"Athlon 3000G\",\n" +
                        "   \"brand\": \"AMD\",\n" +
                        "   \"socket\": \" AM4\",\n" +
                        "   \"clockSpeed\": \"3.5 GHz\",\n" +
                        "   \"numberOfCores\": 4,\n" +
                        "   \"numberOfThreads\": 4,\n" +
                        "   \"TDP\": 35,\n" +
                        "   \"EUR\": 383\n" +
                        " },\n" +
                        " {\n" +
                        "   \"model\": \"Core i7-4790\",\n" +
                        "   \"brand\": \"INTEL\",\n" +
                        "   \"socket\": \"1150\",\n" +
                        "   \"clockSpeed\": \"3.6 to 4 GHz\",\n" +
                        "   \"numberOfCores\": 4,\n" +
                        "   \"numberOfThreads\": 8,\n" +
                        "   \"TDP\": 84,\n" +
                        "   \"EUR\": 241\n" +
                        " },\n" +
                        " {\n" +
                        "   \"model\": \"Ryzen 3 4300GE\",\n" +
                        "   \"brand\": \"AMD\",\n" +
                        "   \"socket\": \" AM4\",\n" +
                        "   \"clockSpeed\": \"3.5 to 4 GHz\",\n" +
                        "   \"numberOfCores\": 4,\n" +
                        "   \"numberOfThreads\": 8,\n" +
                        "   \"TDP\": 35,\n" +
                        "   \"EUR\": 600\n" +
                        " }\n" +
                        "]\n" +
                        "}");

            } catch (Exception err) {
                System.out.println("erro: " + err);
            }


            JSONArray aux = (JSONArray) jsonObject.get("Sheet1");
            for (Object aux2 : aux) {
                if (aux2 instanceof JSONObject) {

                    JSONObject aux3 = (JSONObject) aux2;
                System.out.println(aux3.get("numberOfCores").getClass());


                    repo.save(new Processor((String) aux3.get("model"),
                            (String) aux3.get("brand"),
                            (String) aux3.get("socket"),
                            (String) aux3.get("clockSpeed"),
                            ((Integer) aux3.get("numberOfCores")).longValue(),
                            ((Integer) aux3.get("numberOfThreads")).longValue(),
                            new Double(aux3.get("TDP").toString() + ".0"),
                            new Double(aux3.get("EUR").toString() + ".0")
                            , false
                    ));

                }
            }
            repo.save(new Processor("Ryzen 3800",
                    "AMD",
                    "AM4",
                    "4.7 ghz",
                    3L,
                    4L,
                    43.2,
                    450.3, false));
			repo.save(new Processor("Ryzen 3700",
					"AMD",
					"AM4",
					"4.4 ghz",
					3L,
					4L,
					43.2,
					450.3,false ));


        };
    }

}


