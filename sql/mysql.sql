delete from discount;

 -- JP added for development of public view
insert into discount values (default, 4, 1,'05/01/2016','05/10/2016','05/24/2016', 50); -- executive
insert into discount values (default, 8, 2,'05/01/2016','05/10/2016','05/24/2016', 10); -- queen
insert into discount values (default, 12, 3,'05/01/2016','05/20/2016','05/31/2016', 20); -- twin
insert into discount values (default, 25, 6,'05/01/2016','05/10/2016','05/24/2016', 30); -- suite

Select * FROM discount;

