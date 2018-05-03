CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `nome` varchar(30) NOT NULL,
  `cognome` varchar(30) NOT NULL,
  `id_role` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `role_idx` (`id_role`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4