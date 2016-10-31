package org.v5k.crawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.v5k.domain.Episode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ShowCrawler {

    @Value("${url}")
    private String URL;

    public void setURL(String URL) {
        this.URL = URL;
    }

    public List<String> availableShows() {
        try {
            Document doc = Jsoup.connect(URL).get();
            Elements elements = doc.select("div#leftandright li a");
            return elements.stream().skip(1).map(Element::text).collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Oops.. cannot load shows", e);
        }
    }

    public Map<Integer, List<Episode>> availableEpisodes(String show) {
        try {
            Document doc = Jsoup.connect(generateURL(show)).get();
            Elements elements = doc.select(".entry p, .entry li");
            Map<Integer, List<Episode>> map = new HashMap<>();

            int season;
            List<Episode> episodes = new ArrayList<>();
            for (int i = 2, n = elements.size(); i < n - 1; i++) {
                Element element = elements.get(i);
                if (!element.html().contains("<a")) {
                    season = Integer.valueOf(element.text().split(" ")[1].trim());
                    episodes = new ArrayList<>();
                    map.put(season, episodes);
                } else {
                    Elements episodeDetails = element.select("a");
                    episodes.add(new Episode(episodeDetails.text(), episodeDetails.attr("href")));
                }
            }
            return map;
        } catch (IOException e) {
            throw new RuntimeException("Oops.. cannot load episodes", e);
        }
    }

    private String generateURL(String show) {
        return URL + "watch-" + show.toLowerCase().replace(' ', '-') + "-online/";
    }

    public static void main(String[] args) {
        ShowCrawler showCrawler = new ShowCrawler();
        showCrawler.setURL("http://couchtuner.ch/");

        showCrawler.availableEpisodes("American Dad");
    }
}
