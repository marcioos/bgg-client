package co.yellowbricks.bggclient.common;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public final class JAXB {
    
    private JAXB() {
    }
    
    public static Unmarshaller createUnmarshaller(Class<?> classToBeBound) {
        try {
            return JAXBContext.newInstance(classToBeBound).createUnmarshaller();
        } catch (JAXBException e) {
            throw new IllegalStateException("Could not create unmarshaller for " + classToBeBound, e);
        }
    }
}
