 insert into staff values(default, 'admin', 'admin', 'owner', 0);
 insert into staff values (default, 'Lucy', 'Meriton', 'manager', 1);
 insert into staff values (default, 'Lily', 'Mecure', 'manager', 2);
 insert into staff values (default, 'John', 'Arena', 'manager', 3);
 insert into staff values (default, 'Mark', 'Mayfair', 'manager', 4);
 insert into staff values (default, 'Even', 'Somerset', 'manager', 5);
 insert into staff values (default, 'Kate', 'Baileys', 'manager', 6);
 
 insert into hotel values (default, 'Meriton', 'Sydney',2 );
 insert into hotel values (default, 'Mecure', 'Melbourne',3);
 insert into hotel values (default, 'Arena', 'Brisbane',4);
 insert into hotel values (default, 'Mayfair', 'Adelaide',5);
 insert into hotel values (default, 'Somerset', 'Hobart',6);
 insert into hotel values (default, 'Baileys', 'Perth',7);
 
 -- Meriton hotel
 insert into room_type values (default, 'Single', 80, 3, 1);
 insert into room_type values (default, 'Twin', 100, 2, 1);
 insert into room_type values (default, 'Queen', 200, 2, 1);
 insert into room_type values (default, 'Executive', 300, 1, 1);
 insert into room_type values (default, 'Suite', 400, 1, 1);
 
 insert into room values (default, 1, 1, 101,'available');
 insert into room values (default, 1, 1, 102,'available');
 insert into room values (default, 1, 1, 103,'available');
 insert into room values (default, 2, 1, 201,'available');
 insert into room values (default, 2, 1, 202,'available');
 insert into room values (default, 3, 1, 203,'available');
 insert into room values (default, 3, 1, 204,'available');
 insert into room values (default, 4, 1, 301,'available');
 insert into room values (default, 5, 1, 302,'available');
 
 
 -- Mecure hotel
 insert into room_type values (default, 'Single', 80, 3, 2);
 insert into room_type values (default, 'Twin', 100, 2, 2);
 insert into room_type values (default, 'Queen', 200, 2, 2);
 insert into room_type values (default, 'Executive', 300, 1, 2);
 insert into room_type values (default, 'Suite', 400, 1, 2);
 insert into room values (default, 6, 2, 101, 'available');
 insert into room values (default, 6, 2, 102,'available');
 insert into room values (default, 6, 2, 103,'available');
 insert into room values (default, 7, 2, 201,'available');
 insert into room values (default, 7, 2, 202,'available');
 insert into room values (default, 8, 2, 203,'available');
 insert into room values (default, 8, 2, 204,'available');
 insert into room values (default, 9, 2, 301,'available');
 insert into room values (default, 10, 2, 302,'available');
 
 
 -- Arena hotel
 insert into room_type values (default, 'Single', 80, 3, 3);
 insert into room_type values (default, 'Twin', 100, 2, 3);
 insert into room_type values (default, 'Queen', 200, 2, 3);
 insert into room_type values (default, 'Executive', 300, 1, 3);
 insert into room_type values (default, 'Suite', 400, 1, 3);
 insert into room values (default, 11, 3, 101, 'available');
 insert into room values (default, 11, 3, 102,'available');
 insert into room values (default, 11, 3, 103,'available');
 insert into room values (default, 12, 3, 201,'available');
 insert into room values (default, 12, 3, 202,'available');
 insert into room values (default, 13, 3, 203,'available');
 insert into room values (default, 13, 3, 204,'available');
 insert into room values (default, 14, 3, 301,'available');
 insert into room values (default, 15, 3, 302,'available');
 
 
 -- Mayfair hotel
 insert into room_type values (default, 'Single', 80, 3, 4);
 insert into room_type values (default, 'Twin', 100, 2, 4);
 insert into room_type values (default, 'Queen', 200, 2, 4);
 insert into room_type values (default, 'Executive', 300, 1, 4);
 insert into room_type values (default, 'Suite', 400, 1, 4);
 insert into room values (default, 16, 4, 101, 'available');
 insert into room values (default, 16, 4, 102,'available');
 insert into room values (default, 16, 4, 103,'available');
 insert into room values (default, 17, 4, 201,'available');
 insert into room values (default, 17, 4, 202,'available');
 insert into room values (default, 18, 4, 203,'available');
 insert into room values (default, 18, 4, 204,'available');
 insert into room values (default, 19, 4, 301,'available');
 insert into room values (default, 20, 4, 302,'available');
 
 
 -- Somerset hotel
 insert into room_type values (default, 'Single', 80, 3, 5);
 insert into room_type values (default, 'Twin', 100, 2, 5);
 insert into room_type values (default, 'Queen', 200, 2, 5);
 insert into room_type values (default, 'Executive', 300, 1, 5);
 insert into room_type values (default, 'Suite', 400, 1, 5);
 insert into room values (default, 21, 5, 101, 'available');
 insert into room values (default, 21, 5, 102,'available');
 insert into room values (default, 21, 5, 103,'available');
 insert into room values (default, 22, 5, 201,'available');
 insert into room values (default, 22, 5, 202,'available');
 insert into room values (default, 23, 5, 203,'available');
 insert into room values (default, 23, 5, 204,'available');
 insert into room values (default, 24, 5, 301,'available');
 insert into room values (default, 25, 5, 302,'available');
 
 -- Baileys hotel
 insert into room_type values (default, 'Single', 80, 3, 6);
 insert into room_type values (default, 'Twin', 100, 2, 6);
 insert into room_type values (default, 'Queen', 200, 2, 6);
 insert into room_type values (default, 'Executive', 300, 1, 6);
 insert into room_type values (default, 'Suite', 400, 1, 6);
 insert into room values (default, 26, 6, 101, 'available');
 insert into room values (default, 26, 6, 102,'available');
 insert into room values (default, 26, 6, 103,'available');
 insert into room values (default, 27, 6, 201,'available');
 insert into room values (default, 27, 6, 202,'available');
 insert into room values (default, 28, 6, 203,'available');
 insert into room values (default, 28, 6, 204,'available');
 insert into room values (default, 29, 6, 301,'available');
 insert into room values (default, 30, 6, 302,'available');

 insert into booking values (default, 3, '38400000-8cf0-11bd-b23e-10b96e4ef00d')
 
 
 
 
 
 