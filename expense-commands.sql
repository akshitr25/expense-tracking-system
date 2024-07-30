create database expensetracker;
use expensetracker;
create table tbl_expenses
(
	id int primary key auto_increment,
    expense_name varchar(255) not null,
    description varchar(255) not null,
    expense_amount double(5,2) not null,
    category varchar(255) not null,
    date date not null
);

insert into tbl_expenses(expense_name, description, expense_amount, category, date)
values("Water bill", "water bill", 600.00, "Bills", "2024-07-30");

insert into tbl_expenses(expense_name, description, expense_amount, category, date)
values("Electricity bill", "electricity bill", 900.00, "Bills", "2024-07-15");