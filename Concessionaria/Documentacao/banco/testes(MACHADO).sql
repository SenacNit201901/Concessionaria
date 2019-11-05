CREATE DATABASE concessionariaDB;
ALTER DATABASE concessionariaDB CHARACTER SET utf8 COLLATE utf8_unicode_ci;

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
  REFERENCES cor (id_cor) on delete cascade,
  id_marca INT NOT NULL,
  CONSTRAINT fk_marca FOREIGN KEY(id_marca)
  REFERENCES marca(id_marca) on delete cascade,
  id_combustivel INT NOT NULL,
  CONSTRAINT fk_combustivel FOREIGN KEY(id_combustivel)
  REFERENCES combustivel(id_combustivel) on delete cascade
);

CREATE TABLE endereco(
    id_endereco INT AUTO_INCREMENT PRIMARY KEY,
	cep VARCHAR (9) NOT NULL,
	rua VARCHAR (100) NOT NULL,
	numero VARCHAR (50) NOT NULL,
	complemento VARCHAR (50),
	id_estado INT NOT NULL,	
	CONSTRAINT fk_estado FOREIGN KEY(id_estado)
	REFERENCES estado(id_estado) on delete cascade,
	id_bairro INT NOT NULL,
	CONSTRAINT fk_bairro FOREIGN KEY(id_bairro)
	REFERENCES bairro(id_bairro) on delete cascade,
	id_cidade INT NOT NULL,
	CONSTRAINT fk_cidade FOREIGN KEY(id_cidade)
	REFERENCES cidade(id_cidade) on delete cascade
);

CREATE TABLE usuario(
	id_usuario INT AUTO_INCREMENT PRIMARY KEY,
	nome VARCHAR (40) NOT NULL,
	sobrenome VARCHAR (40) NOT NULL,
	cpf VARCHAR (11) NOT NULL UNIQUE,
	email VARCHAR (45) NOT NULL UNIQUE,
	senha VARCHAR (32) NOT NULL,
	id_endereco INT NOT NULL,
	CONSTRAINT fk_endereco FOREIGN KEY(id_endereco)
	REFERENCES endereco(id_endereco) on delete cascade,
	id_tipo_usuario INT NOT NULL,
	CONSTRAINT fk_tipo_usuario FOREIGN KEY(id_tipo_usuario)
	REFERENCES tipo_usuario(id_tipo_usuario) on delete cascade

);


CREATE TABLE contato(
id_contato INT AUTO_INCREMENT PRIMARY KEY,
telefone VARCHAR (20) NOT NULL,
id_usuario INT NOT NULL,
CONSTRAINT fk_usuario FOREIGN KEY(id_usuario)
REFERENCES usuario(id_usuario) on delete cascade
);

CREATE TABLE pedidos(
  id_pedido INT AUTO_INCREMENT PRIMARY KEY,
  data_pedido DATE NOT NULL,
  valor_total DECIMAL(10,2) NOT NULL,
  quantidade_parcelamento INT,
  id_usuario INT NOT NULL,
  id_forma_pagamento INT NOT NULL,
  CONSTRAINT fk_usuarioPedido FOREIGN KEY(id_usuario)
   REFERENCES usuario(id_usuario) on delete cascade,
   CONSTRAINT fk_forma_pagamento FOREIGN KEY(id_forma_pagamento)
   REFERENCES forma_pagamento(id_forma_pagamento) on delete cascade
);




CREATE TABLE item_pedidos(
id_item_pedido INT AUTO_INCREMENT PRIMARY KEY,
quantidade INT NOT NULL,
subtotal DECIMAL(10,2) NOT NULL,
id_veiculos_pedido INT NOT NULL,
CONSTRAINT fk_veiculos FOREIGN KEY(id_veiculos_pedido)
REFERENCES veiculos(id_veiculo) on delete cascade,
id_pedido INT NOT NULL,
CONSTRAINT fk_pedido FOREIGN KEY(id_pedido)
REFERENCES pedidos(id_pedido) on delete cascade
);

-- INSERT 3 estado
SELECT * FROM estado;
INSERT INTO estado VALUES (null, 'RJ');
INSERT INTO estado VALUES (null, 'SP');
INSERT INTO estado VALUES (null, 'MG');
-- INSERT 5 CIDADES
SELECT * FROM cidade;
INSERT INTO cidade VALUES (null, 'Niterói');
INSERT INTO cidade VALUES (null, 'Sao Gonçalo');
INSERT INTO cidade VALUES (null, 'Rio de Janeiro');
INSERT INTO cidade VALUES (null, 'Maricá');
INSERT INTO cidade VALUES (null, 'Itaboraí');

-- INSERT 15 BAIRRO;
select * from bairro;
INSERT INTO bairro VALUES (null, 'Centro');
INSERT INTO bairro VALUES (null, 'Icarai');
INSERT INTO bairro VALUES (null, 'Inga');
INSERT INTO bairro VALUES (null, 'São Francisco');
INSERT INTO bairro VALUES (null, 'Piratininga');
INSERT INTO bairro VALUES (null, 'Columbande');
INSERT INTO bairro VALUES (null, 'Itauna');
INSERT INTO bairro VALUES (null, 'Galo Branco');
INSERT INTO bairro VALUES (null, 'Santa Isabel');
INSERT INTO bairro VALUES (null, 'Itacoatiara');
INSERT INTO bairro VALUES (null, 'Camboinhas');
INSERT INTO bairro VALUES (null, 'Engenho do Mato');
INSERT INTO bairro VALUES (null, 'Fonseca');
INSERT INTO bairro VALUES (null, 'Itaipu');
INSERT INTO bairro VALUES (null, 'Itaipuaçu');


-- INSERT 4 Combustivel


INSERT INTO combustivel VALUES (null, 'Flex');
INSERT INTO combustivel VALUES (null, 'Diesel');


-- INSERT endereco *** JAVA
SELECT * FROM endereco;
INSERT INTO endereco VALUES(null, '24030085', 'R. Alm. Tefé', '680', 'Predio', 1, 1, 1); 

-- INSERT 3 forma_pagamento

INSERT INTO forma_pagamento VALUES (null, 'Crédito');
INSERT INTO forma_pagamento VALUES (null, 'Débito');
INSERT INTO forma_pagamento VALUES (null, 'Boleto');

-- INSERT item_pedidos *** JAVA


-- INSERT 2 tipo_usuario

select * from tipo_usuario;
INSERT INTO tipo_usuario VALUES (null, 'Funcionário');
INSERT INTO tipo_usuario VALUES (null, 'Cliente');

-- INSERT 7 CORES
 
INSERT INTO cor VALUES (null, 'Branco'); -- 1 
INSERT INTO cor VALUES (null, 'Prata'); -- 2
INSERT INTO cor VALUES (null, 'Cinza'); -- 3
INSERT INTO cor VALUES (null, 'Azul'); -- 4
INSERT INTO cor VALUES (null, 'Laranja'); -- 5
INSERT INTO cor VALUES (null, 'Preto'); -- 6
INSERT INTO cor VALUES (null, 'Vermelho'); -- 7

-- INSERT 6 MARCA

INSERT INTO marca VALUES (null, 'Volkswagen'); -- 1
INSERT INTO marca VALUES (null, 'Fiat'); -- 2
INSERT INTO marca VALUES (null, 'Chevrolet'); -- 3
INSERT INTO marca VALUES (null, 'Ford'); -- 4
INSERT INTO marca VALUES (null, 'Honda'); -- 5 
INSERT INTO marca VALUES (null, 'Renault'); -- 6


-- INSERT USUARIO *** JAVA
select * from usuario where senha = md5('admin');
select  md5('admin');
INSERT INTO USUARIO VALUES(null, 'admin', 'senac', '12345678921', 'admin@senac.com.br', md5('admin'), 1, 1);
SELECT * FROM USUARIO;
-- INSERT CONTATO *** JAVA

-- INSERT VEICULOS

INSERT INTO veiculos VALUES (null, 'Accord', 2020, 'abc123456qwerty00', 204900.00, 2, 5, 1);
INSERT INTO veiculos VALUES (null, 'Civic', 2020, 'abc123456qwerty01', 97900.0, 2, 5, 1);
INSERT INTO veiculos VALUES (null, 'Toro', 2020, 'abc123456qwerty02', 125502.00, 4, 2, 2);
INSERT INTO veiculos VALUES (null, 'Tracker', 2020, 'abc123456qwerty03', 93990.00, 6, 3, 1);
INSERT INTO veiculos VALUES (null, 'Uno Attractive', 2020, 'abc123456qwerty04', 46490.00, 7, 2, 1);
INSERT INTO veiculos VALUES (null, 'Virtus', 2020, 'abc123456qwerty05', 60990.00, 6, 1, 1);
INSERT INTO veiculos VALUES (null, 'WRV', 2020, 'abc123456qwerty06', 87900.00, 6, 5, 1);
INSERT INTO veiculos VALUES (null, 'T-Cross', 2020, 'abc123456qwerty07', 94990.00, 6, 1, 1);
INSERT INTO veiculos VALUES (null, 'KA Sedan', 2020, 'abc123456qwerty08', 57990.00, 7, 4, 1);
INSERT INTO veiculos VALUES (null, 'Sandero Life 1.0', 2020, 'abc123456qwerty09', 42990.00, 7, 6, 1);
INSERT INTO veiculos VALUES (null, 'S10 LTZ', 2020, 'abc123456qwerty10', 130990.00, 4, 3, 1);
INSERT INTO veiculos VALUES (null, 'City', 2020, 'abc123456qwerty11', 85800.00, 2, 5, 1);
INSERT INTO veiculos VALUES (null, 'Ranger', 2020, 'abc123456qwerty12', 124900.00, 4, 4, 2);
INSERT INTO veiculos VALUES (null, 'Prisma', 2020, 'abc123456qwerty13', 93990.00, 1, 3, 2);
INSERT INTO veiculos VALUES (null, 'Polo', 2020, 'abc123456qwerty14', 57390.00, 6, 1, 1);
INSERT INTO veiculos VALUES (null, 'Onix', 2020, 'abc123456qwerty15', 44990.00, 6, 3, 1);
INSERT INTO veiculos VALUES (null, 'Logan', 2020, 'abc123456qwerty16', 45490.00, 3, 6, 1);
INSERT INTO veiculos VALUES (null, 'Kwid', 2020, 'abc123456qwerty17', 36900.00, 5, 6, 1);
INSERT INTO veiculos VALUES (null, 'KA', 2020, 'abc123456qwerty18', 42490.00, 3, 4, 1);
INSERT INTO veiculos VALUES (null, 'Jetta', 2020, 'abc123456qwerty19', 93990.00, 1, 1, 1);
INSERT INTO veiculos VALUES (null, 'HRV', 2020, 'abc123456qwerty20', 139900.00, 1, 5, 1);
INSERT INTO veiculos VALUES (null, 'Grand Siena', 2020, 'abc123456qwerty21', 44490.00, 6, 2, 1);
INSERT INTO veiculos VALUES (null, 'Gol', 2020, 'abc123456qwerty22', 43690.00, 1, 1, 1);
INSERT INTO veiculos VALUES (null, 'New Fiesta', 2020, 'abc123456qwerty23', 50990.00, 2, 4, 1);
INSERT INTO veiculos VALUES (null, 'Ecosport', 2020, 'abc123456qwerty24', 68990.00, 7, 4, 1);
INSERT INTO veiculos VALUES (null, 'Duster', 2020, 'abc123456qwerty25', 72990.00, 5, 6, 1);
INSERT INTO veiculos VALUES (null, 'Cruze', 2020, 'abc123456qwerty26', 96490.00, 1, 3, 1);
INSERT INTO veiculos VALUES (null, 'Cronos', 2020, 'abc123456qwerty27', 53266.00, 2, 2, 1);
INSERT INTO veiculos VALUES (null, 'Captur', 2020, 'abc123456qwerty28', 88867.00, 1, 6, 1);
INSERT INTO veiculos VALUES (null, 'Argo', 2020, 'abc123456qwerty29', 49590.00, 1, 2, 1);

-- drop database concessionariadb;

-- DML



