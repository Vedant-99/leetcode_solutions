# Write your MySQL query statement below
SELECT email as EMAIL from Person
GROUP BY email HAVING count(email)>1