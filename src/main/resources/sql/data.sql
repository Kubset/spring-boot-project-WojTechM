\copy location(address, description, name, is_Archived) from /home/makiela/codecool/advanced/TW3/src/main/resources/sql/locations.csv delimiter ','
\copy mine (is_archived, name, location_id) from /home/makiela/codecool/advanced/TW3/src/main/resources/sql/mines.csv delimiter ','
\copy resource (name, description, price, is_archived) from /home/makiela/codecool/advanced/TW3/src/main/resources/sql/resources.csv delimiter ','
\copy excavation (excavation, is_archived, mine_id, resource_id) from /home/makiela/codecool/advanced/TW3/src/main/resources/sql/excavations.csv delimiter ','