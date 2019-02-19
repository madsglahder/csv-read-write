import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;
import java.util.List;

public class main {

    public static void main(String[] args) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {

        // generate csv
        GenerateCSV generateCSV = new GenerateCSV();
        generateCSV.generate(5, "generated.csv");

        //load bean into memory
        CSV csv = new CSV();
        List<CSVPerson> csvPeople = csv.load("generated.csv");

        //write said bean
        //this took way longer than anticipated
        WriteCSVOriginal writeCSVOriginal = new WriteCSVOriginal();
        writeCSVOriginal.write(csvPeople, "generated_original.csv");

    }
}
