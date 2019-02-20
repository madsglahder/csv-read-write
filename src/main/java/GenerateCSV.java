import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.FileWriter;
import java.io.IOException;

public class GenerateCSV {
    public void generate(int lines, String filename) {

        //Usage for generating excellent CSVs
        /* generate csv
        GenerateCSV generateCSV = new GenerateCSV();
        generateCSV.generate(5, "generated.csv");
        */

        try {
            FileWriter writer = new FileWriter("src/APIApplication/resources/" + filename);
            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader(
                    "id",
                    "firstName",
                    "lastNAme"
            ));

            while (lines > 0) {
                csvPrinter.printRecord(lines, "test_first", "last_test");
                lines--;
            }
            csvPrinter.flush();

        } catch (IOException e) {
            System.out.println("Exception when trying to create generated file");
            e.printStackTrace();
        }

    }

}
