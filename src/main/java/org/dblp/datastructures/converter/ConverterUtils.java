package org.dblp.datastructures.converter;

import org.dblp.datastructures.DblpElement;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 */
public class ConverterUtils {

    public static String extract(String key, DblpElement element) {
        Collection<String> attr = element.attributes.get(key);

        if(attr.size() != 1) {
            //System.out.println("Unexpected number ("+attr.size()+") of elements for key '"+key+"'" + attr);
            return null;
        } else {
            return new ArrayList<>(attr).get(0);
        }
    }
}
