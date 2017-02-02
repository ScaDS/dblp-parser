package org.dblp.datastructures;


import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import java.util.ArrayList;
import java.util.List;

/**
 * The raw DBLP element
 */
public class DblpElement {
    public DblpElementType type;
    public Multimap<String, String> attributes;

    // shared fields
    public String key;
    public String title;
    public List<String> authors;

    protected DblpElement () {
        initialize();
    }

    public DblpElement (DblpElementType type) {
        this.type = type;
        initialize();
    }

    private void initialize() {
        authors = new ArrayList<>();
        title = "";
        this.attributes = ArrayListMultimap.create();
    }

    public void addAttribute(String key, String value) {
        if(key != null && value != null) {
            attributes.put(key, value);
        }
    }

    public DblpElementType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "DblpElement{" +
                "type=" + type +
                ", attributes=" + attributes +
                '}';
    }
}
