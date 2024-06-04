package lucadipietro.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(long id) {
        super("L'evento con l'id " + id + " non è stato trovato!");
    }
}
