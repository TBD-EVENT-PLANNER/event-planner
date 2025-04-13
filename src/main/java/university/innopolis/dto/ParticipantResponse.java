package university.innopolis.dto;

import university.innopolis.entity.Event;
import university.innopolis.entity.Participant;

public record ParticipantResponse(
    Long id,
    String firstName,
    String lastName
) {
    public static ParticipantResponse fromEntity(Participant participant) {
        return new ParticipantResponse(
            participant.getId(),
            participant.getFirstName(),
            participant.getLastName()
        );
    }
}
