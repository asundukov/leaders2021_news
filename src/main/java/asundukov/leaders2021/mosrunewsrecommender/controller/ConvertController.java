package asundukov.leaders2021.mosrunewsrecommender.controller;

import asundukov.leaders2021.mosrunewsrecommender.model.News;
import asundukov.leaders2021.mosrunewsrecommender.model.NewsItem;
import asundukov.leaders2021.mosrunewsrecommender.repository.NewsEntity;
import asundukov.leaders2021.mosrunewsrecommender.repository.NewsRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import static asundukov.leaders2021.mosrunewsrecommender.MosruNewsRecommenderConverter.escapeString;

@RestController
public class ConvertController {

    private final NewsRepository newsRepository;

    public ConvertController(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    private static final ObjectMapper mapper = new ObjectMapper();

    @GetMapping("/convert")
    public String convert() throws IOException {
        URL url = Thread.currentThread().getContextClassLoader().getResource("ttt.txt");
        File file = new File(url.getPath());
        InputStream in = new FileInputStream(file);
        BufferedReader r = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));

        News news = mapper.readValue(r, News.class);

        FileWriter fw = new FileWriter("out.txt");

        for (NewsItem item : news) {
            System.out.print(".");
            NewsEntity entity = new NewsEntity(item);
            newsRepository.save(entity);
        }
        fw.close();
        System.out.println();

        return "hello";
    }
}
