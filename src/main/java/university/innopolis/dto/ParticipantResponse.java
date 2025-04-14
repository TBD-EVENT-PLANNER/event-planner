package university.innopolis.dto;

import university.innopolis.entity.Participant;

public record ParticipantResponse(
    Long id,
    String firstName,
    String lastName,
    String email
) {
    public static ParticipantResponse fromEntity(Participant participant) {
        return new ParticipantResponse(
            participant.getId(),
            participant.getFirstName(),
            participant.getLastName(),
            participant.getEmail()
        );
    }
}
