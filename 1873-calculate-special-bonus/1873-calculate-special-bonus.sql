# Write your MySQL query statement below

select employee_id , 
Case 
 When name Not like 'M%' AND employee_id % 2 != 0 Then salary 
 Else salary * 0 
 end as bonus 
 from Employees order by employee_id ; 



