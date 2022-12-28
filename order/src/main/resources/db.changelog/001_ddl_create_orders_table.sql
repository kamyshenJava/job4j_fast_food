create table if not exists orders(
     id serial primary key,
     price decimal (12,4) not null,
     order_status text
);

comment on table orders is 'Orders';
comment on column orders.id is 'Identifier of the order';
comment on column orders.price is 'Price of the order';
comment on column orders.order_status is 'Status of the order';