create database projects;

\connect project
create schema pos;

create user pos password 'password';

grant connect on database projects to pos;
grant all on schema pos to pos;
