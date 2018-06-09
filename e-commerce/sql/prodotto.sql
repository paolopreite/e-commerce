CREATE TABLE `prodotto` (
  `id` bigint(20) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `descrizione` varchar(100) NOT NULL,
  `prezzo` varchar(45) NOT NULL,
  `produttore` varchar(100) NOT NULL,
  `foto` varchar(150) DEFAULT NULL,
  `id_company` bigint(20) NOT NULL,
  `id_categoria` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `company_idx` (`id_company`),
  KEY `prod_categoria_idx` (`id_categoria`),
  CONSTRAINT `prod_categoria` FOREIGN KEY (`id_categoria`) REFERENCES `categoria` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `prod_company` FOREIGN KEY (`id_company`) REFERENCES `company` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4