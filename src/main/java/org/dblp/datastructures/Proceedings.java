package org.dblp.datastructures;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Proceedings extends DblpElement {
    public String key;
    public String series;
    public String booktitle;
    public String title;
    public String volume;
    public List<String> editors;
    public String year;
    public String isbn;
    public String publisher;
    public String url;

    public Proceedings() {
        this.type = DblpElementType.PROCEEDINGS;
        this.editors = new ArrayList<>();
        this.title = "";
    }

    @Override
    public String toString() {
        return "Proceedings{" +
                "key='" + key + '\'' +
                ", series='" + series + '\'' +
                ", booktitle='" + booktitle + '\'' +
                ", title='" + title + '\'' +
                ", volume='" + volume + '\'' +
                ", editors='" + editors + '\'' +
                ", year='" + year + '\'' +
                ", isbn='" + isbn + '\'' +
                ", publisher='" + publisher + '\'' +
                ", url='" + url + '\'' +
                "} " + super.toString();
    }
}
