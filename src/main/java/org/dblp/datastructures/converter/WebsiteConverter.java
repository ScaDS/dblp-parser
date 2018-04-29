package org.dblp.datastructures.converter;

import org.dblp.datastructures.DblpElement;
import org.dblp.datastructures.Website;

import java.util.Collection;

/**
 * Converts a {@link DblpElement} to an {@link Website} element.
 */
public class WebsiteConverter implements DblpElementConverter<Website> {
    @Override
    public Website convertEssentials(DblpElement element) {
        Website www = new Website();
        www.attributes = element.attributes;

        setKey(www, element);
        setAuthor(www, element);
        setTitle(www, element);

        return www;
    }

    @Override
    public Website convert(DblpElement element) {
        Website www = new Website();
        www.attributes = element.attributes;

        setKey(www, element);
        setAuthor(www, element);
        setTitle(www, element);
        setUrl(www, element);
        setNote(www, element);
        setYear(www, element);

        return www;
    }

    private void setKey(Website www, DblpElement element) {
        String key = "www";
        www.key = ConverterUtils.extract(key, element);
        www.attributes.removeAll(key);
    }

    private void setAuthor(Website www, DblpElement element) {
        String key = "author";
        String key2 = "editor";
        www.authors.addAll(element.attributes.get(key));
        www.authors.addAll(element.attributes.get(key2));

        www.attributes.removeAll(key);
        www.attributes.removeAll(key2);
    }

    private void setTitle(Website www, DblpElement element) {
        String key = "title";
        www.title = ConverterUtils.extract(key, element);
        www.attributes.removeAll(key);
    }

    private void setUrl(Website www, DblpElement element) {
        String key = "url";
        String key2 = "ee";
        www.url.addAll(element.attributes.get(key));
        www.url.addAll(element.attributes.get(key2));
        www.attributes.removeAll(key);
        www.attributes.removeAll(key2);
    }

    private void setNote(Website www, DblpElement element) {
        String key = "note";
        www.note.addAll(element.attributes.get(key));
        www.attributes.removeAll(key);
    }

    private void setYear(Website www, DblpElement element) {
        String key = "year";
        www.year = ConverterUtils.extract(key, element);
        www.attributes.removeAll(key);
    }
}
