-- Write your PostgreSQL query statement below
select query_name,
       round(sum(rating::numeric / position) / (count(query_name)), 2)                    as quality,
       round((count(rating) filter (WHERE rating < 3)) * 100. / count(rating),2) as poor_query_percentage
from queries
group by query_name;