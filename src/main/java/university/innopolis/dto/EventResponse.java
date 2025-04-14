package university.innopolis.dto;

import java.time.LocalDateTime;
import university.innopolis.entity.Event;

public record EventResponse(
    Long id,
    String title,
    String eventType,
    LocalDateTime eventDateTime,
    int numberOfSeats
) {
    public static EventResponse fromEntity(Event event) {
        return new EventResponse(
            event.getId(),
            event.getTitle(),
            event.getEventType(),
            event.getEventDateTime(),
            event.getNumberOfSeats()
        );
    }
}

