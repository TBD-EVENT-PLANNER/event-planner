//package university.innopolis.repository;
//
//import jakarta.persistence.*;
//import university.innopolis.entity.Event;
//import university.innopolis.entity.Participant;
//import university.innopolis.entity.ParticipantEventId;
//
//@Entity
//@IdClass(ParticipantEventId.class)
//public class ParticipantEventRepository {
//    @Id
//    @ManyToOne
//    @JoinColumn(name = "participant_id")
//    private Participant participant;
//
//    @Id
//    @ManyToOne
//    @JoinColumn(name = "event_id")
//    private Event event;
//
//    // Getters and setters
//}
