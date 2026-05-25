-- Write your PostgreSQL query statement below
select p.firstName, p.lastName, a.city, a.state from PERSON p left join ADDRESS a on
    p.personId = a.personId;