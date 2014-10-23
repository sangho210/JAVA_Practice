SELECT  * FROM EMP;

--1. EMP 테이블에서 인원수,최대 급여,최소 급여,급여의 합을 계산하여 출력하는 SELECT 문장을 작성하여라.

SELECT COUNT(*) 인원수, MAX(SAL) 최대급여 , MIN(SAL) 최소급여, SUM(SAL)
FROM EMP;

--2. EMP 테이블에서 각 업무별로 최대 급여, 최소 급여, 급여의 합을 출력하는 SELECT 문장을 작성하여라.

SELECT JOB, MAX(SAL), MIN(SAL), SUM(SAL)
FROM EMP
GROUP BY JOB

--3. EMP 테이블에서 업무별 인원수를 구하여 출력하는 SELECT 문장을 작성하여라.

SELECT JOB 업무, COUNT(*) "인원수"
FROM EMP
GROUP BY JOB


--4. EMP 테이블에서 최고 급여와 최소 급여의 차이는 얼마인가 출력하는 SELECT 문장을 작성하여라.

SELECT MAX(SAL)-MIN(SAL) 최대최소급여차이
FROM EMP


/*
5. EMP 테이블에서 아래의 결과를 출력하는 SELECT 문장을 작성하여라.

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
6. EMP 테이블에서 아래의 결과를 출력하는 SELECT 문장을 작성하여라.

    TOTAL      1980      1981      1982      1983

--------- --------- --------- --------- ---------

       12         1        10         1         0
 */
 --방법1
SELECT
DISTINCT((SELECT SUM(COUNT(*)) FROM EMP  GROUP BY HIREDATE
HAVING HIREDATE LIKE '1980%' OR HIREDATE LIKE '1981%' OR HIREDATE LIKE '1982%'
OR HIREDATE LIKE '1983%')) "TOTAL",
(SELECT SUM(COUNT(*)) FROM EMP GROUP BY HIREDATE HAVING HIREDATE LIKE '1980%') "1980",
(SELECT SUM(COUNT(*)) FROM EMP GROUP BY HIREDATE HAVING HIREDATE LIKE '1981%') "1981",
(SELECT SUM(COUNT(*)) FROM EMP GROUP BY HIREDATE HAVING HIREDATE LIKE '1982%') "1982",
NVL((SELECT SUM(COUNT(*)) FROM EMP GROUP BY HIREDATE HAVING HIREDATE LIKE '1983%'),0) "1983"
FROM EMP



--방법2
SELECT DISTINCT
(SELECT COUNT(*) FROM EMP WHERE HIREDATE LIKE '1980%' OR HIREDATE LIKE '1981%'
OR HIREDATE LIKE'1982%' OR HIREDATE LIKE'1983%') "TOTAL",
(SELECT COUNT(*) FROM EMP WHERE HIREDATE LIKE '1980%') "1980",
(SELECT COUNT(*) FROM EMP WHERE HIREDATE LIKE '1981%') "1981",
(SELECT COUNT(*) FROM EMP WHERE HIREDATE LIKE '1982%') "1982",
(SELECT COUNT(*) FROM EMP WHERE HIREDATE LIKE '1983%') "1983"
FROM EMP;


/*
7. EMP 테이블에서 아래의 결과를 출력하는 SELECT 문장을 작성하여라.

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
