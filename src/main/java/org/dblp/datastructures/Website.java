package org.dblp.datastructures;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Website extends DblpElement {
    public List<String> url;
    public List<String> note;
    public String year;

    public Website () {
        super();
        this.type = DblpElementType.WEBSITE;
        this.url = new ArrayList<>();
        this.note = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Website{" +
                "key='" + key + '\'' +
                ", author='" + authors + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", note='" + note + '\'' +
                ", year='" + year + '\'' +
                "} " + super.toString();
    }
}
