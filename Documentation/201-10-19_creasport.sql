-- phpMyAdmin SQL Dump
-- version 4.4.15.7
-- http://www.phpmyadmin.net
--
-- Client :  10.1.3.74
-- Généré le :  Mer 19 Octobre 2016 à 16:39
-- Version du serveur :  5.6.15-log
-- Version de PHP :  5.4.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `creasport`
--

-- --------------------------------------------------------

--
-- Structure de la table `articles`
--

CREATE TABLE IF NOT EXISTS `articles` (
  `ar_id` int(11) NOT NULL,
  `ar_ref` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `ar_nom` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `ar_isHC` tinyint(1) NOT NULL,
  `ar_description` text COLLATE utf8_unicode_ci,
  `ar_image` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ar_dateCreation` date DEFAULT NULL,
  `ar_isActif` tinyint(1) NOT NULL,
  `fa_id` int(11) NOT NULL,
  `mo_id` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Contenu de la table `articles`
--

INSERT INTO `articles` (`ar_id`, `ar_ref`, `ar_nom`, `ar_isHC`, `ar_description`, `ar_image`, `ar_dateCreation`, `ar_isActif`, `fa_id`, `mo_id`) VALUES
(1, 'test855', 'test8522', 0, NULL, NULL, NULL, 1, 1, 1),
(2, 'test89', 'test85', 0, NULL, NULL, NULL, 1, 1, 1),
(3, '', '', 0, NULL, NULL, NULL, 1, 1, 1),
(4, 'ssqsq', 'ssqsq', 0, NULL, NULL, NULL, 1, 1, 1),
(5, 'testajout', 'testajout', 0, NULL, NULL, NULL, 1, 2, 2),
(6, 'sqsqsq', 'sqqdqsd', 0, NULL, NULL, NULL, 1, 2, 3),
(7, 'sss', 'qaQ', 0, NULL, NULL, NULL, 1, 2, 3),
(8, 'test', 'ddddd', 0, NULL, NULL, NULL, 1, 1, 1),
(10, 'test25', 'sssss', 0, NULL, NULL, NULL, 1, 2, 3),
(11, 'reference1', 'decap1', 0, NULL, NULL, NULL, 1, 2, 2),
(12, 'r123456', 'n123', 0, NULL, NULL, NULL, 1, 2, 2),
(13, 'r1', 'n1', 0, NULL, NULL, NULL, 1, 2, 2),
(14, 'r2', 'n2', 0, NULL, NULL, NULL, 1, 2, 2),
(15, 'r3', 'n3', 0, NULL, NULL, NULL, 1, 1, 2),
(16, 'r4', 'n4', 0, NULL, NULL, NULL, 1, 1, 1),
(18, 'r5', 'n55', 0, NULL, NULL, NULL, 1, 2, 2),
(19, 'GERNOM12', 'DCEAP58', 0, NULL, NULL, NULL, 1, 2, 3),
(20, 'texts25', 'test86', 0, NULL, NULL, NULL, 1, 2, 2),
(21, 'sdqdqsd', 'qdqqdqdqddqsqdsqsd', 0, NULL, NULL, NULL, 1, 1, 1),
(23, 'CR241476801329964', 'zertuioo', 0, NULL, NULL, NULL, 1, 2, 4),
(24, 'CR231476869912529', 'Rose', 0, NULL, NULL, NULL, 1, 2, 3),
(25, 'CR221476870173964', 'Vert fluo', 0, NULL, NULL, NULL, 1, 2, 2),
(26, 'CR361476870338705', 'version 2016', 0, NULL, NULL, NULL, 1, 3, 6),
(27, 'CR231476870576639', 'test 2016', 0, NULL, NULL, NULL, 1, 2, 3),
(28, 'CR351476870883745', 'test ajout', 0, NULL, NULL, NULL, 1, 3, 5),
(29, 'CR321476871112925', 'dedee', 0, NULL, NULL, NULL, 1, 3, 2),
(30, 'CR221476871472551', 'test201523', 0, NULL, NULL, NULL, 1, 2, 2),
(31, 'CR241476871630271', 'decdddddd', 0, NULL, NULL, NULL, 1, 2, 4),
(32, 'CR111476871821136', 'ddeedsss', 0, NULL, NULL, NULL, 1, 1, 1),
(33, 'CR111476871892619', 'deeyiopp dsdhjsq', 0, NULL, NULL, NULL, 1, 1, 1),
(34, 'CR111476872365753', 'Test852369', 0, NULL, NULL, NULL, 1, 1, 1),
(35, 'CR331476885968956', 'anglirus noir', 0, NULL, NULL, NULL, 1, 3, 3);

-- --------------------------------------------------------

--
-- Structure de la table `destinataires`
--

CREATE TABLE IF NOT EXISTS `destinataires` (
  `de_id` int(11) NOT NULL,
  `de_ref` varchar(25) COLLATE utf8_unicode_ci NOT NULL,
  `de_nomClub` varchar(250) COLLATE utf8_unicode_ci NOT NULL,
  `de_nomContact` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `de_adresse1` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `de_adresse2` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `de_codePostal` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `de_ville` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `de_IsClient` tinyint(1) NOT NULL,
  `de_isActive` tinyint(1) NOT NULL,
  `pa_id` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Contenu de la table `destinataires`
--

INSERT INTO `destinataires` (`de_id`, `de_ref`, `de_nomClub`, `de_nomContact`, `de_adresse1`, `de_adresse2`, `de_codePostal`, `de_ville`, `de_IsClient`, `de_isActive`, `pa_id`) VALUES
(2, 'CTH-LESHERBIERS-111016', 'Cyclo Tourisme les Herbiers', 'Guy-marie Soulard', '10 rue de saulur', NULL, '85500', 'Les Herbiers', 1, 1, 75),
(3, 'StHerblainArchers-111016', 'Compagnie d''Archers Saint Herblain', 'Gweanelle Tonret', '1 rue de la loire', NULL, '44000', 'Nantes', 0, 1, 75),
(9, 'ref 1', 'FC Nantes', 'M. Coucuff', 'a', '', 'a', 'a', 1, 1, 75),
(14, 'ref 2', 'msb', '', 'parc des expositions', '', '72000', 'Le Mans', 1, 1, 75),
(18, 'reference nouvelle', 'marseille', 'Ronaldo', 'Mafia road', '', '13000', 'Marseille', 0, 1, 75),
(33, 'ART25D', 'Paris Saint Germain', 'M. Deschamps', 'Stade de France', '', '92200', 'Saint Denis', 1, 1, 75),
(35, 'ARTU', 'Le Losc', 'Mme barbier Nathalie', 'rue du stade', '', '12000', 'Lille', 0, 1, 75),
(37, 'ADR2', 'Lille basket club', 'Antoine DIOT', 'rue du stade', '', '12000', 'Lille', 1, 1, 75),
(38, 'T5', 'Lyon handball club', 'M. K rabat''itch', 'près de la gare', '', '42000', 'Lyio', 1, 1, 75),
(49, 'refB', 'Brest cycliste', '', 'rue des footeux', '', '12000', 'Brest', 1, 1, 75);

-- --------------------------------------------------------

--
-- Structure de la table `expeditionsarticles`
--

CREATE TABLE IF NOT EXISTS `expeditionsarticles` (
  `ea_id` int(11) NOT NULL,
  `ea_dateCreation` date NOT NULL,
  `ea_realisePar` char(5) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ea_TrackingColis` varchar(250) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ea_nbArticleEnvoyeTotal` int(11) NOT NULL,
  `ea_infoComplementaire` text COLLATE utf8_unicode_ci,
  `ea_isRetourIncomplet` tinyint(1) NOT NULL,
  `te_id` int(11) NOT NULL,
  `de_id` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=184 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Contenu de la table `expeditionsarticles`
--

INSERT INTO `expeditionsarticles` (`ea_id`, `ea_dateCreation`, `ea_realisePar`, `ea_TrackingColis`, `ea_nbArticleEnvoyeTotal`, `ea_infoComplementaire`, `ea_isRetourIncomplet`, `te_id`, `de_id`) VALUES
(175, '2016-10-18', 'fezfe', 'dzazd', 2, 'ffezfffffffff', 1, 1, 3),
(176, '2016-10-02', 'manu', 'dzdaz', 1, 'fza', 1, 1, 3),
(177, '2016-10-18', 'loic', '1236546', 2, 'pour retour incomplet', 1, 1, 9),
(178, '2016-10-18', 'loic', '654', 3, '', 0, 1, 9),
(179, '2016-10-18', '', '98745', 4, '', 1, 2, 2),
(180, '2016-10-18', '', '', 6, '', 1, 1, 2),
(181, '2016-10-19', 'dzada', 'czzad', 0, 'dzad', 0, 1, 2),
(182, '2016-10-19', 'manu', 'toto', 2, 'stef est num', 1, 3, 35),
(183, '2016-10-19', 'manu', 'gfkljcvjqf', 2, 'fgrjezg', 1, 2, 2);

-- --------------------------------------------------------

--
-- Structure de la table `familles`
--

CREATE TABLE IF NOT EXISTS `familles` (
  `fa_id` int(11) NOT NULL,
  `fa_code` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `fa_nom` varchar(25) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Contenu de la table `familles`
--

INSERT INTO `familles` (`fa_id`, `fa_code`, `fa_nom`) VALUES
(1, 'CUICY', 'Cuissard cycliste'),
(2, 'CUIATH', 'Cuissard Athletisme'),
(3, 'MAIATH', 'Maillot Athletisme');

-- --------------------------------------------------------

--
-- Structure de la table `lotsarticles`
--

CREATE TABLE IF NOT EXISTS `lotsarticles` (
  `la_id` int(11) NOT NULL,
  `la_dateRetour` date DEFAULT NULL,
  `sa_id` int(11) NOT NULL,
  `ea_id` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Contenu de la table `lotsarticles`
--

INSERT INTO `lotsarticles` (`la_id`, `la_dateRetour`, `sa_id`, `ea_id`) VALUES
(26, '2016-10-19', 124, 175),
(27, NULL, 123, 175),
(28, NULL, 123, 176),
(29, NULL, 123, 177),
(30, '2016-10-20', 124, 177),
(31, '2016-10-19', 124, 178),
(32, '2016-10-19', 128, 178),
(33, '2016-10-19', 123, 178),
(34, '2016-10-19', 124, 179),
(35, '2016-10-19', 134, 179),
(36, NULL, 200, 179),
(37, NULL, 198, 179),
(38, NULL, 134, 180),
(39, NULL, 159, 180),
(40, '2016-10-19', 157, 180),
(41, NULL, 124, 180),
(42, NULL, 132, 180),
(43, NULL, 129, 180),
(44, NULL, 123, 182),
(45, '2016-10-19', 203, 183),
(46, NULL, 202, 183);

-- --------------------------------------------------------

--
-- Structure de la table `modeles`
--

CREATE TABLE IF NOT EXISTS `modeles` (
  `mo_id` int(11) NOT NULL,
  `mo_code` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `mo_nom` varchar(15) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Contenu de la table `modeles`
--

INSERT INTO `modeles` (`mo_id`, `mo_code`, `mo_nom`) VALUES
(1, 'ELIT', 'Elite'),
(2, 'ALBAN', 'Alban'),
(3, 'LEA', 'Lea'),
(4, 'PROTEAM', 'Proteam'),
(5, 'MANUELA', 'Manuela'),
(6, 'EVA', 'Eva');

-- --------------------------------------------------------

--
-- Structure de la table `pays`
--

CREATE TABLE IF NOT EXISTS `pays` (
  `pa_id` int(11) NOT NULL,
  `pa_code` char(2) COLLATE utf8_unicode_ci NOT NULL,
  `pa_nom` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=242 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Contenu de la table `pays`
--

INSERT INTO `pays` (`pa_id`, `pa_code`, `pa_nom`) VALUES
(1, 'AF', 'Afghanistan'),
(2, 'AL', 'Albania'),
(3, 'AQ', 'Antarctica'),
(4, 'DZ', 'Algeria'),
(5, 'AS', 'American Samoa'),
(6, 'AD', 'Andorra'),
(7, 'AO', 'Angola'),
(8, 'AG', 'Antigua and Barbuda'),
(9, 'AZ', 'Azerbaijan'),
(10, 'AR', 'Argentina'),
(11, 'AU', 'Australia'),
(12, 'AT', 'Austria'),
(13, 'BS', 'Bahamas'),
(14, 'BH', 'Bahrain'),
(15, 'BD', 'Bangladesh'),
(16, 'AM', 'Armenia'),
(17, 'BB', 'Barbados'),
(18, 'BE', 'Belgium'),
(19, 'BM', 'Bermuda'),
(20, 'BT', 'Bhutan'),
(21, 'BO', 'Bolivia'),
(22, 'BA', 'Bosnia and Herzegovina'),
(23, 'BW', 'Botswana'),
(24, 'BV', 'Bouvet Island'),
(25, 'BR', 'Brazil'),
(26, 'BZ', 'Belize'),
(27, 'IO', 'British Indian Ocean Territory'),
(28, 'SB', 'Solomon Islands'),
(29, 'VG', 'British Virgin Islands'),
(30, 'BN', 'Brunei Darussalam'),
(31, 'BG', 'Bulgaria'),
(32, 'MM', 'Myanmar'),
(33, 'BI', 'Burundi'),
(34, 'BY', 'Belarus'),
(35, 'KH', 'Cambodia'),
(36, 'CM', 'Cameroon'),
(37, 'CA', 'Canada'),
(38, 'CV', 'Cape Verde'),
(39, 'KY', 'Cayman Islands'),
(40, 'CF', 'Central African'),
(41, 'LK', 'Sri Lanka'),
(42, 'TD', 'Chad'),
(43, 'CL', 'Chile'),
(44, 'CN', 'China'),
(45, 'TW', 'Taiwan'),
(46, 'CX', 'Christmas Island'),
(47, 'CC', 'Cocos (Keeling), Islands'),
(48, 'CO', 'Colombia'),
(49, 'KM', 'Comoros'),
(50, 'YT', 'Mayotte'),
(51, 'CG', 'Republic of the Congo'),
(52, 'CD', 'The Democratic Republic Of The Congo'),
(53, 'CK', 'Cook Islands'),
(54, 'CR', 'Costa Rica'),
(55, 'HR', 'Croatia'),
(56, 'CU', 'Cuba'),
(57, 'CY', 'Cyprus'),
(58, 'CZ', 'Czech Republic'),
(59, 'BJ', 'Benin'),
(60, 'DK', 'Denmark'),
(61, 'DM', 'Dominica'),
(62, 'DO', 'Dominican Republic'),
(63, 'EC', 'Ecuador'),
(64, 'SV', 'El Salvador'),
(65, 'GQ', 'Equatorial Guinea'),
(66, 'ET', 'Ethiopia'),
(67, 'ER', 'Eritrea'),
(68, 'EE', 'Estonia'),
(69, 'FO', 'Faroe Islands'),
(70, 'FK', 'Falkland Islands'),
(71, 'GS', 'South Georgia and the South Sandwich Islands'),
(72, 'FJ', 'Fiji'),
(73, 'FI', 'Finland'),
(74, 'AX', 'Åland Islands'),
(75, 'FR', 'France'),
(76, 'GF', 'French Guiana'),
(77, 'PF', 'French Polynesia'),
(78, 'TF', 'French Southern Territories'),
(79, 'DJ', 'Djibouti'),
(80, 'GA', 'Gabon'),
(81, 'GE', 'Georgia'),
(82, 'GM', 'Gambia'),
(83, 'PS', 'Occupied Palestinian Territory'),
(84, 'DE', 'Germany'),
(85, 'GH', 'Ghana'),
(86, 'GI', 'Gibraltar'),
(87, 'KI', 'Kiribati'),
(88, 'GR', 'Greece'),
(89, 'GL', 'Greenland'),
(90, 'GD', 'Grenada'),
(91, 'GP', 'Guadeloupe'),
(92, 'GU', 'Guam'),
(93, 'GT', 'Guatemala'),
(94, 'GN', 'Guinea'),
(95, 'GY', 'Guyana'),
(96, 'HT', 'Haiti'),
(97, 'HM', 'Heard Island and McDonald Islands'),
(98, 'VA', 'Vatican City State'),
(99, 'HN', 'Honduras'),
(100, 'HK', 'Hong Kong'),
(101, 'HU', 'Hungary'),
(102, 'IS', 'Iceland'),
(103, 'IN', 'India'),
(104, 'ID', 'Indonesia'),
(105, 'IR', 'Islamic Republic of Iran'),
(106, 'IQ', 'Iraq'),
(107, 'IE', 'Ireland'),
(108, 'IL', 'Israel'),
(109, 'IT', 'Italy'),
(110, 'CI', 'Côte d''Ivoire'),
(111, 'JM', 'Jamaica'),
(112, 'JP', 'Japan'),
(113, 'KZ', 'Kazakhstan'),
(114, 'JO', 'Jordan'),
(115, 'KE', 'Kenya'),
(116, 'KP', 'Democratic People''s Republic of Korea'),
(117, 'KR', 'Republic of Korea'),
(118, 'KW', 'Kuwait'),
(119, 'KG', 'Kyrgyzstan'),
(120, 'LA', 'Lao People''s Democratic Republic'),
(121, 'LB', 'Lebanon'),
(122, 'LS', 'Lesotho'),
(123, 'LV', 'Latvia'),
(124, 'LR', 'Liberia'),
(125, 'LY', 'Libyan Arab Jamahiriya'),
(126, 'LI', 'Liechtenstein'),
(127, 'LT', 'Lithuania'),
(128, 'LU', 'Luxembourg'),
(129, 'MO', 'Macao'),
(130, 'MG', 'Madagascar'),
(131, 'MW', 'Malawi'),
(132, 'MY', 'Malaysia'),
(133, 'MV', 'Maldives'),
(134, 'ML', 'Mali'),
(135, 'MT', 'Malta'),
(136, 'MQ', 'Martinique'),
(137, 'MR', 'Mauritania'),
(138, 'MU', 'Mauritius'),
(139, 'MX', 'Mexico'),
(140, 'MC', 'Monaco'),
(141, 'MN', 'Mongolia'),
(142, 'MD', 'Republic of Moldova'),
(143, 'MS', 'Montserrat'),
(144, 'MA', 'Morocco'),
(145, 'MZ', 'Mozambique'),
(146, 'OM', 'Oman'),
(147, 'NA', 'Namibia'),
(148, 'NR', 'Nauru'),
(149, 'NP', 'Nepal'),
(150, 'NL', 'Netherlands'),
(151, 'AN', 'Netherlands Antilles'),
(152, 'AW', 'Aruba'),
(153, 'NC', 'New Caledonia'),
(154, 'VU', 'Vanuatu'),
(155, 'NZ', 'New Zealand'),
(156, 'NI', 'Nicaragua'),
(157, 'NE', 'Niger'),
(158, 'NG', 'Nigeria'),
(159, 'NU', 'Niue'),
(160, 'NF', 'Norfolk Island'),
(161, 'NO', 'Norway'),
(162, 'MP', 'Northern Mariana Islands'),
(163, 'UM', 'United States Minor Outlying Islands'),
(164, 'FM', 'Federated States of Micronesia'),
(165, 'MH', 'Marshall Islands'),
(166, 'PW', 'Palau'),
(167, 'PK', 'Pakistan'),
(168, 'PA', 'Panama'),
(169, 'PG', 'Papua New Guinea'),
(170, 'PY', 'Paraguay'),
(171, 'PE', 'Peru'),
(172, 'PH', 'Philippines'),
(173, 'PN', 'Pitcairn'),
(174, 'PL', 'Poland'),
(175, 'PT', 'Portugal'),
(176, 'GW', 'Guinea-Bissau'),
(177, 'TL', 'Timor-Leste'),
(178, 'PR', 'Puerto Rico'),
(179, 'QA', 'Qatar'),
(180, 'RE', 'Réunion'),
(181, 'RO', 'Romania'),
(182, 'RU', 'Russian Federation'),
(183, 'RW', 'Rwanda'),
(184, 'SH', 'Saint Helena'),
(185, 'KN', 'Saint Kitts and Nevis'),
(186, 'AI', 'Anguilla'),
(187, 'LC', 'Saint Lucia'),
(188, 'PM', 'Saint-Pierre and Miquelon'),
(189, 'VC', 'Saint Vincent and the Grenadines'),
(190, 'SM', 'San Marino'),
(191, 'ST', 'Sao Tome and Principe'),
(192, 'SA', 'Saudi Arabia'),
(193, 'SN', 'Senegal'),
(194, 'SC', 'Seychelles'),
(195, 'SL', 'Sierra Leone'),
(196, 'SG', 'Singapore'),
(197, 'SK', 'Slovakia'),
(198, 'VN', 'Vietnam'),
(199, 'SI', 'Slovenia'),
(200, 'SO', 'Somalia'),
(201, 'ZA', 'South Africa'),
(202, 'ZW', 'Zimbabwe'),
(203, 'ES', 'Spain'),
(204, 'EH', 'Western Sahara'),
(205, 'SD', 'Sudan'),
(206, 'SR', 'Suriname'),
(207, 'SJ', 'Svalbard and Jan Mayen'),
(208, 'SZ', 'Swaziland'),
(209, 'SE', 'Sweden'),
(210, 'CH', 'Switzerland'),
(211, 'SY', 'Syrian Arab Republic'),
(212, 'TJ', 'Tajikistan'),
(213, 'TH', 'Thailand'),
(214, 'TG', 'Togo'),
(215, 'TK', 'Tokelau'),
(216, 'TO', 'Tonga'),
(217, 'TT', 'Trinidad and Tobago'),
(218, 'AE', 'United Arab Emirates'),
(219, 'TN', 'Tunisia'),
(220, 'TR', 'Turkey'),
(221, 'TM', 'Turkmenistan'),
(222, 'TC', 'Turks and Caicos Islands'),
(223, 'TV', 'Tuvalu'),
(224, 'UG', 'Uganda'),
(225, 'UA', 'Ukraine'),
(226, 'MK', 'The Former Yugoslav Republic of Macedonia'),
(227, 'EG', 'Egypt'),
(228, 'GB', 'United Kingdom'),
(229, 'IM', 'Isle of Man'),
(230, 'TZ', 'United Republic Of Tanzania'),
(231, 'US', 'United States'),
(232, 'VI', 'U.S. Virgin Islands'),
(233, 'BF', 'Burkina Faso'),
(234, 'UY', 'Uruguay'),
(235, 'UZ', 'Uzbekistan'),
(236, 'VE', 'Venezuela'),
(237, 'WF', 'Wallis and Futuna'),
(238, 'WS', 'Samoa'),
(239, 'YE', 'Yemen'),
(240, 'CS', 'Serbia and Montenegro'),
(241, 'ZM', 'Zambia');

-- --------------------------------------------------------

--
-- Structure de la table `statuts`
--

CREATE TABLE IF NOT EXISTS `statuts` (
  `st_id` int(11) NOT NULL,
  `st_code` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `st_nom` varchar(25) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Contenu de la table `statuts`
--

INSERT INTO `statuts` (`st_id`, `st_code`, `st_nom`) VALUES
(1, '0', 'En stock'),
(2, '1', 'Envoyé'),
(3, '2', 'Non reçu'),
(4, '3', 'Vendu');

-- --------------------------------------------------------

--
-- Structure de la table `stocksarticles`
--

CREATE TABLE IF NOT EXISTS `stocksarticles` (
  `sa_id` int(11) NOT NULL,
  `sa_ref` varchar(25) COLLATE utf8_unicode_ci NOT NULL,
  `sa_dateCreation` date NOT NULL,
  `sa_isActive` tinyint(1) NOT NULL,
  `ar_id` int(11) NOT NULL,
  `ta_id` int(11) NOT NULL,
  `st_id` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=237 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Contenu de la table `stocksarticles`
--

INSERT INTO `stocksarticles` (`sa_id`, `sa_ref`, `sa_dateCreation`, `sa_isActive`, `ar_id`, `ta_id`, `st_id`) VALUES
(123, 'CUICYELIT0510160002-S', '2016-10-04', 1, 1, 1, 2),
(124, 'MAIlMANU-test-001-l', '2016-10-11', 1, 2, 4, 2),
(128, 'MAIlMANU-test-001-XL', '2016-10-11', 1, 2, 5, 2),
(129, 'r4-XS0', '2016-10-18', 1, 16, 1, 2),
(130, 'r5-XS0', '2016-10-18', 1, 18, 1, 2),
(131, 'GERNOM12-M-5', '2016-10-18', 1, 19, 3, 1),
(132, 'GERNOM12-S-5', '2016-10-18', 1, 19, 2, 2),
(134, 'GERNOM12-XS-5', '2016-10-18', 1, 19, 1, 2),
(135, 'GERNOM12-XL-5', '2016-10-18', 1, 19, 5, 2),
(136, 'GERNOM12-L-5', '2016-10-18', 1, 19, 4, 2),
(156, 'texts25-XS-0', '2016-10-18', 1, 20, 1, 2),
(157, 'texts25-XS-1', '2016-10-18', 1, 20, 1, 2),
(158, 'texts25-S-0', '2016-10-18', 1, 20, 2, 2),
(159, 'texts25-L-0', '2016-10-18', 1, 20, 4, 2),
(160, 'texts25-XL-0', '2016-10-18', 1, 20, 5, 2),
(161, 'texts25-XS-2', '2016-10-18', 1, 20, 1, 1),
(162, 'texts25-M-0', '2016-10-18', 1, 20, 3, 1),
(163, 'texts25-S-1', '2016-10-18', 1, 20, 2, 2),
(164, 'texts25-L-1', '2016-10-18', 1, 20, 4, 2),
(165, 'texts25-L-2', '2016-10-18', 1, 20, 4, 2),
(166, 'texts25-M-1', '2016-10-18', 1, 20, 3, 2),
(167, 'texts25-XL-1', '2016-10-18', 1, 20, 5, 2),
(168, 'texts25-S-2', '2016-10-18', 1, 20, 2, 2),
(169, 'texts25-XS-3', '2016-10-18', 1, 20, 1, 2),
(170, 'texts25-L-3', '2016-10-18', 1, 20, 4, 2),
(171, 'texts25-M-2', '2016-10-18', 1, 20, 3, 2),
(172, 'texts25-XL-2', '2016-10-18', 1, 20, 5, 2),
(173, 'texts25-L-4', '2016-10-18', 1, 20, 4, 2),
(174, 'texts25-S-3', '2016-10-18', 1, 20, 2, 2),
(175, 'texts25-M-3', '2016-10-18', 1, 20, 3, 2),
(176, 'texts25-XS-4', '2016-10-18', 1, 20, 1, 2),
(177, 'texts25-XS-5', '2016-10-18', 1, 20, 1, 2),
(178, 'texts25-S-4', '2016-10-18', 1, 20, 2, 2),
(179, 'texts25-L-5', '2016-10-18', 1, 20, 4, 2),
(180, 'texts25-XL-3', '2016-10-18', 1, 20, 5, 2),
(181, 'texts25-XS-6', '2016-10-18', 1, 20, 1, 2),
(182, 'texts25-M-4', '2016-10-18', 1, 20, 3, 2),
(183, 'texts25-S-5', '2016-10-18', 1, 20, 2, 2),
(184, 'texts25-S-6', '2016-10-18', 1, 20, 2, 2),
(185, 'texts25-XS-7', '2016-10-18', 1, 20, 1, 2),
(186, 'texts25-M-5', '2016-10-18', 1, 20, 3, 2),
(187, 'texts25-XL-4', '2016-10-18', 1, 20, 5, 2),
(188, 'texts25-L-6', '2016-10-18', 1, 20, 4, 2),
(189, 'texts25-S-7', '2016-10-18', 1, 20, 2, 2),
(190, 'texts25-XL-5', '2016-10-18', 1, 20, 5, 2),
(191, 'texts25-L-7', '2016-10-18', 1, 20, 4, 2),
(192, 'texts25-M-6', '2016-10-18', 1, 20, 3, 2),
(193, 'texts25-XL-6', '2016-10-18', 1, 20, 5, 2),
(194, 'texts25-XL-7', '2016-10-18', 1, 20, 5, 2),
(195, 'texts25-M-7', '2016-10-18', 1, 20, 3, 2),
(196, 'sdqdqsd-M-0', '2016-10-18', 1, 21, 3, 2),
(197, 'sdqdqsd-XS-0', '2016-10-18', 1, 21, 1, 2),
(198, 'sdqdqsd-M-1', '2016-10-18', 1, 21, 3, 2),
(199, 'sdqdqsd-XS-1', '2016-10-18', 1, 21, 1, 2),
(200, 'sdqdqsd-M-2', '2016-10-18', 1, 21, 3, 2),
(201, 'sdqdqsd-XS-2', '2016-10-18', 1, 21, 1, 2),
(202, 'CR231476869912529-S-0', '2016-10-19', 1, 24, 2, 2),
(203, 'CR231476869912529-M-0', '2016-10-19', 1, 24, 3, 2),
(204, 'CR231476869912529-S-1', '2016-10-19', 1, 24, 2, 2),
(205, 'CR231476869912529-S-2', '2016-10-19', 1, 24, 2, 2),
(206, 'CR231476869912529-M-1', '2016-10-19', 1, 24, 3, 1),
(207, 'CR231476869912529-M-2', '2016-10-19', 1, 24, 3, 1),
(208, 'CR111476872365753-XS-0', '2016-10-19', 1, 34, 1, 1),
(209, 'CR111476872365753-L-0', '2016-10-19', 1, 34, 4, 1),
(210, 'CR111476872365753-M-0', '2016-10-19', 1, 34, 3, 1),
(211, 'CR111476872365753-L-1', '2016-10-19', 1, 34, 4, 1),
(212, 'CR111476872365753-XS-1', '2016-10-19', 1, 34, 1, 1),
(213, 'CR111476872365753-M-1', '2016-10-19', 1, 34, 3, 1),
(214, 'CR111476872365753-L-2', '2016-10-19', 1, 34, 4, 1),
(215, 'CR111476872365753-XS-2', '2016-10-19', 1, 34, 1, 1),
(216, 'CR111476872365753-M-2', '2016-10-19', 1, 34, 3, 1),
(217, 'CR331476885968956-XS-0', '2016-10-19', 1, 35, 1, 1),
(218, 'CR331476885968956-XS-1', '2016-10-19', 1, 35, 1, 1),
(219, 'CR331476885968956-M-0', '2016-10-19', 1, 35, 3, 1),
(220, 'CR331476885968956-XL-0', '2016-10-19', 1, 35, 5, 1),
(221, 'CR331476885968956-XS-2', '2016-10-19', 1, 35, 1, 1),
(222, 'CR331476885968956-S-0', '2016-10-19', 1, 35, 2, 1),
(223, 'CR331476885968956-S-1', '2016-10-19', 1, 35, 2, 1),
(224, 'CR331476885968956-M-1', '2016-10-19', 1, 35, 3, 1),
(225, 'CR331476885968956-XS-3', '2016-10-19', 1, 35, 1, 1),
(226, 'CR331476885968956-XL-1', '2016-10-19', 1, 35, 5, 1),
(227, 'CR331476885968956-XL-2', '2016-10-19', 1, 35, 5, 1),
(228, 'CR331476885968956-M-2', '2016-10-19', 1, 35, 3, 1),
(229, 'CR331476885968956-XL-3', '2016-10-19', 1, 35, 5, 1),
(230, 'CR331476885968956-XS-4', '2016-10-19', 1, 35, 1, 1),
(231, 'CR331476885968956-XL-4', '2016-10-19', 1, 35, 5, 1),
(232, 'CR331476885968956-M-3', '2016-10-19', 1, 35, 3, 1),
(233, 'CR331476885968956-XS-5', '2016-10-19', 1, 35, 1, 1),
(234, 'CR331476885968956-M-4', '2016-10-19', 1, 35, 3, 1),
(235, 'CR331476885968956-XL-5', '2016-10-19', 1, 35, 5, 1),
(236, 'CR331476885968956-M-5', '2016-10-19', 1, 35, 3, 1);

-- --------------------------------------------------------

--
-- Structure de la table `tailles`
--

CREATE TABLE IF NOT EXISTS `tailles` (
  `ta_id` int(11) NOT NULL,
  `ta_code` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `ta_nom` varchar(25) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Contenu de la table `tailles`
--

INSERT INTO `tailles` (`ta_id`, `ta_code`, `ta_nom`) VALUES
(1, '1', 'XS (1)'),
(2, '2', 'S (2)'),
(3, '3', 'M (3)'),
(4, '4', 'L (4)'),
(5, '5', 'XL (5)');

-- --------------------------------------------------------

--
-- Structure de la table `typesexpeditions`
--

CREATE TABLE IF NOT EXISTS `typesexpeditions` (
  `te_id` int(11) NOT NULL,
  `te_code` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `te_nom` varchar(25) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Contenu de la table `typesexpeditions`
--

INSERT INTO `typesexpeditions` (`te_id`, `te_code`, `te_nom`) VALUES
(1, '1', 'Présentation modèle'),
(2, '2', 'Essai taille'),
(3, '3', 'Salon Commercial');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `articles`
--
ALTER TABLE `articles`
  ADD PRIMARY KEY (`ar_id`),
  ADD UNIQUE KEY `ar_ref` (`ar_ref`),
  ADD KEY `FK_Articles_fa_id` (`fa_id`),
  ADD KEY `FK_Articles_mo_id` (`mo_id`);

--
-- Index pour la table `destinataires`
--
ALTER TABLE `destinataires`
  ADD PRIMARY KEY (`de_id`),
  ADD UNIQUE KEY `de_ref` (`de_ref`),
  ADD KEY `FK_Destinataires_pa_id` (`pa_id`);

--
-- Index pour la table `expeditionsarticles`
--
ALTER TABLE `expeditionsarticles`
  ADD PRIMARY KEY (`ea_id`),
  ADD KEY `FK_ExpeditionsArticles_te_id` (`te_id`),
  ADD KEY `FK_ExpeditionsArticles_de_id` (`de_id`);

--
-- Index pour la table `familles`
--
ALTER TABLE `familles`
  ADD PRIMARY KEY (`fa_id`),
  ADD UNIQUE KEY `fa_code` (`fa_code`);

--
-- Index pour la table `lotsarticles`
--
ALTER TABLE `lotsarticles`
  ADD PRIMARY KEY (`la_id`),
  ADD KEY `FK_LotsArticles_sa_id` (`sa_id`),
  ADD KEY `FK_LotsArticles_ea_id` (`ea_id`);

--
-- Index pour la table `modeles`
--
ALTER TABLE `modeles`
  ADD PRIMARY KEY (`mo_id`),
  ADD UNIQUE KEY `mo_code` (`mo_code`);

--
-- Index pour la table `pays`
--
ALTER TABLE `pays`
  ADD PRIMARY KEY (`pa_id`);

--
-- Index pour la table `statuts`
--
ALTER TABLE `statuts`
  ADD PRIMARY KEY (`st_id`),
  ADD UNIQUE KEY `st_code` (`st_code`);

--
-- Index pour la table `stocksarticles`
--
ALTER TABLE `stocksarticles`
  ADD PRIMARY KEY (`sa_id`),
  ADD UNIQUE KEY `sa_ref` (`sa_ref`),
  ADD KEY `FK_StocksArticles_ar_id` (`ar_id`),
  ADD KEY `FK_StocksArticles_ta_Id` (`ta_id`),
  ADD KEY `FK_StocksArticles_st_id` (`st_id`);

--
-- Index pour la table `tailles`
--
ALTER TABLE `tailles`
  ADD PRIMARY KEY (`ta_id`),
  ADD UNIQUE KEY `ta_code` (`ta_code`);

--
-- Index pour la table `typesexpeditions`
--
ALTER TABLE `typesexpeditions`
  ADD PRIMARY KEY (`te_id`),
  ADD UNIQUE KEY `te_code` (`te_code`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `articles`
--
ALTER TABLE `articles`
  MODIFY `ar_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=36;
--
-- AUTO_INCREMENT pour la table `destinataires`
--
ALTER TABLE `destinataires`
  MODIFY `de_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=50;
--
-- AUTO_INCREMENT pour la table `expeditionsarticles`
--
ALTER TABLE `expeditionsarticles`
  MODIFY `ea_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=184;
--
-- AUTO_INCREMENT pour la table `familles`
--
ALTER TABLE `familles`
  MODIFY `fa_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT pour la table `lotsarticles`
--
ALTER TABLE `lotsarticles`
  MODIFY `la_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=47;
--
-- AUTO_INCREMENT pour la table `modeles`
--
ALTER TABLE `modeles`
  MODIFY `mo_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT pour la table `pays`
--
ALTER TABLE `pays`
  MODIFY `pa_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=242;
--
-- AUTO_INCREMENT pour la table `statuts`
--
ALTER TABLE `statuts`
  MODIFY `st_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT pour la table `stocksarticles`
--
ALTER TABLE `stocksarticles`
  MODIFY `sa_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=237;
--
-- AUTO_INCREMENT pour la table `tailles`
--
ALTER TABLE `tailles`
  MODIFY `ta_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `typesexpeditions`
--
ALTER TABLE `typesexpeditions`
  MODIFY `te_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `articles`
--
ALTER TABLE `articles`
  ADD CONSTRAINT `FK_Articles_fa_id` FOREIGN KEY (`fa_id`) REFERENCES `familles` (`fa_id`),
  ADD CONSTRAINT `FK_Articles_mo_id` FOREIGN KEY (`mo_id`) REFERENCES `modeles` (`mo_id`);

--
-- Contraintes pour la table `destinataires`
--
ALTER TABLE `destinataires`
  ADD CONSTRAINT `FK_Destinataires_pa_id` FOREIGN KEY (`pa_id`) REFERENCES `pays` (`pa_id`);

--
-- Contraintes pour la table `expeditionsarticles`
--
ALTER TABLE `expeditionsarticles`
  ADD CONSTRAINT `FK_ExpeditionsArticles_de_id` FOREIGN KEY (`de_id`) REFERENCES `destinataires` (`de_id`),
  ADD CONSTRAINT `FK_ExpeditionsArticles_te_id` FOREIGN KEY (`te_id`) REFERENCES `typesexpeditions` (`te_id`);

--
-- Contraintes pour la table `lotsarticles`
--
ALTER TABLE `lotsarticles`
  ADD CONSTRAINT `FK_LotsArticles_ea_id` FOREIGN KEY (`ea_id`) REFERENCES `expeditionsarticles` (`ea_id`),
  ADD CONSTRAINT `FK_LotsArticles_sa_id` FOREIGN KEY (`sa_id`) REFERENCES `stocksarticles` (`sa_id`);

--
-- Contraintes pour la table `stocksarticles`
--
ALTER TABLE `stocksarticles`
  ADD CONSTRAINT `FK_StocksArticles_ar_id` FOREIGN KEY (`ar_id`) REFERENCES `articles` (`ar_id`),
  ADD CONSTRAINT `FK_StocksArticles_st_id` FOREIGN KEY (`st_id`) REFERENCES `statuts` (`st_id`),
  ADD CONSTRAINT `FK_StocksArticles_ta_Id` FOREIGN KEY (`ta_Id`) REFERENCES `tailles` (`ta_Id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
