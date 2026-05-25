-- Write your PostgreSQL query statement below
delete from Person p where p.id not in
                           (select min(id) from Person per group by per.email);