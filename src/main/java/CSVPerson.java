import com.opencsv.bean.CsvBindByName;

public class CSVPerson {

    @CsvBindByName(column = "id")
    private int id;

    @CsvBindByName(column = "firstName")
    private String firstName;

    @CsvBindByName(column = "lastName")
    private String lastName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
