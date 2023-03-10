create table if not exists student
(
    id            serial primary key,
    first_name    varchar not null,
    last_name     varchar not null,
    date_of_birth date    not null,
    gender        varchar,
    email         varchar not null,
    phone_number  varchar not null,
    address       varchar not null
);
