-- liquibase formatted sql

-- changeset alex:5
CREATE INDEX name_student_idx ON student (name)

-- changeset alex:6
CREATE INDEX color_faculty_idx ON faculty (color)

