package org.dblp.datastructures;

public class MastersThesis extends DblpElement
{
    public String school;
    public String year;

    public MastersThesis() {
        super();
        this.type = DblpElementType.MASTERSTHESIS;
    }

    @Override
    public String toString() {
        return "Article{" +
                "key='" + key + '\'' +
                ", school='" + school + '\'' +
                ", authors=" + authors +
                ", title='" + title + '\'' +
                ", year='" + year + '\'' +
                "} " + super.toString();
    }
}
