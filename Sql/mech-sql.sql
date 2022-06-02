DROP TABLE IF EXISTS "user" CASCADE;
DROP TABLE IF EXISTS contact_info CASCADE;
DROP TABLE IF EXISTS mech CASCADE;
DROP TABLE IF EXISTS picture CASCADE;
DROP TABLE IF EXISTS rating CASCADE;

CREATE TABLE "user" (
  id SERIAL PRIMARY KEY,
  username varchar NOT NULL,
  "password" varchar NOT NULL,
  firstname varchar,
  lastname varchar,
  is_pilot boolean NOT NULL,
  is_admin boolean NOT NULL
);

CREATE TABLE contact_info (
  id SERIAL PRIMARY KEY,
  user_id integer NOT NULL,
  contact varchar
);

CREATE TABLE mech (
  id SERIAL PRIMARY KEY,
  make varchar NOT NULL,
  model varchar NOT NULL,
  year varchar NOT NULL,
  color varchar,
  max_speed float,
  weight float,
  height float,
  description varchar,
  current_pilot int REFERENCES "user"(id),
  pilot_count int,
  available boolean NOT NULL,
  confidential boolean NOT NULL
);

CREATE TABLE picture (
  id SERIAL PRIMARY KEY,
  file BYTEA,
  mech_id integer
);

CREATE TABLE rating (
  id SERIAL PRIMARY KEY,
  user_id integer NOT NULL,
  mech_id integer NOT NULL,
  stars integer,
  review varchar
);

SELECT * FROM "user";
SELECT * FROM contact_info;
SELECT * FROM mech;
SELECT * FROM picture;
SELECT * FROM rating;


ALTER TABLE contact_info ADD FOREIGN KEY (user_id) REFERENCES "user" (id);

ALTER TABLE picture ADD FOREIGN KEY (mech_id) REFERENCES mech (id);

ALTER TABLE rating ADD FOREIGN KEY (user_id) REFERENCES "user" (id);

ALTER TABLE rating ADD FOREIGN KEY (mech_id) REFERENCES mech (id);

--SAMPLE DATA

INSERT INTO "user" VALUES
(DEFAULT,'tsnark', 'password', 'Tommy', 'Snark', TRUE, TRUE),
(DEFAULT, 'scari', 'password', 'Sinji', 'Cari', TRUE, FALSE);

INSERT INTO mech VALUES
(
	DEFAULT,
	'Snark Industries',
	'Copper Man MK. IV',
	'2008',
	'Green',
	100,
	300,
	2,
	'A suit of mechanized armor created for counter-terrorism. This suit is fully flight capable and includes a multitude of lethal and non-lethal combatitve options',
	NULL,
	1,
	TRUE,
	FALSE
),
(
	DEFAULT,
	'Hasis',
	'Wattron',
	'2016',
	'Blue',
	800,
	1000,
	15,
	'A Mech designed for combatting threats high in the atmosphere. Fully capable of flight and weapons designed for air-to-air combat.',
	NULL,
	5,
	FALSE,
	FALSE
);
  
-- Original File ENDPOINT


INSERT INTO public.mech (id, make,model,"year",color,max_speed,weight,height,description,current_pilot,pilot_count,available,confidential) VALUES 	 
(DEFAULT,'prototype close combat mobile suit',' RX-78-2/RX-78-02',' UC 0079','Blue, Red and White',205.0,60000.0,18.0,'The Gundam implemented multiple new technologies, including the Core Block System, in which the cockpit transformed into the FF-X7 Core Fighter to increase pilot survivability (and secure valuable combat data). The Gundam also featured a learning computer that learned from a pilot''s input, and this data was used in the development of the mass produced RGM-79 GM. The Gundam''s other innovations included beam sabers and an energy cap-based beam rifle, which gave the suit the firepower of a battleship.',3,1,true,false),
(DEFAULT, 'WarShip','Limited Edition','2022','Blank and Gold', 1200.50, 1900.0, 25.0,'The Ultimate Warezone Machine', 4, 3, true, true),
(DEFAULT, 'The Destroyer','RD750','2020','Platium', 600.0, 1000.0, 15.4, 'Take out all enemies with ease equipped with various weapons', 2, 1, false,false),
(DEFAULT, 'The Terminator','TRS 1000X','2021', 'White, Black, Blue' ,500.0, 900.0, 17.5,'The Combat Mobile Suit reloaded', 3, 2, false, true);

INSERT INTO public.rating (id, user_id,mech_id,stars,review) VALUES
(DEFAULT, 3, 1, 5, 'Awesome Armor for all my battle needs!'),
(DEFAULT, 2, 2, 5, 'Perfect for my air combat missions, will be politing this mech again!'),
(DEFAULT, 1, 1, 3, 'It was just okay.'),
(DEFAULT, 1, 1, 2,'Far too small to be a real mech.'),
(DEFAULT, 4, 5, 5,'Best mech yet'),
(DEFAULT, 5, 3, 5,'Will be politing again with this mech');

INSERT INTO public.picture (id, file, mech_id)VALUES
(DEFAULT, bytea('F:/Revature_jd/Project-2/Project Web/images/green-mech.jpg') , 1),
(DEFAULT, bytea('F:/Revature_jd/Project-2/Project Web/images/blue-mech.jpg'), 2),
(DEFAULT, bytea('F:/Revature_jd/Project-2/Project Web/images/blue-red-white-mech.jpg'), 3),
(DEFAULT, bytea('F:/Revature_jd/Project-2/Project Web/images/black-gold-mech.jpg'), 4),
(DEFAULT, bytea('F:/Revature_jd/Project-2/Project Web/images/platuim-mech.jpg'), 5),
(DEFAULT, bytea('F:/Revature_jd/Project-2/Project Web/images/black-white-mech.jpg'), 6);
	 
INSERT INTO public."user" (id, username,"password",firstname,lastname,is_pilot,is_admin) VALUES
(DEFAULT, 'Rjose','password','Ryu','Jose', true, true),
(DEFAULT, 'Markel','password','Markel','Rogue', false, true),
(DEFAULT, 'aCreed','password','Assassin','Creed', true, false)