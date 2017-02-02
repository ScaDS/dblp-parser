package org.dblp.datastructures.converter;

import org.dblp.datastructures.DblpElement;
import org.dblp.datastructures.Website;

/**
 *
 */
public class WebsiteConverter implements DblpElementConverter<Website> {
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
        if(ConverterUtils.extract(key, element) != null) {
            www.authors.add(ConverterUtils.extract(key, element));
        } else {
            if(ConverterUtils.extract(key2, element) != null) {
                www.authors.add(ConverterUtils.extract(key2, element));
            }
        }
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
        www.url = ConverterUtils.extract(key, element);
        if(www.url == null) {
            www.url = ConverterUtils.extract(key2, element);
        }
        www.attributes.removeAll(key);
        www.attributes.removeAll(key2);
    }

    private void setNote(Website www, DblpElement element) {
        String key = "note";
        www.note = ConverterUtils.extract(key, element);
        www.attributes.removeAll(key);
    }

    private void setYear(Website www, DblpElement element) {
        String key = "year";
        www.year = ConverterUtils.extract(key, element);
        www.attributes.removeAll(key);
    }
}
