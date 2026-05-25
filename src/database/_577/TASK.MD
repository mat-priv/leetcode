# Employees With Bonus

## Table: Employee

| Column Name | Type    |
|-------------|---------|
| empId       | int     |
| name        | varchar |
| supervisor  | int     |
| salary      | int     |

empId is the primary key for this table. Each row contains an employee's id, name, supervisor id, and salary.

## Table: Bonus

| Column Name | Type |
|-------------|------|
| empId       | int  |
| bonus       | int  |

empId is a foreign key referencing Employee(empId). Each row contains an employee's id and their bonus amount.

## Task

Report the name and bonus amount of each employee who either:

- has a bonus less than 1000, or
- did not get any bonus.

Return the result in any order.

## Example

**Input**

Employee table:

| empId | name   | supervisor | salary |
|-------|--------|------------|--------|
| 3     | Brad   | NULL       | 4000   |
| 1     | John   | 3          | 1000   |
| 2     | Dan    | 3          | 2000   |
| 4     | Thomas | 3          | 4000   |

Bonus table:

| empId | bonus |
|-------|-------|
| 2     | 500   |
| 4     | 2000  |

**Output**

| name | bonus |
|------|-------|
| Brad | NULL  |
| John | NULL  |
| Dan  | 500   |
