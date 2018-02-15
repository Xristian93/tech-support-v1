import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.HashSet;

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
    private HashMap<HashSet<String>, String> responseMap;

    /**
     * Construct a Responder - nothing to do
     */
    public Responder()
    {
        aleatorio = new Random();
        responseMap = new HashMap<>();
        createDefaultResponses();

        HashSet<String> set01 = new HashSet<>();
        set01.add("free");
        set01.add("app");
        HashSet<String> set02 = new HashSet<>();
        set02.add("free");
        HashSet<String> set03 = new HashSet<>();
        set03.add("app");
        HashSet<String> set04 = new HashSet<>();
        set04.add("problem");
        set04.add("linux");
        set04.add("crash");

        responseMap.put(set04,"Creo que tienes un problema con el hardware de tu equipo");
        responseMap.put(set01,"Todo software tiene algun pequeño error, no se preocupe");
        responseMap.put(set02,"Ese problema es muy facil de solucionar, reinicie su equipo");
        responseMap.put(set03,"Su tarjeta grafica esta muy anticuada, pruebe a cambiarla");
    }

    /**
     * Generate a response
     */
    public String generateResponse (HashSet<String> word){
        String response = null;
        response = responseMap.get(word);
        if (response == null){
            if (listaRespuestas.size() > 0){
                response = listaRespuestas.remove(aleatorio.nextInt(listaRespuestas.size()));
            }
            else{
                response = "Sorry, I don´t understand your question";
            }
        }
        return response;
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

    private void createDefaultResponses(){
        listaRespuestas = new ArrayList<String>();
        listaRespuestas.add("Muy interesante");
        listaRespuestas.add("No lo entiendo");
        listaRespuestas.add("Alguna duda mas?");
        listaRespuestas.add("Lo siento, no puedo ayudarle");
        listaRespuestas.add("Buena idea");
    }
}
