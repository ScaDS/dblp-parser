package org.dblp.datastructures.converter;

import org.dblp.datastructures.Book;
import org.dblp.datastructures.DblpElement;

import java.util.*;

/**
 *
 */
public class BookConverter implements DblpElementConverter<Book> {
    private final List<String> authorKeys = Arrays.asList("editor", "author");

    @Override
    public Book convert(DblpElement element) {
        Book book = new Book();

        book.attributes = element.attributes;

        setKey(book, element);
        setTitle(book, element);
        setAuthor(book, element);
        setSeries(book, element);
        setYear(book, element);
        setIsbns(book, element);
        setPublisher(book, element);
        setUrl(book, element);


        return book;
    }

    private void setUrl(Book book, DblpElement element) {
        String key = "url";
        book.url = ConverterUtils.extract(key, element);
        book.attributes.removeAll(key);
    }

    private void setPublisher(Book book, DblpElement element) {
        String key = "publisher";

        Collection<String> attributes = element.attributes.get(key);
        for(String publisher : attributes) {
            book.publisher += publisher != null ? publisher : "";
        }
        book.attributes.removeAll(key);
    }

    private void setIsbns(Book book, DblpElement element) {
        String key = "isbn";

        Collection<String> attributes = element.attributes.get(key);
        for(String isbn : attributes) {
            book.isbns.add(isbn);
        }
        book.attributes.removeAll(key);
    }

    private void setYear(Book book, DblpElement element) {
        String key = "year";
        book.year = ConverterUtils.extract(key, element);
        book.attributes.removeAll(key);
    }

    private void setAuthor(Book book, DblpElement element) {
        Optional<String> key = authorKeys.stream()
                .filter(element.attributes::containsKey)
                .findFirst();

        if(key.isPresent()) {
            for(String author : new ArrayList<>(element.attributes.get(key.get()))) {
                book.authors.add(author);
            }
            book.attributes.removeAll(key.get());
        }
    }

    private void setTitle(Book book, DblpElement element) {
        String key = "title";

        Collection<String> attributes = element.attributes.get(key);
        for(String titlePart : attributes) {
            book.title += titlePart != null ? titlePart : "";
        }
        book.attributes.removeAll(key);
    }

    private void setSeries(Book book, DblpElement element) {
        String key = "series";
        book.series = ConverterUtils.extract(key, element);
        book.attributes.removeAll(key);
    }

    private void setKey(Book book, DblpElement element) {
        String key = "book";
        book.key = ConverterUtils.extract(key, element);
        book.attributes.removeAll(key);
    }
}
