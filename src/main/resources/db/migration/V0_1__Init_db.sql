CREATE sequence hibernate_sequence start 1 increment 1;

CREATE TABLE IF NOT EXISTS COMPANY (
    id BIGINT not null,
    inn BIGINT not null,
    ogrn BIGINT not null,
    organization varchar(255) not null,
    address varchar(255) not null,
    primary key (id)
);