CREATE TABLE users(
    username varchar(128) not null primary key ,
    password varchar(512) not null,
    enabled boolean not null
);

create table authorities(
    username varchar(128) not null ,
    authority varchar(128) not null
);

create unique index idx_auth_username on authorities(username,authority);

create table public.t_owner(
    id int not null ,
    first_name varchar(50) not null ,
    last_name varchar(50) not null
);
create table public.t_pet(
    id int not null ,
    name varchar(50),
    birth_date date,
    owner_id int

);

alter table public.t_owner add constraint public.constraint_1 primary key(id);
alter table public.t_pet add constraint public.constraint_2 primary key (id);
alter table public.t_pet add constraint public.constraint_3 foreign key (owner_id) references public.t_owner(id);
create sequence public.petclinic_sequence start with (100);
;