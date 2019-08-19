# Assignment session 3
use storefront ;

#3.1  already inserted

#3.2.
select * from product;
insert into product(price,name,Category_id)
values (100,'shirt3',3),
       (200, 'shirt4',3);
       
insert into product(price,name,Category_id)
values (10,'shirt5',3),
       (20, 'shirt6',3);

select * from product;
       
#Display Count of products as per price range
SELECT  '0 - 100' as 'Range in Rs.', COUNT(id) AS COUNT FROM product
WHERE price  BETWEEN 0 AND 100
UNION 
SELECT  '101 - 500' as 'Range in Rs', COUNT(id) AS COUNT FROM product
WHERE price  BETWEEN 101 AND 500
UNION 
SELECT  'ABOVE 500' as 'Range in Rs', COUNT(id) AS COUNT FROM product
WHERE price  >500;

#Display the Categories along with number of products under each category.
select * from product;
select c.category_name ,p.Category_id,count(p.id) As No_of_products from product p inner join Category c on p.Category_id = c.id
group by Category_id;

select * from orders;
insert into orders
values(6,'2019-08-02', 2400,4,1),
      (5,'2019-08-02', 2400,4,2);

#3.3
#Display Shopper’s information along with number of orders he/she placed during last 30 days.
SELECT u.id, u.name, u.email_id, u.contact_number, COUNT(o.id)
FROM user u join orders o where o.user_id=u.id AND DATEDIFF(CURDATE(), date_of_order_placed)<=30
GROUP BY o.user_id;

#Display the top 10 Shoppers who generated maximum number of revenue in last 30 days.
SELECT u.id, u.name, u.email_id, u.contact_number, SUM(o.amount) AS revenue from
user u join orders o where  o.user_id=u.id AND DATEDIFF(CURDATE(), o.date_of_order_placed) <=30
GROUP BY o.user_id ORDER BY revenue DESC LIMIT 10;

#Display top 20 Products which are ordered most in last 60 days along with numbers.
select * from item_list;
insert into item_list 
values(3,4,1,'Shipped'),
       (4,4,1,'Shipped');

SELECT p.name, COUNT(p.id) AS Number_Of_Purchases 
FROM product p join item_list i join orders o 
where i.product_id=p.id AND o.id=i.order_number AND DATEDIFF(CURDATE(),o.date_of_order_placed)<=60 
GROUP BY i.product_id 
ORDER BY COUNT(p.id) DESC LIMIT 20;



#Display Monthly sales revenue of the StoreFront for last 6 months. It should display each month’s sale.
SELECT DATE_FORMAT(o.date_of_order_placed,"%M-%Y") AS MONTH ,SUM(o.amount) AS MONTHLY_SALE
FROM orders o
WHERE DATEDIFF(now(),o.date_of_order_placed)<=180
GROUP BY DATE_FORMAT(o.date_of_order_placed,"%M-%Y")
ORDER BY o.date_of_order_placed DESC;


# FIX THIS 
#Mark the products as Inactive which are not ordered in last 90 days   
select * from product;
UPDATE product set product.active='Inactive' where product.id NOT IN(
SELECT * from(
Select p.id from product p join orders o join item_list i
where p.id=i.product_id AND i.order_number=o.id AND DATEDIFF(CURDATE(), o.date_of_order_placed)<=90)AS T);

#Display top 10 Items which were cancelled most.
select * from item_list;
SELECT p.id, p.name, COUNT(p.id) AS Number_Of_cancellation
from product p join item_list i 
where p.id=i.product_id and i.status= 'Cancelled'
GROUP BY i.product_id
ORDER BY Count(p.id) DESC LIMIT 10;


#Given a category search keyword, display all the Products present in this category/categories.





  #3.4
  
#Create appropriate tables and relationships for the same and write a SQL query for that 
#returns a Resultset containing Zip Code, City Names and
# States ordered by State Name and City Name.

create table zip_code(
id INT PRIMARY KEY AUTO_INCREMENT,
Code VARCHAR(10),
City_Id INT,
Foreign Key(City_id) REFERENCES City(Id));

create table city(
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(40),
state_id INT,
Foreign Key(state_id) REFERENCES State(Id));

create table state(
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(40));

select z.code, c.name, s.name
from zip_code z join city c join state s
where z.city_id=c.id AND c.state_id=s.id
order by s.name, c.name;




#Create a view displaying the order information (Id, Title, Price, Shopper’s name, Email, Orderdate, Status) 
#with latest ordered items should be displayed first for last 60 days.
create view order_info AS
SELECT p.id, p.name AS title, p.price, u.name, u.email_id, o.date_of_order_placed, i.status
from product p join item_list i  join orders o join user u 
where p.id=i.product_id AND i.order_number=o.id AND o.user_id=u.id
AND DATEDIFF(CURDATE(), o.date_of_order_placed)<=60
ORDER BY o.date_of_order_placed DESC;

select * from order_info;

#Use the above view to display the Products(Items) which are in ‘shipped’ state.
select id, title from order_info where status='Shipped';

#Use the above view to display the top 5 most selling products.
select id, title, COUNT(id) AS Number_of_items_sold 
from order_info
group by id
order by COUNT(id) DESC LIMIT 5;


