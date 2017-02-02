package org.dblp.datastructures;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Incollection extends DblpElement {
    public String booktitle;
    public String url;
    public String electronicEdition;

    public String pages;
    public String year;
    public String crossref;

    public Incollection () {
        super();
        this.type = DblpElementType.INCOLLECTION;
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
