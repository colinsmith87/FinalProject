CREATE TABLE STORES (
STOREID     NUMBER,
SLOCATION   VARCHAR2(255) NOT NULL,
CONSTRAINT STORE_PRIMARY_KEY PRIMARY KEY (SLOCATION));

CREATE TABLE EMPLOYEE (
EMPLOYEEID  NUMBER,
FNAME       VARCHAR2(255) NOT NULL,
LNAME       VARCHAR2(255) NOT NULL,
SALARY      NUMBER NOT NULL,
ADDRESS     VARCHAR2(255) NOT NULL,
PHONE       NUMBER(10) NOT NULL,
STREET      VARCHAR2(255) NOT NULL,
CITY        VARCHAR2(255) NOT NULL,
ADDSTATE    CHAR(2) NOT NULL,
ZIP         NUMBER(5) NOT NULL,
STORELOC    VARCHAR2(255) NOT NULL,
CONSTRAINT EMPLOYEE_PRIMARY_KEY PRIMARY KEY (EMPLOYEEID),
CONSTRAINT EMPLOYEE_FOREIGN_KEY FOREIGN KEY (STORELOC) REFERENCES STORES (SLOCATION));

CREATE TABLE DEPENDENT (
DEPENDENTID     NUMBER,
FNAME           VARCHAR2(255) NOT NULL,
LNAME           VARCHAR2(255) NOT NULL,
RELATION        VARCHAR2(255) NOT NULL,
PHONE           NUMBER(10) NOT NULL,
EMPID           NUMBER,
CONSTRAINT DEPENDENT_FOREIGN_KEY FOREIGN KEY (EMPID) REFERENCES EMPLOYEE (EMPLOYEEID));

CREATE TABLE FOOD_ITEMS (
FOODID      NUMBER,
ITEMNAME    VARCHAR2(255) NOT NULL,
PRICE       NUMBER(4,2) NOT NULL,
SELLBY      DATE NOT NULL,
CONSTRAINT FOOD_ITEMS_PRIMARY_KEY PRIMARY KEY (ITEMNAME));

CREATE TABLE IN_STOCK (
INSTOCKID   NUMBER,
QUANTITY    NUMBER,
STORELOC    VARCHAR2(255) NOT NULL,
FOODNAME    VARCHAR2(255) NOT NULL,
CONSTRAINT IN_STOCK_FOREIGN_KEY_1 FOREIGN KEY (STORELOC) REFERENCES STORES (SLOCATION),
CONSTRAINT IN_STOCK_FOREIGN_KEY_2 FOREIGN KEY (FOODNAME) REFERENCES FOOD_ITEMS (ITEMNAME));

CREATE TABLE TRANSACTIONS (
TRANSACTIONID   NUMBER,
PRICE           NUMBER(4,2) NOT NULL,
FOODITEM        VARCHAR2(255) NOT NULL,
STORELOC        VARCHAR2(255) NOT NULL,
CONSTRAINT TRANSACTIONS_FOREIGN_KEY FOREIGN KEY (STORELOC) REFERENCES STORES (SLOCATION));

CREATE TABLE MEMBERS (
MEMBERID    NUMBER,
FNAME       VARCHAR2(255) NOT NULL,
LNAME       VARCHAR2(255) NOT NULL,
DATEOFBIRTH DATE NOT NULL,
PHONE       NUMBER(10) NOT NULL,
POINTS      NUMBER,
STORELOC    VARCHAR2(255) NOT NULL,
CONSTRAINT MEMBER_PRIMARY_KEY PRIMARY KEY (MEMBERID),
CONSTRAINT MEMBER_FOREIGN_KEY FOREIGN KEY (STORELOC) REFERENCES STORES (SLOCATION));
