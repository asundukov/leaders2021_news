package asundukov.leaders2021.mosrunewsrecommender.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NewsItem {
    public Integer id;
    public String title;
    public String importance;
    public Integer is_deferred_publication;

    public String status;

    public Integer ya_rss;

    public String label;

    public String is_powered;

    public String has_image;

    public String has_district;

    public List<Tag> tags;

    public List<Sphere> spheres;

    public Sphere sphere;

    public Kind kind;

    public String preview_text;

    public String full_text;

    @JsonProperty("published_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    public Date publishedAt;

    @JsonProperty("created_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    public Date createdAt;

    @Override
    public String toString() {
        return "NewsItem{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", importance='" + importance + '\'' +
                ", publishedAt=" + publishedAt +
                ", createdAt=" + createdAt +
                '}';
    }
}
