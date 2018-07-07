create database financeiro;

CREATE TABLE `categorias` (
  `idcategoria` int(11) NOT NULL AUTO_INCREMENT,
  `nomecategoria` varchar(45) DEFAULT NULL,
  `descricao` varchar(45) DEFAULT NULL,
  `datacriacao` datetime DEFAULT NULL,
  PRIMARY KEY (`idcategoria`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

CREATE TABLE `contas` (
  `idconta` int(11) NOT NULL AUTO_INCREMENT,
  `nomeconta` varchar(45) NOT NULL,
  `saldo` decimal(10,2) NOT NULL,
  `descricao` varchar(45) DEFAULT NULL,
  `datacriacao` datetime DEFAULT NULL,
  `idtipoconta` int(11) DEFAULT NULL,
  PRIMARY KEY (`idconta`),
  KEY `fk_idtipoconta_idx` (`idtipoconta`),
  CONSTRAINT `fk_idtipoconta` FOREIGN KEY (`idtipoconta`) REFERENCES `tipoconta` (`idtipoconta`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;


CREATE TABLE `despesas` (
  `iddespesa` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(45) NOT NULL,
  `datadespesa` date NOT NULL,
  `valordespesa` decimal(10,2) NOT NULL,
  `idconta` int(11) DEFAULT NULL,
  `observacao` varchar(45) DEFAULT NULL,
  `idcategoria` int(11) DEFAULT NULL,
  `qtd` int(11) DEFAULT NULL,
  `periodo` varchar(30) DEFAULT NULL,
  `pago` tinyint(1)despesas DEFAULT NULL,
  PRIMARY KEY (`iddespesa`),
  KEY `fk_idcategoria_idx` (`idcategoria`),
  KEY `fk_idconta_idx` (`idconta`),
  CONSTRAINT `fk_idcategoria` FOREIGN KEY (`idcategoria`) REFERENCES `categorias` (`idcategoria`) ON UPDATE CASCADE,
  CONSTRAINT `fk_idconta` FOREIGN KEY (`idconta`) REFERENCES `contas` (`idconta`) ON UPDATE CASCADE

) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `receita` (
  `idreceita` int(11) NOT NULL AUTO_INCREMENT,
  `nomereceita` varchar(45) NOT NULL,
  `descricao` varchar(45) DEFAULT NULL,
  `idtiporeceita` int(11) NOT NULL,
  `idconta` int(11) NOT NULL,
  `datacriacao` date DEFAULT NULL,
  `valor` decimal(10,2) NOT NULL,
  PRIMARY KEY (`idreceita`),
  KEY `fk_idconta_idx` (`idconta`),
  KEY `fk_idtiporeceita_idx` (`idtiporeceita`),
  CONSTRAINT `fk_idtiporeceita` FOREIGN KEY (`idtiporeceita`) REFERENCES `tiporeceita` (`idtiporeceita`) ON UPDATE CASCADE,
  CONSTRAINT `fk_tipoconta` FOREIGN KEY (`idconta`) REFERENCES `contas` (`idconta`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `tipoconta` (
  `idtipoconta` int(11) NOT NULL AUTO_INCREMENT,
  `tipoconta` varchar(45) DEFAULT NULL,
  `datacriacao` datetime DEFAULT NULL,
  `descricao` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idtipoconta`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;


CREATE TABLE `tiporeceita` (
  `idtiporeceita` int(11) NOT NULL AUTO_INCREMENT,
  `tiporeceita` varchar(45) NOT NULL,
  `datacriacao` date NOT NULL,
  `descricao` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idtiporeceita`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;




