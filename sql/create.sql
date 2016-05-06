drop table detail;
drop table discount;
drop table booking;
drop table credit_card;
drop table room;
drop table room_type;
drop table hotel;
drop table staff;
drop table customer;

--staff information

create table staff(
	id int not null generated always as identity,
	username varchar(20) not null unique,
	password varchar(20) not null,
	staff_type varchar(10) not null,
	constraint chk_staff_type check (staff_type = 'owner' or staff_type = 'manager'),
	primary key (id)
);

--room information
create table hotel (
	id int not null generated always as identity,
	name varchar(20) not null,
	location varchar(20) not null,
	constraint chk_location check (location = 'Sydney' or location = 'Brisbane' or location = 'Melbourne' or location = 'Perth' or location = 'Adelaide' or location = 'Hobart' ),
	manager_id int not null,
	primary key (id),
	foreign key (manager_id) references staff(id)
);

create table room_type(
	id int not null generated always as identity,
	room_type varchar(10) not null,
	constraint chk_room_type check (room_type = 'Single' or room_type = 'Twin' or room_type = 'Queen' or room_type = 'Executive' or room_type = 'Suite'),
	price decimal not null,
	available_num int not null,
	hotel_id int not null,
	constraint chk_price check (price >= 0),
	primary key (id)
);

create table room(
	id int not null generated always as identity,
	room_type_id int not null,
	hotel_id int not null,
	room_number int not null,
	availability varchar(15) not null,
	constraint chk_availability check (availability = 'available' or availability = 'occupied' or availability = 'maintenance'),
	primary key (id),
	foreign key (room_type_id) references room_type(id),
	foreign key (hotel_id) references hotel(id)
);

--customer information
create table customer(
	id int not null generated always as identity,
	username varchar(20) not null unique,
	password varchar(20) not null,
	nickname varchar(20),
	firstname varchar(50),
	lastname varchar(20),
	email varchar(50) not null unique,
	address varchar(100),
	primary key (id)
);

create table credit_card(
	id int not null generated always as identity,
	card_type varchar(20) not null,
	constraint chk_card_type check (card_type = 'VISA' or card_type = 'MasterCard' or card_type = 'America Express' or card_type = 'JCB' or card_type = 'UnionPay'),
	card_num decimal(16) not null,
	customer_id int not null,
	primary key (id),
	foreign key (customer_id) references customer(id)
);
--discount information

create table discount(
	id int not null generated always as identity,
	room_type_id int not null,
	hotel_id int not null,
	start_date date not null,
	end_date date not null,
	rate decimal(3,2) not null,
	primary key (id),
	foreign key (room_type_id) references room_type(id),
	foreign key (hotel_id) references hotel(id)
);

--booking information

create table booking(
	id int not null generated always as identity,
	customer_id int not null,
	pin int not null,
	url varchar(50) not null,
	primary key (id),
	foreign key (customer_id) references customer(id)
);

create table detail(
	id int not null generated always as identity,
	booking_id int not null,
	start_date date not null,
	end_date date not null,
	hotel_id int not null,
	room_type_id int not null,
	extra_bed int not null,
	constraint chk_extra_bed check (extra_bed = 0 or extra_bed = 1),
	num_rooms int not null,
	primary key (id),
	foreign key (booking_id) references booking(id),
	foreign key (hotel_id) references hotel(id),
	foreign key (room_type_id) references room_type(id)
);
