# Write your MySQL query statement below


update Salary set sex =
  Case sex when 'f'
  then 'm'
  else 'f' 
  end ;