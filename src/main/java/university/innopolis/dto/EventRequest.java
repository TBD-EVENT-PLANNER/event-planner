package university.innopolis.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import university.innopolis.entity.Event;

public record EventRequest(
    @NotEmpty(message = "Title is required")
    String title,

    @NotEmpty(message = "Event type is required")
    String eventType,

    @NotNull(message = "Event date and time are required")
    @FutureOrPresent(message = "Event date and time must be in the future or present")
    LocalDateTime eventDateTime,

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
