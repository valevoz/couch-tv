package org.v5k.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.v5k.crawler.ShowCrawler;
import org.v5k.domain.Show;
import org.v5k.domain.ShowRepository;

import java.util.List;

@Component
public class ShowService {

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private ShowCrawler crawler;

    public Iterable<Show> subscribedShows() {
        return showRepository.findAll();
    }

    public List<String> availableShows() {
        return crawler.availableShows();
    }
}