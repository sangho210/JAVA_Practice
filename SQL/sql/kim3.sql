
--DATABASE DICTIONARY
--ORACLE�� ������ �����س��� TABLE �Ǵ� VIEW

SELECT * FROM USER_CONSTRAINTS;

SELECT COUNT(*) FROM DICTIONARY;
SELECT * FROM DICTIONARY;

--����
/*

USER_ ������ ���°�, ��������� ���� (��������)
ALL_  ������ ������ �������� ���°�(�߰�)
DBA_  ���� �ٺ��°�, �����س�, ������(����ū��), 85%
V$  : ORACLE�� H/W����

*/


SELECT * FROM USER_CONSTRAINTS;

SELECT * FROM ALL_CONSTRAINTS;

SELECT * FROM DBA_CONSTRAINTS;

SELECT * FROM V$VERSION;

SELECT * FROM USER_INDEXES;
SELECT * FROM USER_CATALOG;
SELECT * FROM USER_TABLES;
SELECT * FROM USER_VIEWS;
SELECT * FROM USER_TAB_PRIVS; --������ �����ش�.
SELECT * FROM USER_SYS_PRIVS; --UNLIMITED ���� Ȯ�ε�

--VIEW
--SIMPLE VIEW


--SYS���� ���� CREATE������ �ְ� �Ʒ� ����

CREATE VIEW PER10_V
AS
SELECT * FROM PERSONNEL WHERE DNO=10;

SELECT * FROM PER10_V;  --Ȯ��

CREATE VIEW PER20_V
AS
SELECT PNO, PNAME, MANAGER, PAY, DNO FROM PERSONNEL;

SELECT * FROM PER20_V;



-- ��� �հ� ���ϴ� �����

CREATE VIEW PER_AVG
AS
SELECT DNO, AVG(PAY) ���, SUM(PAY) �հ�
FROM PERSONNEL
GROUP BY DNO;


SELECT * FROM PER_AVG; -- �̰͸� ���� ������ ���� ���ɰ���
--���� ���� : ����, �ڵ��� ª������.


--WHERE���� ����
SELECT * FROM PER_AVG WHERE DNO=10;

SELECT * FROM PER_AVG WHERE �հ�>7500;

--DML�� ����
SELECT * FROM PER20_V;

INSERT INTO PER20_V VALUES(1234,'JJJ','1001',2000,10);
SELECT * FROM PER20_V;

UPDATE PER20_V SET PNAME='AAA' WHERE PNO=1234

DELETE PER20_V WHERE PNO=1234;

SELECT * FROM PERSONNEL;

 --INSERT����
 CREATE VIEW PER
 AS
 SELECT PNAME, JOB, PAY FROM PERSONNEL;

SELECT * FROM PER;

INSERT INTO PER VALUES ('BBB','ACCOUNT',3000);  --X

SELECT * FROM PER_AVG;

INSERT INTO PER VALUES('40', 1234, 5000); --X ��������  ������ �ƴ�

--VIEW ����
CREATE -> ALTER

--������ �����ϰ� ������ ������
CREATE OR REPLACE VIEW PER20_V
(��ȣ, �̸�, ����, �μ���ȣ)
AS
SELECT PNO, PNAME, JOB, DNO FROM PERSONNEL
WHERE DNO=20;

SELECT * FROM PER20_V;

SELECT * FROM USER_VIEWS;

DROP VIEW PER_AVG;

--�Լ������ INDEX
SELECT * FROM PERSONNEL WHERE PNAME='SMITH';
SELECT * FROM PERSONNEL WHERE PNAME=UPPER('smith');







