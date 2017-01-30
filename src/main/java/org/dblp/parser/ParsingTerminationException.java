package org.dblp.parser;


import org.xml.sax.SAXException;

/**
 * This exception is used to distinguish between an actual parsing error and an interrupt to the parsing.
 */
public class ParsingTerminationException extends SAXException {
}
