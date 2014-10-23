

DECLARE
TYPE firsttype IS RECORD
(a 사원.사원명%TYPE, b 사원.직급%TYPE, c 사원.급여%type);
abc firsttype;
BEGIN
SELECT 사원명, 직급, 급여 INTO abc FROM 사원 WHERE 사원번호=2001;
dbms_output.put_line('---------------------');
dbms_output.put_line('사원명   직급   급여');
dbms_output.put_line('---------------------');
dbms_output.put_line(abc.a||'   '||abc.b||'   '||TO_CHAR(abc.c));
dbms_output.put_line('현재 질의하신 분은: ' ||user||'입니다.');
dbms_output.put_line('질의하신 시간은: '|| TO_CHAR(SYSDATE, 'yy-mm-dd hh:mi:ss'));
END;

-----------------------------------------------------------------------
create or replace procedure change_pay
(v_sano in number, v_new_pay in number)
is
begin
update 사원 set 급여 = v_new_pay where 사원번호=v_sano;
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
 select ((급여+12)+nvl(커미션,0))*0.05 into v_tax
 from 사원 where 사원번호=v_sano;
 return v_tax;
 end;


 CREATE OR REPLACE PROCEDURE P_OUTEX
 (V_SANO IN 사원.사원번호%TYPE, --사원번호에 적용되잇는 타입을 가져와라
 V_SANAME OUT 사원.사원명%TYPE,
 V_PAY OUT 사원.급여%TYPE,
 V_COMM OUT 사원.커미션%TYPE)
 --IN으로 받으면 그걸로 인해서 3개의 OUT으로 뿌려라(입력 출력)
 IS--위쪽에 써주는건 사용자한테 받아야 되는 변수
 BEGIN
 SELECT 사원명,급여,커미션 INTO V_SANAME, V_PAY, V_COMM
 FROM 사원 WHERE 사원번호=V_SANO;
 END; --반환값이 있는 프로시저


 ------------------------------------------

 create or replace procedure p_ex1
 (id test_pro.id%type, name test_pro.name%type)
 is
 begin
 insert into test_pro(id,name) values (id,name);
 commit;
 dbms_output.put_line(id || '데이터 입력 성공');
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
 dbms_output.put_line(userid || '데이터 입력 성공');
 end;



EXECUTE cus_in('mk1111', '김김김', '646464-1111111', 45, '1', '111-111', '서', '울', '시', '02-222-2222', '학생', '초졸', 111, sysdate);


--custom테이블에 update시키는 프로시져
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




EXECUTE cus_up('mk1111', '김김김', '211111-1111111', 25, '1', '111-111', '서', '울', '시', '02-222-2222', '학생', '초졸', 111, sysdate);


--custom테이블에 delete시키는 프로시져
CREATE OR REPLACE PROCEDURE cus_del
(userid2 CUSTOM.USERID%TYPE)
IS
BEGIN
DELETE CUSTOM where USERID=USERID;
COMMIT;
END;

execute cus_del('444');




--고객번호를 입력받아서 해당고객이 지금까지 주문한 총 횟수 구하기
create or replace procedure gogak_tot
(v_gno IN varchar2)
is
tot number;
begin
select count(*) into tot from sales  --값을 tot에 담는다.
where userid=v_gno;
dbms_output.put_line(v_gno||'번 고객님의 총 주문량은: '||to_char(tot)
||' 입니다');
END;

execute gogak_tot ('mh3020');


--직책을 입력받아 그직책이 급여의 총액, 평균월급, 인원수를 출력
create or replace procedure SEARCH1
(JIK IN VARCHAR2)
is
A NUMBER := 0;
B NUMBER(12,2):=0;
C NUMBER:=0;
begin
select SUM(PAY), AVG(PAY), COUNT(*) into A, B, C
from company where POSIT=JIK;
dbms_output.put_line('급여 총액 :  '||A);
dbms_output.put_line('평균 월급 :  '||B);
dbms_output.put_line('인원수 :  '||C);
END;

EXECUTE SEARCH1('과장');




CREATE OR REPLACE PROCEDURE P_OUTEX
 (V_SANO IN 사원.사원번호%TYPE, --사원번호에 적용되잇는 타입을 가져와라
 V_SANAME OUT 사원.사원명%TYPE,
 V_PAY OUT 사원.급여%TYPE,
 V_COMM OUT 사원.커미션%TYPE)
 --IN으로 받으면 그걸로 인해서 3개의 OUT으로 뿌려라(입력 출력)
 IS--위쪽에 써주는건 사용자한테 받아야 되는 변수
 BEGIN
 SELECT 사원명,급여,커미션 INTO V_SANAME, V_PAY, V_COMM
 FROM 사원 WHERE 사원번호=V_SANO;
 END; --반환값이 있는 프로시저



 --함수

 --부피를 구하는 함수

CREATE OR REPLACE function f_cubvol
 (gili in number, pok in number, nopi in number)
 return number
 is
 bupi number;
 BEGIN
 bupi := gili*pok*nopi;
 return bupi;
 END f_cubvol;

 select f_cubvol(2,6,9) bupi from dual;  -- sql 실행창에에서 실행한다.


 --성명을 입력받아 이름만 반환하는 함수

 CREATE OR REPLACE FUNCTION F_NAME
 (FULLNAME IN VARCHAR2)
 RETURN VARCHAR2
 IS
 NAME VARCHAR2(4);
 BEGIN
 NAME := SUBSTR(FULLNAME,2);
 RETURN NAME;
 END;

 SELECT F_NAME('홍길동') 이름 FROM DUAL; --cmd문에서 확인

 ------------------------------------------------------------

 입사일을 입력받아 사원명, 입사일, 근무기간을 출력


 CREATE OR REPLACE FUNCTION F_IPSA
 (V_DATE IN DATE)
 RETURN VARCHAR2
 IS
 GUNDATE VARCHAR2(20);
 BEGIN
 GUNDATE :=
 FLOOR(MONTHS_BETWEEN(SYSDATE,V_DATE)/12)||'년'||
 FLOOR(MOD(MONTHS_BETWEEN(SYSDATE,V_DATE),12))||'개월';
 RETURN GUNDATE;
 END;



 SELECT USERNAME, REGDATE, F_IPSA(REGDATE) FROM CUSTOM WHERE ADDR1='제주도';
 --CMD에서 확인 : 14명의 데이타 나옴

---------------------------------------------------------------------------


CREATE OR REPLACE FUNCTION F_SUNG
(V_JUMIN IN VARCHAR2)
RETURN VARCHAR2
IS
SUNG VARCHAR2(2);
BEGIN
SUNG := SUBSTR(V_JUMIN,8,1);
IF SUNG IN ('1','3') THEN
SUNG := '남';
ELSE
SUNG := '여';
END IF;
RETURN SUNG;
END;


--CMD에서 결과 확인
SELECT USERNAME, F_SUNG(JUMIN) 성별
FROM CUSTOM
WHERE ADDR1='제주도';

---------------------------------------------------------------------------

--날짜에 년수,개월,날수를 입력해서 계약기간을 출력하는 함수

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


SELECT USERNAME, REGDATE, F_GAEYAK(REGDATE,1,11,30) 계약만료일 from custom where userid='841883';


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
DBMS_OUTPUT.PUT_LINE('데이터 입력완료');
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
DBMS_OUTPUT.PUT_LINE('최종값은 '||TO_CHAR(V_COUNTER)||'이고'||
'총 반복횟수는 ' ||TO_CHAR(V_OUTPUT) || '이다');
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
DBMS_OUTPUT.PUT_LINE('최종값은 '||TO_CHAR(V_COUNTER)||'이고 '||
'총 반복횟수는 ' ||TO_CHAR(V_OUTPUT-1) || '이다');
END;

---------------------------------------------------------------------------
--15

CREATE OR REPLACE PROCEDURE EXP_TEST
IS
SW_REC 사원%ROWTYPE; --사원의 있는 모든 데이터 타입을 자동으로 입맛에 맞게 적용
BEGIN
SELECT * INTO SW_REC FROM 사원; --그냥 이행까지만 하면 데이터가 많아서 실행 오류
DBMS_OUTPUT.PUT_LINE('데이터 검색 성공!');
EXCEPTION
WHEN TOO_MANY_ROWS THEN
ROLLBACK;
DBMS_OUTPUT.PUT_LINE('많은 행이 검색됩습니다.');

WHEN NO_DATA_FOUND THEN
ROLLBACK;
DBMS_OUTPUT.PUT_LINE('데이터가 없습니다.');

WHEN OTHERS THEN
ROLLBACK;
DBMS_OUTPUT.PUT_LINE('기타에러...');
END;


---------------------------------------------------------------------------
--16

 CREATE TABLE TRANS
 (NAME NUMBER CONSTRAINT TRANS_NAME_PK PRIMARY KEY,
 TDATE DATE, TYPE VARCHAR2(12),
 AMOUNT NUMBER);

 INSERT INTO TRANS VALUES(1,SYSDATE,'저금', 100000);
 INSERT INTO TRANS VALUES(2,SYSDATE,'예금', 500000);
 INSERT INTO TRANS VALUES(3,SYSDATE,'저축', 600000);
 INSERT INTO TRANS VALUES(4,SYSDATE,'신탁', 700000);

 COMMIT;


---------------------------------------------------------------------------
--17
--%type           --컬럼
--%ROWTYPE;       --한개의 레코드타입 전체를 읽어오는
--%ROWCOUNT;      --레코드의 갯수

CREATE OR REPLACE PROCEDURE DATA_EXP
IS
TRANS_REC TRANS%ROWTYPE;       --한개의 레코드타입 전체를 읽어오는
BEGIN
SELECT * INTO TRANS_REC FROM TRANS;
DBMS_OUTPUT.PUT_LINE('데이터 검색성공');
EXCEPTION
WHEN TOO_MANY_ROWS THEN
ROLLBACK;
DBMS_OUTPUT.PUT_LINE('TOO_MANY_ROWS에러');
WHEN NO_DATA_FOUND THEN
ROLLBACK;
DBMS_OUTPUT.PUT_LINE('NO_DATA_FOUND에러');
WHEN DUP_VAL_ON_INDEX THEN
ROLLBACK;
DBMS_OUTPUT.PUT_LINE('DUP_VAL_ON_INDEX에러');
END;


---------------------------------------------------------------------------
--18

--cursor

CREATE OR REPLACE PROCEDURE P_DEPTNO
(I_DEPTNO 사원.부서번호%TYPE)
IS
	CURSOR CUR_DEPTNO        --선언후, 커서오픈, 후 FETCH, 후 CLOSE,
  IS
  SELECT 부서번호, 사원명, 직급, 급여 FROM 사원
  WHERE 부서번호=I_DEPTNO;
V_DEPT 사원.부서번호%TYPE;
V_SANAME 사원.사원명%TYPE;
V_JIK 사원.직급%TYPE;
V_SAL 사원.급여%TYPE;
BEGIN
OPEN CUR_DEPTNO;
DBMS_OUTPUT.PUT_LINE('------------------------------');
DBMS_OUTPUT.PUT_LINE('부서번호  사원명   직급   급여');
DBMS_OUTPUT.PUT_LINE('------------------------------');

LOOP
FETCH CUR_DEPTNO INTO V_DEPT, V_SANAME, V_JIK, V_SAL; --CUR_DEPTNO에서 V_DEPT, V_SANAME순으로 하나씩 선언된 변수에 넣어준다.
EXIT WHEN CUR_DEPTNO%NOTFOUND;   --커서에서 데이터가 없으면 닫아라.
DBMS_OUTPUT.PUT_LINE(TO_CHAR(V_DEPT)||'   '||V_SANAME||'   '||V_JIK||'   '||TO_CHAR(V_SAL));
END LOOP;
DBMS_OUTPUT.PUT_LINE('------------------------------');
DBMS_OUTPUT.PUT_LINE('전체 데이터 갯수 : '||
TO_CHAR(CUR_DEPTNO%ROWCOUNT));
CLOSE CUR_DEPTNO;
END;


---------------------------------------------------------------------------
--19





CREATE OR REPLACE PROCEDURE P_DEPTNO1
(I_DEPTNO 사원.부서번호%TYPE)
IS
	CURSOR CUR_DEPTNO        --선언후, 커서오픈, 후 FETCH, 후 CLOSE
  IS
  SELECT 부서번호, 사원명, 직급, 급여 FROM 사원
  WHERE 부서번호=I_DEPTNO;
V_CNT NUMBER;
BEGIN
DBMS_OUTPUT.PUT_LINE('------------------------------');
DBMS_OUTPUT.PUT_LINE('부서번호  사원명   직급   급여');
DBMS_OUTPUT.PUT_LINE('------------------------------');

FOR CUR_DEPTNO_REC IN CUR_DEPTNO LOOP -- CUR DEPTNO 의 값을 CUR_DEPTNO_REC로 하나씩 하나씪 꺼내어 넣어라   * 1.OPEN 2.FETCH(데이터갖고옴)

DBMS_OUTPUT.PUT_LINE(TO_CHAR(CUR_DEPTNO_REC.부서번호)||'   '||
CUR_DEPTNO_REC.사원명||'   '||CUR_DEPTNO_REC.직급||'   '||
TO_CHAR(CUR_DEPTNO_REC.급여));

V_CNT := CUR_DEPTNO%ROWCOUNT; --포문이 끝나기전에 미리 넣는다.

END LOOP;     --* 3.CLOSE

DBMS_OUTPUT.PUT_LINE('------------------------------');
DBMS_OUTPUT.PUT_LINE('전체 데이터 갯수 : '||TO_CHAR(V_CNT));

END;









EXECUTE P_DEPTNO1(10);


---------------------------------------------------------------------------
--20

--사원번호를 입력시 사원이름과 구입한 제품명을 출력


CREATE OR REPLACE PROCEDURE P_jepum
(I_userid CUSTOM.USERID%TYPE)
IS
--커서 선언
CURSOR CUR_JEPUM
IS
SELECT AA.USERID, USERNAME, PRODUCTNAME FROM CUSTOM AA, SALES BB
WHERE AA.USERID=BB.USERID AND AA.USERID=I_userid;
V_GAE NUMBER;
BEGIN
DBMS_OUTPUT.PUT_LINE('-----------------------------------');
DBMS_OUTPUT.PUT_LINE('아이디       고객이름        제품명');
DBMS_OUTPUT.PUT_LINE('-----------------------------------');
FOR CUR_JEPUM_REC IN CUR_JEPUM LOOP
DBMS_OUTPUT.PUT_LINE(CUR_JEPUM_REC.USERID || '     ' || CUR_JEPUM_REC.USERNAME ||
'     ' || CUR_JEPUM_REC.PRODUCTNAME);
V_GAE := CUR_JEPUM%ROWCOUNT;
END LOOP;
DBMS_OUTPUT.PUT_LINE('-------------------------------------');
DBMS_OUTPUT.PUT_LINE('전체 데이터 개수 ' || TO_CHAR(V_GAE));
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
--패키지를 7개 만들었다.



--package
--덩어리안에 들어잇는  프로시저를 하나씩 꺼내서 사용한다.
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
--패키지를 7개 만들엇다.
END;

--BODY


CREATE OR REPLACE PACKAGE BODY SA_PACK
IS
	CURSOR SW_CUR
  IS
  SELECT * FROM 사원;
PROCEDURE SA_NO--위의 SA_NO랑 같아야한다.
IS
BEGIN
DBMS_OUTPUT.PUT_LINE('사원번호');
DBMS_OUTPUT.PUT_LINE('--------');
FOR SW_CUR_REC IN SW_CUR LOOP
DBMS_OUTPUT.PUT_LINE(SW_CUR_REC.사원번호);--SW_CUR_REC에서 사원번호를 호출하여라;
END LOOP;
END;

PROCEDURE SA_NAME--위의 SA_NO랑 같아야한다.
IS
BEGIN
DBMS_OUTPUT.PUT_LINE('사원명');
DBMS_OUTPUT.PUT_LINE('--------');
FOR SW_CUR_REC IN SW_CUR LOOP
DBMS_OUTPUT.PUT_LINE(SW_CUR_REC.사원명);--SW_CUR_REC에서 사원번호를 호출하여라;
END LOOP;
END;

PROCEDURE BU_NO--위의 SA_NO랑 같아야한다.
IS
BEGIN
DBMS_OUTPUT.PUT_LINE('부서번호');
DBMS_OUTPUT.PUT_LINE('--------');
FOR SW_CUR_REC IN SW_CUR LOOP
DBMS_OUTPUT.PUT_LINE(SW_CUR_REC.부서번호);--SW_CUR_REC에서 사원번호를 호출하여라;
END LOOP;
END;

PROCEDURE JIK--위의 SA_NO랑 같아야한다.
IS
BEGIN
DBMS_OUTPUT.PUT_LINE('직급');
DBMS_OUTPUT.PUT_LINE('--------');
FOR SW_CUR_REC IN SW_CUR LOOP
DBMS_OUTPUT.PUT_LINE(SW_CUR_REC.직급);--SW_CUR_REC에서 사원번호를 호출하여라;
END LOOP;
END;

PROCEDURE PAY--위의 SA_NO랑 같아야한다.
IS
BEGIN
DBMS_OUTPUT.PUT_LINE('급여');
DBMS_OUTPUT.PUT_LINE('--------');
FOR SW_CUR_REC IN SW_CUR LOOP
DBMS_OUTPUT.PUT_LINE(SW_CUR_REC.급여);--SW_CUR_REC에서 사원번호를 호출하여라;
END LOOP;
END;

PROCEDURE IBSAIL--위의 SA_NO랑 같아야한다.
IS
BEGIN
DBMS_OUTPUT.PUT_LINE('입사일');
DBMS_OUTPUT.PUT_LINE('--------');
FOR SW_CUR_REC IN SW_CUR LOOP
DBMS_OUTPUT.PUT_LINE(SW_CUR_REC.입사일);--SW_CUR_REC에서 사원번호를 호출하여라;
END LOOP;
END;

PROCEDURE MGR--위의 SA_NO랑 같아야한다.
IS
BEGIN
DBMS_OUTPUT.PUT_LINE('사수번호');
DBMS_OUTPUT.PUT_LINE('--------');
FOR SW_CUR_REC IN SW_CUR LOOP
DBMS_OUTPUT.PUT_LINE(SW_CUR_REC.사수번호);--SW_CUR_REC에서 사원번호를 호출하여라;
END LOOP;
END;

END;


--실행

set serveroutput on;
exec sa_pack.sa_no;
exec sa_pack.mgr;
exec sa_pack.ibsail;






CREATE OR REPLACE PACKAGE BODY SA_PACK
IS
	CURSOR SW_CUR
  IS
  SELECT * FROM 사원;
PROCEDURE SA_NO--위의 SA_NO랑 같아야한다.
IS
BEGIN
DBMS_OUTPUT.PUT_LINE('사원번호');
DBMS_OUTPUT.PUT_LINE('--------');
FOR SW_CUR_REC IN SW_CUR LOOP
DBMS_OUTPUT.PUT_LINE(SW_CUR_REC.사원번호);--SW_CUR_REC에서 사원번호를 호출하여라;
END LOOP;
END;

PROCEDURE SA_NAME--위의 SA_NO랑 같아야한다.
IS
BEGIN
DBMS_OUTPUT.PUT_LINE('사원명');
DBMS_OUTPUT.PUT_LINE('--------');
FOR SW_CUR_REC IN SW_CUR LOOP
DBMS_OUTPUT.PUT_LINE(SW_CUR_REC.사원명);--SW_CUR_REC에서 사원번호를 호출하여라;
END LOOP;
END;

PROCEDURE BU_NO--위의 SA_NO랑 같아야한다.
IS
BEGIN
DBMS_OUTPUT.PUT_LINE('부서번호');
DBMS_OUTPUT.PUT_LINE('--------');
FOR SW_CUR_REC IN SW_CUR LOOP
DBMS_OUTPUT.PUT_LINE(SW_CUR_REC.부서번호);--SW_CUR_REC에서 사원번호를 호출하여라;
END LOOP;
END;

PROCEDURE JIK--위의 SA_NO랑 같아야한다.
IS
BEGIN
DBMS_OUTPUT.PUT_LINE('직급');
DBMS_OUTPUT.PUT_LINE('--------');
FOR SW_CUR_REC IN SW_CUR LOOP
DBMS_OUTPUT.PUT_LINE(SW_CUR_REC.직급);--SW_CUR_REC에서 사원번호를 호출하여라;
END LOOP;
END;

PROCEDURE PAY--위의 SA_NO랑 같아야한다.
IS
BEGIN
DBMS_OUTPUT.PUT_LINE('급여');
DBMS_OUTPUT.PUT_LINE('--------');
FOR SW_CUR_REC IN SW_CUR LOOP
DBMS_OUTPUT.PUT_LINE(SW_CUR_REC.급여);--SW_CUR_REC에서 사원번호를 호출하여라;
END LOOP;
END;

PROCEDURE IBSAIL--위의 SA_NO랑 같아야한다.
IS
BEGIN
DBMS_OUTPUT.PUT_LINE('입사일');
DBMS_OUTPUT.PUT_LINE('--------');
FOR SW_CUR_REC IN SW_CUR LOOP
DBMS_OUTPUT.PUT_LINE(SW_CUR_REC.입사일);--SW_CUR_REC에서 사원번호를 호출하여라;
END LOOP;
END;

PROCEDURE MGR--위의 SA_NO랑 같아야한다.
IS
BEGIN
DBMS_OUTPUT.PUT_LINE('사수번호');
DBMS_OUTPUT.PUT_LINE('--------');
FOR SW_CUR_REC IN SW_CUR LOOP
DBMS_OUTPUT.PUT_LINE(SW_CUR_REC.사수번호);--SW_CUR_REC에서 사원번호를 호출하여라;
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
insert into lee.memo values(lee.sehak.nextval,'행이 insert되었습니다');
end;
