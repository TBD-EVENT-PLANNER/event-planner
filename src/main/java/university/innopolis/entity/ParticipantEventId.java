package university.innopolis.entity;

import java.io.Serializable;

public class ParticipantEventId implements Serializable {
    private Long participant;
    private Long event;

    public ParticipantEventId() {
    }

    public ParticipantEventId(Long participant, Long event) {
        this.participant = participant;
        this.event = event;
    }

    // hashCode and equals
}
