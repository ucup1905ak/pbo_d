-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 21, 2026 at 06:01 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `object_persistence_d`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `id_customer` int(5) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `alamat` varchar(255) NOT NULL,
  `no_telepon` varchar(14) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`id_customer`, `nama`, `alamat`, `no_telepon`) VALUES
(3, 'sukirman', '3121231331', 'babarsari'),
(4, 'ucup curucup', '123123132', 'mars');

-- --------------------------------------------------------

--
-- Table structure for table `kasir`
--

CREATE TABLE `kasir` (
  `id_kasir` int(5) NOT NULL,
  `nama_kasir` varchar(255) NOT NULL,
  `nomor_loket` int(15) NOT NULL,
  `shift` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `kasir`
--

INSERT INTO `kasir` (`id_kasir`, `nama_kasir`, `nomor_loket`, `shift`) VALUES
(2, 'ucup', 3, 'malam'),
(4, 'wowok', 2, 'pagi');

-- --------------------------------------------------------

--
-- Table structure for table `kendaraan`
--

CREATE TABLE `kendaraan` (
  `id_kendaraan` varchar(5) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `harga` float NOT NULL,
  `jenis` varchar(14) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `kendaraan`
--

INSERT INTO `kendaraan` (`id_kendaraan`, `nama`, `harga`, `jenis`) VALUES
('K1', 'qwrq', 12414200, 'Mobil'),
('K2', 'tewrwrfwrrfereew', 123131, 'Motor');

-- --------------------------------------------------------

--
-- Table structure for table `mobil`
--

CREATE TABLE `mobil` (
  `id_kendaraan` varchar(5) NOT NULL,
  `jenis_mesin` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `mobil`
--

INSERT INTO `mobil` (`id_kendaraan`, `jenis_mesin`) VALUES
('K1', 'mantao');

-- --------------------------------------------------------

--
-- Table structure for table `motor`
--

CREATE TABLE `motor` (
  `id_kendaraan` varchar(5) NOT NULL,
  `jumlah_tak` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `motor`
--

INSERT INTO `motor` (`id_kendaraan`, `jumlah_tak`) VALUES
('K2', 2);

-- --------------------------------------------------------

--
-- Table structure for table `paket_lengkap`
--

CREATE TABLE `paket_lengkap` (
  `id_paketservis` varchar(255) NOT NULL,
  `fasilitas_paket` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `paket_lengkap`
--

INSERT INTO `paket_lengkap` (`id_paketservis`, `fasilitas_paket`) VALUES
('PS-0', 'wefwe');

-- --------------------------------------------------------

--
-- Table structure for table `paket_ringan`
--

CREATE TABLE `paket_ringan` (
  `id_paketservis` varchar(255) NOT NULL,
  `layanan_tambahan` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `paket_servis`
--

CREATE TABLE `paket_servis` (
  `id_paketservis` varchar(255) NOT NULL,
  `nama_paketservis` varchar(255) NOT NULL,
  `jenis_paketservis` varchar(255) NOT NULL,
  `durasi_pengerjaan` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `paket_servis`
--

INSERT INTO `paket_servis` (`id_paketservis`, `nama_paketservis`, `jenis_paketservis`, `durasi_pengerjaan`) VALUES
('PS-0', 'udin curudin', 'Paket Lengkap', 12);

-- --------------------------------------------------------

--
-- Table structure for table `pembelian_kendaraan`
--

CREATE TABLE `pembelian_kendaraan` (
  `no_resi` int(11) NOT NULL,
  `id_customer` int(11) NOT NULL,
  `id_kendaraan` varchar(5) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `tambahan` varchar(255) NOT NULL,
  `metode_pembayaran` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pembelian_kendaraan`
--

INSERT INTO `pembelian_kendaraan` (`no_resi`, `id_customer`, `id_kendaraan`, `jumlah`, `tambahan`, `metode_pembayaran`) VALUES
(1, 4, 'K1', 2, 'Tambahan sistem navigasi', 'BRI');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id_customer`);

--
-- Indexes for table `kasir`
--
ALTER TABLE `kasir`
  ADD PRIMARY KEY (`id_kasir`);

--
-- Indexes for table `kendaraan`
--
ALTER TABLE `kendaraan`
  ADD PRIMARY KEY (`id_kendaraan`);

--
-- Indexes for table `mobil`
--
ALTER TABLE `mobil`
  ADD UNIQUE KEY `id_kendaraan` (`id_kendaraan`);

--
-- Indexes for table `motor`
--
ALTER TABLE `motor`
  ADD KEY `fk_motor_kendaraan` (`id_kendaraan`);

--
-- Indexes for table `paket_lengkap`
--
ALTER TABLE `paket_lengkap`
  ADD UNIQUE KEY `id_paketservis` (`id_paketservis`);

--
-- Indexes for table `paket_ringan`
--
ALTER TABLE `paket_ringan`
  ADD UNIQUE KEY `id_paketservis` (`id_paketservis`);

--
-- Indexes for table `paket_servis`
--
ALTER TABLE `paket_servis`
  ADD PRIMARY KEY (`id_paketservis`);

--
-- Indexes for table `pembelian_kendaraan`
--
ALTER TABLE `pembelian_kendaraan`
  ADD PRIMARY KEY (`no_resi`),
  ADD KEY `FK_pembelian_customer` (`id_customer`),
  ADD KEY `FK_pembelian_kendaraan` (`id_kendaraan`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `id_customer` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `kasir`
--
ALTER TABLE `kasir`
  MODIFY `id_kasir` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `pembelian_kendaraan`
--
ALTER TABLE `pembelian_kendaraan`
  MODIFY `no_resi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `mobil`
--
ALTER TABLE `mobil`
  ADD CONSTRAINT `fk_mobil_kendaraan` FOREIGN KEY (`id_kendaraan`) REFERENCES `kendaraan` (`id_kendaraan`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `motor`
--
ALTER TABLE `motor`
  ADD CONSTRAINT `fk_motor_kendaraan` FOREIGN KEY (`id_kendaraan`) REFERENCES `kendaraan` (`id_kendaraan`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `paket_lengkap`
--
ALTER TABLE `paket_lengkap`
  ADD CONSTRAINT `fk_paketServis_paketLengkap` FOREIGN KEY (`id_paketservis`) REFERENCES `paket_servis` (`id_paketservis`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `paket_ringan`
--
ALTER TABLE `paket_ringan`
  ADD CONSTRAINT `fk_paketServis_paketRingan` FOREIGN KEY (`id_paketservis`) REFERENCES `paket_servis` (`id_paketservis`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `pembelian_kendaraan`
--
ALTER TABLE `pembelian_kendaraan`
  ADD CONSTRAINT `FK_pembelian_customer` FOREIGN KEY (`id_customer`) REFERENCES `customer` (`id_customer`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_pembelian_kendaraan` FOREIGN KEY (`id_kendaraan`) REFERENCES `kendaraan` (`id_kendaraan`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
