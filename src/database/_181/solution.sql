-- Write your PostgreSQL query statement below
select e.name as Employee from Employee e join Employee emp on
    e.managerId = emp.id
where e.salary > emp.salary;