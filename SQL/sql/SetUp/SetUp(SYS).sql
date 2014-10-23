CREATE USER KIM IDENTIFIED BY BOB
DEFAULT TABLESPACE USERS
TEMPORARY TABLESPACE TEMP;

GRANT CONNECT,RESOURCE,UNLIMITED TABLESPACE TO KIM;

create user LEE identified by BOB
default tablespace users
temporary tablespace temp;

grant connect,resource,unlimited tablespace to LEE;

alter user scott identified by tiger account unlock;