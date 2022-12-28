create table if not exists orders_dishes(
    id serial primary key,
    order_id int not null references orders(id),
    dishes_id int not null references dishes(id)
);

comment on table orders_dishes is 'Orders-dishes many-to-many relation';
comment on column orders_dishes.id is 'Identifier of the orders_dishes';
comment on column orders_dishes.order_id is 'Reference to the order_id';
comment on column orders_dishes.dishes_id is 'Reference to the dish_id';