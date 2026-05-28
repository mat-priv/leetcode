-- Write your PostgreSQL query statement below

select m.employee_id,
       m.name,
       count(e.reports_to)                   as reports_count,
       round(sum(e.age) * 1. / count(e.age)) as average_age
from Employees m
         join Employees e on m.employee_id = e.reports_to
group by m.employee_id, m.name
order by m.employee_id;