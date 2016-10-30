package org.v5k.crawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShowCrawler {

    @Value("${url}")
    private String URL;

    public List<String> availableShows() {
        try {
            Document doc = Jsoup.connect(URL).get();
            Elements elements = doc.select("div#leftandright li a");
            return elements.stream().skip(1).map(e -> e.text()).collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Oops.. cannot load available shows", e);
        }
    }
}
