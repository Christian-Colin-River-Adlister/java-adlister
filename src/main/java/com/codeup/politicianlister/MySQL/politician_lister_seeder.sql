USE politic_lister;

INSERT INTO users(username, email, password, bio, is_Admin) VALUES ('Admin','colin@marchbanks.org','$2a$12$wNj96VnRk5nfuCIMVVLaeO4K9CrkD89q7H44gl3X04CRTV/j/Tg3a','I am the admin','Y');

# todo Add all the countries PLEASE NOTE I removed the levels column, but added a wiki link column (I'm sorry) we should add that information to every country for more depth
INSERT INTO countries(name, continent, wiki_link) VALUES ('Afghanistan','Africa','https://en.wikipedia.org/wiki/Afghanistan');
INSERT INTO countries(name, continent, wiki_link) VALUES ('Albania','Europe','https://en.wikipedia.org/wiki/Albania');
INSERT INTO countries(name, continent, wiki_link) VALUES ('Angola','Africa','https://en.wikipedia.org/wiki/Angola');
INSERT INTO countries(name, continent, wiki_link) VALUES ('Austria','Europe','https://en.wikipedia.org/wiki/Austria');
INSERT INTO countries(name, continent, wiki_link) VALUES ('Azerbaijan','Asia','https://en.wikipedia.org/wiki/Azerbaijan');
INSERT INTO countries(name, continent, wiki_link) VALUES ('Benin','Africa','https://en.wikipedia.org/wiki/Benin');
INSERT INTO countries(name, continent, wiki_link) VALUES ('Bulgaria','Europe','https://en.wikipedia.org/wiki/Bulgaria');
INSERT INTO countries(name, continent, wiki_link) VALUES ('Cambodia','Asia','https://en.wikipedia.org/wiki/Cambodia');
INSERT INTO countries(name, continent, wiki_link) VALUES ('China','Asia','https://en.wikipedia.org/wiki/China');
INSERT INTO countries(name, continent, wiki_link) VALUES ('Colombia','South America','https://en.wikipedia.org/wiki/Colombia');
INSERT INTO countries(name, continent, wiki_link) VALUES ('Congo','Africa','https://en.wikipedia.org/wiki/Congo');
INSERT INTO countries(name, continent, wiki_link) VALUES ('Cuba','North American','https://en.wikipedia.org/wiki/Cuba');
INSERT INTO countries(name, continent, wiki_link) VALUES ('Czechoslovakia','Europe','https://en.wikipedia.org/wiki/Czechoslovakia');
INSERT INTO countries(name, continent, wiki_link) VALUES ('Ethiopia','Africa','https://en.wikipedia.org/wiki/Ethiopia');
INSERT INTO countries(name, continent, wiki_link) VALUES ('Finland','Europe','https://en.wikipedia.org/wiki/Finland');
INSERT INTO countries(name, continent, wiki_link) VALUES ('France','Europe','https://en.wikipedia.org/wiki/France');
INSERT INTO countries(name, continent, wiki_link) VALUES ('Germany','Europe','https://en.wikipedia.org/wiki/Germany');
INSERT INTO countries(name, continent, wiki_link) VALUES ('Grenada','South America','https://en.wikipedia.org/wiki/Grenada');
INSERT INTO countries(name, continent, wiki_link) VALUES ('Iran','Africa','https://en.wikipedia.org/wiki/Iran');
INSERT INTO countries(name, continent, wiki_link) VALUES ('Lao','Asia','https://en.wikipedia.org/wiki/Lao');
INSERT INTO countries(name, continent, wiki_link) VALUES ('North Korea','Asia','https://en.wikipedia.org/wiki/North_Korea');
INSERT INTO countries(name, continent, wiki_link) VALUES ('South Korea','Asia','https://en.wikipedia.org/wiki/South_Korea');
INSERT INTO countries(name, continent, wiki_link) VALUES ('Madagascar','Africa','https://en.wikipedia.org/wiki/Madagascar');
INSERT INTO countries(name, continent, wiki_link) VALUES ('Mongolia','Asia','https://en.wikipedia.org/wiki/Mongolia');
INSERT INTO countries(name, continent, wiki_link) VALUES ('Mozambique','Africa','https://en.wikipedia.org/wiki/Mozambique');
INSERT INTO countries(name, continent, wiki_link) VALUES ('Nepal','Asia','https://en.wikipedia.org/wiki/Nepal');
INSERT INTO countries(name, continent, wiki_link) VALUES ('Poland','Europe','https://en.wikipedia.org/wiki/Poland');
INSERT INTO countries(name, continent, wiki_link) VALUES ('Romania','Europe','https://en.wikipedia.org/wiki/Romania');
INSERT INTO countries(name, continent, wiki_link) VALUES ('Russia','Eurasia','https://en.wikipedia.org/wiki/Russia');
INSERT INTO countries(name, continent, wiki_link) VALUES ('Somalia','Africa','https://en.wikipedia.org/wiki/Somalia');
INSERT INTO countries(name, continent, wiki_link) VALUES ('Spain','Europe','https://en.wikipedia.org/wiki/Spain');
INSERT INTO countries(name, continent, wiki_link) VALUES ('Ukraine','Europe','https://en.wikipedia.org/wiki/Ukriane');
INSERT INTO countries(name, continent, wiki_link) VALUES ('United States of America','North America','https://en.wikipedia.org/wiki/United_States');
INSERT INTO countries(name, continent, wiki_link) VALUES ('USSR','Eurasia','https://en.wikipedia.org/wiki/USSR');
INSERT INTO countries(name, continent, wiki_link) VALUES ('Vietnam','Asia','https://en.wikipedia.org/wiki/Vietnam');
INSERT INTO countries(name, continent, wiki_link) VALUES ('Yemen','Africa','https://en.wikipedia.org/wiki/Yemen');
INSERT INTO countries(name, continent, wiki_link) VALUES ('Yugoslavia','Europe','https://en.wikipedia.org/wiki/Yugoslavia');
INSERT INTO countries(name, continent, wiki_link) VALUES ('Zanzibar','Africa','https://en.wikipedia.org/wiki/Zanzibar');

# todo Add 15/20 Major Politicians for more visual seeded data PLEASE NOTE I added a head shot picture url to the table for better looking webpages
INSERT INTO politicians(name, description, wiki_link, head_shot_url , user_id) VALUES ('Joesph Stalin','Communist dictator of the USSR, responsible for the deaths of millions of people.','https://en.wikipedia.org/wiki/Joseph_Stalin','https://www.biography.com/.image/t_share/MTY2NjgyOTkyNTMyNTMwMjMx/gettyimages-2637237.jpg',1);

# todo Add Every Major U.S. party, as well as every party that our seeded politicians are a part of PLEASE NOTE I removed the date founded and date dissolved columns because the information was kind of boring, I did however add a wiki link column to the party
INSERT INTO parties(name, description,wiki_link ,country_of_operation_id,flag_url) VALUES ('Communist Party of the Soviet Union (CPSU)','The founding and ruling political party of the Soviet Union. The CPSU was the sole governing party of the Soviet Union until 1990.','https://en.wikipedia.org/wiki/Communist_Party_of_the_Soviet_Union','34','https://upload.wikimedia.org/wikipedia/commons/thumb/f/fe/%D0%9A%D0%9F%D0%A1%D0%A1.svg/1920px-%D0%9A%D0%9F%D0%A1%D0%A1.svg.png');


INSERT INTO politicians_parties(politician_id, parties_id) VALUES (1,1);




