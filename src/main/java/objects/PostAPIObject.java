package objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PostAPIObject {
    @JsonProperty(value = "id")
    private int id;

    public int getId() {
        return id;
    }
}
