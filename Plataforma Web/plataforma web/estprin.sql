-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 10, 2020 at 06:12 PM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.3.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `estprin`
--
CREATE DATABASE IF NOT EXISTS `estprin` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `estprin`;

-- --------------------------------------------------------

--
-- Table structure for table `auth_group`
--

CREATE TABLE IF NOT EXISTS `auth_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(150) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `auth_group`
--

INSERT INTO `auth_group` (`id`, `name`) VALUES
(2, 'cajero'),
(4, 'duenho'),
(3, 'usuario_final');

-- --------------------------------------------------------

--
-- Table structure for table `auth_group_permissions`
--

CREATE TABLE IF NOT EXISTS `auth_group_permissions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `group_id` int(11) NOT NULL,
  `permission_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `auth_group_permissions_group_id_permission_id_0cd325b0_uniq` (`group_id`,`permission_id`),
  KEY `auth_group_permissio_permission_id_84c5c92e_fk_auth_perm` (`permission_id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `auth_group_permissions`
--

INSERT INTO `auth_group_permissions` (`id`, `group_id`, `permission_id`) VALUES
(1, 2, 2),
(2, 2, 4),
(3, 2, 8),
(4, 2, 12),
(5, 2, 16),
(6, 2, 20),
(7, 2, 24),
(8, 2, 28),
(9, 2, 32),
(10, 2, 33),
(11, 2, 36),
(12, 2, 40),
(13, 2, 44),
(14, 2, 48),
(15, 2, 52),
(16, 2, 53),
(17, 2, 56),
(18, 2, 60),
(19, 2, 61),
(20, 2, 64),
(23, 3, 4),
(25, 3, 8),
(27, 3, 12),
(30, 3, 16),
(33, 3, 20),
(35, 3, 24),
(29, 3, 28),
(37, 3, 30),
(22, 3, 32),
(24, 3, 36),
(26, 3, 40),
(28, 3, 44),
(31, 3, 48),
(32, 3, 52),
(34, 3, 56),
(36, 3, 60),
(21, 3, 64);

-- --------------------------------------------------------

--
-- Table structure for table `auth_permission`
--

CREATE TABLE IF NOT EXISTS `auth_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `content_type_id` int(11) NOT NULL,
  `codename` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `auth_permission_content_type_id_codename_01ab375a_uniq` (`content_type_id`,`codename`)
) ENGINE=InnoDB AUTO_INCREMENT=85 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `auth_permission`
--

INSERT INTO `auth_permission` (`id`, `name`, `content_type_id`, `codename`) VALUES
(1, 'Can add user', 1, 'add_customuser'),
(2, 'Can change user', 1, 'change_customuser'),
(3, 'Can delete user', 1, 'delete_customuser'),
(4, 'Can view user', 1, 'view_customuser'),
(5, 'Can add cliente', 2, 'add_cliente'),
(6, 'Can change cliente', 2, 'change_cliente'),
(7, 'Can delete cliente', 2, 'delete_cliente'),
(8, 'Can view cliente', 2, 'view_cliente'),
(9, 'Can add genero', 3, 'add_genero'),
(10, 'Can change genero', 3, 'change_genero'),
(11, 'Can delete genero', 3, 'delete_genero'),
(12, 'Can view genero', 3, 'view_genero'),
(13, 'Can add roles clientes', 4, 'add_rolesclientes'),
(14, 'Can change roles clientes', 4, 'change_rolesclientes'),
(15, 'Can delete roles clientes', 4, 'delete_rolesclientes'),
(16, 'Can view roles clientes', 4, 'view_rolesclientes'),
(17, 'Can add sucursal', 5, 'add_sucursal'),
(18, 'Can change sucursal', 5, 'change_sucursal'),
(19, 'Can delete sucursal', 5, 'delete_sucursal'),
(20, 'Can view sucursal', 5, 'view_sucursal'),
(21, 'Can add sucursal cliente', 6, 'add_sucursalcliente'),
(22, 'Can change sucursal cliente', 6, 'change_sucursalcliente'),
(23, 'Can delete sucursal cliente', 6, 'delete_sucursalcliente'),
(24, 'Can view sucursal cliente', 6, 'view_sucursalcliente'),
(25, 'Can add tipo telefono', 7, 'add_tipotelefono'),
(26, 'Can change tipo telefono', 7, 'change_tipotelefono'),
(27, 'Can delete tipo telefono', 7, 'delete_tipotelefono'),
(28, 'Can view tipo telefono', 7, 'view_tipotelefono'),
(29, 'Can add usuario final', 8, 'add_usuariofinal'),
(30, 'Can change usuario final', 8, 'change_usuariofinal'),
(31, 'Can delete usuario final', 8, 'delete_usuariofinal'),
(32, 'Can view usuario final', 8, 'view_usuariofinal'),
(33, 'Can add token', 9, 'add_token'),
(34, 'Can change token', 9, 'change_token'),
(35, 'Can delete token', 9, 'delete_token'),
(36, 'Can view token', 9, 'view_token'),
(37, 'Can add telefonos ususarios', 10, 'add_telefonosususarios'),
(38, 'Can change telefonos ususarios', 10, 'change_telefonosususarios'),
(39, 'Can delete telefonos ususarios', 10, 'delete_telefonosususarios'),
(40, 'Can view telefonos ususarios', 10, 'view_telefonosususarios'),
(41, 'Can add telefonos sucursales', 11, 'add_telefonossucursales'),
(42, 'Can change telefonos sucursales', 11, 'change_telefonossucursales'),
(43, 'Can delete telefonos sucursales', 11, 'delete_telefonossucursales'),
(44, 'Can view telefonos sucursales', 11, 'view_telefonossucursales'),
(45, 'Can add telefonos clientes', 12, 'add_telefonosclientes'),
(46, 'Can change telefonos clientes', 12, 'change_telefonosclientes'),
(47, 'Can delete telefonos clientes', 12, 'delete_telefonosclientes'),
(48, 'Can view telefonos clientes', 12, 'view_telefonosclientes'),
(49, 'Can add meta', 13, 'add_meta'),
(50, 'Can change meta', 13, 'change_meta'),
(51, 'Can delete meta', 13, 'delete_meta'),
(52, 'Can view meta', 13, 'view_meta'),
(53, 'Can add canje', 14, 'add_canje'),
(54, 'Can change canje', 14, 'change_canje'),
(55, 'Can delete canje', 14, 'delete_canje'),
(56, 'Can view canje', 14, 'view_canje'),
(57, 'Can add campana', 15, 'add_campana'),
(58, 'Can change campana', 15, 'change_campana'),
(59, 'Can delete campana', 15, 'delete_campana'),
(60, 'Can view campana', 15, 'view_campana'),
(61, 'Can add canjetoken', 16, 'add_canjetoken'),
(62, 'Can change canjetoken', 16, 'change_canjetoken'),
(63, 'Can delete canjetoken', 16, 'delete_canjetoken'),
(64, 'Can view canjetoken', 16, 'view_canjetoken'),
(65, 'Can add log entry', 17, 'add_logentry'),
(66, 'Can change log entry', 17, 'change_logentry'),
(67, 'Can delete log entry', 17, 'delete_logentry'),
(68, 'Can view log entry', 17, 'view_logentry'),
(69, 'Can add permission', 18, 'add_permission'),
(70, 'Can change permission', 18, 'change_permission'),
(71, 'Can delete permission', 18, 'delete_permission'),
(72, 'Can view permission', 18, 'view_permission'),
(73, 'Can add group', 19, 'add_group'),
(74, 'Can change group', 19, 'change_group'),
(75, 'Can delete group', 19, 'delete_group'),
(76, 'Can view group', 19, 'view_group'),
(77, 'Can add content type', 20, 'add_contenttype'),
(78, 'Can change content type', 20, 'change_contenttype'),
(79, 'Can delete content type', 20, 'delete_contenttype'),
(80, 'Can view content type', 20, 'view_contenttype'),
(81, 'Can add session', 21, 'add_session'),
(82, 'Can change session', 21, 'change_session'),
(83, 'Can delete session', 21, 'delete_session'),
(84, 'Can view session', 21, 'view_session');

-- --------------------------------------------------------

--
-- Table structure for table `campana`
--

CREATE TABLE IF NOT EXISTS `campana` (
  `id_campana` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) NOT NULL,
  `fechaInicio` datetime(6) NOT NULL,
  `duracion` int(11) NOT NULL,
  `target` varchar(300) DEFAULT NULL,
  `sucursal` int(11) NOT NULL,
  PRIMARY KEY (`id_campana`),
  KEY `campana_sucursal_7d5ea620_fk_sucursal_id_local` (`sucursal`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `canje`
--

CREATE TABLE IF NOT EXISTS `canje` (
  `id_canje` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` datetime(6) NOT NULL,
  `cajero` int(11) NOT NULL,
  `meta` int(11) NOT NULL,
  `sucursal` int(11) NOT NULL,
  `usuario` int(11) NOT NULL,
  PRIMARY KEY (`id_canje`),
  KEY `canje_cajero_4a87be2b_fk_cliente_id_cliente` (`cajero`),
  KEY `canje_meta_21ddb9e3_fk_meta_id_meta` (`meta`),
  KEY `canje_sucursal_03b8c399_fk_sucursal_id_local` (`sucursal`),
  KEY `canje_usuario_8c171763_fk_usuario_final_id_usufinal` (`usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `canjetoken`
--

CREATE TABLE IF NOT EXISTS `canjetoken` (
  `usuario` int(11) NOT NULL,
  `fecha` datetime(6) NOT NULL,
  `token` int(11) NOT NULL,
  PRIMARY KEY (`usuario`),
  UNIQUE KEY `canjetoken_usuario_token_991bd0c2_uniq` (`usuario`,`token`),
  KEY `canjetoken_token_daed890a_fk_token_id_token` (`token`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `cliente`
--

CREATE TABLE IF NOT EXISTS `cliente` (
  `id_cliente` int(11) NOT NULL AUTO_INCREMENT,
  `plan` int(11) NOT NULL,
  `cuser_id` int(11) NOT NULL,
  `rol` int(11) NOT NULL,
  PRIMARY KEY (`id_cliente`),
  UNIQUE KEY `cuser_id` (`cuser_id`),
  KEY `cliente_rol_e2e49898_fk_roles_clientes_id_rol` (`rol`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cliente`
--

INSERT INTO `cliente` (`id_cliente`, `plan`, `cuser_id`, `rol`) VALUES
(1, 1, 1, 1),
(2, 1, 5, 1);

-- --------------------------------------------------------

--
-- Table structure for table `django_admin_log`
--

CREATE TABLE IF NOT EXISTS `django_admin_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `action_time` datetime(6) NOT NULL,
  `object_id` longtext,
  `object_repr` varchar(200) NOT NULL,
  `action_flag` smallint(5) UNSIGNED NOT NULL,
  `change_message` longtext NOT NULL,
  `content_type_id` int(11) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `django_admin_log_content_type_id_c4bce8eb_fk_django_co` (`content_type_id`),
  KEY `django_admin_log_user_id_c564eba6_fk_main_customuser_id` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `django_admin_log`
--

INSERT INTO `django_admin_log` (`id`, `action_time`, `object_id`, `object_repr`, `action_flag`, `change_message`, `content_type_id`, `user_id`) VALUES
(1, '2019-10-17 18:30:14.790363', '1', 'caje', 1, '[{\"added\": {}}]', 19, 1),
(2, '2019-10-17 18:30:20.243599', '1', 'caje', 3, '', 19, 1),
(3, '2019-10-17 18:31:58.239066', '2', 'cajero', 1, '[{\"added\": {}}]', 19, 1),
(4, '2019-10-17 18:32:40.819362', '3', 'usuario_final', 1, '[{\"added\": {}}]', 19, 1),
(5, '2019-10-17 18:34:12.996930', '4', 'duenho', 1, '[{\"added\": {}}]', 19, 1),
(6, '2019-10-17 18:36:37.476626', '1', 'carlosffm', 2, '[{\"changed\": {\"fields\": [\"first_name\", \"last_name\", \"user_permissions\"]}}]', 1, 1),
(7, '2019-10-17 21:26:41.497451', '1', 'Cliente: carlosffm', 1, '[{\"added\": {}}]', 8, 1),
(8, '2019-10-17 21:41:42.043026', '1', 'RolesClientes object (1)', 1, '[{\"added\": {}}]', 4, 1),
(9, '2019-10-17 21:42:29.672514', '1', 'Cliente: carlosffm', 1, '[{\"added\": {}}]', 2, 1),
(10, '2019-10-17 21:46:16.453452', '1', 'Sucursal object (1)', 1, '[{\"added\": {}}]', 5, 1),
(11, '2019-10-31 16:44:12.106265', '1', 'SucursalCliente object (1)', 1, '[{\"added\": {}}]', 6, 1),
(12, '2019-10-31 16:44:21.188899', '1', 'Token object (1)', 1, '[{\"added\": {}}]', 9, 1),
(13, '2019-10-31 18:02:22.738013', '2', 'Sucursal object (2)', 1, '[{\"added\": {}}]', 5, 1),
(14, '2019-10-31 18:02:34.186048', '2', 'SucursalCliente object (2)', 1, '[{\"added\": {}}]', 6, 1),
(15, '2019-10-31 18:02:50.381815', '2', 'Token object (2)', 1, '[{\"added\": {}}]', 9, 1),
(16, '2019-10-31 18:02:56.918608', '3', 'Token object (3)', 1, '[{\"added\": {}}]', 9, 1),
(17, '2019-11-08 19:28:14.661757', '1', 'carlosffm', 2, '[{\"changed\": {\"fields\": [\"cedula_ruc\", \"profile_pic\"]}}]', 1, 1),
(18, '2019-11-08 19:30:10.726559', '1', 'carlosffm', 2, '[{\"changed\": {\"fields\": [\"profile_pic\"]}}]', 1, 1),
(19, '2019-12-06 14:57:27.091019', '2', 'TestUser', 3, '', 1, 1),
(20, '2019-12-06 14:58:32.526015', '3', 'TestUser', 1, '[{\"added\": {}}]', 1, 1),
(21, '2019-12-06 14:59:32.904208', '3', 'TestUser', 2, '[{\"changed\": {\"fields\": [\"profile_pic\"]}}]', 1, 1),
(22, '2019-12-06 15:05:47.767530', '1', 'TipoTelefono object (1)', 1, '[{\"added\": {}}]', 7, 1),
(23, '2019-12-06 15:05:51.470338', '2', 'TipoTelefono object (2)', 1, '[{\"added\": {}}]', 7, 1),
(24, '2019-12-06 15:05:56.402474', '3', 'TipoTelefono object (3)', 1, '[{\"added\": {}}]', 7, 1),
(25, '2019-12-07 00:24:37.881260', '3', 'TestUser', 3, '', 1, 1),
(26, '2019-12-07 19:28:55.526836', '2', 'Otra sucursal', 2, '[{\"changed\": {\"fields\": [\"imagenTkn\"]}}]', 5, 1),
(27, '2019-12-07 19:29:13.961966', '1', 'Prueba 1', 2, '[{\"changed\": {\"fields\": [\"imagenTkn\"]}}]', 5, 1),
(28, '2019-12-07 20:49:53.178730', '2', 'Cliente: oscar', 1, '[{\"added\": {}}]', 2, 1),
(29, '2019-12-07 20:51:51.749209', '5', 'prueba oscar', 1, '[{\"added\": {}}]', 5, 1),
(30, '2019-12-07 20:53:31.367160', '5', 'prueba oscar', 2, '[{\"changed\": {\"fields\": [\"imagenTkn\"]}}]', 5, 1),
(31, '2019-12-07 20:55:58.761368', '7', 'otrasucursalmas', 1, '[{\"added\": {}}]', 5, 1);

-- --------------------------------------------------------

--
-- Table structure for table `django_content_type`
--

CREATE TABLE IF NOT EXISTS `django_content_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `app_label` varchar(100) NOT NULL,
  `model` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `django_content_type_app_label_model_76bd3d3b_uniq` (`app_label`,`model`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `django_content_type`
--

INSERT INTO `django_content_type` (`id`, `app_label`, `model`) VALUES
(17, 'admin', 'logentry'),
(19, 'auth', 'group'),
(18, 'auth', 'permission'),
(20, 'contenttypes', 'contenttype'),
(15, 'main', 'campana'),
(14, 'main', 'canje'),
(16, 'main', 'canjetoken'),
(2, 'main', 'cliente'),
(1, 'main', 'customuser'),
(3, 'main', 'genero'),
(13, 'main', 'meta'),
(4, 'main', 'rolesclientes'),
(5, 'main', 'sucursal'),
(6, 'main', 'sucursalcliente'),
(12, 'main', 'telefonosclientes'),
(11, 'main', 'telefonossucursales'),
(10, 'main', 'telefonosususarios'),
(7, 'main', 'tipotelefono'),
(9, 'main', 'token'),
(8, 'main', 'usuariofinal'),
(21, 'sessions', 'session');

-- --------------------------------------------------------

--
-- Table structure for table `django_migrations`
--

CREATE TABLE IF NOT EXISTS `django_migrations` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `app` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `applied` datetime(6) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `django_migrations`
--

INSERT INTO `django_migrations` (`id`, `app`, `name`, `applied`) VALUES
(1, 'contenttypes', '0001_initial', '2019-10-17 18:23:46.678598'),
(2, 'contenttypes', '0002_remove_content_type_name', '2019-10-17 18:23:47.415476'),
(3, 'auth', '0001_initial', '2019-10-17 18:23:47.988799'),
(4, 'auth', '0002_alter_permission_name_max_length', '2019-10-17 18:23:50.162533'),
(5, 'auth', '0003_alter_user_email_max_length', '2019-10-17 18:23:50.196595'),
(6, 'auth', '0004_alter_user_username_opts', '2019-10-17 18:23:50.234124'),
(7, 'auth', '0005_alter_user_last_login_null', '2019-10-17 18:23:50.263194'),
(8, 'auth', '0006_require_contenttypes_0002', '2019-10-17 18:23:50.294265'),
(9, 'auth', '0007_alter_validators_add_error_messages', '2019-10-17 18:23:50.328593'),
(10, 'auth', '0008_alter_user_username_max_length', '2019-10-17 18:23:50.365898'),
(11, 'auth', '0009_alter_user_last_name_max_length', '2019-10-17 18:23:50.402295'),
(12, 'auth', '0010_alter_group_name_max_length', '2019-10-17 18:23:51.918134'),
(13, 'auth', '0011_update_proxy_permissions', '2019-10-17 18:23:51.969344'),
(14, 'main', '0001_initial', '2019-10-17 18:23:56.416295'),
(15, 'admin', '0001_initial', '2019-10-17 18:24:19.344654'),
(16, 'admin', '0002_logentry_remove_auto_add', '2019-10-17 18:24:20.462126'),
(17, 'admin', '0003_logentry_add_action_flag_choices', '2019-10-17 18:24:20.499319'),
(18, 'sessions', '0001_initial', '2019-10-17 18:24:21.021835'),
(19, 'main', '0002_auto_20191108_1335', '2019-11-08 18:36:08.384525'),
(20, 'main', '0003_auto_20191108_1347', '2019-11-08 18:47:48.955421'),
(21, 'main', '0004_auto_20191108_1351', '2019-11-08 18:51:11.003725'),
(22, 'main', '0005_auto_20191108_1413', '2019-11-08 19:13:23.708805'),
(23, 'main', '0006_auto_20191206_1428', '2019-12-06 19:28:48.873166'),
(24, 'main', '0007_sucursalcliente_activo', '2019-12-06 21:07:03.953645'),
(25, 'main', '0008_auto_20191207_1554', '2019-12-07 20:54:47.896375'),
(26, 'main', '0009_auto_20191207_1555', '2019-12-07 20:55:38.649372'),
(27, 'main', '0010_auto_20191210_1330', '2019-12-10 18:30:09.087775');

-- --------------------------------------------------------

--
-- Table structure for table `django_session`
--

CREATE TABLE IF NOT EXISTS `django_session` (
  `session_key` varchar(40) NOT NULL,
  `session_data` longtext NOT NULL,
  `expire_date` datetime(6) NOT NULL,
  PRIMARY KEY (`session_key`),
  KEY `django_session_expire_date_a5c62663` (`expire_date`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `django_session`
--

INSERT INTO `django_session` (`session_key`, `session_data`, `expire_date`) VALUES
('6ifdmeq8hhd1vrrc6h5pe9osr7r3j7mx', 'YWY1YWQwMTBhMDNkNGI0MWNhMWRhZTA1MmM1OWI3MDdlNmZkNjA2Mzp7fQ==', '2019-12-20 20:29:51.980042'),
('a4zg1guomi6qm4au9g0o6bwfxmdokp0n', 'YWY1YWQwMTBhMDNkNGI0MWNhMWRhZTA1MmM1OWI3MDdlNmZkNjA2Mzp7fQ==', '2019-12-20 20:33:11.836546'),
('f82r8jn01wragnr2mcyyo6hdw9iy5nn8', 'YWY1YWQwMTBhMDNkNGI0MWNhMWRhZTA1MmM1OWI3MDdlNmZkNjA2Mzp7fQ==', '2019-12-20 20:39:08.274007'),
('jalv0tdzojw78iaa9tklkzv1jltzc0ts', 'YWY1YWQwMTBhMDNkNGI0MWNhMWRhZTA1MmM1OWI3MDdlNmZkNjA2Mzp7fQ==', '2019-12-20 20:36:27.115849'),
('js77sk3l9heeor1n1kq4mxsjw5p4ou6v', 'YWY1YWQwMTBhMDNkNGI0MWNhMWRhZTA1MmM1OWI3MDdlNmZkNjA2Mzp7fQ==', '2019-12-20 20:30:33.588441'),
('ksjgtyi3jgeqe445y1u224sfubt2a1ut', 'YWY1YWQwMTBhMDNkNGI0MWNhMWRhZTA1MmM1OWI3MDdlNmZkNjA2Mzp7fQ==', '2019-12-20 20:38:48.274117');

-- --------------------------------------------------------

--
-- Table structure for table `genero`
--

CREATE TABLE IF NOT EXISTS `genero` (
  `id_genero` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id_genero`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `main_customuser`
--

CREATE TABLE IF NOT EXISTS `main_customuser` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(128) NOT NULL,
  `last_login` datetime(6) DEFAULT NULL,
  `is_superuser` tinyint(1) NOT NULL,
  `username` varchar(150) NOT NULL,
  `first_name` varchar(30) NOT NULL,
  `last_name` varchar(150) NOT NULL,
  `is_staff` tinyint(1) NOT NULL,
  `is_active` tinyint(1) NOT NULL,
  `date_joined` datetime(6) NOT NULL,
  `email` varchar(254) NOT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `genero` int(11) DEFAULT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  `cedula_ruc` varchar(13) NOT NULL,
  `razon_soc` varchar(50) NOT NULL,
  `profile_pic` varchar(100) NOT NULL,
  `is_cliente` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `cedula_ruc` (`cedula_ruc`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `main_customuser`
--

INSERT INTO `main_customuser` (`id`, `password`, `last_login`, `is_superuser`, `username`, `first_name`, `last_name`, `is_staff`, `is_active`, `date_joined`, `email`, `fecha_nacimiento`, `genero`, `direccion`, `cedula_ruc`, `razon_soc`, `profile_pic`, `is_cliente`) VALUES
(1, 'pbkdf2_sha256$150000$WcxvH1UHadGO$+llnixBDhQPKAqa6MoaO4fiz0YXFbX8W0Mgq8I05ocU=', '2020-01-09 21:42:23.898813', 1, 'carlosffm', 'Carlos', 'Flores', 1, 1, '2019-10-17 18:27:41.000000', 'carlosffm2198@gmail.com', '1998-07-21', NULL, 'Guayacanes Mz 33 V 10', '0923085955', '9999999999', 'profile_pics/Call_of_Duty_Screenshot_2019.10.14_02.38.37.jpg', 1),
(4, 'pbkdf2_sha256$150000$7kDbJZKx1zED$gkVDBdRucB0rnxB3YZ/CDdP7PyEdVWJfMpnsaA0B4jw=', '2019-12-07 00:25:53.754484', 0, 'TestUser', 'Test', 'User', 0, 1, '2019-12-07 00:25:23.410523', 'test@company.com', '1998-01-01', NULL, NULL, '0999999998', 'Cliente Final', 'profile_pics/default.jpg', 0),
(5, 'pbkdf2_sha256$150000$Jcx5AMurKV3A$EASdI3whqwS9tuhtH3mut4eWZKBQocjKA8hrkP4m204=', '2019-12-07 20:56:19.215894', 0, 'oscar', 'Oscar', 'Avila', 0, 1, '2019-12-07 20:40:18.590366', 'avila.oscar98@hotmail.com', '1998-02-17', NULL, NULL, '0923018964', 'Cliente Final', 'profile_pics/default.jpg', 1),
(6, 'pbkdf2_sha256$150000$ltCkdKsBAuir$dswREbgw8D9Xpo510ZyIEGIHEKY1xo2UShe/7eO3E44=', NULL, 0, 'ljahakj', 'kjhsfs', 'fsajdhf', 0, 1, '2020-01-09 22:01:26.058372', 'fdasdsaaf@jflan.com', '1998-01-01', NULL, NULL, '0988877790', 'Cliente Final', 'profile_pics/default.jpg', 0);

-- --------------------------------------------------------

--
-- Table structure for table `main_customuser_groups`
--

CREATE TABLE IF NOT EXISTS `main_customuser_groups` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customuser_id` int(11) NOT NULL,
  `group_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `main_customuser_groups_customuser_id_group_id_8a5023dd_uniq` (`customuser_id`,`group_id`),
  KEY `main_customuser_groups_group_id_8149f607_fk_auth_group_id` (`group_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `main_customuser_groups`
--

INSERT INTO `main_customuser_groups` (`id`, `customuser_id`, `group_id`) VALUES
(2, 4, 3),
(3, 6, 3);

-- --------------------------------------------------------

--
-- Table structure for table `main_customuser_user_permissions`
--

CREATE TABLE IF NOT EXISTS `main_customuser_user_permissions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customuser_id` int(11) NOT NULL,
  `permission_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `main_customuser_user_per_customuser_id_permission_06a652d8_uniq` (`customuser_id`,`permission_id`),
  KEY `main_customuser_user_permission_id_38e6f657_fk_auth_perm` (`permission_id`)
) ENGINE=InnoDB AUTO_INCREMENT=85 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `main_customuser_user_permissions`
--

INSERT INTO `main_customuser_user_permissions` (`id`, `customuser_id`, `permission_id`) VALUES
(1, 1, 1),
(2, 1, 2),
(3, 1, 3),
(4, 1, 4),
(5, 1, 5),
(6, 1, 6),
(7, 1, 7),
(8, 1, 8),
(9, 1, 9),
(10, 1, 10),
(11, 1, 11),
(12, 1, 12),
(13, 1, 13),
(14, 1, 14),
(15, 1, 15),
(16, 1, 16),
(17, 1, 17),
(18, 1, 18),
(19, 1, 19),
(20, 1, 20),
(21, 1, 21),
(22, 1, 22),
(23, 1, 23),
(24, 1, 24),
(25, 1, 25),
(26, 1, 26),
(27, 1, 27),
(28, 1, 28),
(29, 1, 29),
(30, 1, 30),
(31, 1, 31),
(32, 1, 32),
(33, 1, 33),
(34, 1, 34),
(35, 1, 35),
(36, 1, 36),
(37, 1, 37),
(38, 1, 38),
(39, 1, 39),
(40, 1, 40),
(41, 1, 41),
(42, 1, 42),
(43, 1, 43),
(44, 1, 44),
(45, 1, 45),
(46, 1, 46),
(47, 1, 47),
(48, 1, 48),
(49, 1, 49),
(50, 1, 50),
(51, 1, 51),
(52, 1, 52),
(53, 1, 53),
(54, 1, 54),
(55, 1, 55),
(56, 1, 56),
(57, 1, 57),
(58, 1, 58),
(59, 1, 59),
(60, 1, 60),
(61, 1, 61),
(62, 1, 62),
(63, 1, 63),
(64, 1, 64),
(65, 1, 65),
(66, 1, 66),
(67, 1, 67),
(68, 1, 68),
(69, 1, 69),
(70, 1, 70),
(71, 1, 71),
(72, 1, 72),
(73, 1, 73),
(74, 1, 74),
(75, 1, 75),
(76, 1, 76),
(77, 1, 77),
(78, 1, 78),
(79, 1, 79),
(80, 1, 80),
(81, 1, 81),
(82, 1, 82),
(83, 1, 83),
(84, 1, 84);

-- --------------------------------------------------------

--
-- Table structure for table `meta`
--

CREATE TABLE IF NOT EXISTS `meta` (
  `id_meta` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `descripcion` varchar(300) DEFAULT NULL,
  `tokens` int(11) NOT NULL,
  `activa` int(11) NOT NULL,
  `cliente` int(11) NOT NULL,
  PRIMARY KEY (`id_meta`),
  KEY `meta_cliente_5f87cdde_fk_cliente_id_cliente` (`cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `roles_clientes`
--

CREATE TABLE IF NOT EXISTS `roles_clientes` (
  `id_rol` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id_rol`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `roles_clientes`
--

INSERT INTO `roles_clientes` (`id_rol`, `descripcion`) VALUES
(1, 'Dueño');

-- --------------------------------------------------------

--
-- Table structure for table `sucursal`
--

CREATE TABLE IF NOT EXISTS `sucursal` (
  `id_local` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `direccion` varchar(150) NOT NULL,
  `correo` varchar(150) DEFAULT NULL,
  `imagenTkn` varchar(100) NOT NULL,
  `propietario` int(11) NOT NULL,
  PRIMARY KEY (`id_local`),
  UNIQUE KEY `direccion` (`direccion`),
  KEY `sucursal_propietario_43cba6ce_fk_cliente_id_cliente` (`propietario`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sucursal`
--

INSERT INTO `sucursal` (`id_local`, `nombre`, `direccion`, `correo`, `imagenTkn`, `propietario`) VALUES
(1, 'Prueba 1', 'Calle 1', NULL, 'token_pics/gaugan_input_4.png', 1),
(2, 'Otra sucursal', 'fkldsh', 'calda@fldka.com', 'token_pics/Call_of_Duty_Screenshot_2019.10.14_02.38.37.jpg', 1),
(5, 'prueba oscar', 'centro', NULL, 'token_pics/Gambaru_Mesa-de-trabajo-1_76.png', 2),
(7, 'otrasucursalmas', 'sur', NULL, 'token_pics/default.png', 2),
(8, 'PruebaClass', 'ESPOL', 'pic@company.com', 'token_pics/default.png', 1),
(9, 'PruebaClass2', 'ESPOL - Biblio', 'pic2@company.com', 'token_pics/default.png', 1),
(10, 'PruebaClass3', 'ESPOL - Biblio - Abajo', 'pic3@company.com', 'token_pics/default.png', 1),
(11, 'PruebaClassRedirect', 'ESPOL - Biblio - Abajo - Atras', 'pic4@company.com', 'token_pics/default.png', 1),
(12, 'PruebaClassFinal', 'otro lugar', 'adas@company.com', 'token_pics/default.png', 1),
(13, 'PruebaClassFinalFinal', 'otro lugar 2', 'adasds@company.com', 'token_pics/default.png', 1),
(14, 'PruebaClassFinalFinalFinal', 'otro lugar 3', 'adasdslj@company.com', 'token_pics/default.png', 1),
(15, 'PruebaClassRedirectFinal', 'falkjf', 'fsdfaa@company.com', 'token_pics/default.png', 1),
(16, 'PruebaReverse', 'flafa', 'fajslfaj@comany.com', 'token_pics/default.png', 1),
(17, 'PruebaReversePK', 'flafaddsad', 'fajsldsfaj@comany.com', 'token_pics/default.png', 1),
(18, 'PruebaReversePKs', 'fldjfald', 'fladflkja@sfed.com', 'token_pics/default.png', 1),
(19, 'PruebaClass', 'SAUCES', 'loquesea@company.com', 'token_pics/default.png', 1);

-- --------------------------------------------------------

--
-- Table structure for table `sucursal_cliente`
--

CREATE TABLE IF NOT EXISTS `sucursal_cliente` (
  `id_cajero` int(11) NOT NULL AUTO_INCREMENT,
  `cliente` int(11) NOT NULL,
  `sucursal` int(11) NOT NULL,
  `activo` tinyint(1) NOT NULL,
  PRIMARY KEY (`id_cajero`),
  KEY `sucursal_cliente_cliente_194b6788_fk_cliente_id_cliente` (`cliente`),
  KEY `sucursal_cliente_sucursal_6914bca3_fk_sucursal_id_local` (`sucursal`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sucursal_cliente`
--

INSERT INTO `sucursal_cliente` (`id_cajero`, `cliente`, `sucursal`, `activo`) VALUES
(1, 1, 1, 1),
(2, 1, 2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `telefonos_clientes`
--

CREATE TABLE IF NOT EXISTS `telefonos_clientes` (
  `id_telefono` int(11) NOT NULL AUTO_INCREMENT,
  `numero` varchar(14) NOT NULL,
  `propietario` int(11) NOT NULL,
  `tipo_telefono` int(11) NOT NULL,
  PRIMARY KEY (`id_telefono`),
  UNIQUE KEY `numero` (`numero`),
  KEY `telefonos_clientes_propietario_138cbb66_fk_cliente_id_cliente` (`propietario`),
  KEY `telefonos_clientes_tipo_telefono_ca401f71_fk_tipo_telefono_cod` (`tipo_telefono`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `telefonos_clientes`
--

INSERT INTO `telefonos_clientes` (`id_telefono`, `numero`, `propietario`, `tipo_telefono`) VALUES
(1, '0999063646', 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `telefonos_sucursales`
--

CREATE TABLE IF NOT EXISTS `telefonos_sucursales` (
  `id_telefono` int(11) NOT NULL AUTO_INCREMENT,
  `numero` varchar(14) NOT NULL,
  `propietario` int(11) NOT NULL,
  `tipo_telefono` int(11) NOT NULL,
  PRIMARY KEY (`id_telefono`),
  UNIQUE KEY `numero` (`numero`),
  KEY `telefonos_sucursales_propietario_4e450954_fk_sucursal_id_local` (`propietario`),
  KEY `telefonos_sucursales_tipo_telefono_afafeaf3_fk_tipo_telefono_cod` (`tipo_telefono`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `telefonos_ususarios`
--

CREATE TABLE IF NOT EXISTS `telefonos_ususarios` (
  `id_telefono` int(11) NOT NULL AUTO_INCREMENT,
  `numero` varchar(14) NOT NULL,
  `tipo_telefono` int(11) NOT NULL,
  `usuario` int(11) NOT NULL,
  PRIMARY KEY (`id_telefono`),
  UNIQUE KEY `numero` (`numero`),
  KEY `telefonos_ususarios_tipo_telefono_dc9faa39_fk_tipo_telefono_cod` (`tipo_telefono`),
  KEY `telefonos_ususarios_usuario_668de92d_fk_usuario_f` (`usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `telefonos_ususarios`
--

INSERT INTO `telefonos_ususarios` (`id_telefono`, `numero`, `tipo_telefono`, `usuario`) VALUES
(1, '0999063646', 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `tipo_telefono`
--

CREATE TABLE IF NOT EXISTS `tipo_telefono` (
  `cod` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(20) NOT NULL,
  PRIMARY KEY (`cod`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tipo_telefono`
--

INSERT INTO `tipo_telefono` (`cod`, `descripcion`) VALUES
(1, 'Casa'),
(2, 'Celular'),
(3, 'Local');

-- --------------------------------------------------------

--
-- Table structure for table `token`
--

CREATE TABLE IF NOT EXISTS `token` (
  `id_token` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` datetime(6) NOT NULL,
  `cajero` int(11) NOT NULL,
  `usuario` int(11) NOT NULL,
  PRIMARY KEY (`id_token`),
  KEY `token_cajero_47e830a5_fk_sucursal_cliente_id_cajero` (`cajero`),
  KEY `token_usuario_0962a311_fk_usuario_final_id_usufinal` (`usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `token`
--

INSERT INTO `token` (`id_token`, `fecha`, `cajero`, `usuario`) VALUES
(1, '2019-10-31 16:44:21.145646', 1, 1),
(2, '2019-10-31 18:02:50.374821', 1, 1),
(3, '2019-10-31 18:02:56.911628', 2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `usuario_final`
--

CREATE TABLE IF NOT EXISTS `usuario_final` (
  `id_usufinal` int(11) NOT NULL AUTO_INCREMENT,
  `cuser_id` int(11) NOT NULL,
  PRIMARY KEY (`id_usufinal`),
  UNIQUE KEY `cuser_id` (`cuser_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `usuario_final`
--

INSERT INTO `usuario_final` (`id_usufinal`, `cuser_id`) VALUES
(1, 1);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `auth_group_permissions`
--
ALTER TABLE `auth_group_permissions`
  ADD CONSTRAINT `auth_group_permissio_permission_id_84c5c92e_fk_auth_perm` FOREIGN KEY (`permission_id`) REFERENCES `auth_permission` (`id`),
  ADD CONSTRAINT `auth_group_permissions_group_id_b120cbf9_fk_auth_group_id` FOREIGN KEY (`group_id`) REFERENCES `auth_group` (`id`);

--
-- Constraints for table `auth_permission`
--
ALTER TABLE `auth_permission`
  ADD CONSTRAINT `auth_permission_content_type_id_2f476e4b_fk_django_co` FOREIGN KEY (`content_type_id`) REFERENCES `django_content_type` (`id`);

--
-- Constraints for table `campana`
--
ALTER TABLE `campana`
  ADD CONSTRAINT `campana_sucursal_7d5ea620_fk_sucursal_id_local` FOREIGN KEY (`sucursal`) REFERENCES `sucursal` (`id_local`);

--
-- Constraints for table `canje`
--
ALTER TABLE `canje`
  ADD CONSTRAINT `canje_cajero_4a87be2b_fk_cliente_id_cliente` FOREIGN KEY (`cajero`) REFERENCES `cliente` (`id_cliente`),
  ADD CONSTRAINT `canje_meta_21ddb9e3_fk_meta_id_meta` FOREIGN KEY (`meta`) REFERENCES `meta` (`id_meta`),
  ADD CONSTRAINT `canje_sucursal_03b8c399_fk_sucursal_id_local` FOREIGN KEY (`sucursal`) REFERENCES `sucursal` (`id_local`),
  ADD CONSTRAINT `canje_usuario_8c171763_fk_usuario_final_id_usufinal` FOREIGN KEY (`usuario`) REFERENCES `usuario_final` (`id_usufinal`);

--
-- Constraints for table `canjetoken`
--
ALTER TABLE `canjetoken`
  ADD CONSTRAINT `canjetoken_token_daed890a_fk_token_id_token` FOREIGN KEY (`token`) REFERENCES `token` (`id_token`),
  ADD CONSTRAINT `canjetoken_usuario_85fd40d6_fk_usuario_final_id_usufinal` FOREIGN KEY (`usuario`) REFERENCES `usuario_final` (`id_usufinal`);

--
-- Constraints for table `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `cliente_cuser_id_39b71a0f_fk_main_customuser_id` FOREIGN KEY (`cuser_id`) REFERENCES `main_customuser` (`id`),
  ADD CONSTRAINT `cliente_rol_e2e49898_fk_roles_clientes_id_rol` FOREIGN KEY (`rol`) REFERENCES `roles_clientes` (`id_rol`);

--
-- Constraints for table `django_admin_log`
--
ALTER TABLE `django_admin_log`
  ADD CONSTRAINT `django_admin_log_content_type_id_c4bce8eb_fk_django_co` FOREIGN KEY (`content_type_id`) REFERENCES `django_content_type` (`id`),
  ADD CONSTRAINT `django_admin_log_user_id_c564eba6_fk_main_customuser_id` FOREIGN KEY (`user_id`) REFERENCES `main_customuser` (`id`);

--
-- Constraints for table `main_customuser_groups`
--
ALTER TABLE `main_customuser_groups`
  ADD CONSTRAINT `main_customuser_grou_customuser_id_13869e25_fk_main_cust` FOREIGN KEY (`customuser_id`) REFERENCES `main_customuser` (`id`),
  ADD CONSTRAINT `main_customuser_groups_group_id_8149f607_fk_auth_group_id` FOREIGN KEY (`group_id`) REFERENCES `auth_group` (`id`);

--
-- Constraints for table `main_customuser_user_permissions`
--
ALTER TABLE `main_customuser_user_permissions`
  ADD CONSTRAINT `main_customuser_user_customuser_id_34d37f86_fk_main_cust` FOREIGN KEY (`customuser_id`) REFERENCES `main_customuser` (`id`),
  ADD CONSTRAINT `main_customuser_user_permission_id_38e6f657_fk_auth_perm` FOREIGN KEY (`permission_id`) REFERENCES `auth_permission` (`id`);

--
-- Constraints for table `meta`
--
ALTER TABLE `meta`
  ADD CONSTRAINT `meta_cliente_5f87cdde_fk_cliente_id_cliente` FOREIGN KEY (`cliente`) REFERENCES `cliente` (`id_cliente`);

--
-- Constraints for table `sucursal`
--
ALTER TABLE `sucursal`
  ADD CONSTRAINT `sucursal_propietario_43cba6ce_fk_cliente_id_cliente` FOREIGN KEY (`propietario`) REFERENCES `cliente` (`id_cliente`);

--
-- Constraints for table `sucursal_cliente`
--
ALTER TABLE `sucursal_cliente`
  ADD CONSTRAINT `sucursal_cliente_cliente_194b6788_fk_cliente_id_cliente` FOREIGN KEY (`cliente`) REFERENCES `cliente` (`id_cliente`),
  ADD CONSTRAINT `sucursal_cliente_sucursal_6914bca3_fk_sucursal_id_local` FOREIGN KEY (`sucursal`) REFERENCES `sucursal` (`id_local`);

--
-- Constraints for table `telefonos_clientes`
--
ALTER TABLE `telefonos_clientes`
  ADD CONSTRAINT `telefonos_clientes_propietario_138cbb66_fk_cliente_id_cliente` FOREIGN KEY (`propietario`) REFERENCES `cliente` (`id_cliente`),
  ADD CONSTRAINT `telefonos_clientes_tipo_telefono_ca401f71_fk_tipo_telefono_cod` FOREIGN KEY (`tipo_telefono`) REFERENCES `tipo_telefono` (`cod`);

--
-- Constraints for table `telefonos_sucursales`
--
ALTER TABLE `telefonos_sucursales`
  ADD CONSTRAINT `telefonos_sucursales_propietario_4e450954_fk_sucursal_id_local` FOREIGN KEY (`propietario`) REFERENCES `sucursal` (`id_local`),
  ADD CONSTRAINT `telefonos_sucursales_tipo_telefono_afafeaf3_fk_tipo_telefono_cod` FOREIGN KEY (`tipo_telefono`) REFERENCES `tipo_telefono` (`cod`);

--
-- Constraints for table `telefonos_ususarios`
--
ALTER TABLE `telefonos_ususarios`
  ADD CONSTRAINT `telefonos_ususarios_tipo_telefono_dc9faa39_fk_tipo_telefono_cod` FOREIGN KEY (`tipo_telefono`) REFERENCES `tipo_telefono` (`cod`),
  ADD CONSTRAINT `telefonos_ususarios_usuario_668de92d_fk_usuario_f` FOREIGN KEY (`usuario`) REFERENCES `usuario_final` (`id_usufinal`);

--
-- Constraints for table `token`
--
ALTER TABLE `token`
  ADD CONSTRAINT `token_cajero_47e830a5_fk_sucursal_cliente_id_cajero` FOREIGN KEY (`cajero`) REFERENCES `sucursal_cliente` (`id_cajero`),
  ADD CONSTRAINT `token_usuario_0962a311_fk_usuario_final_id_usufinal` FOREIGN KEY (`usuario`) REFERENCES `usuario_final` (`id_usufinal`);

--
-- Constraints for table `usuario_final`
--
ALTER TABLE `usuario_final`
  ADD CONSTRAINT `usuario_final_cuser_id_3d231e50_fk_main_customuser_id` FOREIGN KEY (`cuser_id`) REFERENCES `main_customuser` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
