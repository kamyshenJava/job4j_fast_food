create table if not exists dishes(
     id serial primary key,
     name text not null,
     ingredients text
);

comment on table dishes is 'Dishes';
comment on column dishes.id is 'Identifier of the dish';
comment on column dishes.name is 'Name of the dish';
comment on column dishes.ingredients is 'Ingredients for the dish';