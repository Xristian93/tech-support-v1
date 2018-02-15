import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * The responder class represents a response generator object.
 * It is used to generate an automatic response to an input string.
 * 
 * @author     Michael KÃ¶lling and David J. Barnes
 * @version    0.1 (2011.07.31)
 */
public class Responder
{
    private Random aleatorio;
    private ArrayList<String> listaRespuestas;
    private HashMap<String, String> responseMap;

    /**
     * Construct a Responder - nothing to do
     */
    public Responder()
    {
        aleatorio = new Random();
        listaRespuestas = new ArrayList<String>();
        listaRespuestas.add("Muy interesante");
        listaRespuestas.add("No lo entiendo");
        listaRespuestas.add("Alguna duda mas?");
        listaRespuestas.add("Lo siento, no puedo ayudarle");
        listaRespuestas.add("Buena idea");
        responseMap = new HashMap<String, String>();
        fillResponseMap();
    }

    /**
     * Introducir en el mapa de respuestas las palabras claves y sus respuestas
     */
    public void fillResponseMap(){
        responseMap.put("lento","Creo que tienes un problema con el hardware de tu equipo");
        responseMap.put("error","Todo software tiene algun pequeño error, no se preocupe");
        responseMap.put("problema","Ese problema es muy facil de solucionar, reinicie su equipo");
        responseMap.put("grafica","Su tarjeta grafica esta muy anticuada, pruebe a cambiarla");
    }

    /**
     * Generate a response
     */
    public String generateResponse (String word){
        String response = responseMap.get(word);
        if (response != null){
            return response;
        }
        else {
            return pickDefaultResponse();
        }
    }

    /**
     * Generate a default response.
     * @return   A string that should be displayed as the response
     */
    public String pickDefaultResponse()
    {
        int posicion = aleatorio.nextInt(listaRespuestas.size());
        return listaRespuestas.get(posicion);
    }
}
