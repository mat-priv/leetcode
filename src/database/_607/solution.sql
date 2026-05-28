-- Write your MySQL query statement below
select sp.name from salesperson sp
               where sp.sales_id not in (select o.sales_id from orders o
                                    where o.com_id = (select c.com_id from company c where c.name = 'RED'))