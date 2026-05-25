-- Write your PostgreSQL query statement below
select w.id from weather w join weather wet on
    w.recordDate = wet.recordDate + 1 and w.temperature > wet.temperature;