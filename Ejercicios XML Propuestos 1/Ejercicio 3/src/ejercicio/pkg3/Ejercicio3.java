package ejercicio.pkg3;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

public class Ejercicio3 {

    
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        SAXParserFactory saxParserfactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserfactory.newSAXParser();
        PersonasHandler handler = new PersonasHandler();       
        File file = new File("./datos/personas.xml");
        saxParser.parse(file, handler);
        
        ArrayList<Personas> personas = handler.getPersonas();
        
        Collections.sort(personas, new Comparator<Personas>() {        
            @Override
            public int compare(Personas p1, Personas p2) {
                return p1.getNombre().compareTo(p2.getNombre() );
            }
        });
        
        for (Personas objPersonas: personas) {
            System.out.println(objPersonas);
        }
    }
    
}
