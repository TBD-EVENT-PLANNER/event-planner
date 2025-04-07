--liquibase formatted sql

--changeset catorleader:2
CREATE TABLE event_registration
(
    id                BIGSERIAL PRIMARY KEY,
    first_name        VARCHAR(100) NOT NULL,
    last_name         VARCHAR(100) NOT NULL,
    event_id          BIGINT       NOT NULL,
    registration_date TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_event_registration_event FOREIGN KEY (event_id)
        REFERENCES event (id)
        ON DELETE CASCADE
);
