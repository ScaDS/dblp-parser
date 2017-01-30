package org.dblp.datastructures;

/**
 *
 */
public class Website extends DblpElement {
    public String key;
    public String author;
    public String title;
    public String url;
    public String note;
    public String year;

    public Website () {
        this.type = DblpElementType.WEBSITE;
    }

    @Override
    public String toString() {
        return "Website{" +
                "key='" + key + '\'' +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", note='" + note + '\'' +
                ", year='" + year + '\'' +
                "} " + super.toString();
    }
}
