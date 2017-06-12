package org.dblp.datastructures.converter;

import org.dblp.datastructures.DblpElement;
import org.dblp.datastructures.DblpElementType;

/**
 * The interface is describing the methods which have to be implemented to properly convert a DBLP
 * entry to its {@link DblpElementType}
 *
 */
public interface DblpElementConverter<T extends DblpElement> {

    T convertEssentials(DblpElement element);

    T convert(DblpElement element);

}
