import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CSV {
    public List<CSVPerson> load(String fileName) throws IOException {
        Reader reader = Files.newBufferedReader(Paths.get("src/main/resources/" + fileName));
        CsvToBean csvBean = new CsvToBeanBuilder(reader)
                .withType(CSVPerson.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build();

        return csvBean.parse();
    }
}
