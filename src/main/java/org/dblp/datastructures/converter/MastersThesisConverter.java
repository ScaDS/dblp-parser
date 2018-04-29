package org.dblp.datastructures.converter;

import org.dblp.datastructures.MastersThesis;
import org.dblp.datastructures.DblpElement;

import java.util.*;

/**
 * Converts a {@link DblpElement} to an {@link MastersThesis} element.
 */
public class MastersThesisConverter implements DblpElementConverter<MastersThesis> {
    private final List<String> titleKeys = Arrays.asList("title", "sub", "sup", "i", "tt");

    @Override
    public MastersThesis convertEssentials(DblpElement element) {
        MastersThesis mastersThesis = new MastersThesis();

        mastersThesis.attributes = element.attributes;

        setKey(mastersThesis, element);
        setTitle(mastersThesis, element);
        setAuthors(mastersThesis, element);

        return mastersThesis;
    }

    @Override
    public MastersThesis convert(DblpElement element) {
        MastersThesis mastersThesis = new MastersThesis();

        mastersThesis.attributes = element.attributes;

        setKey(mastersThesis, element);
        setTitle(mastersThesis, element);
        setYear(mastersThesis, element);
        setSchool(mastersThesis, element);
        setAuthors(mastersThesis, element);

        return mastersThesis;
    }

    private void setKey(MastersThesis mastersThesis, DblpElement element) {
        String key = "mastersthesis";
        mastersThesis.key = ConverterUtils.extract(key, element);
        mastersThesis.attributes.removeAll(key);
    }

    private void setTitle(MastersThesis mastersThesis, DblpElement element) {
        Optional<String> key = titleKeys.stream()
                .filter(element.attributes::containsKey)
                .findFirst();

        if(key.isPresent()) {
            mastersThesis.title = new ArrayList<>(element.attributes.get(key.get())).get(0);
            mastersThesis.attributes.removeAll(key.get());
        } else {
            System.out.println("No Title for mastersthesis Element found." + element);
        }
    }

    private void setYear(MastersThesis mastersThesis, DblpElement element) {
        String key = "year";
        mastersThesis.year = ConverterUtils.extract(key, element);
        mastersThesis.attributes.removeAll(key);
    }

    private void setSchool(MastersThesis mastersThesis, DblpElement element) {
        String key = "school";
        mastersThesis.school = ConverterUtils.extract(key, element);
        mastersThesis.attributes.removeAll(key);
    }

    private void setAuthors(MastersThesis mastersThesis, DblpElement element) {
        String key = "author";
        Collection<String> attributes = element.attributes.get(key);

        mastersThesis.authors.addAll(attributes);
        mastersThesis.attributes.removeAll(key);
    }
}
