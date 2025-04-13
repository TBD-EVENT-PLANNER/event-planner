package university.innopolis.controller;

import university.innopolis.dto.EventDto;
import university.innopolis.entity.Event;
import university.innopolis.entity.Participant;
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
    public EventDto createEvent(@RequestBody EventDto dto) {
        Event event = mapToEntity(dto);
        Event saved = service.createEvent(event);
        return mapToDto(saved);
    }

    @GetMapping
    public List<EventDto> getAll() {
        return service.getAllEvents()
                .stream()
                .map(this::mapToDto)
                .toList();
    }

    @GetMapping("/{id}")
    public EventDto getById(@PathVariable Long id) {
        return mapToDto(service.getEvent(id));
    }

    @GetMapping("/{id}/participants")
    public List<Participant> getParticipantsByEventId(@PathVariable Long id) {
        return service.getParticipantsByEventId(id);
    }

    @PostMapping("/{id}/participants")
    public boolean registerParticipant(@PathVariable Long id, @RequestBody Long userId) {
        return service.registerParticipant(id, userId);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteEvent(id);
    }

    private EventDto mapToDto(Event event) {
        return new EventDto(
                event.getId(),
                event.getTitle(),
                event.getEventType(),
                event.getEventDateTime(),
                event.getNumberOfSeats()
        );
    }
    private Event mapToEntity(EventDto dto) {
        Event event = new Event();
        event.setTitle(dto.title());
        event.setEventType(dto.eventType());
        event.setEventDateTime(dto.eventDateTime());
        event.setNumberOfSeats(dto.numberOfSeats());
        return event;
    }
}

