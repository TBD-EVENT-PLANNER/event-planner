package university.innopolis.dto;

import jakarta.validation.constraints.NotEmpty;
import university.innopolis.entity.Participant;

public record ParticipantRequest(
    @NotEmpty(message = "Name is required")
    String firstName,

    @NotEmpty(message = "Last name is required")
    String lastName,

    @NotEmpty(message = "Email is required")
    String email
) {
    public Participant toEntity() {
        return new Participant(
            this.firstName,
            this.lastName,
            this.email
        );
    }
}
