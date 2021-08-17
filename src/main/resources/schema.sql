CREATE TABLE IF NOT EXISTS CUSTOMER_DETAILS(
    id identity,
    first_name varchar(50) not null,
    last_name varchar (50) not null,
    phone varchar (20) not null
);

CREATE TABLE IF NOT EXISTS CUSTOMER(
    id identity,
    username varchar(50) not null,
    customer_details_id bigint not null,
    foreign key(customer_details_id) references CUSTOMER_DETAILS(id)
);

CREATE TABLE IF NOT EXISTS DELIVERY(
    id identity,
    customer_id bigint not null,
    submission_date date not null,
    foreign key(customer_id) references CUSTOMER(id)
);

CREATE TABLE IF NOT EXISTS PIZZA(
    id identity,
    name varchar(50) not null
);

CREATE TABLE IF NOT EXISTS PIZZA_ORDER(
    id identity,
    quantity varchar(50) not null,
    size varchar(50) not null,
    pizza_id bigint not null,
    delivery_id bigint not null,
    foreign key(pizza_id) references PIZZA(id),
    foreign key(delivery_id) references DELIVERY(id)
);

CREATE TABLE IF NOT EXISTS INGREDIENT(
    id identity,
    name varchar(50) not null,
    pizza_id bigint not null,
    foreign key(pizza_id) references PIZZA(ID)
);


