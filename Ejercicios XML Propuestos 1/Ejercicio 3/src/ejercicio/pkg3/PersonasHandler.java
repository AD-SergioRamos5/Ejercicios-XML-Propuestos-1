package ejercicio.pkg3;

import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class PersonasHandler extends DefaultHandler {
    private final ArrayList<Personas> personas = new ArrayList();
    private Personas persona;
    private String buffer;
    
    public ArrayList<Personas> getPersonas()
    {
        return personas;
    }
    
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch(qName) {
            case "ListaPersonas":
                break;
            case "DatosPersona":
                persona = new Personas();
                personas.add(persona);
                break;
            case "nombre":
                buffer=""; // Vaciamos nuestro buffer
                break;
        }
    }
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        buffer = new String(ch,start,length); // Almacenamos en nuestro buffer
    }
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        
        switch(qName) {
            case "ListaPersonas":
                break;
            case "DatosPersona":
                break;
            case "nombre":
                persona.setNombre(buffer);
                break;
        }
    }
}
