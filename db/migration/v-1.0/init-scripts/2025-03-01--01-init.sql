CREATE TABLE event (
    id                BIGSERIAL PRIMARY KEY,
    title             VARCHAR(255) NOT NULL,
    event_type        VARCHAR(50) NOT NULL, -- Meetup, Conference, Concert, etc.
    event_date_time   TIMESTAMPTZ NOT NULL,
    number_of_seats   INT NOT NULL
);

CREATE TABLE participant (
    id                BIGSERIAL PRIMARY KEY,
    first_name        VARCHAR(100) NOT NULL,
    last_name         VARCHAR(100) NOT NULL,
    email             VARCHAR(100) NOT NULL
);

CREATE TABLE participant_event (
    participant_id    BIGINT NOT NULL,
    event_id          BIGINT NOT NULL,

    PRIMARY KEY (participant_id, event_id),
    CONSTRAINT fk_participant FOREIGN KEY (participant_id)
        REFERENCES participant (id)
        ON DELETE CASCADE,
    CONSTRAINT fk_event FOREIGN KEY (event_id)
        REFERENCES event (id)
        ON DELETE CASCADE
);
