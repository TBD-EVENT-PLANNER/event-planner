--liquibase formatted sql

--changeset catorleader:1
CREATE TABLE event
(
    id             BIGSERIAL PRIMARY KEY,
    event_title    VARCHAR(255)             NOT NULL,
    event_type     VARCHAR(100)             NOT NULL,
    event_datetime TIMESTAMP WITH TIME ZONE NOT NULL,
    seats_in_hall  INT                      NOT NULL
);
