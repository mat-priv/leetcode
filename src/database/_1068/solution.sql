-- Write your MySQL query statement below

select p.product_na, s.year, s.price from dales s join product on s.product_id = p.product_id;