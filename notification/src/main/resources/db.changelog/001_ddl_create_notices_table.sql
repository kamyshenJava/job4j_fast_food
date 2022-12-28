create table if not exists notices(
    id serial primary key,
    body text not null
);

comment on table notices is 'Notices';
comment on column notices.id is 'Identifier of the notice';
comment on column notices.body is 'Body of the notice';