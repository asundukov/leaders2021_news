package asundukov.leaders2021.mosrunewsrecommender.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Kind {
    public String id;

    public String title;

    public Integer type;
}
