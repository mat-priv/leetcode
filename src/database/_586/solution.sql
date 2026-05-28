-- Write your PostgreSQL query statement below
select customer_number from ORDERS
group by customer_number
order by count(customer_number) desc
    LIMIT 1