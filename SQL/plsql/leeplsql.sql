

DECLARE
TYPE firsttype IS RECORD
(a ���.�����%TYPE, b ���.����%TYPE, c ���.�޿�%type);
abc firsttype;
BEGIN
SELECT �����, ����, �޿� INTO abc FROM ��� WHERE �����ȣ=2001;
dbms_output.put_line('---------------------');
dbms_output.put_line('�����   ����   �޿�');
dbms_output.put_line('---------------------');
dbms_output.put_line(abc.a||'   '||abc.b||'   '||TO_CHAR(abc.c));
dbms_output.put_line('���� �����Ͻ� ����: ' ||user||'�Դϴ�.');
dbms_output.put_line('�����Ͻ� �ð���: '|| TO_CHAR(SYSDATE, 'yy-mm-dd hh:mi:ss'));
END;

-----------------------------------------------------------------------
create or replace procedure change_pay
(v_sano in number, v_new_pay in number)
is
begin
update ��� set �޿� = v_new_pay where �����ȣ=v_sano;
commit;
end change_pay;           -- change_pay

execute change_pay(2002,7000);


-----------------------------------------------------------------------

 create or replace function f_tax
 (v_sano in number)
 return number
 is
 v_tax number;
 begin
 select ((�޿�+12)+nvl(Ŀ�̼�,0))*0.05 into v_tax
 from ��� where �����ȣ=v_sano;
 return v_tax;
 end;


 CREATE OR REPLACE PROCEDURE P_OUTEX
 (V_SANO IN ���.�����ȣ%TYPE, --�����ȣ�� ������մ� Ÿ���� �����Ͷ�
 V_SANAME OUT ���.�����%TYPE,
 V_PAY OUT ���.�޿�%TYPE,
 V_COMM OUT ���.Ŀ�̼�%TYPE)
 --IN���� ������ �װɷ� ���ؼ� 3���� OUT���� �ѷ���(�Է� ���)
 IS--���ʿ� ���ִ°� ��������� �޾ƾ� �Ǵ� ����
 BEGIN
 SELECT �����,�޿�,Ŀ�̼� INTO V_SANAME, V_PAY, V_COMM
 FROM ��� WHERE �����ȣ=V_SANO;
 END; --��ȯ���� �ִ� ���ν���


 ------------------------------------------

 create or replace procedure p_ex1
 (id test_pro.id%type, name test_pro.name%type)
 is
 begin
 insert into test_pro(id,name) values (id,name);
 commit;
 dbms_output.put_line(id || '������ �Է� ����');
 end;


execute p_ex1(222,'lee');

-------------------------------------------------------

create or replace procedure cus_in
 (USERID custom.USERID%type,
 USERNAME custom.USERNAME%type,
 JUMIN custom.JUMIN%type,
 AGE custom.AGE%type,
 SEX custom.SEX%type,
 ZIP custom.ZIP%type,
 ADDR1 custom.ADDR1%type,
 ADDR2 custom.ADDR2%type,
 ADDR3 custom.ADDR3%type,
 TEL custom.TEL%type,
 JOB custom.JOB%type,
 SCHOL custom.SCHOL%type,
 POINT custom.POINT%type,
 REGDATE custom.REGDATE%type)
 is
 begin
 insert into custom(USERID,USERNAME, JUMIN, AGE, SEX, ZIP, ADDR1, ADDR2, ADDR3, TEL, JOB, SCHOL, POINT, REGDATE)
 values (USERID,USERNAME, JUMIN, AGE, SEX, ZIP, ADDR1, ADDR2, ADDR3, TEL, JOB, SCHOL, POINT, REGDATE);
 commit;
 dbms_output.put_line(userid || '������ �Է� ����');
 end;



EXECUTE cus_in('mk1111', '����', '646464-1111111', 45, '1', '111-111', '��', '��', '��', '02-222-2222', '�л�', '����', 111, sysdate);


--custom���̺� update��Ű�� ���ν���
create or replace procedure cus_up
(AA custom.USERID%type,
 BB custom.USERNAME%type,
 CC custom.JUMIN%type,
 DD custom.AGE%type,
 EE custom.SEX%type,
 FF custom.ZIP%type,
 GG custom.ADDR1%type,
 HH custom.ADDR2%type,
 II custom.ADDR3%type,
 JJ custom.TEL%type,
 KK custom.JOB%type,
 LL custom.SCHOL%type,
 MM custom.POINT%type,
 NN custom.REGDATE%type)
 is
 begin
 update custom set USERID=AA, USERNAME=BB, JUMIN=CC, AGE=DD, SEX=EE, ZIP=FF, ADDR1=GG, ADDR2=HH, ADDR3=II, TEL=JJ, JOB=KK, SCHOL=LL, POINT=MM,
 REGDATE=NN where USERID=AA;
 COMMIT;
 END;




EXECUTE cus_up('mk1111', '����', '211111-1111111', 25, '1', '111-111', '��', '��', '��', '02-222-2222', '�л�', '����', 111, sysdate);


--custom���̺� delete��Ű�� ���ν���
CREATE OR REPLACE PROCEDURE cus_del
(userid2 CUSTOM.USERID%TYPE)
IS
BEGIN
DELETE CUSTOM where USERID=USERID;
COMMIT;
END;

execute cus_del('444');




--����ȣ�� �Է¹޾Ƽ� �ش���� ���ݱ��� �ֹ��� �� Ƚ�� ���ϱ�
create or replace procedure gogak_tot
(v_gno IN varchar2)
is
tot number;
begin
select count(*) into tot from sales  --���� tot�� ��´�.
where userid=v_gno;
dbms_output.put_line(v_gno||'�� ������ �� �ֹ�����: '||to_char(tot)
||' �Դϴ�');
END;

execute gogak_tot ('mh3020');


--��å�� �Է¹޾� ����å�� �޿��� �Ѿ�, ��տ���, �ο����� ���
create or replace procedure SEARCH1
(JIK IN VARCHAR2)
is
A NUMBER := 0;
B NUMBER(12,2):=0;
C NUMBER:=0;
begin
select SUM(PAY), AVG(PAY), COUNT(*) into A, B, C
from company where POSIT=JIK;
dbms_output.put_line('�޿� �Ѿ� :  '||A);
dbms_output.put_line('��� ���� :  '||B);
dbms_output.put_line('�ο��� :  '||C);
END;

EXECUTE SEARCH1('����');




CREATE OR REPLACE PROCEDURE P_OUTEX
 (V_SANO IN ���.�����ȣ%TYPE, --�����ȣ�� ������մ� Ÿ���� �����Ͷ�
 V_SANAME OUT ���.�����%TYPE,
 V_PAY OUT ���.�޿�%TYPE,
 V_COMM OUT ���.Ŀ�̼�%TYPE)
 --IN���� ������ �װɷ� ���ؼ� 3���� OUT���� �ѷ���(�Է� ���)
 IS--���ʿ� ���ִ°� ��������� �޾ƾ� �Ǵ� ����
 BEGIN
 SELECT �����,�޿�,Ŀ�̼� INTO V_SANAME, V_PAY, V_COMM
 FROM ��� WHERE �����ȣ=V_SANO;
 END; --��ȯ���� �ִ� ���ν���



 --�Լ�

 --���Ǹ� ���ϴ� �Լ�

CREATE OR REPLACE function f_cubvol
 (gili in number, pok in number, nopi in number)
 return number
 is
 bupi number;
 BEGIN
 bupi := gili*pok*nopi;
 return bupi;
 END f_cubvol;

 select f_cubvol(2,6,9) bupi from dual;  -- sql ����â������ �����Ѵ�.


 --������ �Է¹޾� �̸��� ��ȯ�ϴ� �Լ�

 CREATE OR REPLACE FUNCTION F_NAME
 (FULLNAME IN VARCHAR2)
 RETURN VARCHAR2
 IS
 NAME VARCHAR2(4);
 BEGIN
 NAME := SUBSTR(FULLNAME,2);
 RETURN NAME;
 END;

 SELECT F_NAME('ȫ�浿') �̸� FROM DUAL; --cmd������ Ȯ��

 ------------------------------------------------------------

 �Ի����� �Է¹޾� �����, �Ի���, �ٹ��Ⱓ�� ���


 CREATE OR REPLACE FUNCTION F_IPSA
 (V_DATE IN DATE)
 RETURN VARCHAR2
 IS
 GUNDATE VARCHAR2(20);
 BEGIN
 GUNDATE :=
 FLOOR(MONTHS_BETWEEN(SYSDATE,V_DATE)/12)||'��'||
 FLOOR(MOD(MONTHS_BETWEEN(SYSDATE,V_DATE),12))||'����';
 RETURN GUNDATE;
 END;



 SELECT USERNAME, REGDATE, F_IPSA(REGDATE) FROM CUSTOM WHERE ADDR1='���ֵ�';
 --CMD���� Ȯ�� : 14���� ����Ÿ ����

---------------------------------------------------------------------------


CREATE OR REPLACE FUNCTION F_SUNG
(V_JUMIN IN VARCHAR2)
RETURN VARCHAR2
IS
SUNG VARCHAR2(2);
BEGIN
SUNG := SUBSTR(V_JUMIN,8,1);
IF SUNG IN ('1','3') THEN
SUNG := '��';
ELSE
SUNG := '��';
END IF;
RETURN SUNG;
END;


--CMD���� ��� Ȯ��
SELECT USERNAME, F_SUNG(JUMIN) ����
FROM CUSTOM
WHERE ADDR1='���ֵ�';

---------------------------------------------------------------------------

--��¥�� ���,����,������ �Է��ؼ� ���Ⱓ�� ����ϴ� �Լ�

CREATE OR REPLACE FUNCTION F_GAEYAK
(V_DATE IN DATE, Y IN NUMBER, M IN NUMBER, D IN NUMBER)
RETURN DATE
IS
NALZA DATE;
BEGIN
NALZA:=ADD_MONTHS(V_DATE,Y*12);
NALZA:=ADD_MONTHS(NALZA,M);
NALZA:=NALZA + D;
RETURN NALZA;
END;


SELECT USERNAME, REGDATE, F_GAEYAK(REGDATE,1,11,30) ��ุ���� from custom where userid='841883';


---------------------------------------------------------------------------
--10

CREATE OR REPLACE FUNCTION F_PAYDEUN
(V_PAY IN NUMBER)
RETURN VARCHAR2
IS
RESULT VARCHAR(20);
BEGIN
IF V_PAY >2500001 THEN
RESULT := 'A';
ELSIF V_PAY > 2000001 THEN
RESULT := 'B';
ELSIF V_PAY > 1500001 THEN
RESULT := 'C';
ELSIF V_PAY > 1000001 THEN
RESULT := 'D';
ELSE
RESULT := 'E';
END IF;
RETURN RESULT;
END;


--cmd
SELECT PAY, F_PAYDEUN(PAY) FROM COMPANY WHERE USERID='wk4526';

---------------------------------------------------------------------------
--11

--LOOP
DECLARE V_COUNT NUMBER(2):=1;
BEGIN
LOOP
INSERT INTO LOOP1(NO) VALUES (V_COUNT);
V_COUNT:=V_COUNT+1;
EXIT WHEN V_COUNT>10;
END LOOP;
DBMS_OUTPUT.PUT_LINE('������ �Է¿Ϸ�');
END;

---------------------------------------------------------------------------
--12

CREATE OR REPLACE PROCEDURE FOR_TEST
IS
BEGIN
FOR I IN 1..10 LOOP
INSERT INTO LOOP1(NO) VALUES(I);
END LOOP;
END;


---------------------------------------------------------------------------
--13

CREATE OR REPLACE PROCEDURE BANBOK
(V_LOWER NUMBER, V_UPPER NUMBER)
IS
V_COUNTER NUMBER(10) := 0;
V_OUTPUT NUMBER(10) := 0;
BEGIN
FOR I IN V_LOWER..V_UPPER LOOP
V_COUNTER := V_COUNTER + I;
V_OUTPUT := I;
END LOOP;
DBMS_OUTPUT.PUT_LINE('�������� '||TO_CHAR(V_COUNTER)||'�̰�'||
'�� �ݺ�Ƚ���� ' ||TO_CHAR(V_OUTPUT) || '�̴�');
END;


---------------------------------------------------------------------------
--14

CREATE OR REPLACE PROCEDURE BANBOK1
(V_LOWER NUMBER, V_UPPER NUMBER)
IS
V_COUNTER NUMBER(10) := 0;
V_OUTPUT NUMBER(10) := 0;
BEGIN
V_OUTPUT := V_LOWER;
WHILE V_OUTPUT <= V_UPPER LOOP
V_COUNTER := V_COUNTER + V_OUTPUT;
V_OUTPUT := V_OUTPUT + 1;
END LOOP;
DBMS_OUTPUT.PUT_LINE('�������� '||TO_CHAR(V_COUNTER)||'�̰� '||
'�� �ݺ�Ƚ���� ' ||TO_CHAR(V_OUTPUT-1) || '�̴�');
END;

---------------------------------------------------------------------------
--15

CREATE OR REPLACE PROCEDURE EXP_TEST
IS
SW_REC ���%ROWTYPE; --����� �ִ� ��� ������ Ÿ���� �ڵ����� �Ը��� �°� ����
BEGIN
SELECT * INTO SW_REC FROM ���; --�׳� ��������� �ϸ� �����Ͱ� ���Ƽ� ���� ����
DBMS_OUTPUT.PUT_LINE('������ �˻� ����!');
EXCEPTION
WHEN TOO_MANY_ROWS THEN
ROLLBACK;
DBMS_OUTPUT.PUT_LINE('���� ���� �˻��˽��ϴ�.');

WHEN NO_DATA_FOUND THEN
ROLLBACK;
DBMS_OUTPUT.PUT_LINE('�����Ͱ� �����ϴ�.');

WHEN OTHERS THEN
ROLLBACK;
DBMS_OUTPUT.PUT_LINE('��Ÿ����...');
END;


---------------------------------------------------------------------------
--16

 CREATE TABLE TRANS
 (NAME NUMBER CONSTRAINT TRANS_NAME_PK PRIMARY KEY,
 TDATE DATE, TYPE VARCHAR2(12),
 AMOUNT NUMBER);

 INSERT INTO TRANS VALUES(1,SYSDATE,'����', 100000);
 INSERT INTO TRANS VALUES(2,SYSDATE,'����', 500000);
 INSERT INTO TRANS VALUES(3,SYSDATE,'����', 600000);
 INSERT INTO TRANS VALUES(4,SYSDATE,'��Ź', 700000);

 COMMIT;


---------------------------------------------------------------------------
--17
--%type           --�÷�
--%ROWTYPE;       --�Ѱ��� ���ڵ�Ÿ�� ��ü�� �о����
--%ROWCOUNT;      --���ڵ��� ����

CREATE OR REPLACE PROCEDURE DATA_EXP
IS
TRANS_REC TRANS%ROWTYPE;       --�Ѱ��� ���ڵ�Ÿ�� ��ü�� �о����
BEGIN
SELECT * INTO TRANS_REC FROM TRANS;
DBMS_OUTPUT.PUT_LINE('������ �˻�����');
EXCEPTION
WHEN TOO_MANY_ROWS THEN
ROLLBACK;
DBMS_OUTPUT.PUT_LINE('TOO_MANY_ROWS����');
WHEN NO_DATA_FOUND THEN
ROLLBACK;
DBMS_OUTPUT.PUT_LINE('NO_DATA_FOUND����');
WHEN DUP_VAL_ON_INDEX THEN
ROLLBACK;
DBMS_OUTPUT.PUT_LINE('DUP_VAL_ON_INDEX����');
END;


---------------------------------------------------------------------------
--18

--cursor

CREATE OR REPLACE PROCEDURE P_DEPTNO
(I_DEPTNO ���.�μ���ȣ%TYPE)
IS
	CURSOR CUR_DEPTNO        --������, Ŀ������, �� FETCH, �� CLOSE,
  IS
  SELECT �μ���ȣ, �����, ����, �޿� FROM ���
  WHERE �μ���ȣ=I_DEPTNO;
V_DEPT ���.�μ���ȣ%TYPE;
V_SANAME ���.�����%TYPE;
V_JIK ���.����%TYPE;
V_SAL ���.�޿�%TYPE;
BEGIN
OPEN CUR_DEPTNO;
DBMS_OUTPUT.PUT_LINE('------------------------------');
DBMS_OUTPUT.PUT_LINE('�μ���ȣ  �����   ����   �޿�');
DBMS_OUTPUT.PUT_LINE('------------------------------');

LOOP
FETCH CUR_DEPTNO INTO V_DEPT, V_SANAME, V_JIK, V_SAL; --CUR_DEPTNO���� V_DEPT, V_SANAME������ �ϳ��� ����� ������ �־��ش�.
EXIT WHEN CUR_DEPTNO%NOTFOUND;   --Ŀ������ �����Ͱ� ������ �ݾƶ�.
DBMS_OUTPUT.PUT_LINE(TO_CHAR(V_DEPT)||'   '||V_SANAME||'   '||V_JIK||'   '||TO_CHAR(V_SAL));
END LOOP;
DBMS_OUTPUT.PUT_LINE('------------------------------');
DBMS_OUTPUT.PUT_LINE('��ü ������ ���� : '||
TO_CHAR(CUR_DEPTNO%ROWCOUNT));
CLOSE CUR_DEPTNO;
END;


---------------------------------------------------------------------------
--19





CREATE OR REPLACE PROCEDURE P_DEPTNO1
(I_DEPTNO ���.�μ���ȣ%TYPE)
IS
	CURSOR CUR_DEPTNO        --������, Ŀ������, �� FETCH, �� CLOSE
  IS
  SELECT �μ���ȣ, �����, ����, �޿� FROM ���
  WHERE �μ���ȣ=I_DEPTNO;
V_CNT NUMBER;
BEGIN
DBMS_OUTPUT.PUT_LINE('------------------------------');
DBMS_OUTPUT.PUT_LINE('�μ���ȣ  �����   ����   �޿�');
DBMS_OUTPUT.PUT_LINE('------------------------------');

FOR CUR_DEPTNO_REC IN CUR_DEPTNO LOOP -- CUR DEPTNO �� ���� CUR_DEPTNO_REC�� �ϳ��� �ϳ��� ������ �־��   * 1.OPEN 2.FETCH(�����Ͱ����)

DBMS_OUTPUT.PUT_LINE(TO_CHAR(CUR_DEPTNO_REC.�μ���ȣ)||'   '||
CUR_DEPTNO_REC.�����||'   '||CUR_DEPTNO_REC.����||'   '||
TO_CHAR(CUR_DEPTNO_REC.�޿�));

V_CNT := CUR_DEPTNO%ROWCOUNT; --������ ���������� �̸� �ִ´�.

END LOOP;     --* 3.CLOSE

DBMS_OUTPUT.PUT_LINE('------------------------------');
DBMS_OUTPUT.PUT_LINE('��ü ������ ���� : '||TO_CHAR(V_CNT));

END;









EXECUTE P_DEPTNO1(10);


---------------------------------------------------------------------------
--20

--�����ȣ�� �Է½� ����̸��� ������ ��ǰ���� ���


CREATE OR REPLACE PROCEDURE P_jepum
(I_userid CUSTOM.USERID%TYPE)
IS
--Ŀ�� ����
CURSOR CUR_JEPUM
IS
SELECT AA.USERID, USERNAME, PRODUCTNAME FROM CUSTOM AA, SALES BB
WHERE AA.USERID=BB.USERID AND AA.USERID=I_userid;
V_GAE NUMBER;
BEGIN
DBMS_OUTPUT.PUT_LINE('-----------------------------------');
DBMS_OUTPUT.PUT_LINE('���̵�       ���̸�        ��ǰ��');
DBMS_OUTPUT.PUT_LINE('-----------------------------------');
FOR CUR_JEPUM_REC IN CUR_JEPUM LOOP
DBMS_OUTPUT.PUT_LINE(CUR_JEPUM_REC.USERID || '     ' || CUR_JEPUM_REC.USERNAME ||
'     ' || CUR_JEPUM_REC.PRODUCTNAME);
V_GAE := CUR_JEPUM%ROWCOUNT;
END LOOP;
DBMS_OUTPUT.PUT_LINE('-------------------------------------');
DBMS_OUTPUT.PUT_LINE('��ü ������ ���� ' || TO_CHAR(V_GAE));
END;


---------------------------------------------------------------------------
--21 (20141022)

CREATE OR REPLACE PACKAGE SA_PACK
IS
V_COUNTER NUMBER := 0;
procedure sa_no;
procedure sa_name;
procedure bu_no;
procedure jik;
procedure pay;
procedure ibsail;
procedure MGR;
END;
--��Ű���� 7�� �������.



--package
--����ȿ� ����մ�  ���ν����� �ϳ��� ������ ����Ѵ�.
--body, head
--HEADER
CREATE OR REPLACE PACKAGE SA_PACK
IS
V_COUNTER NUMBER:=0;
PROCEDURE SA_NO;
PROCEDURE SA_NAME;
PROCEDURE BU_NO;
PROCEDURE JIK;
PROCEDURE PAY;
PROCEDURE IBSAIL;
PROCEDURE MGR;
--��Ű���� 7�� �������.
END;

--BODY


CREATE OR REPLACE PACKAGE BODY SA_PACK
IS
	CURSOR SW_CUR
  IS
  SELECT * FROM ���;
PROCEDURE SA_NO--���� SA_NO�� ���ƾ��Ѵ�.
IS
BEGIN
DBMS_OUTPUT.PUT_LINE('�����ȣ');
DBMS_OUTPUT.PUT_LINE('--------');
FOR SW_CUR_REC IN SW_CUR LOOP
DBMS_OUTPUT.PUT_LINE(SW_CUR_REC.�����ȣ);--SW_CUR_REC���� �����ȣ�� ȣ���Ͽ���;
END LOOP;
END;

PROCEDURE SA_NAME--���� SA_NO�� ���ƾ��Ѵ�.
IS
BEGIN
DBMS_OUTPUT.PUT_LINE('�����');
DBMS_OUTPUT.PUT_LINE('--------');
FOR SW_CUR_REC IN SW_CUR LOOP
DBMS_OUTPUT.PUT_LINE(SW_CUR_REC.�����);--SW_CUR_REC���� �����ȣ�� ȣ���Ͽ���;
END LOOP;
END;

PROCEDURE BU_NO--���� SA_NO�� ���ƾ��Ѵ�.
IS
BEGIN
DBMS_OUTPUT.PUT_LINE('�μ���ȣ');
DBMS_OUTPUT.PUT_LINE('--------');
FOR SW_CUR_REC IN SW_CUR LOOP
DBMS_OUTPUT.PUT_LINE(SW_CUR_REC.�μ���ȣ);--SW_CUR_REC���� �����ȣ�� ȣ���Ͽ���;
END LOOP;
END;

PROCEDURE JIK--���� SA_NO�� ���ƾ��Ѵ�.
IS
BEGIN
DBMS_OUTPUT.PUT_LINE('����');
DBMS_OUTPUT.PUT_LINE('--------');
FOR SW_CUR_REC IN SW_CUR LOOP
DBMS_OUTPUT.PUT_LINE(SW_CUR_REC.����);--SW_CUR_REC���� �����ȣ�� ȣ���Ͽ���;
END LOOP;
END;

PROCEDURE PAY--���� SA_NO�� ���ƾ��Ѵ�.
IS
BEGIN
DBMS_OUTPUT.PUT_LINE('�޿�');
DBMS_OUTPUT.PUT_LINE('--------');
FOR SW_CUR_REC IN SW_CUR LOOP
DBMS_OUTPUT.PUT_LINE(SW_CUR_REC.�޿�);--SW_CUR_REC���� �����ȣ�� ȣ���Ͽ���;
END LOOP;
END;

PROCEDURE IBSAIL--���� SA_NO�� ���ƾ��Ѵ�.
IS
BEGIN
DBMS_OUTPUT.PUT_LINE('�Ի���');
DBMS_OUTPUT.PUT_LINE('--------');
FOR SW_CUR_REC IN SW_CUR LOOP
DBMS_OUTPUT.PUT_LINE(SW_CUR_REC.�Ի���);--SW_CUR_REC���� �����ȣ�� ȣ���Ͽ���;
END LOOP;
END;

PROCEDURE MGR--���� SA_NO�� ���ƾ��Ѵ�.
IS
BEGIN
DBMS_OUTPUT.PUT_LINE('�����ȣ');
DBMS_OUTPUT.PUT_LINE('--------');
FOR SW_CUR_REC IN SW_CUR LOOP
DBMS_OUTPUT.PUT_LINE(SW_CUR_REC.�����ȣ);--SW_CUR_REC���� �����ȣ�� ȣ���Ͽ���;
END LOOP;
END;

END;


--����

set serveroutput on;
exec sa_pack.sa_no;
exec sa_pack.mgr;
exec sa_pack.ibsail;






CREATE OR REPLACE PACKAGE BODY SA_PACK
IS
	CURSOR SW_CUR
  IS
  SELECT * FROM ���;
PROCEDURE SA_NO--���� SA_NO�� ���ƾ��Ѵ�.
IS
BEGIN
DBMS_OUTPUT.PUT_LINE('�����ȣ');
DBMS_OUTPUT.PUT_LINE('--------');
FOR SW_CUR_REC IN SW_CUR LOOP
DBMS_OUTPUT.PUT_LINE(SW_CUR_REC.�����ȣ);--SW_CUR_REC���� �����ȣ�� ȣ���Ͽ���;
END LOOP;
END;

PROCEDURE SA_NAME--���� SA_NO�� ���ƾ��Ѵ�.
IS
BEGIN
DBMS_OUTPUT.PUT_LINE('�����');
DBMS_OUTPUT.PUT_LINE('--------');
FOR SW_CUR_REC IN SW_CUR LOOP
DBMS_OUTPUT.PUT_LINE(SW_CUR_REC.�����);--SW_CUR_REC���� �����ȣ�� ȣ���Ͽ���;
END LOOP;
END;

PROCEDURE BU_NO--���� SA_NO�� ���ƾ��Ѵ�.
IS
BEGIN
DBMS_OUTPUT.PUT_LINE('�μ���ȣ');
DBMS_OUTPUT.PUT_LINE('--------');
FOR SW_CUR_REC IN SW_CUR LOOP
DBMS_OUTPUT.PUT_LINE(SW_CUR_REC.�μ���ȣ);--SW_CUR_REC���� �����ȣ�� ȣ���Ͽ���;
END LOOP;
END;

PROCEDURE JIK--���� SA_NO�� ���ƾ��Ѵ�.
IS
BEGIN
DBMS_OUTPUT.PUT_LINE('����');
DBMS_OUTPUT.PUT_LINE('--------');
FOR SW_CUR_REC IN SW_CUR LOOP
DBMS_OUTPUT.PUT_LINE(SW_CUR_REC.����);--SW_CUR_REC���� �����ȣ�� ȣ���Ͽ���;
END LOOP;
END;

PROCEDURE PAY--���� SA_NO�� ���ƾ��Ѵ�.
IS
BEGIN
DBMS_OUTPUT.PUT_LINE('�޿�');
DBMS_OUTPUT.PUT_LINE('--------');
FOR SW_CUR_REC IN SW_CUR LOOP
DBMS_OUTPUT.PUT_LINE(SW_CUR_REC.�޿�);--SW_CUR_REC���� �����ȣ�� ȣ���Ͽ���;
END LOOP;
END;

PROCEDURE IBSAIL--���� SA_NO�� ���ƾ��Ѵ�.
IS
BEGIN
DBMS_OUTPUT.PUT_LINE('�Ի���');
DBMS_OUTPUT.PUT_LINE('--------');
FOR SW_CUR_REC IN SW_CUR LOOP
DBMS_OUTPUT.PUT_LINE(SW_CUR_REC.�Ի���);--SW_CUR_REC���� �����ȣ�� ȣ���Ͽ���;
END LOOP;
END;

PROCEDURE MGR--���� SA_NO�� ���ƾ��Ѵ�.
IS
BEGIN
DBMS_OUTPUT.PUT_LINE('�����ȣ');
DBMS_OUTPUT.PUT_LINE('--------');
FOR SW_CUR_REC IN SW_CUR LOOP
DBMS_OUTPUT.PUT_LINE(SW_CUR_REC.�����ȣ);--SW_CUR_REC���� �����ȣ�� ȣ���Ͽ���;
END LOOP;
END;

END;



-------------------------------------------------------------------------------
create sequence sehak
start with 1
increment by 1
nomaxvalue
nocycle
nocache

create or replace trigger tri_in
after insert
on lee.haksang
begin
insert into lee.memo values(lee.sehak.nextval,'���� insert�Ǿ����ϴ�');
end;
