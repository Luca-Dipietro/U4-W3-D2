package lucadipietro.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import lucadipietro.entities.Event;
import lucadipietro.exceptions.NotFoundException;

public class EventsDAO {

    private final EntityManager em;

    public EventsDAO(EntityManager em) {
        this.em = em;
    }

    public void saveEvent(Event event) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(event);
        transaction.commit();
        System.out.println("L'evento " + event.getTitle() + " è stato salvato con successo nel database!");
    }

    public Event getById(long eventId) {
        Event event = em.find(Event.class, eventId);
        if (event == null) throw new NotFoundException(eventId);
        return event;
    }

    public void deleteEvent(long eventId) {
        Event found = this.getById(eventId);

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("L'evento " + found.getTitle() + " è stato eliminato con successo dal database!");
    }
}
