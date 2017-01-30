package org.dblp.example;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import org.dblp.datastructures.*;
import org.dblp.datastructures.converter.DblpElementConverter;
import org.dblp.parser.DblpElementProcessor;
import org.dblp.parser.DblpParser;
import org.dblp.parser.ParsingTerminationException;
import org.xml.sax.SAXException;

/**
 * This is a simple example implementation which extracts the statistics for the first N elements from the dblp
 * xml and prints every parsed element to the console.
 */
public class StatisticsProcessor implements DblpElementProcessor {
    private final int excerptSize;
    private final boolean print;
    public int count = 0;

    public Table<DblpElementType, String, Integer> countTable;


    public StatisticsProcessor(int excerptSize, boolean print) {
        this.excerptSize = excerptSize;
        this.countTable = HashBasedTable.create();
        this.print = print;
    }

    @Override
    public void process(DblpElement element) throws SAXException {
        count++;

        /*
         * Statistics Block
         */

        // count the number of occurences per element
        if(!countTable.containsRow(element.type)) {
            countTable.put(element.type, "element.count", 0);
        }
        countTable.put(element.type, "element.count", countTable.get(element.type, "element.count") + 1);

        // count the different xml keys per element
        for(String key : element.attributes.keySet()) {
            if(!countTable.contains(element.type, key)) {
                countTable.put(element.type, key, 0);
            }
            countTable.put(element.type, key, countTable.get(element.type, key) + 1);
        }

        /*
         * Parse to POJO and Print Block
         */

        // convert
        DblpElementConverter conv = element.type.getConverter();
        DblpElement convertedElement = conv.convert(element);

        // print
        if(print) {
            System.out.println(convertedElement);
        }

        /*
         * Finish if excerpt size is reached
         */
        if(count >= excerptSize) {
            throw new ParsingTerminationException();
        }
    }


    /**
     * An example main.
     * @param args
     */
    public static void main(String[] args) {
        StatisticsProcessor processor = new StatisticsProcessor(Integer.parseInt(args[1]), Boolean.parseBoolean(args[2]));
        DblpParser.load(processor, args[0]);
        System.out.println("Parsed elements : " + processor.count);
        System.out.println("Statistics Table: " + processor.countTable);
    }
}
