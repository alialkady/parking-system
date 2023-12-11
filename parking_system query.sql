create database parking_system
GO
use parking_system
GO
create table operator(
username varchar(20) unique,--add unique
password varchar(8) unique,--add unique
shift_time int	
)
drop table operator
GO
create table customers (
entry_id int unique,
plate_number varchar(10) unique, --maybe need to use unique constraint
transaction_date datetime
)
drop table customers
Go
create table spots(
spot int unique, --add unique
spot_free varchar(10)	
)
drop table spots
Go
create table payment(
shifts_payment double
)


