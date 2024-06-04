package lucadipietro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import lucadipietro.dao.EventsDAO;
import lucadipietro.entities.Event;
import lucadipietro.entities.EventType;

import java.time.LocalDate;

public class Application {
    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        EventsDAO ev = new EventsDAO(em);

        Event event1 = new Event("Spring Festival", LocalDate.of(2024, 3, 23), "Spring Festival Party Tour", EventType.PUBBLICO, 1500);
        ev.saveEvent(event1);

        em.close();
        emf.close();
    }
}
