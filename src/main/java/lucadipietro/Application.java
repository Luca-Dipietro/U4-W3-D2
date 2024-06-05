package lucadipietro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import lucadipietro.dao.EventsDAO;
import lucadipietro.entities.Event;
import lucadipietro.entities.EventType;
import lucadipietro.exceptions.NotFoundException;

import java.time.LocalDate;

public class Application {
    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        EventsDAO ev = new EventsDAO(em);

        Event event1 = new Event("Spring Festival", LocalDate.of(2024, 3, 23), "Spring Festival Party Tour", EventType.PUBBLICO, 1500);
        Event event2 = new Event("World Cup", LocalDate.of(2026, 6, 16), "World Cup Final", EventType.PUBBLICO, 70000);
        Event event3 = new Event("Tournament Pokemon", LocalDate.of(2024, 5, 30), "Friendly Tournament", EventType.PRIVATO, 20);
        Event event4 = new Event("Boat Party", LocalDate.of(2024, 8, 15), "Viking Boat Party", EventType.PRIVATO, 50);
        Event event5 = new Event("Summer Concert", LocalDate.of(2024, 7, 7), "Collisioni Summer Festival", EventType.PUBBLICO, 10000);


//        ev.saveEvent(event1);
//        ev.saveEvent(event2);
//        ev.saveEvent(event3);
//        ev.saveEvent(event4);
//        ev.saveEvent(event5);

        try {
            Event event1FromDB = ev.getById(102);
            System.out.println(event1FromDB.toString());

        } catch (NotFoundException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            ev.deleteEvent(106);
        } catch (NotFoundException ex) {
            System.out.println(ex.getMessage());
        }

        em.close();
        emf.close();
    }
}
