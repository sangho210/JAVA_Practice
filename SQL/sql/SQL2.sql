SELECT * FROM TAB;

SELECT * FROM EMP;


--1. 현재 날짜를 출력하고 열 레이블은 Current Date로 출력하는 SELECT 문장을 기술하시오.

SELECT TO_CHAR(sysdate, 'YYYY-MM-DD') "Current Date" FROM DUAL;

--2. EMP 테이블에서 현재 급여에 15%가 증가된 급여를 사원번호,이름,업무,급여,증가된 급여(New Salary),증가액(Increase)를 출력하는 SELECT 문장을 기술하시오.

SELECT EMPNO,ENAME,JOB,SAL,(SAL*1.15) "New Salary", ((SAL*1.15)-SAL) "Increase"
FROM EMP;

--3. EMP 테이블에서 이름,입사일,입사일로부터 6개월 후 돌아오는 월요일 구하여 출력하는 SELECT 문장을 기술하시오.

SELECT ENAME, TO_CHAR(HIREDATE, 'YYYY-MM-DD DY') 고용일, TO_CHAR(NEXT_DAY(ADD_MONTHS(HIREDATE,6),'MONDAY'), 'YYYY-MM-DD DY') "6개월 후 월요일" FROM EMP;


--4. EMP 테이블에서 이름,입사일, 입사일로부터 현재까지의 월수,급여, 입사일부터 현재까지의 급여의 총계를 출력하는 SELECT 문장을 기술하시오.

SELECT ENAME, HIREDATE, TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) "재직월수", SAL,
TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE))*SAL "총급여"
FROM EMP;


/*
5. EMP 테이블에서 다음의 결과가 출력되도록 작성하시오.

Dream Salary

------------------------------------------------------------

KING earns $5,000.00 monthly but wants $15,000.00

BLAKE earns $2,850.00 monthly but wants $8,550.00

CLARK earns $2,450.00 monthly but wants $7,350.00

. . . . . . . . . .
14 rows selected
*/

SELECT ENAME||' earns'||TO_CHAR(SAL, '$99,999.99')||' monthly but wants'||TO_CHAR(SAL*3, '$99,999.99')
"Dream Salary"
FROM EMP


--6. EMP 테이블에서 모든 사원의 이름과 급여(15자리로 출력 좌측의 빈곳은 “*”로 대치)를 출력하는 SELECT 문장을 기술하시오.

SELECT ENAME, LPAD(SAL, 15, '*') "급여"
FROM EMP



--7. EMP 테이블에서 모든 사원의 정보를 이름,업무,입사일,입사한 요일을 출력하는 SELECT 문장을 기술하시오.

SELECT ENAME,JOB,HIREDATE, TO_CHAR(HIREDATE,'DY') "입사한 요일"
FROM EMP;



--8. EMP 테이블에서 이름의 길이가 6자 이상인 사원의 정보를 이름,이름의 글자수,업무를 출력하는 SELECT 문장을 기술하시오.

SELECT ENAME,LENGTH(ENAME) "이름의글자수", JOB
FROM EMP
WHERE LENGTH(ENAME) >= 6;


--9. EMP 테이블에서 모든 사원의 정보를 이름,업무,급여,보너스,급여+보너스를 출력하는 SELECT 문장을 기술하시오.

SELECT ENAME 이름, JOB 업무, SAL 급여, NVL(COMM,0) "보너스", SAL+ NVL(COMM,0) "급여+보너스"
FROM EMP;


