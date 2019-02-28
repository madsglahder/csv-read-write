package csv;

import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class WriteCSVAltered {
    public void writeAltered(List<CSVPerson> csvPeople, String fileName) throws IOException,
            CsvDataTypeMismatchException,
            CsvRequiredFieldEmptyException {

        List<CSVPersonAltered> alteredPeople = alterPeople(csvPeople);

        Writer writer = new FileWriter(Paths.get("src/main/resources/" + fileName).toString());

        StatefulBeanToCsvBuilder<CSVPersonAltered> builder = new StatefulBeanToCsvBuilder<>(writer);
        StatefulBeanToCsv<CSVPersonAltered> beanWriter = builder.build();

        beanWriter.write(alteredPeople);
        writer.close();
    }

    private CSVPersonAltered alterPerson(CSVPerson originalPerson) {

        CSVPersonAltered alteredPerson = new CSVPersonAltered();

        //add more set lines here if you want to pilfer
        //with additional parameters
        alteredPerson.setId(originalPerson.getId());
        alteredPerson.setName(originalPerson.getFirstName() + " " + originalPerson.getLastName());

        return alteredPerson;
    }

    private List<CSVPersonAltered> alterPeople(List<CSVPerson> originalPeople) {

        List<CSVPersonAltered> alteredPeople = new ArrayList<>();

        for (CSVPerson originalPerson : originalPeople) {

            alteredPeople.add(alterPerson(originalPerson));
        }
        return alteredPeople;
    }
}
