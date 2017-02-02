package org.dblp.datastructures;

/**
 *
 */
public class Website extends DblpElement {
    public String url;
    public String note;
    public String year;

    public Website () {
        super();
        this.type = DblpElementType.WEBSITE;
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
