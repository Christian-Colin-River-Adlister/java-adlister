USE comrad_lister;

INSERT INTO users(username, email, password, bio, is_Supreme_Leader) VALUES ('Daddy_Stalin','Supreme_Leader9001@yahoo.com','$2a$12$wNj96VnRk5nfuCIMVVLaeO4K9CrkD89q7H44gl3X04CRTV/j/Tg3a','I am big boy Stalin, and I am the admin, and I am not gonna tolerate no capitalism','Y');

INSERT INTO countries(name, continent, level_of_comradery) VALUES ('Grenada','South America', 7);
INSERT INTO countries(name, continent, level_of_comradery) VALUES ('Zanzibar','Africa', 4);
INSERT INTO countries(name, continent, level_of_comradery) VALUES ('Benin','Africa', 6);
INSERT INTO countries(name, continent, level_of_comradery) VALUES ('Madagascar','Africa', 6);
INSERT INTO countries(name, continent, level_of_comradery) VALUES ('Angola','Africa', 7);
INSERT INTO countries(name, continent, level_of_comradery) VALUES ('Mozambique','Africa', 7);
INSERT INTO countries(name, continent, level_of_comradery) VALUES ('Congo','Africa', 7);
INSERT INTO countries(name, continent, level_of_comradery) VALUES ('Somalia','Africa', 7);
INSERT INTO countries(name, continent, level_of_comradery) VALUES ('Yemen','Africa', 7);
INSERT INTO countries(name, continent, level_of_comradery) VALUES ('Ethiopia','Africa', 7);
INSERT INTO countries(name, continent, level_of_comradery) VALUES ('Mozambique','Africa', 7);
INSERT INTO countries(name, continent, level_of_comradery) VALUES ('Iran','Africa', 3);
INSERT INTO countries(name, continent, level_of_comradery) VALUES ('Afghanistan','Africa', 3);
INSERT INTO countries(name, continent, level_of_comradery) VALUES ('Cambodia','Asia', 8);
INSERT INTO countries(name, continent, level_of_comradery) VALUES ('Vietnam','Asia', 10);
INSERT INTO countries(name, continent, level_of_comradery) VALUES ('Korea','Asia', 9);
INSERT INTO countries(name, continent, level_of_comradery) VALUES ('China','Asia', 10);
INSERT INTO countries(name, continent, level_of_comradery) VALUES ('Spain','Europe', 1);
INSERT INTO countries(name, continent, level_of_comradery) VALUES ('France','Europe', 1);
INSERT INTO countries(name, continent, level_of_comradery) VALUES ('Finland','Europe', 2);
INSERT INTO countries(name, continent, level_of_comradery) VALUES ('Austria','Europe', 2);
INSERT INTO countries(name, continent, level_of_comradery) VALUES ('Germany','Europe', 7);
INSERT INTO countries(name, continent, level_of_comradery) VALUES ('Hungary','Europe', 8);
INSERT INTO countries(name, continent, level_of_comradery) VALUES ('Czechoslovakia','Europe', 8);
INSERT INTO countries(name, continent, level_of_comradery) VALUES ('Romania','Europe', 8);
INSERT INTO countries(name, continent, level_of_comradery) VALUES ('Poland','Europe', 7);
INSERT INTO countries(name, continent, level_of_comradery) VALUES ('Albania','Europe', 8);
INSERT INTO countries(name, continent, level_of_comradery) VALUES ('Bulgaria','Europe', 8);
INSERT INTO countries(name, continent, level_of_comradery) VALUES ('Yugoslavia','Europe', 8);
INSERT INTO countries(name, continent, level_of_comradery) VALUES ('Mongolia','Asia', 9);
INSERT INTO countries(name, continent, level_of_comradery) VALUES ('Azerbaijan','Asia', 5);
INSERT INTO countries(name, continent, level_of_comradery) VALUES ('Cuba','North American', 10);
INSERT INTO countries(name, continent, level_of_comradery) VALUES ('Lao','Asia', 7);
INSERT INTO countries(name, continent, level_of_comradery) VALUES ('Colombia','South America', 6);
INSERT INTO countries(name, continent, level_of_comradery) VALUES ('Nepal','Asia', 6);
INSERT INTO countries(name, continent, level_of_comradery) VALUES ('United States of America','North America', 0);
INSERT INTO countries(name, continent, level_of_comradery) VALUES ('USSR','Eurasia', 10);
INSERT INTO countries(name, continent, level_of_comradery) VALUES ('Russia','Eurasia', 8);
INSERT INTO countries(name, continent, level_of_comradery) VALUES ('Ukraine','Europe', 3);
INSERT INTO countries(name, continent, level_of_comradery) VALUES ('Baltic States(Estonia, Latvia, Lithuania)','Eurasia', 5);

INSERT INTO parties(name, description, date_founded, date_dissolved, country_of_operation_id) VALUES ('Communist Party of the Soviet Union (CPSU)','The founding and ruling political party of the Soviet Union. The CPSU was the sole governing party of the Soviet Union until 1990.','1912-01-01','1991-08-29','37');

INSERT INTO comrades(name, description, wiki_link, user_id) VALUES ('Joesph Stalin','Communist dictator of the USSR, responsible for the deaths of millions of people.','https://en.wikipedia.org/wiki/Joseph_Stalin',1);

INSERT INTO comrades_parties(comrade_id, parties_id) VALUES (1,1);




