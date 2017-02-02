package org.dblp.datastructures.converter;

import org.dblp.datastructures.DblpElement;
import org.dblp.datastructures.Proceedings;

import java.util.Collection;


/**
 * Created by kricke on 24.01.17.
 */
public class ProceedingsConverter implements DblpElementConverter<Proceedings> {
    @Override
    public Proceedings convert(DblpElement element) {
        Proceedings proceedings = new Proceedings();

        proceedings.attributes = element.attributes;

        setKey(proceedings, element);
        setSeries(proceedings, element);
        setBooktitle(proceedings, element);
        setTitle(proceedings, element);
        setVolume(proceedings, element);
        setEditors(proceedings, element);
        setYear(proceedings, element);
        setIsbn(proceedings, element);
        setPublisher(proceedings, element);
        setUrl(proceedings, element);

        return proceedings;
    }

    private void setUrl(Proceedings proceedings, DblpElement element) {
        String key = "url";
        proceedings.url = ConverterUtils.extract(key, element);
        proceedings.attributes.removeAll(key);
    }

    private void setPublisher(Proceedings proceedings, DblpElement element) {
        String key = "publisher";
        proceedings.publisher = ConverterUtils.extract(key, element);
        proceedings.attributes.removeAll(key);
    }

    private void setIsbn(Proceedings proceedings, DblpElement element) {
        String key = "isbn";
        proceedings.isbn = ConverterUtils.extract(key, element);
        proceedings.attributes.removeAll(key);
    }

    private void setYear(Proceedings proceedings, DblpElement element) {
        String key = "year";
        proceedings.year = ConverterUtils.extract(key, element);
        proceedings.attributes.removeAll(key);
    }

    private void setEditors(Proceedings proceedings, DblpElement element) {
        String key = "editor";
        Collection<String> attributes = element.attributes.get(key);

        for(String editor : attributes) {
            proceedings.authors.add(editor);
        }
        proceedings.attributes.removeAll(key);
    }

    private void setVolume(Proceedings proceedings, DblpElement element) {
        String key = "volume";
        proceedings.volume = ConverterUtils.extract(key, element);
        proceedings.attributes.removeAll(key);
    }

    private void setTitle(Proceedings proceedings, DblpElement element) {
        String key = "title";

        Collection<String> attributes = element.attributes.get(key);
        for(String titlePart : attributes) {
            proceedings.title += titlePart;
        }
        proceedings.attributes.removeAll(key);
    }

    private void setBooktitle(Proceedings proceedings, DblpElement element) {
        String key = "booktitle";
        proceedings.booktitle = ConverterUtils.extract(key, element);
        proceedings.attributes.removeAll(key);
    }

    private void setSeries(Proceedings proceedings, DblpElement element) {
        String key = "series";
        proceedings.series = ConverterUtils.extract(key, element);
        proceedings.attributes.removeAll(key);
    }

    private void setKey(Proceedings proceedings, DblpElement element) {
        String key = "proceedings";
        proceedings.key = ConverterUtils.extract(key, element);
        proceedings.attributes.removeAll(key);
    }
}
