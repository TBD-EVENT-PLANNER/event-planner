package university.innopolis.dto;

import university.innopolis.entity.Event;
import java.time.ZonedDateTime;

public record EventResponse(
    Long id,
    String title,
    String eventType,
    ZonedDateTime eventDateTime,
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

