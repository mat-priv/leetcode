-- Write your PostgreSQL query statement below

select p.project_id,
       round(sum(e.experience_years * 1. / count(p.employee_id)), 2) as average_years
from project p  join employee e on p.employee_id = e.employee_id
group by p.project_id;