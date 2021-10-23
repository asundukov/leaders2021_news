package asundukov.leaders2021.mosrunewsrecommender.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Sphere {
    public Integer id;

    public String title;
    public Integer special;

    public Integer activated;

    public Integer priority;


}
