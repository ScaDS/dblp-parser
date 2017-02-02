package org.dblp.datastructures;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Article extends DblpElement {
    public String journal;
    public String volume;
    public String month;
    public String year;

    public Article () {
        super();
        this.type = DblpElementType.ARTICLE;
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
