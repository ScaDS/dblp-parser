package org.dblp.datastructures;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Article extends DblpElement {
    public String key;
    public String journal;
    public String volume;
    public List<String> authors;
    public String title;
    public String month;
    public String year;

    public Article () {
        this.type = DblpElementType.ARTICLE;
        this.authors = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Article{" +
                "key='" + key + '\'' +
                ", journal='" + journal + '\'' +
                ", volume='" + volume + '\'' +
                ", authors=" + authors +
                ", title='" + title + '\'' +
                ", month='" + month + '\'' +
                ", year='" + year + '\'' +
                "} " + super.toString();
    }
}
