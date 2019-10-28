CREATE DATABASE concessionariaDB;

USE concessionariaDB;

---- CRIAÇÃO DAS TABELAS -------

CREATE TABLE estado(
id_estado INT PRIMARY KEY AUTO_INCREMENT,
uf CHAR(2) NOT NULL
);

CREATE TABLE cidade(
id_cidade INT PRIMARY KEY AUTO_INCREMENT,
nome_cidade VARCHAR (50) NOT NULL
);

CREATE TABLE bairro(
id_bairro INT AUTO_INCREMENT PRIMARY KEY,
nome_bairro VARCHAR(50) NOT NULL
);

CREATE TABLE tipo_usuario(
id_tipo_usuario INT AUTO_INCREMENT PRIMARY KEY,
tipo_usuario VARCHAR(50)
);

CREATE TABLE contato(
id_contato INT AUTO_INCREMENT PRIMARY KEY,
telefone VARCHAR (20) NOT NULL
);

CREATE TABLE cor(
id_cor INT AUTO_INCREMENT PRIMARY KEY,
nome_cor VARCHAR(20) NOT NULL
);

CREATE TABLE marca(
id_marca INT AUTO_INCREMENT PRIMARY KEY,
nome_marca VARCHAR (50) NOT NULL
);

CREATE TABLE combustivel(
id_combustivel INT AUTO_INCREMENT PRIMARY KEY,
tipo_combustivel VARCHAR (50) NOT NULL
);

CREATE TABLE forma_pagamento(
id_forma_pagamento INT AUTO_INCREMENT PRIMARY KEY,
tipo_pagamento VARCHAR (50) NOT NULL
);

CREATE TABLE veiculos(
  id_veiculo INT AUTO_INCREMENT PRIMARY KEY,
  modelo VARCHAR(30) NOT NULL,
  ano INT NOT NULL,
  chassi VARCHAR (25) NOT NULL, 
  valor_unitario DECIMAL(10,2),
  id_cor INT NOT NULL,
  CONSTRAINT fk_cor FOREIGN KEY(id_cor)
  REFERENCES cor (id_cor),
  id_marca INT NOT NULL,
  CONSTRAINT fk_marca FOREIGN KEY(id_marca)
  REFERENCES marca(id_marca),
  id_combustivel INT NOT NULL,
  CONSTRAINT fk_combustivel FOREIGN KEY(id_combustivel)
  REFERENCES combustivel(id_combustivel)
);

CREATE TABLE endereco(
    id_endereco INT AUTO_INCREMENT PRIMARY KEY,
	cep VARCHAR (9) NOT NULL,
	rua VARCHAR (100) NOT NULL,
	numero VARCHAR (50) NOT NULL,
	complemento VARCHAR (50),
	id_estado INT NOT NULL,	
	CONSTRAINT fk_estado FOREIGN KEY(id_estado)
	REFERENCES estado(id_estado),
	id_bairro INT NOT NULL,
	CONSTRAINT fk_bairro FOREIGN KEY(id_bairro)
	REFERENCES bairro(id_bairro),
	id_cidade INT NOT NULL,
	CONSTRAINT fk_cidade FOREIGN KEY(id_cidade)
	REFERENCES cidade(id_cidade)
);

CREATE TABLE usuario(
	id_usuario INT AUTO_INCREMENT PRIMARY KEY,
	nome VARCHAR (40) NOT NULL,
	sobrenome VARCHAR (40) NOT NULL,
	cpf VARCHAR (11) NOT NULL,
	email VARCHAR (45) NOT NULL,
	senha VARCHAR (12) NOT NULL,
	id_endereco INT NOT NULL,
	CONSTRAINT fk_endereco FOREIGN KEY(id_endereco)
	REFERENCES endereco(id_endereco),
	id_contato INT NOT NULL,
	CONSTRAINT fk_contato FOREIGN KEY(id_contato)
	REFERENCES contato(id_contato),
	id_tipo_usuario INT NOT NULL,
	CONSTRAINT fk_tipo_usuario FOREIGN KEY(id_tipo_usuario)
	REFERENCES tipo_usuario(id_tipo_usuario)

);

CREATE TABLE pedidos(
  id_pedido INT AUTO_INCREMENT PRIMARY KEY,
  data_pedido DATE NOT NULL,
  valor_total DECIMAL(10,2) NOT NULL,
  quantidade_parcelamento INT,
  id_usuario INT NOT NULL,
  id_forma_pagamento INT NOT NULL,
  CONSTRAINT fk_usuario FOREIGN KEY(id_usuario)
   REFERENCES usuario(id_usuario),
   CONSTRAINT fk_forma_pagamento FOREIGN KEY(id_forma_pagamento)
   REFERENCES forma_pagamento(id_forma_pagamento)
);




CREATE TABLE item_pedidos(
id_item_pedido INT AUTO_INCREMENT PRIMARY KEY,
quantidade INT NOT NULL,
subtotal DECIMAL(10,2) NOT NULL,
id_veiculos_pedido INT NOT NULL,
CONSTRAINT fk_veiculos FOREIGN KEY(id_veiculos_pedido)
REFERENCES veiculos(id_veiculo),
id_pedido INT NOT NULL,
CONSTRAINT fk_pedido FOREIGN KEY(id_pedido)
REFERENCES pedidos(id_pedido)
);



----------- INSERT NAS TABELAS USUARIO, ESTADO, BAIRRO, CIDADE, CONTATO, ENDERECO, TIPO_USUARIO 
------- IMPORTANTE !!!!! ----

--- OS INSERTS NO MYSQL NECESSITAM DO ID PASSADO NO VALUES, PARA A RESOLUÇÃO DO PROBLEMA PODEMOS PASSAR AS COLUNAS QUE VAO SER ALTERADAS ---

INSERT INTO estado(uf) VALUES ('RJ');

INSERT INTO bairro VALUES ('Centro');
INSERT INTO cidade VALUES ('São Gonçalo');
INSERT INTO contato VALUES ('2199999999');
INSERT INTO endereco VALUES ('123456789', 'Rua Roberto Pimentel', '123', 'Casa', 1, 1, 1);

INSERT INTO tipo_usuario VALUES ('Cliente');
INSERT INTO usuario VALUES ('Anderson', 'Camelo', '12345678910', 'anderson@anderson.com', 'senha@123', 1, 1, 1);

INSERT INTO estado VALUES ('RJ');
INSERT INTO bairro VALUES ('Centro');
INSERT INTO cidade VALUES ('Niteroi');
INSERT INTO contato VALUES ('21987654321');
INSERT INTO endereco VALUES ('987654321', 'Rua Almirante tefé', '321', 'Prédio', 2, 2, 2);

INSERT INTO tipo_usuario VALUES ('Administrador');
INSERT INTO usuario VALUES ('Senac', 'Niteroi', '10123456789', 'senac@senac.com', 'senac@123', 2, 2, 2);

----------- INSERT NAS TABELAS VEICULO, COR, MARCA, COMBUSTIVEL

 INSERT INTO cor VALUES ('Branco');
 INSERT INTO marca VALUES ('Fiat');
 INSERT INTO combustivel VALUES ('Gasolina');
 INSERT INTO veiculos VALUES ('Palio', '2011', '123abc789dhj785bv', 18.000, 1, 1, 1);

  INSERT INTO cor VALUES ('Preto');
 INSERT INTO marca VALUES ('Hyundai');
 INSERT INTO combustivel VALUES ('Flex');
 INSERT INTO veiculos VALUES ('Tucson', '2016', '312dhf531jki785cb', 60.000, 2, 2, 2);

 ----------- INSERT NAS TABELAS PEDIDOS, ITEM_PEDIDO, FORMA DE PAGAMENTO

 INSERT INTO forma_pagamento VALUES ('Crédito');
 INSERT INTO pedidos VALUES ('24-10-2019', 18.000, 36, 1, 1);
 INSERT INTO item_pedidos VALUES (1, 18.000, 1, 1);

  INSERT INTO forma_pagamento VALUES ('Transferencia Bancária');
 INSERT INTO pedidos VALUES ('23-10-2019', 60.000, 36, 2, 2);
 INSERT INTO item_pedidos VALUES (1, 60.000, 2, 2);





