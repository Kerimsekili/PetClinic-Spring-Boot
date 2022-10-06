create table public.t_owner(
    id int not null ,
    first_name varchar(50),
    last_name varchar(50)
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