# Write your MySQL query statement below


select customers.name  as Customers from customers where customers.id NOt in ( select orders.customerId from orders ); 