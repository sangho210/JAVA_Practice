--1. EMP 테이블에서 Blake와 같은 부서에 있는 모든 사원의 이름과 입사일자를 출력하는 SELECT문을 작성하시오.
SELECT * FROM EMP;

SELECT ENAME, HIREDATE FROM EMP WHERE DEPTNO=30;


--2. EMP 테이블에서 평균 급여 이상을 받는 모든 종업원에 대해서 종업원 번호와 이름을 출력하는 SELECT문을 작성하시오. 단 급여가 많은 순으로 출력하여라.

 SELECT * FROM EMP;

 SELECT EMPNO, ENAME FROM EMP WHERE (SAL >= (SELECT CEIL(AVG(SAL)) FROM EMP));



--3. EMP 테이블에서 이름에 “T”가 있는 사원이 근무하는 부서에서 근무하는 모든 종업원에 대해 사원 번호,이름,급여를 출력하는 SELECT문을 작성하시오. 단 사원번호 순으로 출력하여라.

 SELECT * FROM EMP;

 SELECT EMPNO, ENAME, SAL
 FROM EMP
 WHERE DEPTNO
 AND DEPTNO LIKE (SELECT DEPTNO FROM EMP WHERE ENAME LIKE '%T%');


--4. EMP 테이블에서 부서 위치가 Dallas인 모든 종업원에 대해 이름,업무,급여를 출력하는 SELECT문을 작성하시오.
 SELECT * FROM EMP;
 SELECT * FROM DEPT;

SELECT ENAME, JOB, SAL
FROM EMP, DEPT
WHERE EMP.DEPTNO = DEPT.DEPTNO
AND LOC='DALLAS';


--5. EMP 테이블에서 King에게 보고하는 모든 사원의 이름과 급여를 출력하는 SELECT문을 작성하시오.
 SELECT * FROM EMP;
 SELECT * FROM DEPT;

 SELECT DISTINCT
 AA.ENAME, AA.SAL
 FROM EMP AA, EMP BB
 WHERE AA.MGR='7839';


--6. EMP 테이블에서 SALES부서 사원의 이름,업무를 출력하는 SELECT문을 작성하시오.
 SELECT * FROM EMP;


 SELECT ENAME, DNAME
 FROM EMP, DEPT
 WHERE EMP.DEPTNO=DEPT.DEPTNO
 AND DNAME='SALES';



--7. EMP 테이블에서 월급이 부서 30의 최저 월급보다 높은 사원을 출력하는 SELECT문을 작성하시오.
SELECT * FROM EMP;

SELECT *
FROM EMP
WHERE SAL > (SELECT MIN(SAL) FROM EMP WHERE DEPTNO=30);



--8. EMP 테이블에서 부서 10에서 부서 30의 사원과 같은 업무를 맡고 있는 사원의 이름과 업무를 출력하는 SELECT문을 작성하시오.
SELECT * FROM EMP;
SELECT * FROM DEPT;


SELECT ENAME, JOB
FROM EMP
WHERE JOB = (SELECT JOB FROM EMP WHERE DEPTNO = 10 AND DEPTNO = 30);


--9. EMP 테이블에서 FORD와 업무도 월급도 같은 사원의 모든 정보를 출력하는 SELECT문을 작성하시오.
SELECT * FROM EMP;

SELECT *
FROM EMP
WHERE JOB=(SELECT JOB FROM EMP WHERE ENAME='FORD') AND SAL=(SELECT SAL FROM EMP WHERE ENAME='FORD');

--10. EMP 테이블에서 업무가 JONS와 같거나 월급이 FORD이상인 사원의 정보를 이름,업무,부서번호,급여를 출력하는 SELECT문을 작성하시오. 단 업무별, 월급이 많은 순으로 출력하여라.
SELECT * FROM EMP;

SELECT ENAME, JOB, DEPTNO, SAL
FROM EMP
WHERE JOB = (SELECT JOB FROM EMP WHERE ENAME='JONS') OR SAL >= (SELECT SAL FROM EMP WHERE ENAME ='FORD');


--11. EMP 테이블에서 SCOTT 또는 WARD와 월급이 같은 사원의 정보를 이름,업무,급여를 출력하는 SELECT문을 작성하시오.
SELECT * FROM EMP;

SELECT ENAME, JOB, SAL
FROM EMP
WHERE SAL = (SELECT SAL FROM EMP WHERE ENAME='SCOTT') OR SAL = (SELECT SAL FROM EMP WHERE ENAME='WARD');


--12. EMP 테이블에서 CHICAGO에서 근무하는 사원과 같은 업무를 하는 사원의 이름, 업무를 출력하는 SELECT문을 작성하시오.
SELECT * FROM EMP;
SELECT * FROM DEPT;

SELECT ENAME, JOB
FROM EMP
WHERE JOB IN (SELECT JOB FROM EMP WHERE DEPTNO IN (SELECT DEPTNO FROM DEPT WHERE LOC='CHICAGO'));



--13. EMP 테이블에서 부서별로 월급이 평균 월급보다 높은 사원을 부서번호,이름,급여를 출력하는 SELECT문을 작성하시오.
SELECT * FROM EMP;

SELECT DEPTNO, ENAME, SAL
FROM EMP
WHERE	SAL>=(SELECT TRUNC(AVG(SAL)) FROM EMP);




--14. EMP 테이블에서 업무별로 월급이 평균 월급보다 낮은 사원을 부서번호,이름,급여를 출력하는 SELECT문을 작성하시오.
SELECT * FROM EMP;

SELECT DISTINCT DEPTNO, ENAME, SAL
FROM EMP
WHERE	SAL< (SELECT TRUNC(AVG(SAL)) FROM EMP);




--15. EMP 테이블에서 적어도 한명 이상으로부터 보고를 받을 수 있는 사원을 업무,이름,사원번호,부서번호를
--출력하는 SELECT문을 작성하시오.
SELECT * FROM EMP;

SELECT JOB, ENAME, EMPNO, DEPTNO
FROM EMP
WHERE	EMPNO IN (SELECT DISTINCT MGR FROM EMP WHERE MGR IS NOT NULL);





--16. EMP 테이블에서 말단 사원의 사원번호,이름,업무,부서번호를 출력하는 SELECT문을 작성하시오.
SELECT * FROM EMP;

SELECT EMPNO, ENAME, JOB, DEPTNO
FROM EMP
WHERE SAL <= (SELECT TRUNC(MIN(SAL)) FROM EMP)













