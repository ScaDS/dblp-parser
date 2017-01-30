package org.dblp.datastructures;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Incollection extends DblpElement {
    public String key;
    public String title;
    public String booktitle;
    public String url;
    public String electronicEdition;

    public String pages;
    public String year;
    public List<String> authors;
    public String crossref;

    public Incollection () {
        this.type = DblpElementType.INCOLLECTION;

        authors = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Incollection{" +
                "key='" + key + '\'' +
                ", title='" + title + '\'' +
                ", booktitle='" + booktitle + '\'' +
                ", url='" + url + '\'' +
                ", electronicEdition='" + electronicEdition + '\'' +
                ", pages='" + pages + '\'' +
                ", year='" + year + '\'' +
                ", authors=" + authors +
                ", crossref='" + crossref + '\'' +
                "} " + super.toString();
    }
}
