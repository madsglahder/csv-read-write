package application;

import com.sun.research.ws.wadl.HTTPMethods;
import csv.CSV;
import csv.CSVPerson;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CSVController {

    @RequestMapping(value = "/original", method = RequestMethod.GET)
    public ResponseEntity<Object> downloadOriginal(String param) throws IOException {

        File file = new File("src/main/resources/testFile.csv");
        Path path = Paths.get(file.getAbsolutePath());
        ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Expires", "0");
        headers.add("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");

        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(file.length())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(resource);

    }

    @RequestMapping(value = "/altered", method = RequestMethod.GET)
    public ResponseEntity<Object> downloadAltered(String param) throws IOException {
        CSV csv = new CSV();
        csv.load("src/resources/testFile.csv");
        csv.alterPeople();


        //TODO

    }

}
