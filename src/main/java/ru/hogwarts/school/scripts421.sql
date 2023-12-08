CREATE TABLE student (
    id BIGINT PRIMARY KEY,
    age INTEGER CHECK (age > 16) DEFAULT 20,
    name VARCHAR (255) UNIQUE NOT NULL,
    avatar_id BIGINT REFERENCES avatar (id),
    faculty_id BIGINT REFERENCES faculty (id)
);

CREATE TABLE faculty (
    id BIGINT PRIMARY KEY,
    name VARCHAR(255) REFERENCES color (id)
);

CREATE TABLE color (
    id BIGINT PRIMARY KEY,
    name VARCHAR(255),
);

CREATE TABLE avatar (
    id BIGINT PRIMARY KEY,
    data OID,
    file_path VARCHAR (255) UNIQUE NOT NULL,
    file_size BIGINT,
    media_type VARCHAR (255) UNIQUE NOT NULL
);