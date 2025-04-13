package university.innopolis.controller;

import jakarta.validation.Valid;
import university.innopolis.dto.EventRequest;
import university.innopolis.dto.EventResponse;
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
    public EventResponse create(@RequestBody @Valid EventRequest eventRequest) {
        Event event = eventRequest.toEntity();
        Event saved = service.createEvent(event);
        return EventResponse.fromEntity(saved);
    }

    @GetMapping
    public List<EventResponse> getAll() {
        return service.getAllEvents()
                .stream()
                .map(EventResponse::fromEntity)
                .toList();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteEvent(id);
    }

}

