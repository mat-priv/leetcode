-- Write your MySQL query statement below

SELECT *
FROM patients
WHERE conditions REGEXP '(^|[[:space:]])DIAB1'