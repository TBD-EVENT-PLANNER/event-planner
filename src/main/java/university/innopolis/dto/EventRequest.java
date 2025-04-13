package university.innopolis.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PastOrPresent;
import university.innopolis.entity.Event;
import java.time.ZonedDateTime;

public record EventRequest(
    @NotEmpty(message = "Title is required")
    String title,

    @NotEmpty(message = "Event type is required")
    String eventType,

    @NotNull(message = "Event date and time are required")
    @PastOrPresent(message = "Event date and time must be in the past or present")
    ZonedDateTime eventDateTime,

    @NotNull(message = "Number of seats is required")
    int numberOfSeats
) {
    public Event toEntity() {
        return new Event(
            this.title(),
            this.eventType(),
            this.eventDateTime(),
            this.numberOfSeats()
        );
    }
}
