create table if not exists kitchen_notices(
    id serial primary key,
    body text not null
);

comment on table kitchen_notices is 'Kitchen Notices';
comment on column kitchen_notices.id is 'Identifier of the kitchen notice';
comment on column kitchen_notices.body is 'Body of the kitchen notice';