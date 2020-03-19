package eci.ieti.proyecto.voiceBox_backend.Persistance.LocalPersistente;

/**
 *
 * @author cristian
 */
public class PersistenceException extends Exception{

    public PersistenceException(String message) {
        super(message);
    }

    public PersistenceException(String message, Throwable cause) {
        super(message, cause);
    }
    
}