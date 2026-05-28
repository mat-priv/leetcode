-- Write your MySQL query statement below

select * from products where description ~ '\mSN[0-9]{4}-[0-9]{4}\M'
order by product_id;