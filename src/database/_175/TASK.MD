# 175. Combine Two Tables

## Table: Person

| Column Name | Type    |
|-------------|---------|
| personId    | int     |
| lastName    | varchar |
| firstName   | varchar |

personId is the primary key for this table. This table contains each person's ID, first name, and last name.

## Table: Address

| Column Name | Type    |
|-------------|---------|
| addressId   | int     |
| personId    | int     |
| city        | varchar |
| state       | varchar |

addressId is the primary key for this table. Each row contains the city and state for the person identified by personId.

## Task

Report the first name, last name, city, and state of each person in the Person table. If a person's address is not present in the Address table, report NULL for city and state.

Return the result in any order.

## Example

**Input**

Person table:

| personId | lastName | firstName |
|----------|----------|-----------|
| 1        | Wang     | Allen     |
| 2        | Alice    | Bob       |

Address table:

| addressId | personId | city          | state      |
|-----------|----------|---------------|------------|
| 1         | 2        | New York City | New York   |
| 2         | 3        | Leetcode      | California |

**Output**

| firstName | lastName | city          | state    |
|-----------|----------|---------------|----------|
| Allen     | Wang     | NULL          | NULL     |
| Bob       | Alice    | New York City | New York |

**Explanation:** There is no address in the Address table for personId = 1, so city and state are NULL. addressId = 1 contains information about personId = 2.
