#
# BUILD STAGE
#
FROM liquibase/liquibase:4.25

COPY ./db/migration /liquibase/changelog
