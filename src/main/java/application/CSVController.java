package application;

import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import csv.CSV;
import csv.CSVPersonAltered;
import csv.WriteCSVAlteredFile;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
public class CSVController {

    @RequestMapping(value = "/original", method = RequestMethod.GET)
    public ResponseEntity<Object> downloadOriginal(String param) throws IOException {

        //this approach sends a file already on disk

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
    public ResponseEntity<Object> downloadAltered(String param) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
        CSV csv = new CSV();
        csv.load("testFile.csv");

        WriteCSVAlteredFile writeCSVAlteredFile = new WriteCSVAlteredFile();
        writeCSVAlteredFile.writeAltered(csv.getCsvPeople(), "testFileAltered.csv");

        File file = new File("src/main/resources/testFileAltered.csv");
        Path path = Paths.get(file.getAbsolutePath());
        ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Expires", "0");
        headers.add("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");


        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(resource);
    }

}
