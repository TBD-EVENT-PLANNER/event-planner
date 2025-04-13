package university.innopolis.entity;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "participant", cascade = CascadeType.ALL)
    private Set<ParticipantEvent> events;

    // Getters and setters
}
