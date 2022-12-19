-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 19, 2022 at 08:43 AM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bookingsystem`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `user_position` int(50) NOT NULL,
  `customer_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `license_no` int(50) NOT NULL,
  `customer_birthdate` varchar(255) NOT NULL,
  `customer_contactno` varchar(255) NOT NULL,
  `customer_address` varchar(255) NOT NULL,
  `customer_emailadd` varchar(255) NOT NULL,
  `customer_password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`user_position`, `customer_id`, `name`, `license_no`, `customer_birthdate`, `customer_contactno`, `customer_address`, `customer_emailadd`, `customer_password`) VALUES
(2, 25, 'AIRO', 98765, '0', '012345', 'CEBU CITY', 'air12345', 'air12345'),
(3, 27, 'JUNEY', 0, '6 Dec 2022', '987654321', 'CEBU', 'QWERTYUIOP', 'qwertyuiop'),
(3, 32, 'Lorenfe', 21, '9 Dec 2022', '65656565', 'Cebu', 'loren@gmail.com', '456123'),
(1, 34, 'Vanessa', 123456541, '7 Dec 2022', 'Cebu', '123456', 'van@gmail.com', '123456'),
(2, 35, 'Eagle Wings', 123123, '0', '09561234862', 'Sta. Mesa', 'eagles@gmail.com', 'pass'),
(3, 36, 'Vanessa Sagolili', 21, '15 Dec 2020', '0987654534', 'Cebu', 'vanessa@gmail.com', '123456789'),
(1, 37, 'Junjun', 0, '31 Dec 2022', '11234556', 'cebu', 'junjun@gmail.com', '123456789'),
(3, 38, 'Luka Doncic', 23, '28 Feb 1999', '65158964', 'Slovenia', 'luka@gmail.com', '1234567890'),
(3, 39, 'Stephen Curry', 34, '14 Mar 1988', '098765423', 'United States of America', 'stephen@gmail.com', '123456789'),
(1, 40, 'Lorenfe Cuadero', 0, '1 Dec 2022', '09695335535', 'Cebu', 'lorencuadero@gmail.com', '123456'),
(1, 41, 'Cobe Bryan', 0, '27 Dec 2000', '0987654334', 'United States', 'cobe@gmail.com', '123456789'),
(2, 42, 'Ellen Adarna', 25, '4 Dec 1999', '09876543213', 'Cebu', 'ellen@gmail.com', '123456789'),
(3, 43, 'Alex Lee', 19, '1 Dec 2022', '0987654321234', 'Bohol', 'alex@gmail.co ', '123456789'),
(1, 44, 'Bryan Cole', 0, '6 Dec 2022', '987654321', 'Ontario', 'bryan@gmail.com', 'bryan'),
(2, 45, 'Chicken Wings', 789789, '0', '0987654321', 'On his mothers wings', 'wing@gmail.com', 'wing');

-- --------------------------------------------------------

--
-- Table structure for table `customer_availableflightinfopage`
--

CREATE TABLE `customer_availableflightinfopage` (
  `ticket_id` int(11) NOT NULL,
  `no_of_availableticket` varchar(255) NOT NULL,
  `name_of_availableflight` varchar(255) NOT NULL,
  `ticket_price` varchar(255) NOT NULL,
  `destination` varchar(255) NOT NULL,
  `date` varchar(255) NOT NULL,
  `departure_time` varchar(255) NOT NULL,
  `arrival_time` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer_availableflightinfopage`
--

INSERT INTO `customer_availableflightinfopage` (`ticket_id`, `no_of_availableticket`, `name_of_availableflight`, `ticket_price`, `destination`, `date`, `departure_time`, `arrival_time`) VALUES
(10, '45', 'Aero 45', '5000', 'Cebu - Manila', '22 Dec 2022', '5 pm', '4 am'),
(11, '40', 'Rare', '1200', 'Manila - Singapore', '18 Dec 2022', '7 pm', '10 pm');

-- --------------------------------------------------------

--
-- Table structure for table `customer_bookingpage`
--

CREATE TABLE `customer_bookingpage` (
  `ticket_id` int(11) NOT NULL,
  `name_of_availableflight` varchar(50) NOT NULL,
  `destination` varchar(255) NOT NULL,
  `date` varchar(255) NOT NULL,
  `ticket_price` int(50) NOT NULL,
  `expectedtime_of_departure` varchar(255) NOT NULL,
  `expectedtime_of_arrival` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `customer_payment`
--

CREATE TABLE `customer_payment` (
  `transaction_id` int(11) NOT NULL,
  `customer_name` varchar(255) NOT NULL,
  `total_cost` varchar(255) NOT NULL,
  `transaction_date` varchar(255) NOT NULL DEFAULT current_timestamp(),
  `transaction_time` time(6) NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer_payment`
--

INSERT INTO `customer_payment` (`transaction_id`, `customer_name`, `total_cost`, `transaction_date`, `transaction_time`) VALUES
(3, 'Vanessa Sagolili', '5000', '17 Dec 2022', '10:25:49.000000'),
(4, 'Vanessa Sagolili', '5000', '17 Dec 2022', '10:29:50.000000'),
(6, 'Vanessa Sagolili', '5000', '17 Dec 2022', '10:34:06.000000'),
(7, 'Vanessa Sagolili', '5000', '17 Dec 2022', '11:06:49.000000'),
(8, 'Vanessa Sagolili', '5000', '17 Dec 2022', '11:08:43.000000'),
(10, 'Alex Lee', '5000', '18 Dec 2022', '09:45:21.000000');

-- --------------------------------------------------------

--
-- Table structure for table `user_position_info`
--

CREATE TABLE `user_position_info` (
  `user_position` int(50) NOT NULL,
  `position_description` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user_position_info`
--

INSERT INTO `user_position_info` (`user_position`, `position_description`) VALUES
(1, 'Administrator'),
(2, 'Airline Company'),
(3, 'Customer');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`customer_id`),
  ADD KEY `user_position` (`user_position`);

--
-- Indexes for table `customer_availableflightinfopage`
--
ALTER TABLE `customer_availableflightinfopage`
  ADD PRIMARY KEY (`ticket_id`),
  ADD KEY `ticket_id` (`ticket_id`);

--
-- Indexes for table `customer_bookingpage`
--
ALTER TABLE `customer_bookingpage`
  ADD PRIMARY KEY (`ticket_id`);

--
-- Indexes for table `customer_payment`
--
ALTER TABLE `customer_payment`
  ADD PRIMARY KEY (`transaction_id`);

--
-- Indexes for table `user_position_info`
--
ALTER TABLE `user_position_info`
  ADD PRIMARY KEY (`user_position`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `customer_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=47;

--
-- AUTO_INCREMENT for table `customer_availableflightinfopage`
--
ALTER TABLE `customer_availableflightinfopage`
  MODIFY `ticket_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `customer_payment`
--
ALTER TABLE `customer_payment`
  MODIFY `transaction_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `user_position_info`
--
ALTER TABLE `user_position_info`
  MODIFY `user_position` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
