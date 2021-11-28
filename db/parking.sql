-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 28 Nov 2021 pada 07.14
-- Versi server: 10.1.36-MariaDB
-- Versi PHP: 7.2.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `parking`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `jenis_kendaraan`
--

CREATE TABLE `jenis_kendaraan` (
  `kode_jenis` int(20) NOT NULL,
  `nama_jenis` varchar(30) NOT NULL,
  `tarif` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `jenis_kendaraan`
--

INSERT INTO `jenis_kendaraan` (`kode_jenis`, `nama_jenis`, `tarif`) VALUES
(1, 'Motor', 2000),
(2, 'Mobil', 3000),
(5, 'Truk', 10000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `parkir`
--

CREATE TABLE `parkir` (
  `kode_parkir` int(10) NOT NULL,
  `tanggal_masuk` bigint(20) NOT NULL,
  `tanggal_keluar` bigint(20) DEFAULT NULL,
  `plat_nomor` varchar(13) NOT NULL,
  `kode_petugas_masuk` varchar(20) NOT NULL,
  `kode_petugas_keluar` varchar(30) DEFAULT NULL,
  `kode_jenis` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `parkir`
--

INSERT INTO `parkir` (`kode_parkir`, `tanggal_masuk`, `tanggal_keluar`, `plat_nomor`, `kode_petugas_masuk`, `kode_petugas_keluar`, `kode_jenis`) VALUES
(1, 1638070488088, 1638080008447, 'BAUFA ', '1', '1', '1'),
(2, 1638075548726, 1638077429609, 'B 089 UDJ', '1', '1', '2'),
(3, 1638075902165, 1638076121380, '089520123131', '1', '1', '1'),
(4, 1638079580693, 1638080047328, 'B 347 YUT', '18', '1', '1');

-- --------------------------------------------------------

--
-- Struktur dari tabel `petugas`
--

CREATE TABLE `petugas` (
  `kode_petugas` int(20) NOT NULL,
  `nama_pegawai` varchar(30) NOT NULL,
  `shift` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `petugas`
--

INSERT INTO `petugas` (`kode_petugas`, `nama_pegawai`, `shift`) VALUES
(1, 'Qemal', 'malam'),
(15, 'Alip', 'malam'),
(16, 'Farhan', 'siang'),
(17, 'Rizky', 'malam'),
(18, 'Jawir', 'siang'),
(19, 'Nopal', 'siang');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `jenis_kendaraan`
--
ALTER TABLE `jenis_kendaraan`
  ADD PRIMARY KEY (`kode_jenis`);

--
-- Indeks untuk tabel `parkir`
--
ALTER TABLE `parkir`
  ADD PRIMARY KEY (`kode_parkir`);

--
-- Indeks untuk tabel `petugas`
--
ALTER TABLE `petugas`
  ADD PRIMARY KEY (`kode_petugas`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `jenis_kendaraan`
--
ALTER TABLE `jenis_kendaraan`
  MODIFY `kode_jenis` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT untuk tabel `parkir`
--
ALTER TABLE `parkir`
  MODIFY `kode_parkir` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT untuk tabel `petugas`
--
ALTER TABLE `petugas`
  MODIFY `kode_petugas` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
