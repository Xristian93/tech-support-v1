import java.util.Random;
import java.util.ArrayList;

/**
 * The responder class represents a response generator object.
 * It is used to generate an automatic response to an input string.
 * 
 * @author     Michael Kölling and David J. Barnes
 * @version    0.1 (2011.07.31)
 */
public class Responder
{
    private Random aleatorio;
    private ArrayList<String> listaRespuestas;
    
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
    }

    /**
     * Generate a response.
     * @return   A string that should be displayed as the response
     */
    public String generateResponse()
    {
        int posicion = aleatorio.nextInt(listaRespuestas.size());
        return listaRespuestas.get(posicion);
    }
}
