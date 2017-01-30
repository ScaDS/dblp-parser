package org.dblp.datastructures;


import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

/**
 * The raw DBLP element
 */
public class DblpElement {
    public DblpElementType type;
    public Multimap<String, String> attributes;

    protected DblpElement () {

    }

    public DblpElement (DblpElementType type) {
        this.type = type;
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
