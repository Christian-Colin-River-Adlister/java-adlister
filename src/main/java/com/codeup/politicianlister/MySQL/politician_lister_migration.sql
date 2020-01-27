DROP DATABASE IF EXISTS politic_lister;

CREATE DATABASE politic_lister;

USE politic_lister;

CREATE TABLE IF NOT EXISTS users
(
    id       INT UNSIGNED AUTO_INCREMENT,
    username VARCHAR(255) NOT NULL,
    email    VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    bio      TEXT,
    is_Admin ENUM ('Y','N') DEFAULT 'N',
    PRIMARY KEY (id)
);


CREATE TABLE IF NOT EXISTS countries
(
    id        INT UNSIGNED AUTO_INCREMENT,
    name      VARCHAR(255) NOT NULL,
    continent VARCHAR(255) NOT NULL,
    wiki_link VARCHAR(255),
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS parties;
CREATE TABLE IF NOT EXISTS parties
(
    id                      INT UNSIGNED AUTO_INCREMENT,
    name                    VARCHAR(255) NOT NULL,
    description             VARCHAR(255) NOT NULL,
    wiki_link               VARCHAR(255),
    country_of_operation_id INT UNSIGNED,
    flag_url                TEXT,
    PRIMARY KEY (id),
    FOREIGN KEY (country_of_operation_id) REFERENCES countries (id)
);

CREATE TABLE IF NOT EXISTS politicians
(
    id            INT UNSIGNED AUTO_INCREMENT,
    name          VARCHAR(255) NOT NULL,
    description   VARCHAR(255) NOT NULL,
    wiki_link     VARCHAR(255),
    head_shot_url VARCHAR(255),
    user_id       INT UNSIGNED,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users (id)
);

CREATE TABLE IF NOT EXISTS politicians_parties
(
    politician_id INT UNSIGNED,
    parties_id    INT UNSIGNED,
    FOREIGN KEY (politician_id) REFERENCES politicians (id),
    FOREIGN KEY (parties_id) REFERENCES parties (id)
)
