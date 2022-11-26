-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: mysql
-- Tiempo de generación: 24-11-2022 a las 14:51:33
-- Versión del servidor: 8.0.31
-- Versión de PHP: 8.0.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `MazeServer`
--
CREATE DATABASE IF NOT EXISTS `MazeServer` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
USE `MazeServer`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Winners`
--

DROP TABLE IF EXISTS `Winners`;
CREATE TABLE `Winners` (
  `id` int NOT NULL,
  `name` varchar(12) NOT NULL,
  `mazename` varchar(20) NOT NULL,
  `time` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `Winners`
--

INSERT INTO `Winners` (`id`, `name`, `mazename`, `time`) VALUES
(42, 'Fran', 'Tutorial Maze', 29855),
(43, 'Fran', 'Pere\'s Maze', 26183);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `Winners`
--
ALTER TABLE `Winners`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `Winners`
--
ALTER TABLE `Winners`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
