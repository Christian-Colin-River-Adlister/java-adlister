DROP DATABASE comrad_lister;
CREATE DATABASE IF NOT EXISTS comrad_lister;

USE comrad_lister;

CREATE TABLE IF NOT EXISTS users
(
    id                INT UNSIGNED AUTO_INCREMENT,
    username          VARCHAR(255) NOT NULL,
    email             VARCHAR(255) NOT NULL,
    password          VARCHAR(255) NOT NULL,
    bio               TEXT,
    is_Supreme_Leader ENUM ('Y','N'),
    PRIMARY KEY (id)
);


CREATE TABLE IF NOT EXISTS countries
(
    id                 INT UNSIGNED AUTO_INCREMENT,
    name               VARCHAR(255)     NOT NULL,
    continent          VARCHAR(255)     NOT NULL,
    level_of_comradery INT(10) UNSIGNED NOT NULL,
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS parties;
CREATE TABLE IF NOT EXISTS parties
(
    id                      INT UNSIGNED AUTO_INCREMENT,
    name                    VARCHAR(255) NOT NULL,
    description             VARCHAR(255) NOT NULL,
    date_founded            INT UNSIGNED,
    date_dissolved          INT UNSIGNED,
    country_of_operation_id INT UNSIGNED,
    flag_url                VARCHAR(255) NOT NULL DEFAULT 'webapp/images/red_flag.png',
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS comrades
(
    id          INT UNSIGNED AUTO_INCREMENT,
    name        VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    user_id     INT UNSIGNED,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users (id)
);

CREATE TABLE IF NOT EXISTS comrades_parties
(
    comrade_id INT UNSIGNED,
    parties_id INT UNSIGNED,
    FOREIGN KEY (comrade_id) REFERENCES comrades (id),
    FOREIGN KEY (parties_id) REFERENCES parties (id)
)
