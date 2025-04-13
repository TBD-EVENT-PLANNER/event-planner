package university.innopolis.controller;

import university.innopolis.dto.EventDto;
import university.innopolis.entity.Event;
import university.innopolis.service.EventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {
    private final EventService service;

    public EventController(EventService service) {
        this.service = service;
    }

    @PostMapping
    public Event createEvent(@RequestBody Event event) {
        return service.createEvent(event);
    }

    @GetMapping
    public List<Event> getAll() {
        return service.getAllEvents();
    }

    @GetMapping("/{id}")
    public Event getById(@PathVariable Long id) {
        return service.getEvent(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteEvent(id);
    }
}
