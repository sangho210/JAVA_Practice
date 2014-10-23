SELECT * FROM EMP;
SELECT * FROM DEPT;
SELECT * FROM BONUS;
SELECT * FROM SALGRADE;

--1. EMP ���̺��� ��� ����� ���� �̸�,�μ���ȣ,�μ����� ����ϴ� SELECT ������ �ۼ��Ͽ���.

SELECT ENAME �̸�,DEPTNO �μ���ȣ,JOB �μ��� FROM EMP;


--2. EMP ���̺��� NEW YORK���� �ٹ��ϰ� �ִ� ����� ���Ͽ� �̸�,����,�޿�,�μ����� ����ϴ� SELECT ������ �ۼ��Ͽ���.

SELECT ENAME,JOB,SAL,DNAME
FROM EMP, DEPT
WHERE EMP.DEPTNO=DEPT.DEPTNO
AND LOC='NEW YORK';

--3. EMP ���̺��� ���ʽ��� �޴� ����� ���Ͽ� �̸�,�μ���,��ġ�� ����ϴ� SELECT ������ �ۼ��Ͽ���.

SELECT ENAME, DNAME, LOC
FROM EMP, DEPT
WHERE EMP.DEPTNO=DEPT.DEPTNO
AND COMM IS NOT NULL;

--4. EMP ���̺��� �̸� �� L�ڰ� �ִ� ����� ���Ͽ� �̸�,����,�μ���,��ġ�� ����ϴ� SELECT ������ �ۼ��Ͽ���.

SELECT ENAME,JOB,DNAME, LOC
FROM EMP, DEPT
WHERE EMP.DEPTNO=DEPT.DEPTNO
AND ENAME LIKE '%L%';


/*
5. �Ʒ��� ����� ����ϴ� SELECT ������ �ۼ��Ͽ���.(�����ڰ� ���� King�� �����Ͽ� ��� ����� ���)

Employee        Emp# Manager         Mgr#

---------- --------- ---------- ---------

KING            7839

BLAKE           7698 KING            7839

CLARK           7782 KING            7839

. . . . . . . . . .

14 rows selected.
*/

SELECT * FROM EMP;

SELECT
AA.ENAME "Employee",
AA.EMPNO "EMP#",
(SELECT BB.ENAME FROM DUAL WHERE AA.MGR=BB.EMPNO) " Manager",
AA.MGR "Mgr#"
FROM EMP AA, EMP BB
WHERE AA.MGR=BB.EMPNO OR (AA.MGR IS NULL AND BB.MGR IS NULL);


--6. EMP ���̺��� �׵��� ������ ���� ���� �Ի��� ����� ���Ͽ� �̸�,�Ի���,������ �̸�, ������ �Ի����� ����ϴ� SELECT ������ �ۼ��Ͽ���.



/*
7. EMP ���̺��� ����� �޿��� ����� �޿� �縸ŭ ��*���� ����ϴ� SELECT ������ �ۼ��Ͽ���. �� ��*���� 100�� �ǹ��Ѵ�.

Employee and their salary

-----------------------------------------------------------------

KING      **************************************************

BLAKE     ****************************

CLARK     ************************

JONES     *****************************

MARTIN    ************

ALLEN     ****************

TURNER    ***************

. . . . . . . . . .

14 rows selected.
*/


