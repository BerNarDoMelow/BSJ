CREATE TABLE APPCONFIG (ID INTEGER PRIMARY KEY NOT NULL, TOTALAMOUNTPERCENTAGE DOUBLE NOT NULL, AMOUNTTHRESHOLD DOUBLE, ELIGIBLEPERCENTAGE DOUBLE NOT NULL)
CREATE TABLE CUSTOMER (ID INTEGER GENERATED BY DEFAULT AS IDENTITY (START WITH 1) PRIMARY KEY NOT NULL, DESIGNATION VARCHAR(50) NOT NULL, PHONENUMBER INTEGER, VATNUMBER INTEGER NOT NULL UNIQUE, DISCOUNT_ID INTEGER NOT NULL)
CREATE TABLE PRODUCT (ID INTEGER GENERATED BY DEFAULT AS IDENTITY (START WITH 1) PRIMARY KEY NOT NULL, DESCRIPTION VARCHAR(255), DISCOUNTELIGIBILITY SMALLINT default 0, FACEVALUE DOUBLE, PRODCOD INTEGER, QTY DOUBLE, UNIT_ID INTEGER)
CREATE TABLE SALEPRODUCT (ID INTEGER GENERATED BY DEFAULT AS IDENTITY (START WITH 1) PRIMARY KEY NOT NULL, QTY DOUBLE, PRODUCT_ID INTEGER, SALE_ID INTEGER)
CREATE TABLE SALE (ID INTEGER GENERATED BY DEFAULT AS IDENTITY (START WITH 1) PRIMARY KEY NOT NULL, DATE DATE, TOTAL DOUBLE, DISCOUNT_TOTAL DOUBLE, STATUS CHAR(1), CUSTOMER_ID INTEGER, VENDEDOR_ID INT,COMISSAO DOUBLE)
CREATE TABLE VENDEDOR (ID INTEGER GENERATED BY DEFAULT AS IDENTITY (START WITH 1) PRIMARY KEY NOT NULL, NUMERO INT,NOME CHAR(100),TELEFONE INT,TOTALCOMISSAO DOUBLE)
ALTER TABLE SALEPRODUCT ADD CONSTRAINT FK_SALEPRODUCT_PRODUCT_ID FOREIGN KEY (PRODUCT_ID) REFERENCES PRODUCT (ID)
ALTER TABLE SALEPRODUCT ADD CONSTRAINT FK_SALEPRODUCT_SALEPRODUCTS_ID FOREIGN KEY (SALE_ID) REFERENCES SALE (ID)
ALTER TABLE SALE ADD CONSTRAINT FK_SALE_CUSTOMER_ID FOREIGN KEY (CUSTOMER_ID) REFERENCES CUSTOMER (ID)
INSERT INTO APPCONFIG VALUES (1, 0.1, 50, 0.15)
INSERT INTO PRODUCT (ID, PRODCOD, DESCRIPTION, FACEVALUE, QTY, DISCOUNTELIGIBILITY, UNIT_ID) VALUES (1, 123, 'Prod 1', 100, 500, 0, 1)
INSERT INTO PRODUCT (ID, PRODCOD, DESCRIPTION, FACEVALUE, QTY, DISCOUNTELIGIBILITY, UNIT_ID) VALUES (2, 124, 'Prod 2', 35, 1000, 1, 1)
