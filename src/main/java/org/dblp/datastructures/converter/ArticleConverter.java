package org.dblp.datastructures.converter;

import org.dblp.datastructures.Article;
import org.dblp.datastructures.DblpElement;

import java.util.*;

/**
 *
 */
public class ArticleConverter implements DblpElementConverter<Article> {
    private final List<String> titleKeys = Arrays.asList("title", "sub", "sup", "i", "tt");

    @Override
    public Article convert(DblpElement element) {
        Article article = new Article();

        article.attributes = element.attributes;

        setKey(article, element);
        setTitle(article, element);
        setMonth(article, element);
        setYear(article, element);
        setJournal(article, element);
        setVolume(article, element);
        setAuthors(article, element);

        return article;
    }

    private void setKey(Article article, DblpElement element) {
        String key = "article";
        article.key = ConverterUtils.extract(key, element);
        article.attributes.removeAll(key);
    }

    private void setTitle(Article article, DblpElement element) {
        Optional<String> key = titleKeys.stream()
                .filter(element.attributes::containsKey)
                .findFirst();

        if(key.isPresent()) {
            article.title = new ArrayList<>(element.attributes.get(key.get())).get(0);
            article.attributes.removeAll(key.get());
        } else {
            System.out.println("No Title for Article Element found." + element);
        }
    }

    private void setMonth(Article article, DblpElement element) {
        String key = "month";
        article.month = ConverterUtils.extract(key, element);
        article.attributes.removeAll(key);
    }

    private void setYear(Article article, DblpElement element) {
        String key = "year";
        article.year = ConverterUtils.extract(key, element);
        article.attributes.removeAll(key);
    }

    private void setVolume(Article article, DblpElement element) {
        String key = "volume";
        article.volume = ConverterUtils.extract(key, element);
        article.attributes.removeAll(key);
    }

    private void setJournal(Article article, DblpElement element) {
        String key = "journal";
        article.journal = ConverterUtils.extract(key, element);
        article.attributes.removeAll(key);
    }

    private void setAuthors(Article article, DblpElement element) {
        String key = "author";
        Collection<String> attributes = element.attributes.get(key);

        for(String author : attributes) {
            article.authors.add(author);
        }
        article.attributes.removeAll(key);
    }
}
