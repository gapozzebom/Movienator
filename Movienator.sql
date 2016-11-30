-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Nov 30, 2016 at 12:02 AM
-- Server version: 5.7.13-0ubuntu0.16.04.2
-- PHP Version: 7.0.8-0ubuntu0.16.04.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `Movienator`
--

-- --------------------------------------------------------

--
-- Table structure for table `movie`
--
CREATE DATABASE Movienator;

USE Movienator;

CREATE TABLE `movie` (
  `movieId` int(11) NOT NULL,
  `actors` varchar(400) NOT NULL,
  `awards` varchar(300) NOT NULL,
  `country` varchar(300) NOT NULL,
  `director` varchar(300) NOT NULL,
  `genre` varchar(300) NOT NULL,
  `imdbId` varchar(20) NOT NULL,
  `imdbVotes` varchar(20) NOT NULL,
  `imdbRating` varchar(10) NOT NULL,
  `language` varchar(300) NOT NULL,
  `metascore` varchar(5) NOT NULL,
  `plot` varchar(1000) NOT NULL,
  `poster` varchar(400) NOT NULL,
  `rated` varchar(20) NOT NULL,
  `released` varchar(30) NOT NULL,
  `response` varchar(20) NOT NULL,
  `runtime` varchar(20) NOT NULL,
  `title` varchar(100) NOT NULL,
  `type` varchar(20) NOT NULL,
  `writer` varchar(300) NOT NULL,
  `year` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `movie`
--

INSERT INTO `movie` (`movieId`, `actors`, `awards`, `country`, `director`, `genre`, `imdbId`, `imdbVotes`, `imdbRating`, `language`, `metascore`, `plot`, `poster`, `rated`, `released`, `response`, `runtime`, `title`, `type`, `writer`, `year`) VALUES
(1, 'Leonardo DiCaprio, Joseph Gordon-Levitt, Ellen Page, Tom Hardy', 'Won 4 Oscars. Another 144 wins & 198 nominations.', 'USA, UK', 'Christopher Nolan', 'Action, Adventure, Sci-Fi', 'tt1375666', '1,501,172', '8.8', 'English, Japanese, French', '74', 'A thief, who steals corporate secrets through use of dream-sharing technology, is given the inverse task of planting an idea into the mind of a CEO.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1_SX300.jpg', 'PG-13', '16 Jul 2010', 'True', '148 min', 'Inception', 'movie', 'Christopher Nolan', '2010'),
(2, 'Guy Pearce, Carrie-Anne Moss, Joe Pantoliano, Mark Boone Junior', 'Nominated for 2 Oscars. Another 54 wins & 55 nominations.', 'USA', 'Christopher Nolan', 'Mystery, Thriller', 'tt0209144', '865,967', '8.5', 'English', '80', 'A man juggles searching for his wife\'s murderer and keeping his short-term memory loss from being an obstacle.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BNThiYjM3MzktMDg3Yy00ZWQ3LTk3YWEtN2M0YmNmNWEwYTE3XkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg', 'R', '25 May 2001', 'True', '113 min', 'Memento', 'movie', 'Christopher Nolan (screenplay), Jonathan Nolan (short story "Memento Mori")', '2000'),
(3, 'Tom Hanks, Tim Allen, Don Rickles, Jim Varney', 'Nominated for 3 Oscars. Another 23 wins & 18 nominations.', 'USA', 'John Lasseter', 'Animation, Adventure, Comedy', 'tt0114709', '640,117', '8.3', 'English', '92', 'A cowboy doll is profoundly threatened and jealous when a new spaceman figure supplants him as top toy in a boy\'s room.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMDU2ZWJlMjktMTRhMy00ZTA5LWEzNDgtYmNmZTEwZTViZWJkXkEyXkFqcGdeQXVyNDQ2OTk4MzI@._V1_SX300.jpg', 'G', '22 Nov 1995', 'True', '81 min', 'Toy Story', 'movie', 'John Lasseter (original story by), Pete Docter (original story by), Andrew Stanton (original story by), Joe Ranft (original story by), Joss Whedon (screenplay), Andrew Stanton (screenplay), Joel Cohen (screenplay), Alec Sokolow (screenplay)', '1995'),
(4, 'Tom Hanks, Tim Allen, Joan Cusack, Kelsey Grammer', 'Nominated for 1 Oscar. Another 20 wins & 28 nominations.', 'USA', 'John Lasseter, Ash Brannon, Lee Unkrich', 'Animation, Adventure, Comedy', 'tt0120363', '394,229', '7.9', 'English, Arabic, Spanish', '88', 'When Woody is stolen by a toy collector, Buzz and his friends vow to rescue him, but Woody finds the idea of immortality in a museum tempting.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTQ0OTU0NTcyNl5BMl5BanBnXkFtZTcwOTk5Mjc4OA@@._V1_SX300.jpg', 'G', '24 Nov 1999', 'True', '92 min', 'Toy Story 2', 'movie', 'John Lasseter (original story by), Pete Docter (original story by), Ash Brannon (original story by), Andrew Stanton (original story by), Andrew Stanton (screenplay), Rita Hsiao (screenplay), Doug Chamberlin (screenplay), Chris Webb (screenplay)', '1999'),
(5, 'Briana Evigan, Nadine Crocker, Darcy DeMoss, Matt O\'Leary', '2 wins.', 'USA', 'Patrick Chapman', 'Drama, Romance, Thriller', 'tt3530896', '215', '5.6', 'English', 'N/A', 'ToY is a drama about two lost souls from disparate backgrounds who find each other amid the desperation and glamour of Los Angeles, forging an unlikely relationship that spirals into tragic chaos.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTgyNDk3NDEwOV5BMl5BanBnXkFtZTgwODY5MTg5NzE@._V1_SX300.jpg', 'N/A', 'N/A', 'True', '93 min', 'ToY', 'movie', 'Patrick Chapman, Andrew Hanson, Alissa Kokkins', '2015'),
(6, 'Giannis Bezos, Vlassis Bonatsos, Dimitra Papadopoulou, Spiros Papadopoulos', 'N/A', 'Greece', 'N/A', 'Comedy', 'tt0220196', '1,385', '9.1', 'Greek', 'N/A', 'The adventures of four people who live next to each other somewhere in Athens. Spyros and his wife Dimitra on one apartment, and Vlassis with his gay friend Yannis on the other. Though they...', 'https://images-na.ssl-images-amazon.com/images/M/MV5BNzg4N2MzZmItY2U1MC00YzlhLWI2ODYtZmY0ZDRmNzZhYmNkXkEyXkFqcGdeQXVyMjc2NTc3NDA@._V1_SX300.jpg', 'N/A', '18 Sep 1991', 'True', '30 min', 'Oi aparadektoi', 'series', 'N/A', '1991–1993'),
(7, 'Konsta Hietanen, Risto Tuorila, Jarmo Mäkinen, Antti Virmavirta', '1 win & 5 nominations.', 'Finland', 'Raimo O. Niemi', 'Adventure, Family, Drama', 'tt0167341', '817', '5.3', 'English, Finnish', 'N/A', 'Twelve-year-old Tommy reluctantly moves with his father from the big city to a small Lapp village - the childhood home of his mother, who has recently died. The village is close to the ...', 'https://images-na.ssl-images-amazon.com/images/M/MV5BOTYyODcyNTEyMV5BMl5BanBnXkFtZTYwNTA4NDM5._V1_SX300.jpg', 'N/A', '18 Dec 1998', 'True', '102 min', 'Poika ja ilves', 'movie', 'Ville Suhonen (screenplay), Martin Daniel (screenplay), Ville Suhonen (story), Matti Haapanen (story)', '1998'),
(8, 'Tom Hanks, Tim Allen, Joan Cusack, Ned Beatty', 'Won 2 Oscars. Another 58 wins & 89 nominations.', 'USA', 'Lee Unkrich', 'Animation, Adventure, Comedy', 'tt0435761', '555,480', '8.3', 'English, Spanish', '92', 'The toys are mistakenly delivered to a day-care center instead of the attic right before Andy leaves for college, and it\'s up to Woody to convince the other toys that they weren\'t abandoned and to return home.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTgxOTY4Mjc0MF5BMl5BanBnXkFtZTcwNTA4MDQyMw@@._V1_SX300.jpg', 'G', '18 Jun 2010', 'True', '103 min', 'Toy Story 3', 'movie', 'John Lasseter (story by), Andrew Stanton (story by), Lee Unkrich (story by), Michael Arndt (screenplay)', '2010'),
(9, 'Bunnie Blake, Tom Byron, Careena Collins, Candie Evans', 'N/A', 'USA', 'N/A', 'Adult', 'tt0146160', '10', '6.3', 'English', 'N/A', 'N/A', 'N/A', 'X', 'N/A', 'True', '85 min', 'Ramb-Ohh!', 'movie', 'N/A', '1986'),
(10, 'Sylvester Stallone, Richard Crenna, Brian Dennehy, Bill McKinney', '1 win & 2 nominations.', 'USA', 'Ted Kotcheff', 'Action, Adventure, Drama', 'tt0083944', '175,427', '7.7', 'English', '62', 'N/A', 'https://images-na.ssl-images-amazon.com/images/M/MV5BODBmOWU2YWMtZGUzZi00YzRhLWJjNDAtYTUwNWVkNDcyZmU5XkEyXkFqcGdeQXVyNDk3NzU2MTQ@._V1_SX300.jpg', 'R', '22 Oct 1982', 'True', '93 min', 'First Blood', 'movie', 'David Morrell (novel), Michael Kozoll (screenplay), William Sackheim (screenplay), Sylvester Stallone (screenplay)', '1982'),
(11, 'Sylvester Stallone, Richard Crenna, Charles Napier, Steven Berkoff', 'Nominated for 1 Oscar. Another 5 wins & 4 nominations.', 'USA', 'George P. Cosmatos', 'Action, Adventure, Thriller', 'tt0089880', '119,546', '6.4', 'English, Vietnamese', 'N/A', 'John Rambo is removed from prison by his former superior, Colonel Samuel Troutman, for a top-secret operation to bring back POW\'s still held in Vietnam. Rambo\'s assignment is to only take pictures of where the POWs are being held, but Rambo wants to get the POWs out of Vietnam. Teamed up with female Vietnamese freedom fighter Co Bao, Rambo embarks on a mission to rescue the POWs, who are being held by sadistic Vietnamese Captain Vinh and his Russian comrade, Lieutenant Colonel Padovsky. Rambo starts killing every enemy in sight while still focusing on his intentions to rescue the POWs. There are also corrupt American officials involved in the mission, including Marshall Murdock, one of Rambo\'s superiors.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BZWFkY2I1ZDAtNmZhNS00NjVlLWJiMGQtMGQ1ZmM0ZDA5ODg5XkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg', 'R', '22 May 1985', 'True', '96 min', 'Rambo: First Blood Part II', 'movie', 'David Morrell (characters), Kevin Jarre (story), Sylvester Stallone (screenplay), James Cameron (screenplay)', '1985');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `userId` int(11) NOT NULL,
  `userName` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(70) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`userId`, `userName`, `password`, `email`) VALUES
(1, 'gabriel', '123', 'gabriel@gmail.com'),
(2, 'anderson', '1234', 'anderson@anderson.com'),
(3, 'sonic', '123456', 'sonic@wall.com'),
(4, 'sonicwall', '123456', 'sonicw@wall.com');

-- --------------------------------------------------------

--
-- Table structure for table `userMovie`
--

CREATE TABLE `userMovie` (
  `userId` int(11) NOT NULL,
  `movieId` int(11) NOT NULL,
  `userName` varchar(100) DEFAULT NULL,
  `title` varchar(50) DEFAULT NULL,
  `wish` tinyint(1) DEFAULT '0',
  `watch` tinyint(1) DEFAULT '0',
  `review` varchar(10000) DEFAULT NULL,
  `rate` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `userMovie`
--


--
-- Indexes for dumped tables
--

--
-- Indexes for table `movie`
--
ALTER TABLE `movie`
  ADD PRIMARY KEY (`movieId`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`userId`);

--
-- Indexes for table `userMovie`
--
ALTER TABLE `userMovie`
  ADD PRIMARY KEY (`userId`,`movieId`),
  ADD UNIQUE KEY `userId` (`userId`,`movieId`),
  ADD KEY `movieId` (`movieId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `movie`
--
ALTER TABLE `movie`
  MODIFY `movieId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `userId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `userMovie`
--
ALTER TABLE `userMovie`
  ADD CONSTRAINT `userMovie_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`),
  ADD CONSTRAINT `userMovie_ibfk_2` FOREIGN KEY (`movieId`) REFERENCES `movie` (`movieId`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
