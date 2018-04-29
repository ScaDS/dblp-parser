package org.dblp.datastructures;

import java.util.ArrayList;
import java.util.List;

public class PhDThesis extends DblpElement
{
    public List<String> schools;
    public String year;

    public PhDThesis() {
        super();
        this.type = DblpElementType.PHDTHESIS;
        schools = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Article{" +
                "key='" + key + '\'' +
                ", schools='" + schools + '\'' +
                ", authors=" + authors +
                ", title='" + title + '\'' +
                ", year='" + year + '\'' +
                "} " + super.toString();
    }
}
