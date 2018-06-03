CREATE TABLE `prodotto` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome_prodotto` varchar(45) NOT NULL,
  `descrizione_prodotto` varchar(45) NOT NULL,
  `prezzo_prodotto` bigint(20) NOT NULL,
  `produttore_prodotto` varchar(45) NOT NULL,
  `foto_prodotto` varchar(45) NOT NULL,
  `id_company` varchar(45) NOT NULL,
  `id_categoria` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4