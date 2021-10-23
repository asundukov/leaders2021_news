package asundukov.leaders2021.mosrunewsrecommender.repository;

import asundukov.leaders2021.mosrunewsrecommender.model.NewsItem;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class NewsEntity {
    @Id
    public Integer id;
    @Column(length = 100000)
    public String title;
    @Column(length = 100000)
    public String importance;
    @Column
    public Integer isDeferredPublication;
    @Column(length = 100000)
    public String status;
    @Column
    public Integer yaRss;
    @Column(length = 100000)
    public String label;
    @Column(length = 100000)
    public String is_powered;
    @Column(length = 100000)
    public String hasImage;
    @Column(length = 100000)
    public String hasDistrict;
//    @Column
//    public List<Tag> tags;
//    @Column
//    public List<Sphere> spheres;
    @Column
    public Integer sphereId;
    @Column(length = 100000)
    public String sphereTitle;
    @Column(length = 100000)
    public String kindId;
    @Column(length = 100000)
    public String kindTitle;
    @Column
    public Integer kindType;
    @Column(length = 100000)
    public String previewText;
    @Column(length = 100000)
    public String fullText;

    public NewsEntity() {
    }

    public NewsEntity(NewsItem newsItem) {
        this.id = newsItem.id;
        this.fullText = newsItem.full_text;
        this.previewText = newsItem.preview_text;
        this.isDeferredPublication = newsItem.is_deferred_publication;
        this.hasDistrict = newsItem.has_district;
        this.hasImage = newsItem.has_image;
        this.importance = newsItem.importance;
        this.status = newsItem.status;
        this.is_powered = newsItem.is_powered;
        this.title = newsItem.title;
        this.yaRss = newsItem.ya_rss;
        this.label = newsItem.label;

        this.sphereId = newsItem.sphere.id;
        this.sphereTitle = newsItem.sphere.title;

        this.kindId = newsItem.kind.id;
        this.kindTitle = newsItem.kind.title;
        this.kindType = newsItem.kind.type;
    }

}
