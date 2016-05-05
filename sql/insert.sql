 insert into staff values(default, 'admin', 'admin', 'owner');
 insert into staff values (default, 'Lucy', 'Meriton', 'manager');
 insert into staff values (default, 'Lily', 'Mecure', 'manager');
 insert into staff values (default, 'John', 'Arena', 'manager');
 insert into staff values (default, 'Mark', 'Mayfair', 'manager');
 insert into staff values (default, 'Even', 'Somerset', 'manager');
 insert into staff values (default, 'Kate', 'Baileys', 'manager');
 
 insert into hotel values (default, 'Meriton', 'Sydney',2 );
 insert into hotel values (default, 'Mecure', 'Melbourne',3);
 insert into hotel values (default, 'Arena', 'Brisbane',4);
 insert into hotel values (default, 'Mayfair', 'Adelaide',5);
 insert into hotel values (default, 'Somerset', 'Hobart',6);
 insert into hotel values (default, 'Baileys', 'Perth',7);
 
 -- Meriton hotel
 insert into room_type values (default, 'Single', 80, 50, 1);
 insert into room_type values (default, 'Twin', 100, 150, 1);
 insert into room_type values (default, 'Queen', 200, 120, 1);
 insert into room_type values (default, 'Executive', 300, 100, 1);
 insert into room_type values (default, 'Suite', 400, 100, 1);
 
 insert into room values (default, 1, 1, 101,'available');
 
 
 -- Mecure hotel
 insert into room_type values (default, 'Single', 80, 50, 2);
 insert into room_type values (default, 'Twin', 100, 150, 2);
 insert into room_type values (default, 'Queen', 200, 120, 2);
 insert into room_type values (default, 'Executive', 300, 100, 2);
 insert into room_type values (default, 'Suite', 400, 100, 2);
 insert into room values (default, 6, 2, 101, 'available');
 
 
 -- Arena hotel
 insert into room_type values (default, 'Single', 80, 50, 3);
 insert into room_type values (default, 'Twin', 100, 150, 3);
 insert into room_type values (default, 'Queen', 200, 120, 3);
 insert into room_type values (default, 'Executive', 300, 100, 3);
 insert into room_type values (default, 'Suite', 400, 100, 3);
 insert into room values (default, 11, 3, 101, 'available');
 
 
 -- Mayfair hotel
 insert into room_type values (default, 'Single', 80, 50, 4);
 insert into room_type values (default, 'Twin', 100, 150, 4);
 insert into room_type values (default, 'Queen', 200, 120, 4);
 insert into room_type values (default, 'Executive', 300, 100, 4);
 insert into room_type values (default, 'Suite', 400, 100, 4);
 insert into room values (default, 16, 4, 101, 'available');
 
 
 -- Somerset hotel
 insert into room_type values (default, 'Single', 80, 50, 5);
 insert into room_type values (default, 'Twin', 100, 150, 5);
 insert into room_type values (default, 'Queen', 200, 120, 5);
 insert into room_type values (default, 'Executive', 300, 100, 5);
 insert into room_type values (default, 'Suite', 400, 100, 5);
 insert into room values (default, 21, 5, 101, 'available');
 
 -- Baileys hotel
 insert into room_type values (default, 'Single', 80, 50, 6);
 insert into room_type values (default, 'Twin', 100, 150, 6);
 insert into room_type values (default, 'Queen', 200, 120, 6);
 insert into room_type values (default, 'Executive', 300, 100, 6);
 insert into room_type values (default, 'Suite', 400, 100, 6);
 insert into room values (default, 26, 6, 101, 'available');