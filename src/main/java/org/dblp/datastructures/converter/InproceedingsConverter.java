package org.dblp.datastructures.converter;

import org.dblp.datastructures.DblpElement;
import org.dblp.datastructures.Inproceedings;

import java.util.*;

/**
 * Converts a {@link DblpElement} to an {@link Inproceedings} element.
 */
public class InproceedingsConverter implements DblpElementConverter<Inproceedings> {
    private final List<String> titleKeys = Arrays.asList("title", "sub", "sup", "i", "tt");

    @Override
    public Inproceedings convert(DblpElement element) {
        Inproceedings inproc = new Inproceedings();

        inproc.attributes = element.attributes;

        // the set operations will also remove the entries from the "inproceedings" attributes
        // therefore only unused attributes will remain.
        setKey(inproc, element);
        setTitle(inproc, element);
        setMonth(inproc, element);
        setYear(inproc, element);
        setPages(inproc, element);
        setConference(inproc, element);
        setAuthors(inproc, element);
        setCitations(inproc, element);

        return inproc;
    }

    private void setKey(Inproceedings inproc, DblpElement element) {
        String key = "inproceedings";
        inproc.key = ConverterUtils.extract(key, element);
        inproc.attributes.removeAll(key);
    }

    private void setTitle(Inproceedings inproc, DblpElement element) {
         Optional<String> key = titleKeys.stream()
                 .filter(element.attributes::containsKey)
                 .findFirst();

         if(key.isPresent()) {
             inproc.title = new ArrayList<>(element.attributes.get(key.get())).get(0);
             inproc.attributes.removeAll(key.get());
         } else {
             System.out.println("No Title for Inproceeding Element found." + element);
         }
    }

    private void setMonth(Inproceedings inproc, DblpElement element) {
        String key = "month";
        inproc.month = ConverterUtils.extract(key, element);
        inproc.attributes.removeAll(key);
    }

    private void setYear(Inproceedings inproc, DblpElement element) {
        String key = "year";
        inproc.year = ConverterUtils.extract(key, element);
        inproc.attributes.removeAll(key);
    }

    private void setPages(Inproceedings inproc, DblpElement element) {
        String key = "pages";
        inproc.pages = ConverterUtils.extract(key, element);
        inproc.attributes.removeAll(key);
    }

    private void setConference(Inproceedings inproc, DblpElement element) {
        String key = "booktitle";
        inproc.conference = ConverterUtils.extract(key, element);
        inproc.attributes.removeAll(key);
    }

    private void setAuthors(Inproceedings inproc, DblpElement element) {
        String key = "author";
        Collection<String> attributes = element.attributes.get(key);

        for(String author : attributes) {
            inproc.authors.add(author);
        }
        inproc.attributes.removeAll(key);
    }

    private void setCitations(Inproceedings inproc, DblpElement element) {
        String key = "cite";
        Collection<String> attributes = element.attributes.get(key);

        if(attributes != null) {
            for (String citation : attributes) {
                inproc.citations.add(citation);
            }
            inproc.attributes.removeAll(key);
        }
    }
}
