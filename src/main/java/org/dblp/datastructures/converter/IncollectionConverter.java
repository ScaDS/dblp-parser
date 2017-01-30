package org.dblp.datastructures.converter;

import org.dblp.datastructures.DblpElement;
import org.dblp.datastructures.Incollection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

/**
 *
 */
public class IncollectionConverter implements DblpElementConverter<Incollection> {
    @Override
    public Incollection convert(DblpElement element) {
        Incollection incollect = new Incollection();
        incollect.attributes = element.attributes;

        setKey(incollect, element);
        setTitle(incollect, element);
        setUrl(incollect, element);
        setElectronicEdition(incollect, element);
        setYear(incollect, element);
        setPages(incollect, element);
        setBooktitle(incollect, element);
        setAuthors(incollect, element);
        setCrossref(incollect, element);
         
        
        return incollect;
    }


    private void setKey(Incollection incollect, DblpElement element) {
        String key = "incollection";
        incollect.key = ConverterUtils.extract(key, element);
        incollect.attributes.removeAll(key);
    }

    private void setTitle(Incollection incollect, DblpElement element) {
        String key = "title";
        incollect.title = ConverterUtils.extract(key, element);
        incollect.attributes.removeAll(key);
    }

    private void setUrl(Incollection incollect, DblpElement element) {
        String key = "url";
        incollect.url = ConverterUtils.extract(key, element);
        incollect.attributes.removeAll(key);
    }

    private void setElectronicEdition(Incollection incollect, DblpElement element) {
        String key = "ee";
        incollect.electronicEdition = ConverterUtils.extract(key, element);
        incollect.attributes.removeAll(key);
    }

    private void setYear(Incollection incollect, DblpElement element) {
        String key = "year";
        incollect.year = ConverterUtils.extract(key, element);
        incollect.attributes.removeAll(key);
    }

    private void setPages(Incollection incollect, DblpElement element) {
        String key = "pages";
        incollect.pages = ConverterUtils.extract(key, element);
        incollect.attributes.removeAll(key);
    }

    private void setBooktitle(Incollection incollect, DblpElement element) {
        String key = "booktitle";
        incollect.booktitle = ConverterUtils.extract(key, element);
        incollect.attributes.removeAll(key);
    }

    private void setAuthors(Incollection incollect, DblpElement element) {
        String key = "author";
        Collection<String> attributes = element.attributes.get(key);

        for(String author : attributes) {
            incollect.authors.add(author);
        }
        incollect.attributes.removeAll(key);
    }

    private void setCrossref(Incollection incollect, DblpElement element) {
        String key = "crossref";
        incollect.crossref = ConverterUtils.extract(key, element);
        incollect.attributes.removeAll(key);
    }
}
