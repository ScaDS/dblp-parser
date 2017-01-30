package org.dblp.datastructures;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Inproceedings extends DblpElement {
    public String key;
    public String title;
    public String month;
    public String year;
    public String pages;
    public String conference;
    public List<String> authors;
    public List<String> citations;

    public Inproceedings() {
        this.type = DblpElementType.INPROCEEDINGS;
        this.authors = new ArrayList<>();
        this.citations = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Inproceedings{" +
                "key='" + key + '\'' +
                ", title='" + title + '\'' +
                ", month='" + month + '\'' +
                ", year='" + year + '\'' +
                ", pages='" + pages + '\'' +
                ", conference='" + conference + '\'' +
                ", authors=" + authors +
                ", citations=" + citations +
                "} " + super.toString();
    }
}
