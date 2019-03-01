package csv;

import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.PrintWriter;
import java.util.List;

public class WriteCSVAlteredREST {

    public void writeObjects(List<CSVPersonAltered> csvPersonAlteredList, PrintWriter writer) throws CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {

        StatefulBeanToCsvBuilder<CSVPersonAltered> builder = new StatefulBeanToCsvBuilder<>(writer);
        StatefulBeanToCsv<CSVPersonAltered> beanWriter = builder.build();

        beanWriter.write(csvPersonAlteredList);
        writer.close();

    }

}
