-- Write your MySQL query statement below


select us.product_id,
       COALESCE(round(sum(us.units * p.price * 1.)/sum(us.units),2),0) as average_price
from unitssold us
         join prices p
              on us.product_id = p.product_id and us.purchase_date >= p.start_date and us.purchase_date <= p.end_date
group by us.product_id;