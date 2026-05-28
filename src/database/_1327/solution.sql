-- Write your MySQL query statement below

select p.product_name, grouped.units as unit
from (select product_id,
             sum(unit) as units
      from orders
      where order_date >= '2020-02-01'
        AND order_date < '2020-03-01'
      group by product_id) grouped
         join products p on grouped.product_id = p.product_id
where grouped.units >= 100;