-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 02, 2022 at 07:26 AM
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
-- Table structure for table `administrator`
--

CREATE TABLE `administrator` (
  `admin_id` int(11) NOT NULL,
  `admin_name` varchar(255) NOT NULL,
  `admin_birthdate` varchar(255) NOT NULL,
  `admin_address` varchar(255) NOT NULL,
  `admin_contact_number` varchar(255) NOT NULL,
  `admin_emailadd` varchar(255) NOT NULL,
  `admin_password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `airlinecompany`
--

CREATE TABLE `airlinecompany` (
  `airlinecomp_id` int(11) NOT NULL,
  `airlinecomp_name` varchar(255) NOT NULL,
  `airlinecomp_address` varchar(255) NOT NULL,
  `airlinecomp_licenseno` varchar(255) NOT NULL,
  `airlinecomp_contactno` varchar(255) NOT NULL,
  `airlinecomp_emailadd` varchar(255) NOT NULL,
  `airlinecomp_password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `customer_id` int(11) NOT NULL,
  `customer_name` varchar(255) NOT NULL,
  `customer_age` varchar(255) NOT NULL,
  `customer_birthdate` varchar(255) NOT NULL,
  `customer_contactno` varchar(255) NOT NULL,
  `customer_address` varchar(255) NOT NULL,
  `customer_emailadd` varchar(255) NOT NULL,
  `customer_password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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
  `arrival_time` varchar(255) NOT NULL,
  `seat_no` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `customer_bookingpage`
--

CREATE TABLE `customer_bookingpage` (
  `booking_id` int(11) NOT NULL,
  `destination` varchar(255) NOT NULL,
  `date` varchar(255) NOT NULL,
  `expectedtime_of_departure` varchar(255) NOT NULL,
  `expectedtime_of_arrival` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `customer_payment`
--

CREATE TABLE `customer_payment` (
  `transaction_id` int(11) NOT NULL,
  `onlinepayment_flatform` varchar(255) NOT NULL,
  `total_cost` varchar(255) NOT NULL,
  `tansaction_date` varchar(255) NOT NULL,
  `transaction_time` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `administrator`
--
ALTER TABLE `administrator`
  ADD PRIMARY KEY (`admin_id`);

--
-- Indexes for table `airlinecompany`
--
ALTER TABLE `airlinecompany`
  ADD PRIMARY KEY (`airlinecomp_id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`customer_id`);

--
-- Indexes for table `customer_availableflightinfopage`
--
ALTER TABLE `customer_availableflightinfopage`
  ADD PRIMARY KEY (`ticket_id`);

--
-- Indexes for table `customer_bookingpage`
--
ALTER TABLE `customer_bookingpage`
  ADD PRIMARY KEY (`booking_id`);

--
-- Indexes for table `customer_payment`
--
ALTER TABLE `customer_payment`
  ADD PRIMARY KEY (`transaction_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `administrator`
--
ALTER TABLE `administrator`
  MODIFY `admin_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `airlinecompany`
--
ALTER TABLE `airlinecompany`
  MODIFY `airlinecomp_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `customer_availableflightinfopage`
--
ALTER TABLE `customer_availableflightinfopage`
  MODIFY `ticket_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `customer_bookingpage`
--
ALTER TABLE `customer_bookingpage`
  MODIFY `booking_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `customer_payment`
--
ALTER TABLE `customer_payment`
  MODIFY `transaction_id` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
