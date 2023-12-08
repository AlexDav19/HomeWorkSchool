CREATE TABLE person (
    id INTEGER PRIMARY KEY,
    name VARCHAR(255),
    age INTEGER CHECK (age > 0);
    driver_license BOOLEAN,
    auto_id INTEGER REFERENCES auto(id)
);

CREATE TABLE auto (
    id INTEGER PRIMARY KEY,
    model VARCHAR(255) REFERENCES brand(id),
    price INTEGER CHECK (age > 0)
);

CREATE TABLE brand (
    id INTEGER PRIMARY KEY,
    name VARCHAR(255),
);