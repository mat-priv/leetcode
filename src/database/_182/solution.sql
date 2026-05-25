-- Write your PostgreSQL query statement below
select distinct(p.email) as Email from Person p join Person per on
    p.email = per.email and p.id != per.id;