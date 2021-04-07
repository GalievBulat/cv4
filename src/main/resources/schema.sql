create table if not exists persistent_logins(
    username varchar not null,
    series varchar not null primary key,
    token varchar not null,
    last_used timestamp not null
);