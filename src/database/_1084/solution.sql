-- Write your MySQL query statement below
select distinct(p.product_id),
               p.product_name
from product p
         join sales s on s.product_id = p.product_id
where p.product_id not in
      (select distinct(ss.product_id) from sales ss where ss.sale_date not between '2019-01-01' and '2019-03-31');