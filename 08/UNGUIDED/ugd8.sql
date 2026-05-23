-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 23, 2026 at 05:02 PM
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
(7, 'Farelino', '+12345', 'Jl. Seturan'),
(8, 'Budi Santoso', 'Jl. Ahmad Yani No. 45, Yogyakarta', '0812345678'),
(9, 'Siti Nurhaliza', 'Jl. Diponegoro No. 12, Bandung', '0878654321'),
(10, 'Ahmad Rahman', 'Jl. Sudirman No. 78, Jakarta', '0821234567'),
(11, 'Eka Putri', 'Jl. Pemuda No. 33, Surabaya', '0856789012'),
(12, 'Ricky Harahap', 'Jl. Gatot Subroto No. 21, Medan', '0832145678'),
(13, 'Diana Kusuma', 'Jl. Merdeka No. 99, Malang', '0887654321'),
(14, 'Hendra Wijaya', 'Jl. Patimura No. 56, Semarang', '0813579246'),
(15, 'Lina Wijayanto', 'Jl. Jenderal Sudirman No. 88, Bekasi', '0892468135'),
(16, 'Bambang Irawan', 'Jl. Pendidikan No. 42, Bandung', '0871357924'),
(17, 'Maya Suwono', 'Jl. Pancasila No. 15, Depok', '0853792461');

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
(10, 'Rina Wijaya', 1, 'Pagi'),
(11, 'Doni Prasetyo', 2, 'Siang'),
(12, 'Sinta Kusuma', 3, 'Malam'),
(13, 'Putra Santoso', 4, 'Pagi'),
(14, 'Citra Dewi', 5, 'Siang'),
(15, 'Imam Hidayat', 6, 'Malam'),
(16, 'Yuni Hermawan', 7, 'Pagi'),
(17, 'Agus Hermanto', 8, 'Siang'),
(18, 'Lia Safitri', 9, 'Malam');

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
('K1', 'NMAX', 15000, 'Motor '),
('K10', 'Mirage', 155000, 'Mobil'),
('K2', 'Avanza', 15000, 'Mobil '),
('K3', 'Beat', 12500, 'Motor'),
('K4', 'PCX', 18000, 'Motor'),
('K5', 'Vario', 11000, 'Motor'),
('K6', 'Innova', 180000, 'Mobil'),
('K7', 'Calya', 135000, 'Mobil'),
('K8', 'Agya', 125000, 'Mobil'),
('K9', 'Xenia', 140000, 'Mobil');

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
('K10', '1.2L 3Cylinder'),
('K2', '1L 4Cylinder'),
('K6', '1.5L 4Cylinder'),
('K7', '1.2L 3Cylinder'),
('K8', '1.0L 3Cylinder'),
('K9', '1.3L 4Cylinder');

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
('K1', 4),
('K3', 4),
('K4', 4),
('K5', 4);

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
('PS-1', 'Pemeriksaan Menyeluruh + Perbaikan + Penggantian Suku Cadang'),
('PS-3', 'Pembersihan Mesin + Penggantian Oli + Penggantian Filter + Pengecekan Sistem'),
('PS-5', 'Pembongkaran Mesin Lengkap + Pembersihan + Pengecekan Komponen + Perakitan Ulang'),
('PS-6', 'Pencucian Eksterior + Interior + Poles Bodi + Wax Protection'),
('PS-8', 'Pemeriksaan Sistem AC + Pembersihan Kondensor + Isi Freon + Test Run'),
('PS-9', 'Pengurukan + Pengamplasan + Pengecatan + Finishing');

-- --------------------------------------------------------

--
-- Table structure for table `paket_ringan`
--

CREATE TABLE `paket_ringan` (
  `id_paketservis` varchar(255) NOT NULL,
  `layanan_tambahan` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `paket_ringan`
--

INSERT INTO `paket_ringan` (`id_paketservis`, `layanan_tambahan`) VALUES
('PS-2', 'Pemeriksaan Kondisi Kendaraan'),
('PS-4', 'Penggantian Kampas Rem'),
('PS-7', 'Pembersihan Filter Udara');

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
('PS-1', 'yoi', 'Lengkap', 3151),
('PS-2', 'Servis Berkala', 'Ringan', 2),
('PS-3', 'Tune-Up Engine', 'Lengkap', 4),
('PS-4', 'Perbaikan Rem', 'Ringan', 3),
('PS-5', 'Overhaul Mesin', 'Lengkap', 8),
('PS-6', 'Detailing Mobil', 'Lengkap', 5),
('PS-7', 'Ganti Oli & Filter', 'Ringan', 1),
('PS-8', 'Servis AC', 'Lengkap', 3),
('PS-9', 'Pengecatan Ulang', 'Lengkap', 6);

-- --------------------------------------------------------

--
-- Table structure for table `pembelian_kendaraan`
--

CREATE TABLE `pembelian_kendaraan` (
  `no_resi` int(11) NOT NULL,
  `id_customer` int(11) NOT NULL,
  `id_kendaraan` varchar(5) NOT NULL,
  `id_kasir` int(11) NOT NULL,
  `id_paketservis` varchar(5) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `tambahan` varchar(255) NOT NULL,
  `metode_pembayaran` varchar(255) NOT NULL,
  `tanggal_transaksi` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pembelian_kendaraan`
--

INSERT INTO `pembelian_kendaraan` (`no_resi`, `id_customer`, `id_kendaraan`, `id_kasir`, `id_paketservis`, `jumlah`, `tambahan`, `metode_pembayaran`, `tanggal_transaksi`) VALUES
(1, 7, 'K1', 10, 'PS-1', 1, 'Asuransi Komprehensif', 'Tunai', '2026-01-15'),
(2, 8, 'K2', 11, 'PS-2', 1, 'Garansi Mesin 2 Tahun', 'Transfer Bank', '2026-01-20'),
(3, 9, 'K3', 12, 'PS-3', 2, 'Lisensi + Pajak', 'Cicilan', '2026-02-05'),
(4, 10, 'K4', 13, 'PS-4', 1, 'Asuransi Dasar', 'Tunai', '2026-02-10'),
(5, 11, 'K5', 14, 'PS-5', 1, 'Paket Servis 1 Tahun', 'Transfer Bank', '2026-02-18'),
(6, 12, 'K6', 15, 'PS-6', 1, 'Asuransi Komprehensif', 'Cicilan', '2026-02-25'),
(7, 13, 'K7', 16, 'PS-7', 1, 'Gratis Servis 3 Bulan', 'Tunai', '2026-03-05'),
(8, 14, 'K8', 17, 'PS-8', 2, 'Asuransi Dasar', 'Transfer Bank', '2026-03-12'),
(9, 15, 'K9', 18, 'PS-2', 1, 'Paket Servis 6 Bulan', 'Cicilan', '2026-03-20'),
(10, 16, 'K10', 10, 'PS-3', 1, 'Asuransi Komprehensif', 'Tunai', '2026-03-28'),
(11, 17, 'K1', 11, 'PS-4', 1, 'Gratis Servis 1 Bulan', 'Transfer Bank', '2026-04-05'),
(12, 8, 'K2', 12, 'PS-5', 1, 'Asuransi Dasar', 'Cicilan', '2026-04-15'),
(13, 9, 'K6', 13, 'PS-1', 1, 'Paket Servis Lengkap', 'Tunai', '2026-04-22'),
(14, 10, 'K7', 14, 'PS-2', 2, 'Asuransi Komprehensif', 'Transfer Bank', '2026-05-02'),
(15, 11, 'K3', 15, 'PS-3', 1, 'Gratis Servis 2 Bulan', 'Cicilan', '2026-05-10');

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
  ADD KEY `FK_pembelian_kasir` (`id_kasir`),
  ADD KEY `FK_pembelian_kendaraan` (`id_kendaraan`),
  ADD KEY `FK_pembelian_paketservis` (`id_paketservis`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `id_customer` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `kasir`
--
ALTER TABLE `kasir`
  MODIFY `id_kasir` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `pembelian_kendaraan`
--
ALTER TABLE `pembelian_kendaraan`
  MODIFY `no_resi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

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
  ADD CONSTRAINT `FK_pembelian_customer` FOREIGN KEY (`id_customer`) REFERENCES `customer` (`id_customer`),
  ADD CONSTRAINT `FK_pembelian_kasir` FOREIGN KEY (`id_kasir`) REFERENCES `kasir` (`id_kasir`),
  ADD CONSTRAINT `FK_pembelian_kendaraan` FOREIGN KEY (`id_kendaraan`) REFERENCES `kendaraan` (`id_kendaraan`),
  ADD CONSTRAINT `FK_pembelian_paketservis` FOREIGN KEY (`id_paketservis`) REFERENCES `paket_servis` (`id_paketservis`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
