package csv;

import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Paths;
import java.util.List;

public class WriteCSVOriginal {
    public void write(List<CSVPerson> csvPeople, String fileName) throws IOException,
            CsvDataTypeMismatchException,
            CsvRequiredFieldEmptyException {

        Writer writer = new FileWriter(Paths.get("src/application.APIApplication/resources/" + fileName).toString());

        StatefulBeanToCsvBuilder<CSVPerson> builder = new StatefulBeanToCsvBuilder<>(writer);
        StatefulBeanToCsv<CSVPerson> beanWriter = builder.build();

        beanWriter.write(csvPeople);
        writer.close();
    }
}
