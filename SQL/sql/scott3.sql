SELECT  * FROM EMP;

--1. EMP ���̺��� �ο���,�ִ� �޿�,�ּ� �޿�,�޿��� ���� ����Ͽ� ����ϴ� SELECT ������ �ۼ��Ͽ���.

SELECT COUNT(*) �ο���, MAX(SAL) �ִ�޿� , MIN(SAL) �ּұ޿�, SUM(SAL)
FROM EMP;

--2. EMP ���̺��� �� �������� �ִ� �޿�, �ּ� �޿�, �޿��� ���� ����ϴ� SELECT ������ �ۼ��Ͽ���.

SELECT JOB, MAX(SAL), MIN(SAL), SUM(SAL)
FROM EMP
GROUP BY JOB

--3. EMP ���̺��� ������ �ο����� ���Ͽ� ����ϴ� SELECT ������ �ۼ��Ͽ���.

SELECT JOB ����, COUNT(*) "�ο���"
FROM EMP
GROUP BY JOB


--4. EMP ���̺��� �ְ� �޿��� �ּ� �޿��� ���̴� ���ΰ� ����ϴ� SELECT ������ �ۼ��Ͽ���.

SELECT MAX(SAL)-MIN(SAL) �ִ��ּұ޿�����
FROM EMP


/*
5. EMP ���̺��� �Ʒ��� ����� ����ϴ� SELECT ������ �ۼ��Ͽ���.

H_YEAR  COUNT(*)  MIN(SAL)  MAX(SAL)  AVG(SAL)  SUM(SAL)

------ --------- --------- --------- --------- ---------

    87        2      1100      3000      2050      4100

    81       10       950      5000    2282.5	  22825

    82        1      1300      1300      1300      1300

    80        1       800       800       800       800
 */

SELECT TO_CHAR(HIREDATE, 'YY') H_YEAR, COUNT(*), MIN(SAL), MAX(SAL), AVG(SAL), SUM(SAL)
FROM EMP
GROUP BY TO_CHAR(HIREDATE, 'YY');


/*
6. EMP ���̺��� �Ʒ��� ����� ����ϴ� SELECT ������ �ۼ��Ͽ���.

    TOTAL      1980      1981      1982      1983

--------- --------- --------- --------- ---------

       12         1        10         1         0
 */
 --���1
SELECT
DISTINCT((SELECT SUM(COUNT(*)) FROM EMP  GROUP BY HIREDATE
HAVING HIREDATE LIKE '1980%' OR HIREDATE LIKE '1981%' OR HIREDATE LIKE '1982%'
OR HIREDATE LIKE '1983%')) "TOTAL",
(SELECT SUM(COUNT(*)) FROM EMP GROUP BY HIREDATE HAVING HIREDATE LIKE '1980%') "1980",
(SELECT SUM(COUNT(*)) FROM EMP GROUP BY HIREDATE HAVING HIREDATE LIKE '1981%') "1981",
(SELECT SUM(COUNT(*)) FROM EMP GROUP BY HIREDATE HAVING HIREDATE LIKE '1982%') "1982",
NVL((SELECT SUM(COUNT(*)) FROM EMP GROUP BY HIREDATE HAVING HIREDATE LIKE '1983%'),0) "1983"
FROM EMP



--���2
SELECT DISTINCT
(SELECT COUNT(*) FROM EMP WHERE HIREDATE LIKE '1980%' OR HIREDATE LIKE '1981%'
OR HIREDATE LIKE'1982%' OR HIREDATE LIKE'1983%') "TOTAL",
(SELECT COUNT(*) FROM EMP WHERE HIREDATE LIKE '1980%') "1980",
(SELECT COUNT(*) FROM EMP WHERE HIREDATE LIKE '1981%') "1981",
(SELECT COUNT(*) FROM EMP WHERE HIREDATE LIKE '1982%') "1982",
(SELECT COUNT(*) FROM EMP WHERE HIREDATE LIKE '1983%') "1983"
FROM EMP;


/*
7. EMP ���̺��� �Ʒ��� ����� ����ϴ� SELECT ������ �ۼ��Ͽ���.

JOB         Deptno 10    Deptno 20     Deptno 30     Total

---------   ---------    ---------     ---------     ---------

CLERK            1300         1900           950          4150

SALESMAN                                    5600          5600

PRESIDENT	 5000                                     5000

MANAGER	         2450         2975          2850          8275

ANALYST	                      6000                        6000
*/


SELECT JOB, NVL(SUM(CASE DEPTNO WHEN 10 THEN SAL END),0) "Deptno 10",
NVL(SUM(CASE DEPTNO WHEN 20 THEN SAL END),0) "Deptno 20",
NVL(SUM(CASE DEPTNO WHEN 30 THEN SAL END),0) "Deptno 30",
(SUM(SAL)) "Total"
FROM EMP GROUP BY JOB
