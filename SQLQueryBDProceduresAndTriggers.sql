/*Exercício 1. Crie stored procedures para resolver os problemas abaixo:
	Inserir um cliente somente se ele nasceu após 13/10/1993 */
CREATE PROCEDURE NASC_APOS
@COD_CLIENTE INT,
@NOME VARCHAR(100),
@DATA_NASC DATE,
@ENDERECO VARCHAR(100),
@TELEFONE VARCHAR(20),
@EMAIL VARCHAR(50)
AS
BEGIN
	IF (@DATA_NASC >= '1993-10-13')
	BEGIN
		INSERT INTO CLIENTES (COD_CLIENTE, NOME, DATA_NASC, ENDERECO, TELEFONE, EMAIL) VALUES (@COD_CLIENTE, @NOME, @DATA_NASC, @ENDERECO, @TELEFONE, @EMAIL);
	END
	ELSE
	BEGIN
		PRINT('Data Inválida')
	END
END

EXEC NASC_APOS '6', 'Murilo', '2001-08-20', 'Rua Kodak, 32 - 31 de Março', '(12)98111-2222','murilo@hotmail.com'
EXEC NASC_APOS '7', 'CARLOS', '1992-10-13', 'Rua América, 50 - Boa Vista', '(12)98222-3333', 'carlos@hotmail.com'

-------------------------------------------------

--Inserir um produto somente se houver pelo menos um item dele no estoque e se não está vencido

CREATE PROCEDURE PRODUTOS_NAOVENC
@COD_PRODUTO INT,
@PRECO_VENDA FLOAT,
@DESCRICAO VARCHAR(150),
@DATA_VALIDADE DATE,
@PRECO_CUSTO FLOAT,
@ESTOQUE INT,
@IDFK_DISTRIBUIDOR INT
AS
BEGIN
	IF (@ESTOQUE >= 1 AND @DATA_VALIDADE > GETDATE())
	BEGIN
		INSERT INTO PRODUTOS VALUES (@COD_PRODUTO, @PRECO_VENDA, @DESCRICAO, @DATA_VALIDADE, @PRECO_CUSTO, @ESTOQUE, @IDFK_DISTRIBUIDOR);		
	END
	ELSE
	BEGIN
		PRINT ('Produto Inválido')	
	END
END
DROP PROCEDURE PRODUTOS_NAOVENC
EXEC PRODUTOS_NAOVENC '11', '24.99', 'Kit Limpa Telas Lentes Note Tv Tablet Celular Bactericida', '2021-10-07', '10', '4', '1'
EXEC PRODUTOS_NAOVENC '12', '17', 'Limpa Contato Elétrico Spray Eletronico 300ml Orbi', '2020-01-10', '9', '1', '1'
EXEC PRODUTOS_NAOVENC '13', '10', 'Caixa de Bombom', '2022-12-12', '5', '0', '1'

-------------------------------------------------

--Inserir um distribuidor somente se seu nome fantasia e razão social forem diferentes

CREATE PROCEDURE FANTASIA_RAZAO_DIFERENTE
@COD_DISTRIBUIDOR INT,
@NOME_FANTASIA VARCHAR(100),
@RAZAO_SOCIAL VARCHAR(100),
@TELEFONE VARCHAR(20),
@EMAIL VARCHAR(70)
AS
BEGIN
	IF (@NOME_FANTASIA != @RAZAO_SOCIAL)
	BEGIN 
		INSERT INTO DISTRIBUIDORES VALUES (@COD_DISTRIBUIDOR, @NOME_FANTASIA, @RAZAO_SOCIAL, @TELEFONE, @EMAIL);
	END
	ELSE
	BEGIN
		PRINT ('Nome Fantasia e Razão Social iguais')
	END
END

EXEC FANTASIA_RAZAO_DIFERENTE '3', 'Coca Cola', 'Coca Cola Indústrias Ltda', '(12)3966-6611', 'cocacola@hotmail.com'
EXEC FANTASIA_RAZAO_DIFERENTE '4', 'Nestle', 'Nestle', '(12)3966-1166', 'nestle@hotmail.com'

-------------------------------------------------

--Inserir uma venda somente se ela for maior que R$ 2000,00; ou se ela for menor que R$1000,00 e maior que R$ 0,00.

CREATE PROCEDURE VENDA_MAIOR_MENOR
@COD_VENDA INT,
@DATA DATE,
@HORA VARCHAR(20),
@TOTAL FLOAT,
@IDFK_CLIENTE INT
AS
BEGIN 
	IF (@TOTAL > 2000.00 OR @TOTAL < 1000.00 AND @TOTAL > 0.00)
	BEGIN
		INSERT INTO VENDAS VALUES (@COD_VENDA, @DATA, @HORA, @TOTAL, @IDFK_CLIENTE);
	END
	ELSE
	BEGIN
		PRINT ('ERRO!!!')
	END
END

EXEC VENDA_MAIOR_MENOR '11', '2020/10/15', '23:00', '2001.50', '1'
EXEC VENDA_MAIOR_MENOR '12', '2020/10/15', '22:00', '900.00', '2'
EXEC VENDA_MAIOR_MENOR '13', '2020/10/15', '20:00', '1500.50', '6'

-------------------------------------------------

--Inserir um cliente somente se seu nome terminar com “eu”. Exemplo: Irineu, Pompeu, etc...

CREATE PROCEDURE EU
@COD_CLIENTE INT,
@NOME VARCHAR(100),
@DATA_NASC DATE,
@ENDERECO VARCHAR(100),
@TELEFONE VARCHAR(20),
@EMAIL VARCHAR(50)
AS
BEGIN
	IF (@NOME LIKE '%eu')
	BEGIN
		INSERT INTO CLIENTES VALUES (@COD_CLIENTE, @NOME, @DATA_NASC, @ENDERECO, @TELEFONE, @EMAIL);
	END
	ELSE
	BEGIN
		PRINT('Nome Inválido')
	END
END

EXEC EU '7', 'Ireneu', '2020/10/15', 'Rua Vinte e Quatro, Nª 250', '(12) 98141-4141', 'ireneu@hotmail.com'
EXEC EU '8', 'Irenel', '2020/10/15', 'Rua Vinte e Quatro, Nª 250', '(12) 98141-4142', 'irenel@hotmail.com'

-------------------------------------------------

/* Exercício 2. Crie triggers para resolver os problemas abaixo:
• Atualizar a quantidade de um determinado produto em estoque, sempre que uma venda com aquele produto for realizada */

CREATE TRIGGER TR_ATT_ESTOQUE
ON ITENS_VENDA
AFTER INSERT AS
BEGIN
	DECLARE @ESTOQUE INT, @IDFK_PRODUTO INT

	SELECT @IDFK_PRODUTO = IDFK_PRODUTO, @ESTOQUE = QUANTIDADE FROM INSERTED
	UPDATE PRODUTOS SET ESTOQUE = ESTOQUE - @ESTOQUE WHERE COD_PRODUTO = @IDFK_PRODUTO
END

INSERT INTO ITENS_VENDA
(
	QUANTIDADE, SUB_TOTAL, IDFK_VENDA, IDFK_PRODUTO
)
VALUES
(
	1, 150, 5, 1
)

-------------------------------------------------

--Exibir o nome fantasia e a razão social do distribuidor cada vez que um produto novo for adicionado na tabela produtos.

CREATE TRIGGER EXIBIR_FANTASIA_RAZAOSOC
ON PRODUTOS
AFTER INSERT AS 
BEGIN
	DECLARE @IDFK_DISTRIBUIDOR INT
	SELECT @IDFK_DISTRIBUIDOR = IDFK_DISTRIBUIDOR FROM INSERTED
	SELECT NOME_FANTASIA, RAZAO_SOCIAL FROM DISTRIBUIDORES WHERE COD_DISTRIBUIDOR = @IDFK_DISTRIBUIDOR
END

INSERT INTO PRODUTOS 
(
	COD_PRODUTO, PRECO_VENDA, DESCRICAO, DATA_VALIDADE, PRECO_CUSTO, ESTOQUE, IDFK_DISTRIBUIDOR
)
VALUES
(
	12, 10, 'Refrigerante 2l - Coca cola', '2021/10/16', 5, 2, 3
)

-------------------------------------------------

/*Exibir o nome e o e-mail do cliente quando uma nova venda atribuída a ele for inserida no sistema. Caso a venda a ser 
inserida esteja atribuída a um cliente que não exista, o sistema deve exibir uma mensagem de erro.*/

CREATE TRIGGER EXIBIR_NOME_EMAIL 
ON VENDAS
AFTER INSERT AS 
BEGIN 
	DECLARE @IDFK_CLIENTE INT 
	SELECT @IDFK_CLIENTE = IDFK_CLIENTE FROM INSERTED
	IF (@IDFK_CLIENTE = '' OR @IDFK_CLIENTE = null)
	BEGIN
		PRINT ('ERRO!!!')
	END
	ELSE
	BEGIN
		SELECT NOME, EMAIL FROM CLIENTES WHERE COD_CLIENTE = @IDFK_CLIENTE
	END
END

INSERT INTO VENDAS
(
	COD_VENDA, DATA, HORA, TOTAL, IDFK_CLIENTE
)
VALUES
(
	13, '16/10/2020', '14:01', 50, 1
)

INSERT INTO VENDAS
(
	COD_VENDA, DATA, HORA, TOTAL, IDFK_CLIENTE
)
VALUES
(
	14, '11/10/2020', '15:01', 50, 8
)

-------------------------------------------------

/*Impedir a inserção de uma venda caso ela seja menor ou igual à R$ 0,00 e o sistema deve exibir uma mensagem quando houver a 
tentativa de inserção de uma venda com valor menor ou igual à R$ 0,00.*/

CREATE TRIGGER VENDA_MENOR
ON VENDAS
AFTER INSERT AS
BEGIN
	DECLARE @TOTAL FLOAT
	SELECT @TOTAL = @TOTAL FROM INSERTED;

	IF(@TOTAL <= 0.0)	
	BEGIN
		ROLLBACK
		PRINT('Venda com valor menor ou igual a 0')
	END
END

INSERT INTO VENDAS
(
	COD_VENDA, DATA, HORA, TOTAL, IDFK_CLIENTE
)
VALUES
(
	15, '11/10/2020', '15:01', 0.0, 1
)
