-- Write your MySQL query statement below

select (select mn.num
        from mynumbers mn group by mn.num having count(mn.num) < 2 order by mn.num desc limit 1) as num;