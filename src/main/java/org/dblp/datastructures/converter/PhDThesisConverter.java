package org.dblp.datastructures.converter;

import org.dblp.datastructures.PhDThesis;
import org.dblp.datastructures.DblpElement;

import java.util.*;

/**
 * Converts a {@link DblpElement} to an {@link PhDThesis} element.
 */
public class PhDThesisConverter implements DblpElementConverter<PhDThesis> {
    private final List<String> titleKeys = Arrays.asList("title", "sub", "sup", "i", "tt");

    @Override
    public PhDThesis convertEssentials(DblpElement element) {
        PhDThesis phDThesis = new PhDThesis();

        phDThesis.attributes = element.attributes;

        setKey(phDThesis, element);
        setTitle(phDThesis, element);
        setAuthors(phDThesis, element);

        return phDThesis;
    }

    @Override
    public PhDThesis convert(DblpElement element) {
        PhDThesis phDThesis = new PhDThesis();

        phDThesis.attributes = element.attributes;

        setKey(phDThesis, element);
        setTitle(phDThesis, element);
        setYear(phDThesis, element);
        setSchool(phDThesis, element);
        setAuthors(phDThesis, element);

        return phDThesis;
    }

    private void setKey(PhDThesis phDThesis, DblpElement element) {
        String key = "phdthesis";
        phDThesis.key = ConverterUtils.extract(key, element);
        phDThesis.attributes.removeAll(key);
    }

    private void setTitle(PhDThesis phDThesis, DblpElement element) {
        Optional<String> key = titleKeys.stream()
                .filter(element.attributes::containsKey)
                .findFirst();

        if(key.isPresent()) {
            phDThesis.title = new ArrayList<>(element.attributes.get(key.get())).get(0);
            phDThesis.attributes.removeAll(key.get());
        } else {
            System.out.println("No Title for phdthesis Element found." + element);
        }
    }

    private void setYear(PhDThesis phDThesis, DblpElement element) {
        String key = "year";
        phDThesis.year = ConverterUtils.extract(key, element);
        phDThesis.attributes.removeAll(key);
    }

    private void setSchool(PhDThesis phDThesis, DblpElement element) {
        String key = "school";
        Collection<String> attributes = element.attributes.get(key);

        phDThesis.schools.addAll(attributes);
        phDThesis.attributes.removeAll(key);
    }

    private void setAuthors(PhDThesis phDThesis, DblpElement element) {
        String key = "author";
        Collection<String> attributes = element.attributes.get(key);

        phDThesis.authors.addAll(attributes);
        phDThesis.attributes.removeAll(key);
    }
}

