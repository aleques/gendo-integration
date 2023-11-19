package be.atelierrafaelaferreira.gendointegration.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@AllArgsConstructor
public class ComandaService {

    private ObjectMapper objectMapper;

    public void generateComandaDTOs() throws IOException {



        //generateCsv(result);
    }
}
