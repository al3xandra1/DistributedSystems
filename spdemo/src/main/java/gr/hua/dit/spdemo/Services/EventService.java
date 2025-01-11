package gr.hua.dit.spdemo.Services;

import gr.hua.dit.spdemo.Models.Event;
import gr.hua.dit.spdemo.Models.EventStatus;
import gr.hua.dit.spdemo.Repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    // Δημιουργία νέου Event
    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    // Επιστροφή όλων των Events
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    // Αναζήτηση Event με βάση το ID
    public Event getEventById(Long id) {
        return eventRepository.findById(id).orElse(null);
    }

    // Έγκριση Event
    public Event approveEvent(Long id) {
        Optional<Event> optionalEvent = eventRepository.findById(id);
        if (optionalEvent.isPresent()) {
            Event event = optionalEvent.get();
            event.setApproved(true);
            event.setStatus(EventStatus.APPROVED);
            return eventRepository.save(event);
        }
        return null;
    }

    // Απόρριψη Event
    public Event rejectEvent(Long id) {
        Optional<Event> optionalEvent = eventRepository.findById(id);
        if (optionalEvent.isPresent()) {
            Event event = optionalEvent.get();
            event.setApproved(false);
            event.setStatus(EventStatus.REJECTED);
            return eventRepository.save(event);
        }
        return null;
    }

    // Διαγραφή Event
    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }
}
