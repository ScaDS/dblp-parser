package org.dblp.datastructures;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Book extends DblpElement {
    public String series;
    public String year;
    public List<String> isbns;
    public String publisher = "";
    public String url;

    public Book() {
        super();
        this.type = DblpElementType.BOOK;
        this.isbns = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Book{" +
                "key='" + key + '\'' +
                ", title='" + title + '\'' +
                ", authors=" + authors +
                ", series='" + series + '\'' +
                ", year='" + year + '\'' +
                ", isbn='" + isbns + '\'' +
                ", publisher='" + publisher + '\'' +
                ", url='" + url + '\'' +
                "} " + super.toString();
    }
}
