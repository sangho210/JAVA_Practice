SELECT * FROM TAB;

SELECT * FROM EMP;


--1. ���� ��¥�� ����ϰ� �� ���̺��� Current Date�� ����ϴ� SELECT ������ ����Ͻÿ�.

SELECT TO_CHAR(sysdate, 'YYYY-MM-DD') "Current Date" FROM DUAL;

--2. EMP ���̺��� ���� �޿��� 15%�� ������ �޿��� �����ȣ,�̸�,����,�޿�,������ �޿�(New Salary),������(Increase)�� ����ϴ� SELECT ������ ����Ͻÿ�.

SELECT EMPNO,ENAME,JOB,SAL,(SAL*1.15) "New Salary", ((SAL*1.15)-SAL) "Increase"
FROM EMP;

--3. EMP ���̺��� �̸�,�Ի���,�Ի��Ϸκ��� 6���� �� ���ƿ��� ������ ���Ͽ� ����ϴ� SELECT ������ ����Ͻÿ�.

SELECT ENAME, TO_CHAR(HIREDATE, 'YYYY-MM-DD DY') �����, TO_CHAR(NEXT_DAY(ADD_MONTHS(HIREDATE,6),'MONDAY'), 'YYYY-MM-DD DY') "6���� �� ������" FROM EMP;


--4. EMP ���̺��� �̸�,�Ի���, �Ի��Ϸκ��� ��������� ����,�޿�, �Ի��Ϻ��� ��������� �޿��� �Ѱ踦 ����ϴ� SELECT ������ ����Ͻÿ�.

SELECT ENAME, HIREDATE, TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) "��������", SAL,
TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE))*SAL "�ѱ޿�"
FROM EMP;


/*
5. EMP ���̺��� ������ ����� ��µǵ��� �ۼ��Ͻÿ�.

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


--6. EMP ���̺��� ��� ����� �̸��� �޿�(15�ڸ��� ��� ������ ����� ��*���� ��ġ)�� ����ϴ� SELECT ������ ����Ͻÿ�.

SELECT ENAME, LPAD(SAL, 15, '*') "�޿�"
FROM EMP



--7. EMP ���̺��� ��� ����� ������ �̸�,����,�Ի���,�Ի��� ������ ����ϴ� SELECT ������ ����Ͻÿ�.

SELECT ENAME,JOB,HIREDATE, TO_CHAR(HIREDATE,'DY') "�Ի��� ����"
FROM EMP;



--8. EMP ���̺��� �̸��� ���̰� 6�� �̻��� ����� ������ �̸�,�̸��� ���ڼ�,������ ����ϴ� SELECT ������ ����Ͻÿ�.

SELECT ENAME,LENGTH(ENAME) "�̸��Ǳ��ڼ�", JOB
FROM EMP
WHERE LENGTH(ENAME) >= 6;


--9. EMP ���̺��� ��� ����� ������ �̸�,����,�޿�,���ʽ�,�޿�+���ʽ��� ����ϴ� SELECT ������ ����Ͻÿ�.

SELECT ENAME �̸�, JOB ����, SAL �޿�, NVL(COMM,0) "���ʽ�", SAL+ NVL(COMM,0) "�޿�+���ʽ�"
FROM EMP;


