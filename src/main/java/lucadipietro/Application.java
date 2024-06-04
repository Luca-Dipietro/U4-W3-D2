package lucadipietro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import lucadipietro.dao.EventsDAO;

public class Application {
    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        EventsDAO ev = new EventsDAO(em);


        em.close();
        emf.close();
    }
}
