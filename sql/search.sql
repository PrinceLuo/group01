<<<<<<< HEAD
SELECT * FROM customer;
=======
Select * FROM detail;
Select * FROM discount;
Select * FROM booking;
Select * FROM credit_card;
Select * FROM room;
Select * FROM room_type;
Select * FROM hotel;
Select * FROM staff;
Select * FROM customer;
>>>>>>> origin/master

-- JP's own test only ---
SELECT r.hotel_id, r.room_type, r.price, h.id, h.name, h.location FROM room_type AS r INNER JOIN hotel AS h ON r.hotel_id = h.id WHERE r.room_type='Queen' and h.id=1
