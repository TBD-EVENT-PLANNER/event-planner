package university.innopolis.dto;

import java.time.ZonedDateTime;

public record EventDto(
        Long id, String title,
        String eventType,
        ZonedDateTime eventDateTime,
        int numberOfSeats
) {}


