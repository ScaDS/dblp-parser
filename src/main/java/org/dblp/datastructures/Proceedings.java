package org.dblp.datastructures;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Proceedings extends DblpElement {
    public String series;
    public String booktitle;
    public String volume;
    public String year;
    public String isbn;
    public String publisher;
    public String url;

    public Proceedings() {
        super();
        this.type = DblpElementType.PROCEEDINGS;
    }

    @Override
    public String toString() {
        return "Proceedings{" +
                "key='" + key + '\'' +
                ", series='" + series + '\'' +
                ", booktitle='" + booktitle + '\'' +
                ", title='" + title + '\'' +
                ", volume='" + volume + '\'' +
                ", editors/authors='" + authors + '\'' +
                ", year='" + year + '\'' +
                ", isbn='" + isbn + '\'' +
                ", publisher='" + publisher + '\'' +
                ", url='" + url + '\'' +
                "} " + super.toString();
    }
}
