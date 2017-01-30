package org.dblp.parser;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

/**
 * Parses DBLP data
 */
public class DblpParser {
	public static void load(DblpElementProcessor processor, String uri) {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			System.out.println("Start parsing...");
			SAXParser parser = factory.newSAXParser();
			File file = new File(uri);
			DblpParserHandler handler = new DblpParserHandler(processor);
			parser.getXMLReader().setFeature(
					"http://xml.org/sax/features/validation", true);
			parser.parse(file, handler);
		} catch (IOException e) {
			System.out.println("Error reading URI: " + e.getMessage());
		} catch(ParsingTerminationException e) {
			System.out.println("Parsing ended intentionally. Nothing to do.");
		} catch (SAXException e) {
			System.out.println("Error in parsing: " + e.getMessage());
		} catch (ParserConfigurationException e) {
			System.out.println("Error in XML parser configuration: "
					+ e.getMessage());
		}
	}
}
