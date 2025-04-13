#
# BUILD STAGE
#
FROM liquibase/liquibase:4.25

COPY ./db/migration /liquibase/changelog
RUN chmod -R 755 /liquibase/changelog
