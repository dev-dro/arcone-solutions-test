create table if not exists student
(
    id            serial primary key,
    first_name    varchar not null,
    last_name     varchar not null,
    date_of_birth date    not null,
    gender        varchar,
    email         varchar not null unique,
    phone_number  varchar not null,
    address       varchar not null
);

create table if not exists course
(
    id         serial primary key,
    name       varchar not null unique,
    start_date date    not null,
    end_date   date    not null,
    duration   integer not null
);

create table if not exists enrolled_course
(
    id         serial primary key,
    student_id integer not null references student (id),
    course_id  integer not null references course (id),
    status     varchar not null
);

create table if not exists task_category
(
    id   serial primary key,
    name varchar not null unique
);

insert into task_category
values (1, 'RESEARCHING'),
       (2, 'PRACTICING'),
       (3, 'WATCHING_VIDEOS');

create table if not exists task_log
(
    id                 serial primary key,
    date               date    not null,
    enrolled_course_id integer references enrolled_course (id),
    category_id        integer references task_category (id),
    description        text    not null,
    time_spent         numeric not null
);
