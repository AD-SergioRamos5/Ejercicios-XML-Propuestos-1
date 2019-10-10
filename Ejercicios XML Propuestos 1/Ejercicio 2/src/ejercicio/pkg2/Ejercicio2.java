package ejercicio.pkg2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

public class Ejercicio2 {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        
        SAXParserFactory saxParserfactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserfactory.newSAXParser();
        PersonasHandler handler = new PersonasHandler();       
        File file = new File("./datos/personas.xml");
        saxParser.parse(file, handler);
        
        ArrayList<Personas> personas = handler.getPersonas();
        
        
        for (Personas objPersonas: personas) {
            System.out.println(objPersonas);
        }
    } 
    
}
