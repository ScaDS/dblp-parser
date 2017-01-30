package org.dblp.datastructures;

import org.dblp.datastructures.converter.*;

/**
 * This {@link Enum} contains all types in DBLP and the converter class to a POJO
 */
public enum DblpElementType {
    INPROCEEDINGS("inproceedings", new InproceedingsConverter()),
    PROCEEDINGS("proceedings", new ProceedingsConverter()),
    ARTICLE("article", new ArticleConverter()),
    INCOLLECTION("incollection", new IncollectionConverter()),
    WEBSITE("www", new WebsiteConverter()),
    BOOK("book", new BookConverter()),
    ;

    private String identifier = null;
    private DblpElementConverter converter = null;

    DblpElementType(String dblpIdentifier, DblpElementConverter converter) {
        this.identifier = dblpIdentifier;
        this.converter = converter;
    }

    public DblpElementConverter getConverter() {
        return converter;
    }

    public static DblpElementType dblpElementType(String rawType) {
        for(DblpElementType type : DblpElementType.values()) {
            if(type.identifier != null && type.identifier.equals(rawType)) {
                return type;
            }
        }
        return null;
    }
}
