-- Write your MySQL query statement below

select uni.unique_id, emp.name from employees emp left join employeeuni uni on emp.id = uni.id;