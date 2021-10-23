package asundukov.leaders2021.mosrunewsrecommender.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Tag {
    public Integer id;
    public String title;
}
