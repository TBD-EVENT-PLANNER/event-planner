--liquibase formatted sql

--changeset catorleader:3
CREATE INDEX idx_event_registration_event_id ON event_registration (event_id);
