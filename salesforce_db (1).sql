# Author Laveen Ekka
DROP database if exists SalesforceDb;
create database SalesforceDb;

use SalesforceDb;

DROP TABLE IF EXISTS `book_tbl`;
DROP TABLE IF EXISTS `stationery_tbl`;
DROP TABLE IF EXISTS `food_tbl`;
DROP TABLE IF EXISTS `electronic_tbl`;
DROP TABLE IF EXISTS `specification_tbl`;


#Creating Schema For Stationery Table
CREATE TABLE `stationery_tbl` (
  `id` varchar(48) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `description` varchar(3000) DEFAULT NULL,
  `manufacturing_date` date DEFAULT NULL,
  `expiry_date` date DEFAULT NULL,
  `price` float DEFAULT NULL,
  `category` varchar(20) DEFAULT NULL,
  `discount` float DEFAULT NULL,
  `stationeryCategory` varchar(20) DEFAULT NULL
);

#Creating Schema For Food Table
CREATE TABLE `food_tbl` (
  `id` varchar(48) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `description` varchar(3000) DEFAULT NULL,
  `manufacturing_date` date DEFAULT NULL,
  `expiry_date` date DEFAULT NULL,
  `price` float DEFAULT NULL,
  `category` varchar(20) DEFAULT NULL,
  `discount` float DEFAULT NULL,
  `foodCategory` varchar(20) DEFAULT NULL
);

#Creating Schema For Electronic Table
CREATE TABLE `electronic_tbl` (
  `id` varchar(48) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `description` varchar(3000) DEFAULT NULL,
  `manufacturing_date` date DEFAULT NULL,
  `expiry_date` date DEFAULT NULL,
  `price` float DEFAULT NULL,
  `category` varchar(20) DEFAULT NULL,
  `discount` float DEFAULT NULL,
  `electronicCategory` varchar(20) DEFAULT NULL
);

#Creating Schema For Specification Table
CREATE TABLE `specification_tbl`(
   `id` int DEFAULT NULL,
   `referenceKey`  varchar(48) DEFAULT NULL,
   `attribute`  varchar(250) DEFAULT NULL,
   `value` varchar(1000)  DEFAULT NULL
);

CREATE TABLE `book_tbl` (
  `id` varchar(48) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `description` varchar(3000) DEFAULT NULL,
  `manufacturing_date` date DEFAULT NULL,
  `expiry_date` date DEFAULT NULL,
  `price` float DEFAULT NULL,
  `category` varchar(20) DEFAULT NULL,
  `discount` float DEFAULT NULL,
  `bookCategory` varchar(20) DEFAULT NULL,
  `noOfPages` int DEFAULT NULL,
  `author` varchar(50)
);

#Inserting Records In Book TABLE 
insert into  `book_tbl` values('003x0000005AKCcAAO','Introduction to Algorithms','','2020-01-20',NULL,'400','BOOK','0','TEXTBOOK','424','Cormen');
insert into  `book_tbl` values('003x0000005AKXUAA4','Short Fairy Tails','','2019-11-20',NULL,'90','BOOK','10','SHORTSTORY','100','Alex');


#Inserting Records In Stationery TABLE 
insert into  `stationery_tbl` values('003x0000005AKXlAAO','Parker Vector Stainless Steel Ball Pen GT with Gold Plated Clip','Fine point ball point pen with refillable Parker QuinkFlow Ball point refill.Ink Colour : Blue','2017-12-30',NULL,'500','STATIONERY',0,'PEN');
insert into  `stationery_tbl` values('003x0000005AJkxAAG','Personalised Brown Thread Leather Diary','Writing down your thoughts and memories is the best way to treasure them forever. From writing secrets to important notes to even phone numbers these diaries can be used for anything.  So be organized and stylish and at the same time.','2018-01-20',NULL,899,'STATIONERY',0,'DIARY');
insert into  `stationery_tbl` values('003x0000005AJkxAAG','Casio FX-991ES Plus Non-Programmable Scientific Calculator, 417 Functions','Probability, Calculus, Permutation Combination, Random Number Calculation features','2019-06-08',NULL,992,'STATIONERY',0,'CALCULATOR');



#Inserting Records In Food Table
insert into  `food_tbl` values('003x0000005AJlEAAW','Amul Butter - Pasteurised, 500g Pack','This is a Vegetarian product.Spread on Bread, Parantha, Roti, Nans, Sandwiches','2020-06-10','2020-08-25',235,'FOOD',0,'MILK');
insert into  `food_tbl` values('003x0000005AJtGAAW','Pepsi Soft Drink Bottle','Aerated drink by Pepsi','2019-12-30','2020-12-30',90,'FOOD',0,'BEVERAGE');


#Inserting Records in  Specification
insert into `specification_tbl` values(1,'003x0000005AJlEAAW','Brand','Amul'),
                                      (2,'003x0000005AJlEAAW','Weight','499 Grams'),
                                      (3,'003x0000005AJlEAAW','Product Dimensions','12.3 x 6.7 x 7.2 cm'),
                                      (4,'003x0000005AJlEAAW','Units','1'),
                                      (5,'003x0000005AJtGAAW','Product Dimensions','11 x 11 x 35.7 cm'),
                                      (6,'003x0000005AJtGAAW','Capacity','2.25L');


#Inserting Records in Electronic Table
insert into  `electronic_tbl` values('003x0000005AJknAAG','Acer Predator','This Acer Predator Triton 300 gaming laptop comes with enhanced features and functionalities. It is equipped with the 9th Gen Intel Core i5 processor and NVIDIA GeForce GTX 1650 graphics card. So, you can play even a high-octane game without facing any lag. It also features the Killer DoubleShot Pro feature that allows you to play games smoothly even when your Internet connection is weak. What’s more, it features the 4th Gen AeroBlade 3D Technology, which keeps heating issues at bay. To top it off, it also delivers 3D sound for an enhanced listening experience','2020-05-07',NULL,219999,'ELECTRONIC',15,'LAPTOP');


#Inserting Records For Acer Predator
insert into `specification_tbl` values(7,'003x0000005AJknAAG','Brand','Acer'),
(8,'003x0000005AJknAAG','Series','Predator'),
(9,'003x0000005AJknAAG','Colour','Black'),
(10,'003x0000005AJknAAG','Form Factor','Notebook'),
(11,'003x0000005AJknAAG','Item Height','40 Millimeters'),
(12,'003x0000005AJknAAG','Item Width','42.2 Centimeters'),
(13,'003x0000005AJknAAG','Screen Size','15.6 Inches'),
(14,'003x0000005AJknAAG','Item Weight','4.2 Kg'),
(15,'003x0000005AJknAAG','Product Dimensions','32.1 x 42.2 x 4 cm'),
(16,'003x0000005AJknAAG','Batteries','1 Lithium ion batteries required. (included)'),
(17,'003x0000005AJknAAG','Item model number','G9-793'),
(18,'003x0000005AJknAAG','Processor Brand','Intel'),
(19,'003x0000005AJknAAG','Processor Type','Core i7'),
(20,'003x0000005AJknAAG','Processor Speed','2.80 GHz'),
(21,'003x0000005AJknAAG','RAM Size','16 GB'),
(22,'003x0000005AJknAAG','Memory Technology','DDR4'),
(23,'003x0000005AJknAAG','Hard Drive Size','256 GB'),
(24,'003x0000005AJknAAG','Hard Disk Technology','SSD'),
(25,'003x0000005AJknAAG','Audio Details','NH.Q1TSI.003'),
(26,'003x0000005AJknAAG','Graphics Coprocessor','NVIDIA GeForce GTX 1070 with 8 GB of dedicated GDDR5 VRAM'),
(27,'003x0000005AJknAAG','Graphics Chipset Brand','NVIDIA'),
(28,'003x0000005AJknAAG','Graphics Card Description','Dedicated'),
(29,'003x0000005AJknAAG','Graphics RAM Type','VRAM'),
(30,'003x0000005AJknAAG','Graphics Card Ram Size','8 GB'),
(31,'003x0000005AJknAAG','Wireless Type','801.11ac'),
(32,'003x0000005AJknAAG','Number of USB 2.0 Ports','4'),
(33,'003x0000005AJknAAG','Operating System','Windows 10'),
(34,'003x0000005AJknAAG','Lithium Battery Energy Content','37 Watt Hours'),
(35,'003x0000005AJknAAG','Included Components','Laptop, Battery, AC Adapter, User Guide and Manuals');