SELECT * FROM room_type;
SELECT * FROM booking;
SELECT * FROM detail;


--Select * FROM staff;
--Select * FROM hotel;
--Select * FROM detail;
--Select * FROM discount;
--Select * FROM booking;
--Select * FROM room;
--Select * FROM room_type;
--Select * FROM customer;


-- JP's own test only ---
<<<<<<< HEAD
--SELECT r.hotel_id, r.room_type, r.price, h.id, h.name, h.location FROM room_type AS r INNER JOIN hotel AS h ON r.hotel_id = h.id WHERE r.room_type='Queen' and h.id=1
=======
SELECT r.hotel_id, r.room_type, r.price, h.id, h.name, h.location FROM room_type AS r INNER JOIN hotel AS h ON r.hotel_id = h.id WHERE r.room_type='Queen' and h.id=1
SELECT rt.room_type, rt.hotel_id, rt.id, r.availability FROM room AS r INNER JOIN room_type AS rt ON r.room_type_id = rt.id WHERE rt.room_type='Queen' AND rt.hotel_id=1 AND r.availability<>'available'
SELECT d.start_date, d.end_date, d.hotel_id, d.num_rooms, r.room_type, r.hotel_id FROM detail as d INNER JOIN room_type as r ON d.room_type_id = r.id WHERE (d.start_date >= '05/17/2016' AND d.start_date <= '05/20/2016' OR d.end_date >= '05/17/2016' AND d.end_date <= '05/20/2016') AND r.hotel_id=1 AND r.room_type='Queen'
SELECT r.hotel_id, r.room_type, r.price, h.name, h.location, d.start_date, d.end_date, d.rate FROM discount as d INNER JOIN room_type as r ON d.room_type_id = r.id INNER JOIN hotel as h ON r.hotel_id = h.id WHERE d.start_date <= '05/17/2016' AND d.end_date >= '05/20/2016' AND r.hotel_id=1
SELECT r.hotel_id, r.room_type, r.price, h.name, h.location, d.start_date, d.end_date, d.rate FROM discount as d INNER JOIN room_type as r ON d.room_type_id = r.id INNER JOIN hotel as h ON r.hotel_id = h.id WHERE d.start_date <= ? AND d.end_date >= ? AND r.hotel_id=?
>>>>>>> origin/master
