package org.dblp.parser;

import org.dblp.datastructures.DblpElement;
import org.dblp.datastructures.DblpElementType;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * This class provides methods to parse DBLP data.
 */
public class DblpParserHandler extends DefaultHandler {
    private final DblpElementProcessor processor;
    private DblpElement curElement = null;
    private String curRawName = null;
    private StringBuilder bufferedElement = new StringBuilder();


    DblpParserHandler(DblpElementProcessor processor) {
        this.processor = processor;
    }

    @Override
    public void startElement(String namespaceURI, String localName, String rawName, Attributes atts) throws SAXException {

        // identify the type and start new curElement
        DblpElementType type = DblpElementType.dblpElementType(rawName);
        curRawName = rawName;
        if(type != null) {
            if(curElement != null) {
                // the former curElement was not properly ended
                throw new IllegalStateException("Element was not properly closed! New curElement starts before ");
            }
            curElement = new DblpElement(type);
        }

        // add attribute to the existing curElement
        if(curElement != null) {
            curElement.addAttribute(rawName, atts.getValue("key"));
        }


    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if(curElement != null) {
            String str = new String(ch, start, length).trim();
            bufferedElement.append(str);
        }
    }

    @Override
    public void endElement(String namespaceURI, String localName, String rawName) throws SAXException {
        // identify the type
        DblpElementType type = DblpElementType.dblpElementType(rawName);
        if(type != null && type == curElement.getType()) {
            // the dblp element is closing and could be finalized
            processor.process(curElement);

            curElement = null;
            curRawName = null;
        } else if (type != null && type != curElement.getType()) {
            throw new IllegalStateException("Tries to close outer element but is not active element!"
                    + type + " vs " + curElement.getType());
        } else {
            if(curElement != null) {
                curElement.addAttribute(curRawName, bufferedElement.toString());
                bufferedElement = new StringBuilder();
            }
        }
    }

    private void Message(String mode, SAXParseException exception) {
        System.out.println(mode + " Line: " + exception.getLineNumber()
                + " URI: " + exception.getSystemId() + "\n" + " Message: "
                + exception.getMessage());
    }

    @Override
    public void warning(SAXParseException exception) throws SAXException {
        Message("**Parsing Warning**\n", exception);
        throw new SAXException("Warning encountered");
    }

    @Override
    public void error(SAXParseException exception) throws SAXException {
        Message("**Parsing Error**\n", exception);
        throw new SAXException("Error encountered");
    }

    @Override
    public void fatalError(SAXParseException exception) throws SAXException {
        Message("**Parsing Fatal Error**\n", exception);
        throw new SAXException("Fatal Error encountered");
    }
}
