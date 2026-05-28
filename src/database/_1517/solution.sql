-- Write your PostgreSQL query statement below
select * from users where mail ~ '^[A-Za-z][A-Za-z0-9_.-]*@leetcode\.com$';