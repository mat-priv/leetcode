-- Write your PostgreSQL query statement below

select p.user_id,
       count(p.prompt)                                as prompt_count,
       round(sum(p.tokens) * 1. / count(p.tokens), 2) as avg_tokens
from prompts p
group by p.user_id
having max(p.tokens) > round(sum(p.tokens) * 1. / count(p.tokens), 2)
   and count(p.prompt) >= 3
order by avg_tokens desc, p.user_id asc;