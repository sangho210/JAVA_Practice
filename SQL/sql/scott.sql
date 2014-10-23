SELECT * FROM TAB;

SELECT * FROM EMP;


--2. EMP ���̺��� �޿��� 3000�̻��� ����� ������ �����ȣ,�̸�,������,�޿��� ����ϴ� SELECT ������ �ۼ��Ͻÿ�.

 SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE SAL >=3000;

--3. EMP ���̺��� �����ȣ�� 7788�� ����� �̸��� �μ���ȣ�� ����ϴ� SELECT ������ �ۼ��Ͻÿ�.

 SELECT ENAME,DEPTNO FROM EMP WHERE EMPNO = 7788;

--4. EMP ���̺��� �Ի����� 2��, 20, 1981�� 5��, 1, 1998 ���̿� �Ի��� ����� �̸�,����,�Ի����� ����ϴ� SELECT ������ �ۼ��Ͻÿ�. �� �Ի��� ������ ����Ͻÿ�.

 SELECT ENAME,JOB, HIREDATE FROM EMP
 WHERE HIREDATE >= '1981.02.20' AND HIREDATE <= '1998.05.01' ORDER BY HIREDATE ASC;


--5. EMP ���̺��� �μ���ȣ�� 10,20�� ����� ��� ������ ����ϴ� SELECT ������ �ۼ��Ͻÿ�. �� �̸������� �����Ͽ���.

SELECT * FROM EMP
WHERE DEPTNO IN (10,20) ORDER BY ENAME ASC;


--6. EMP ���̺��� �޿��� 1500�̻��̰� �μ���ȣ�� 10,30�� ����� �̸��� �޿��� ����ϴ� SELECT ������ �ۼ��Ͽ���.
--�� HEADING�� Employee�� Monthly Salary�� ����Ͽ���.

SELECT ENAME "Employee",SAL "Monthly Salary" FROM EMP
WHERE SAL >= 1500 AND DEPTNO IN (10, 30);

--7. EMP ���̺��� 1982�⿡ �Ի��� ����� ��� ������ ����ϴ� SELECT ���� �ۼ��Ͽ���.

 SELECT * FROM EMP
 WHERE HIREDATE LIKE '1982%';


--8. EMP ���̺��� COMM�� NULL�� �ƴ� ����� ��� ������ ����ϴ� SELECT ���� �ۼ��Ͽ���.

 SELECT * FROM EMP
 WHERE COMM IS NOT NULL;

--9. EMP ���̺��� ���ʽ��� �޿����� 10%�� ���� ��� �������� ���Ͽ� �̸�,�޿�,���ʽ��� ����ϴ� SELECT ���� �ۼ��Ͽ���.

SELECT ENAME,SAL,COMM FROM EMP
WHERE SAL < COMM*10;

--10. EMP ���̺��� ������ Clerk�̰ų� Analyst�̰� �޿��� 1000,3000,5000�� �ƴ� ��� ����� ������ ����ϴ� SELECT ���� �ۼ��Ͽ���.

SELECT * FROM EMP
WHERE JOB IN ('CLERK','ANALYST') AND SAL NOT IN(1000, 3000, 5000);


--11. EMP ���̺��� �̸��� LL�� �ְ�  �μ��� 30�̰ų� �Ǵ� �����ڰ� 7782�� ����� ��� ������ ����ϴ� SELECT ���� �ۼ��Ͽ���.

SELECT * FROM EMP
WHERE ENAME LIKE '%LL%' AND (DEPTNO = 30 OR MGR = 7782);



