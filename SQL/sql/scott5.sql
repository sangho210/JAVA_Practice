--1. EMP ���̺��� Blake�� ���� �μ��� �ִ� ��� ����� �̸��� �Ի����ڸ� ����ϴ� SELECT���� �ۼ��Ͻÿ�.
SELECT * FROM EMP;

SELECT ENAME, HIREDATE FROM EMP WHERE DEPTNO=30;


--2. EMP ���̺��� ��� �޿� �̻��� �޴� ��� �������� ���ؼ� ������ ��ȣ�� �̸��� ����ϴ� SELECT���� �ۼ��Ͻÿ�. �� �޿��� ���� ������ ����Ͽ���.

 SELECT * FROM EMP;

 SELECT EMPNO, ENAME FROM EMP WHERE (SAL >= (SELECT CEIL(AVG(SAL)) FROM EMP));



--3. EMP ���̺��� �̸��� ��T���� �ִ� ����� �ٹ��ϴ� �μ����� �ٹ��ϴ� ��� �������� ���� ��� ��ȣ,�̸�,�޿��� ����ϴ� SELECT���� �ۼ��Ͻÿ�. �� �����ȣ ������ ����Ͽ���.

 SELECT * FROM EMP;

 SELECT EMPNO, ENAME, SAL
 FROM EMP
 WHERE DEPTNO
 AND DEPTNO LIKE (SELECT DEPTNO FROM EMP WHERE ENAME LIKE '%T%');


--4. EMP ���̺��� �μ� ��ġ�� Dallas�� ��� �������� ���� �̸�,����,�޿��� ����ϴ� SELECT���� �ۼ��Ͻÿ�.
 SELECT * FROM EMP;
 SELECT * FROM DEPT;

SELECT ENAME, JOB, SAL
FROM EMP, DEPT
WHERE EMP.DEPTNO = DEPT.DEPTNO
AND LOC='DALLAS';


--5. EMP ���̺��� King���� �����ϴ� ��� ����� �̸��� �޿��� ����ϴ� SELECT���� �ۼ��Ͻÿ�.
 SELECT * FROM EMP;
 SELECT * FROM DEPT;

 SELECT DISTINCT
 AA.ENAME, AA.SAL
 FROM EMP AA, EMP BB
 WHERE AA.MGR='7839';


--6. EMP ���̺��� SALES�μ� ����� �̸�,������ ����ϴ� SELECT���� �ۼ��Ͻÿ�.
 SELECT * FROM EMP;


 SELECT ENAME, DNAME
 FROM EMP, DEPT
 WHERE EMP.DEPTNO=DEPT.DEPTNO
 AND DNAME='SALES';



--7. EMP ���̺��� ������ �μ� 30�� ���� ���޺��� ���� ����� ����ϴ� SELECT���� �ۼ��Ͻÿ�.
SELECT * FROM EMP;

SELECT *
FROM EMP
WHERE SAL > (SELECT MIN(SAL) FROM EMP WHERE DEPTNO=30);



--8. EMP ���̺��� �μ� 10���� �μ� 30�� ����� ���� ������ �ð� �ִ� ����� �̸��� ������ ����ϴ� SELECT���� �ۼ��Ͻÿ�.
SELECT * FROM EMP;
SELECT * FROM DEPT;


SELECT ENAME, JOB
FROM EMP
WHERE JOB = (SELECT JOB FROM EMP WHERE DEPTNO = 10 AND DEPTNO = 30);


--9. EMP ���̺��� FORD�� ������ ���޵� ���� ����� ��� ������ ����ϴ� SELECT���� �ۼ��Ͻÿ�.
SELECT * FROM EMP;

SELECT *
FROM EMP
WHERE JOB=(SELECT JOB FROM EMP WHERE ENAME='FORD') AND SAL=(SELECT SAL FROM EMP WHERE ENAME='FORD');

--10. EMP ���̺��� ������ JONS�� ���ų� ������ FORD�̻��� ����� ������ �̸�,����,�μ���ȣ,�޿��� ����ϴ� SELECT���� �ۼ��Ͻÿ�. �� ������, ������ ���� ������ ����Ͽ���.
SELECT * FROM EMP;

SELECT ENAME, JOB, DEPTNO, SAL
FROM EMP
WHERE JOB = (SELECT JOB FROM EMP WHERE ENAME='JONS') OR SAL >= (SELECT SAL FROM EMP WHERE ENAME ='FORD');


--11. EMP ���̺��� SCOTT �Ǵ� WARD�� ������ ���� ����� ������ �̸�,����,�޿��� ����ϴ� SELECT���� �ۼ��Ͻÿ�.
SELECT * FROM EMP;

SELECT ENAME, JOB, SAL
FROM EMP
WHERE SAL = (SELECT SAL FROM EMP WHERE ENAME='SCOTT') OR SAL = (SELECT SAL FROM EMP WHERE ENAME='WARD');


--12. EMP ���̺��� CHICAGO���� �ٹ��ϴ� ����� ���� ������ �ϴ� ����� �̸�, ������ ����ϴ� SELECT���� �ۼ��Ͻÿ�.
SELECT * FROM EMP;
SELECT * FROM DEPT;

SELECT ENAME, JOB
FROM EMP
WHERE JOB IN (SELECT JOB FROM EMP WHERE DEPTNO IN (SELECT DEPTNO FROM DEPT WHERE LOC='CHICAGO'));



--13. EMP ���̺��� �μ����� ������ ��� ���޺��� ���� ����� �μ���ȣ,�̸�,�޿��� ����ϴ� SELECT���� �ۼ��Ͻÿ�.
SELECT * FROM EMP;

SELECT DEPTNO, ENAME, SAL
FROM EMP
WHERE	SAL>=(SELECT TRUNC(AVG(SAL)) FROM EMP);




--14. EMP ���̺��� �������� ������ ��� ���޺��� ���� ����� �μ���ȣ,�̸�,�޿��� ����ϴ� SELECT���� �ۼ��Ͻÿ�.
SELECT * FROM EMP;

SELECT DISTINCT DEPTNO, ENAME, SAL
FROM EMP
WHERE	SAL< (SELECT TRUNC(AVG(SAL)) FROM EMP);




--15. EMP ���̺��� ��� �Ѹ� �̻����κ��� ���� ���� �� �ִ� ����� ����,�̸�,�����ȣ,�μ���ȣ��
--����ϴ� SELECT���� �ۼ��Ͻÿ�.
SELECT * FROM EMP;

SELECT JOB, ENAME, EMPNO, DEPTNO
FROM EMP
WHERE	EMPNO IN (SELECT DISTINCT MGR FROM EMP WHERE MGR IS NOT NULL);





--16. EMP ���̺��� ���� ����� �����ȣ,�̸�,����,�μ���ȣ�� ����ϴ� SELECT���� �ۼ��Ͻÿ�.
SELECT * FROM EMP;

SELECT EMPNO, ENAME, JOB, DEPTNO
FROM EMP
WHERE SAL <= (SELECT TRUNC(MIN(SAL)) FROM EMP)













