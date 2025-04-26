CREATE DATABASE employee_management;

USE employee_management;

create table employees(
	id int primary key auto_increment,
    name varchar(100) not null,
    position varchar(100),
    salary double
);

insert into employees (name, position, salary)
values
('Nguyen Van An', 'Developer', 5000),
('Tran Thi Binh', 'Tester', 4500),
('Le Van Cuong', 'Manager', 8000);

select * from employees;

INSERT INTO employees (name, position, salary)
VALUES 
('Pham Van D', 'Developer', 5500),
('Nguyen Thi E', 'Tester', 4600),
('Le Thi F', 'HR', 4000),
('Tran Van G', 'Developer', 5200);

select * from employees where position = 'developer';

select * from employees where salary >= 5000 order by salary desc;

update employees 
set salary = salary + 500
where position = 'Developer';

select * from employees where position = 'developer' and salary >= 5000;

delete from employees where id = 5;

insert into employees (name, position, salary)
values
('Bob', 'Developer', 4500),
('Violet', 'Tester', 3000),
('Payna', 'HR', 6000);

update employees set salary = salary + 10
where position = 'developer';

select * from employees where salary > 5500 order by salary desc;

delete from employees where position = 'hr';