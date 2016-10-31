package org.v5k.domain;

public class Episode {
    private final String name;
    private final String link;

    public Episode(String name, String link) {
        this.name = name;
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public String getLink() {
        return link;
    }
}
