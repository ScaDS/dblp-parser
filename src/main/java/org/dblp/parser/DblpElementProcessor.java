package org.dblp.parser;

import org.dblp.datastructures.DblpElement;
import org.xml.sax.SAXException;

/**
 * To gain full access during the parsing process you have to implement this interface.
 * This enables one to:
 * + execute write operations per element
 * + create batches of elements and write them at once
 * + just doing statistics on the parsed data
 * + etc...
 */
public interface DblpElementProcessor {
     void process(DblpElement element) throws SAXException;
}
