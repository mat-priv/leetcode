-- Write your PostgreSQL query statement below
SELECT name from CUSTOMER where
    referee_id is NULL or
    referee_id != 2;