package csv;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CSV {

    private List<CSVPerson> csvPeople;
    private List<CSVPersonAltered> csvPersonAlteredList;

    public void load(String fileName) throws IOException {
        Reader reader = Files.newBufferedReader(Paths.get("src/main/resources/" + fileName));
        CsvToBean csvBean = new CsvToBeanBuilder(reader)
                .withType(CSVPerson.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build();

        this.csvPeople = csvBean.parse();
    }

    public void alterPeople() {
        List<CSVPerson> csvPeople = this.csvPeople;

        List<CSVPersonAltered> csvPersonAlteredList = new ArrayList<>();

        for ( CSVPerson csvPerson : csvPeople) {

            CSVPersonAltered alteredPerson = new CSVPersonAltered();
            alteredPerson.setId(csvPerson.getId());
            alteredPerson.setName(
                    csvPerson.getFirstName() + " " + csvPerson.getLastName()
            );
            csvPersonAlteredList.add(alteredPerson);
        }

        this.csvPersonAlteredList = csvPersonAlteredList;
    }

    public List<CSVPerson> getCsvPeople() {
        return csvPeople;
    }

    public List<CSVPersonAltered> getCsvPersonAlteredList() {
        return csvPersonAlteredList;
    }
}

