package rest;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("storage")
public class StorageProperties {

    //files stored goes here
    private String location = "src/main/resources";

    public String getLocation() {
        return location;
    }

    //careful with this one
    public void setLocation(String location) {
        this.location = location;
    }

}
