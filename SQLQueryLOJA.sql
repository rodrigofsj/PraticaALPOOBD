CREATE DATABASE LOJA;

USE LOJA;

CREATE TABLE CLIENTES 
(
	COD_CLIENTE INT NOT NULL,
	NOME VARCHAR (100) NOT NULL,
	DATA_NASC DATETIME NOT NULL,
	ENDERECO VARCHAR (100) NOT NULL,
	TELEFONE VARCHAR (20) NOT NULL,
	EMAIL VARCHAR (50),
);
ALTER TABLE CLIENTES ADD CONSTRAINT PK_CLIENTE PRIMARY KEY (COD_CLIENTE)
------------------------

CREATE TABLE VENDAS
(
	COD_VENDA INT NOT NULL,
	DATA DATETIME NOT NULL,
	HORA VARCHAR (20) NOT NULL,
	TOTAL FLOAT NOT NULL,
);
ALTER TABLE VENDAS ADD CONSTRAINT PK_VENDA PRIMARY KEY (COD_VENDA)

ALTER TABLE VENDAS ADD IDFK_CLIENTE INT NOT NULL

ALTER TABLE VENDAS ADD CONSTRAINT FK_VENDA_CLIENTE FOREIGN KEY (IDFK_CLIENTE) REFERENCES CLIENTES(COD_CLIENTE)
------------------------

CREATE TABLE ITENS_VENDA
(
	QUANTIDADE INT NOT NULL,
	SUB_TOTAL FLOAT NOT NULL,
);

ALTER TABLE ITENS_VENDA ADD IDFK_VENDA INT NOT NULL

ALTER TABLE ITENS_VENDA ADD CONSTRAINT FK_ITENS_VENDAS FOREIGN KEY (IDFK_VENDA) REFERENCES VENDAS(COD_VENDA)

ALTER TABLE ITENS_VENDA ADD IDFK_PRODUTO INT NOT NULL

ALTER TABLE ITENS_VENDA ADD CONSTRAINT FK_ITENS_PRODUTOS FOREIGN KEY (IDFK_PRODUTO) REFERENCES PRODUTOS(COD_PRODUTO)
------------------------

CREATE TABLE PRODUTOS 
(
	COD_PRODUTO INT NOT NULL,
	PRECO_VENDA FLOAT NOT NULL,
	DESCRICAO VARCHAR (150),
	DATA_VALIDADE DATETIME,
	PRECO_CUSTO FLOAT NOT NULL,
	ESTOQUE INT NOT NULL,
);

ALTER TABLE PRODUTOS ADD CONSTRAINT PK_PRODUTO PRIMARY KEY (COD_PRODUTO)

ALTER TABLE PRODUTOS ADD IDFK_DISTRIBUIDOR INT NOT NULL

ALTER TABLE PRODUTOS ADD CONSTRAINT FK_PRODUTO_DISTRIBUIDOR FOREIGN KEY (IDFK_DISTRIBUIDOR) REFERENCES DISTRIBUIDORES(COD_DISTRIBUIDOR)
------------------------

CREATE TABLE DISTRIBUIDORES
(
	COD_DISTRIBUIDOR INT NOT NULL,
	NOME_FANTASIA VARCHAR (100) NOT NULL,
	RAZAO_SOCIAL VARCHAR (100) NOT NULL,
	TELEFONE VARCHAR (20) NOT NULL,
	EMAIL VARCHAR (70) NOT NULL,
);

ALTER TABLE DISTRIBUIDORES ADD CONSTRAINT PK_DISTRIBUIDOR PRIMARY KEY (COD_DISTRIBUIDOR)

ALTER TABLE CLIENTES ADD CONSTRAINT UK_COD_CLIENTE UNIQUE(COD_CLIENTE)

ALTER TABLE DISTRIBUIDORES ADD CONSTRAINT UK_COD_DISTRIBUIDOR UNIQUE(COD_DISTRIBUIDOR)

ALTER TABLE PRODUTOS ADD CONSTRAINT UK_COD_PRODUTO UNIQUE(COD_PRODUTO)

ALTER TABLE VENDAS ADD CONSTRAINT UK_COD_VENDA UNIQUE(COD_VENDA)

SELECT * FROM CLIENTES

SELECT * FROM VENDAS  

SELECT * FROM DISTRIBUIDORES

SELECT * FROM PRODUTOS

SELECT * FROM ITENS_VENDA

DELETE FROM PRODUTOS WHERE COD_PRODUTO=11;


