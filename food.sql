-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 06, 2018 at 10:41 AM
-- Server version: 10.1.29-MariaDB
-- PHP Version: 7.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `food`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` int(20) NOT NULL,
  `username` varchar(250) NOT NULL,
  `password` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `username`, `password`) VALUES
(2, 'adminkhan', 'admin123456');

-- --------------------------------------------------------

--
-- Table structure for table `age_group`
--

CREATE TABLE `age_group` (
  `id` int(11) NOT NULL,
  `age_group_from` int(255) NOT NULL,
  `age_group_to` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `age_group`
--

INSERT INTO `age_group` (`id`, `age_group_from`, `age_group_to`) VALUES
(5, 10, 15),
(6, 16, 25),
(7, 26, 35),
(8, 36, 45),
(9, 46, 55),
(10, 56, 65),
(11, 66, 75),
(12, 76, 85);

-- --------------------------------------------------------

--
-- Table structure for table `contact_type`
--

CREATE TABLE `contact_type` (
  `id` int(10) NOT NULL,
  `name` varchar(256) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `contact_type`
--

INSERT INTO `contact_type` (`id`, `name`) VALUES
(1, 'Landline'),
(2, 'Mobile');

-- --------------------------------------------------------

--
-- Table structure for table `dish`
--

CREATE TABLE `dish` (
  `dish_id` int(11) NOT NULL,
  `dish_name` varchar(255) NOT NULL,
  `dish_price` int(255) NOT NULL,
  `dish_cate_id` int(255) NOT NULL,
  `rest_id` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dish`
--

INSERT INTO `dish` (`dish_id`, `dish_name`, `dish_price`, `dish_cate_id`, `rest_id`) VALUES
(1, 'Biryani', 150, 36, 29),
(2, 'Fish Biryani', 200, 36, 29),
(3, 'Haleem', 120, 19, 3),
(4, 'Nihari', 200, 19, 3),
(5, 'Tikka', 250, 25, 16),
(6, 'Korma', 100, 26, 11),
(7, 'Biryani', 200, 36, 11),
(8, 'Kofta Gosht', 200, 19, 16),
(9, 'Chapli Kabab', 200, 25, 3),
(10, 'Chaat', 150, 19, 11),
(11, 'Shami Kabab', 200, 25, 16),
(12, 'Mandi', 500, 36, 26),
(13, 'Harees', 150, 21, 26),
(14, 'Arab Salad', 200, 23, 26),
(15, 'Chicken Sajji', 500, 24, 7),
(16, 'Sindhi Biryani', 200, 36, 7),
(17, 'Chicken Tikka', 150, 25, 7),
(18, 'Chicken Korma', 120, 19, 11),
(19, 'Balti Gosht', 400, 24, 11),
(20, 'Chicken Mayo Garlic Rolls', 100, 28, 13),
(21, 'Beef Paratha Roll', 120, 28, 13),
(22, 'Club Sandwich', 150, 28, 13),
(23, 'Chinese Fried Rice', 200, 36, 13),
(24, 'Chicken Biryani', 150, 36, 11),
(25, 'Chicken Tikka Pizza', 300, 27, 9),
(26, 'Chicken Extra Cheese Pizza', 500, 27, 9),
(27, 'Pepperoni Pizza', 700, 27, 9),
(28, 'Kabuli Pulao', 150, 36, 28),
(29, 'Aghani Kababs', 200, 25, 28),
(30, 'Chicken Burger ', 100, 37, 27),
(31, 'Chicken Zinger Burger', 180, 37, 27),
(32, 'Chicken Cheese Burger ', 120, 37, 27),
(33, 'Chicken Cheese Zinger Burger ', 220, 37, 27),
(34, 'Mushrooms Pizza ', 500, 27, 1),
(35, 'Chicken Cheese Pizza', 550, 27, 1),
(36, 'Chicken Fajita Pizza', 600, 27, 1),
(37, 'Chicken Burger ', 300, 37, 2),
(38, 'Chicken Crispy Burger', 450, 37, 2),
(42, 'Chicken Cheese Burger ', 310, 37, 2),
(43, 'Beef Burger', 200, 37, 2),
(44, 'Beef Cheese Burger', 210, 37, 2),
(45, 'Oven Roasted Chicken Burger', 350, 37, 4),
(46, 'Roast Beef Burger', 250, 37, 4),
(47, 'Black Forest Beef Burger', 600, 37, 4),
(48, 'Chocolate Fudge', 720, 29, 5),
(49, 'Chocolate Fudge Premium', 920, 29, 5),
(50, 'Fried Chicken Burger ', 210, 37, 5),
(51, 'Fish Sticks', 146, 37, 5),
(52, 'Pineapple Cake', 630, 29, 5),
(53, 'Large Pizza + 1.75 Liter Drink', 999, 27, 6),
(54, '2 Medium Pizzas + Cheesy Bread + 1.75 Liter Drink', 1499, 27, 6),
(55, '2 Large Pizzas + Cheesy Bread + Cinnastix + 1.75 L...', 1999, 27, 6),
(56, 'Medium Pizza + Two 345ml Drinks', 689, 27, 6),
(57, 'Small Pizza + 345ml Drink', 349, 27, 6),
(58, 'Mini-me Pizza + Slice Juice ', 239, 27, 6);

-- --------------------------------------------------------

--
-- Table structure for table `dish_cate`
--

CREATE TABLE `dish_cate` (
  `dish_cate_id` int(11) NOT NULL,
  `dish_cate_name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dish_cate`
--

INSERT INTO `dish_cate` (`dish_cate_id`, `dish_cate_name`) VALUES
(19, 'Curry'),
(21, 'Soup'),
(22, 'Bread'),
(23, 'Vegetable'),
(24, 'Roast'),
(25, 'BBQ food'),
(26, 'Stew'),
(27, 'Pizza'),
(28, 'Sandwiches & wraps'),
(29, 'Cakes & tea time treats'),
(30, 'Sauces'),
(32, 'Dessert'),
(33, 'Drinks'),
(34, 'Pasta'),
(35, 'Cookies'),
(36, 'Rice'),
(37, 'Fast Food');

-- --------------------------------------------------------

--
-- Table structure for table `location`
--

CREATE TABLE `location` (
  `loc_id` int(11) NOT NULL,
  `loc_name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `location`
--

INSERT INTO `location` (`loc_id`, `loc_name`) VALUES
(25, 'North Nazimabad'),
(26, 'Gulshan-e-Iqbal'),
(27, 'Malir'),
(28, 'Gulberg'),
(29, 'New Karachi'),
(30, 'Korangi'),
(31, 'Aisha Manzil'),
(32, ' Naseerabad'),
(33, ' Water Pump'),
(34, 'Karimabad'),
(35, 'Azizabad'),
(36, 'Gulzar-e-Hijri'),
(38, 'P.E.C.H.S'),
(39, 'Garden'),
(40, 'Soldier Bazar'),
(41, 'Landhi'),
(42, 'North Karachi'),
(43, 'Clifton'),
(44, 'DHA'),
(45, 'Maymar'),
(46, 'Saddar'),
(47, 'Gulistan-e-Jauhar'),
(48, 'FB-Area'),
(49, 'Mahmudabad'),
(50, 'Safoora Goth'),
(51, 'Bahdurabad'),
(52, 'Nazimabad');

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `order_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `rest_id` int(11) NOT NULL,
  `date_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`order_id`, `user_id`, `rest_id`, `date_time`) VALUES
(1, 1, 26, '2017-12-23 19:57:14'),
(2, 1, 11, '2017-12-23 19:59:31'),
(3, 3, 26, '2017-12-23 20:34:38'),
(4, 3, 26, '2017-12-23 20:35:09'),
(5, 3, 26, '2017-12-23 20:38:54');

-- --------------------------------------------------------

--
-- Table structure for table `orders_detail`
--

CREATE TABLE `orders_detail` (
  `order_detail_id` int(11) NOT NULL,
  `order_id` int(11) NOT NULL,
  `dish_id` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `unit_price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `orders_detail`
--

INSERT INTO `orders_detail` (`order_detail_id`, `order_id`, `dish_id`, `quantity`, `unit_price`) VALUES
(1, 1, 12, 1, 500),
(2, 1, 13, 1, 150),
(3, 1, 14, 1, 200),
(4, 2, 6, 1, 100),
(5, 2, 7, 1, 200),
(6, 2, 10, 1, 150),
(7, 3, 12, 2, 500),
(8, 3, 13, 1, 150),
(9, 3, 14, 1, 200),
(10, 4, 12, 1, 500),
(11, 5, 12, 1, 500);

-- --------------------------------------------------------

--
-- Table structure for table `rest`
--

CREATE TABLE `rest` (
  `rest_id` int(11) NOT NULL,
  `rest_name` varchar(255) NOT NULL,
  `rest_descr` varchar(255) NOT NULL,
  `rest_email` varchar(50) NOT NULL,
  `rest_image` varchar(255) NOT NULL,
  `delivery_time` varchar(255) NOT NULL,
  `loc_id` int(255) NOT NULL,
  `rest_cate_id` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rest`
--

INSERT INTO `rest` (`rest_id`, `rest_name`, `rest_descr`, `rest_email`, `rest_image`, `delivery_time`, `loc_id`, `rest_cate_id`) VALUES
(1, 'Broad Way', 'Pizza Experts', 'BroadWay@customercare.com', 'restImage/broadway-pizza-gulshan-e-iqbal-karachi.jpg', '45 Min', 43, 13),
(2, 'Burger Inc', 'Fast Food Restaurant', 'burgerinc@care.com', 'restImage/burger-inc-gulshan-karachi.jpg', '60 Min', 38, 8),
(3, 'MK Foods', 'Desi Pakistani Food', 'MK@carecustomers.com', 'restImage/de.jpg', '60 Min', 52, 10),
(4, 'Subway', 'Fast Food Champions all around the world', 'subway@care.com', 'restImage/ret23fsd.png', '45 Min', 25, 8),
(5, 'United Kings', 'Baking Experts of Karachi', 'unitedkings@care.com', 'restImage/united.jpg', '60 Min', 25, 10),
(6, 'Domino', 'Best juicy pizza  in town', 'domino@cumtomercare.com', 'restImage/dfd.jpg', '45 Min', 31, 13),
(7, 'Navab Foods', 'Pakistani Foods Experts', 'nfoods@care.com', 'restImage/fdgdg.jpg', '50 Min', 52, 10),
(8, 'Papa Johns', 'Fast Food ', 'papajohns@careonline.com', 'restImage/papp-johns.jpg', '60 Min', 44, 8),
(9, 'Pizza Hut', 'Pizza ', 'pizzahut@onlinecare.com', 'restImage/pizza-hut.png', '45 Min', 31, 13),
(10, 'Hot n Spicy', 'Fast Food And Pakistani Food', 'hotnspicy@care.com', 'restImage/karachi-hot-n-spicy--dha-lahore.png', '45 Min', 39, 10),
(11, 'Firdouse', 'Pakistani Food Master', 'firdouse@careonline.com', 'restImage/fdgdfgdfg.jpg', '60 Min', 40, 10),
(12, 'Kitchen Cusine', 'The True Taste of Thai Food', 'kitchencusine@customer.com', 'restImage/Kitchen-Cuisine-Logo.jpg', '45 Min', 44, 14),
(13, 'Harry Wrap Rolls', 'Paratha Rolls Experts', 'harrywraprolls@onlinecare.com', 'restImage/dsgsdgfgfh.png', '60 Min', 51, 10),
(14, 'Chocko Choza', 'Good Food for Everyone', 'cc@customercare.com', 'restImage/fd.jpg', '45 Min', 38, 13),
(15, 'Marry Brown', 'Fast Food', 'mb@online.com', 'restImage/dsfsdfsdfsdf.jpg', '60 Min', 26, 8),
(16, 'Punjabi Dhaba', 'Punjabi Food Experts', 'pd@customerscare.com', 'restImage/fdgfgfg.png', '45 Min', 26, 10),
(17, 'Peppers', 'Fast Food', 'peppers@care.com', 'restImage/fbdfdfg.jpg', '60 Min', 51, 8),
(18, 'Kaati Zone', 'South Indian Cusine', 'kaatizone@cares.com', 'restImage/retter.jpg', '60 Min', 25, 11),
(19, 'Oven Fresh', 'Bakery Products Masters', 'ovenfresh@customerscare.com', 'restImage/sd.jpg', '50 Min', 28, 21),
(20, 'Arabian Feast', 'Arabian Taste', 'af@care.com', 'restImage/dfgd.jpg', '45 Min', 51, 17),
(21, 'Scarlet Kitchen', 'Fast Food', 'scarletkitchen@care.com', 'restImage/fdhgfh.jpg', '60 Min', 40, 8),
(22, 'Biryani Flames', 'Biryani Master inKarachi', 'biryaniflames@care.com', 'restImage/dsasd.png', '60 Min', 27, 10),
(23, 'Namma Kitchen', 'Indian Food', 'nammakitchen@care.com', 'restImage/gfhfghfg.jpg', '60 Min', 28, 11),
(24, 'Punjabi Tadka', 'Punjabi Food', 'pt@care.com', 'restImage/dsfsdfsdf.jpg', '45 Min', 29, 10),
(25, 'Jakobs Kitchen', 'Fast Food', 'jk@care.com', 'restImage/dgfdghb.jpg', '60 Min', 41, 8),
(26, 'Al-Mabrook Restaurants', 'Arabian Food', 'mr@care.com', 'restImage/dsfsdffsgyre.jpg', '60 Min', 38, 17),
(27, 'Red e Drop Zone', 'Fast Food', 'care@rdz.com', 'restImage/dgssd.jpg', '60 Min', 41, 8),
(28, 'Anjappar', 'Afghan Food', 'anjappar', 'restImage/sdf.png', '45 Min', 47, 19),
(29, 'Velu Biryani', 'South Indian Biryani', 'velubiryani', 'restImage/sdfsdfsdf.jpg', '45 Min', 49, 11);

-- --------------------------------------------------------

--
-- Table structure for table `rest_cate`
--

CREATE TABLE `rest_cate` (
  `id` int(10) NOT NULL,
  `cate_name` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rest_cate`
--

INSERT INTO `rest_cate` (`id`, `cate_name`) VALUES
(8, 'Fast Food'),
(10, 'Pakistani Food'),
(11, 'Indian Food'),
(13, 'Italian Food'),
(14, 'Thai Food'),
(15, 'Japanese Food'),
(16, 'Chinese Food  '),
(17, 'Arabian Food'),
(18, 'Irani Food'),
(19, 'Afghani Food'),
(20, 'Singaporean Food '),
(21, 'Bakery');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `firstname` varchar(255) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `dob` date NOT NULL,
  `mobile` varchar(11) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `firstname`, `lastname`, `email`, `dob`, `mobile`, `password`) VALUES
(1, 'Umar', 'Saeed', 'umarsaeed124@gmail.com', '1994-03-17', '03348673448', '$2y$10$K7GqDKwMxaLckEA7oLj.9.tTEUsyENVoFDnhwmFoGcXGTFAMQWIWa'),
(2, 'Hammad', 'Moazzam', 'hammad_13@hotmail.com', '1993-02-06', '03492986920', '3d58301d074ddafde51a23f9cf18b4a6'),
(3, 'Ahsan', 'Rizvi', 'sarr94@gmail.com', '1994-05-06', '03458781546', '$2y$10$dley45Xzyp9xjtumiVIXSut5eTPJVXOkrMRD77eTwNUa8MHrwZza6'),
(4, 'Wasay', 'Umer', 'wasay@gmail.com', '1992-12-15', '03062338702', '$2y$10$KnvVWFjyQowkogmXuYGF3eevGMdtRVKeRHZsHJ6HYO83D5SyLK2.e'),
(5, 'Junaid', 'Ul-Haq', 'Junaid1345@gmail.com', '1992-09-14', '03422644025', '$2y$10$quKh1/N1d0xad1qWWd.QZeiASqrZzUFDBND5LyR4LFkLPYndXxgyy'),
(6, 'Saad', 'Khan', 'saadi@hotmail.com', '1994-04-15', '03368113669', '$2y$10$O7tSFnSz1B53weWHrtFXQuFodd93ciIu8Qh4qQMa41sXasQ8K377i'),
(7, 'Bilal', 'Ahmed', 'BilalShaikh@hotmail.com', '1994-02-06', '03150236330', '$2y$10$OVTYJgpQpUMIRH4Bxk.AyevTeJZA6PxDhuMW8iXNFOsw8LegwJOJ.'),
(8, 'Syed Zohaib', 'Ahmed', 'zohaib@hotmail.com', '1993-07-14', '03412124585', '$2y$10$CPgsFPK9Uo/y7iYXZKZUNeY3t2lDzYSsh7Gx.v24a14R5ymOmEZnO'),
(9, 'Yousuf', 'Kamal', 'yousufkamal106@gmail.com', '1994-03-24', '03352113595', '$2y$10$40kRvPdGN2bCaIDUYKDQqulsVt6zKZgKTsyoQwr6.b0Iz9v6I9Md6'),
(10, 'Abeer', 'Ullah', 'Abeer1122@hotmail.com', '1992-03-09', '03333521330', '$2y$10$1x.G2DIB2II6LijHyo.NVezU9VZW0zhHW40XFSQYQgnpNLUFHulI2'),
(11, 'Shuja', 'Shujaat', 'shajji@outlook.com', '1994-05-06', '03153926550', '$2y$10$pA2DIB1tbT8kUAKmhCOOouB2g3oJL9gQgFSZkLbC1x86I1TQ5s3Z2'),
(12, 'Sami', 'Khan', 'Sami1256@hotmail.com', '1990-04-07', '03009216587', '$2y$10$8AYyP6q/zX90sHRhBjpd5uqBJowwtQV.PRuX5PNL5WalveOUrbrh.'),
(13, 'Sameed', 'Khan', 'sameed12@gmail.com', '1994-05-07', '03339204590', '$2y$10$/ZxFqclU/EUrSKHM7cA0BulH/S6vDJZYGEgFCJm836fNKSxi5F9.G');

-- --------------------------------------------------------

--
-- Table structure for table `user_contact`
--

CREATE TABLE `user_contact` (
  `id` int(10) NOT NULL,
  `user_id` int(10) NOT NULL,
  `contact_no` int(10) NOT NULL,
  `contact_type` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `age_group`
--
ALTER TABLE `age_group`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `contact_type`
--
ALTER TABLE `contact_type`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `dish`
--
ALTER TABLE `dish`
  ADD PRIMARY KEY (`dish_id`),
  ADD KEY `dish_cate_id` (`dish_cate_id`),
  ADD KEY `dishes_rest_fk` (`rest_id`);

--
-- Indexes for table `dish_cate`
--
ALTER TABLE `dish_cate`
  ADD PRIMARY KEY (`dish_cate_id`);

--
-- Indexes for table `location`
--
ALTER TABLE `location`
  ADD PRIMARY KEY (`loc_id`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`order_id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `rest_id` (`rest_id`);

--
-- Indexes for table `orders_detail`
--
ALTER TABLE `orders_detail`
  ADD PRIMARY KEY (`order_detail_id`),
  ADD KEY `order_orderdetail_fk` (`order_id`),
  ADD KEY `dish_orderdetail_fk` (`dish_id`);

--
-- Indexes for table `rest`
--
ALTER TABLE `rest`
  ADD PRIMARY KEY (`rest_id`),
  ADD KEY `loc_id` (`loc_id`),
  ADD KEY `rest_cate_fk` (`rest_cate_id`);

--
-- Indexes for table `rest_cate`
--
ALTER TABLE `rest_cate`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user_contact`
--
ALTER TABLE `user_contact`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `age_group`
--
ALTER TABLE `age_group`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `contact_type`
--
ALTER TABLE `contact_type`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `dish`
--
ALTER TABLE `dish`
  MODIFY `dish_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=59;

--
-- AUTO_INCREMENT for table `dish_cate`
--
ALTER TABLE `dish_cate`
  MODIFY `dish_cate_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- AUTO_INCREMENT for table `location`
--
ALTER TABLE `location`
  MODIFY `loc_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=53;

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `order_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `orders_detail`
--
ALTER TABLE `orders_detail`
  MODIFY `order_detail_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `rest`
--
ALTER TABLE `rest`
  MODIFY `rest_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT for table `rest_cate`
--
ALTER TABLE `rest_cate`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `user_contact`
--
ALTER TABLE `user_contact`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `dish`
--
ALTER TABLE `dish`
  ADD CONSTRAINT `dishes_cates_fk` FOREIGN KEY (`dish_cate_id`) REFERENCES `dish_cate` (`dish_cate_id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `dishes_rest_fk` FOREIGN KEY (`rest_id`) REFERENCES `rest` (`rest_id`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `rest_order_fk` FOREIGN KEY (`rest_id`) REFERENCES `rest` (`rest_id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `user_order_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `orders_detail`
--
ALTER TABLE `orders_detail`
  ADD CONSTRAINT `dish_orderdetail_fk` FOREIGN KEY (`dish_id`) REFERENCES `dish` (`dish_id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `order_orderdetail_fk` FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `rest`
--
ALTER TABLE `rest`
  ADD CONSTRAINT `rest_cate_fk` FOREIGN KEY (`rest_cate_id`) REFERENCES `rest_cate` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
