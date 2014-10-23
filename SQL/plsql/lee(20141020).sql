
create table 사원
(사원번호 number(10),
사원명 varchar2(10),
부서번호 number(2),
직급 varchar2(10),
우편번호 char(7),
주소 varchar2(50),
전화번호 char(15),
급여 number(5),
커미션 number(5),
입사일 date,
성별 char(4),
사수번호 number(10)
);

insert into 사원 values(2001,'이순신',10,'부장','125-365','서울 용산구','02-985-1254',3500,100,'1980-12-01','남자',null);
insert into 사원 values(2002,'홍길동',10,'대리','354-865','서울 강남구','02-865-1254',4000,'','2000-01-25','남자',2004);
insert into 사원 values(2003,'성유리',20,'사원','587-456','부산 해운대구','051-256-9874',2500,100,'2002-05-24','여자',2002);
insert into 사원 values(2004,'옥주현',30,'과장','987-452','서울 강남구','02-33-6589',5000,'','1997-03-22','여자',2001);
insert into 사원 values(2005,'길건',10,'대리','123-322','서울 성동구','02-888-9564',3000,100,'1999-07-15','여자',2004);
insert into 사원 values(2006,'한지혜',20,'사원','154-762','서울 송파구','02-3369-9874',2000,'','2003-05-22','여자',2005);
insert into 사원 values(2007,'박솔미',30,'대리','367-985','서울 영등포구','02-451-2563',3000,100,'2006-01-25','여자',2004);
insert into 사원 values(2008,'이효리',40,'사원','552-126','서울 중구','02-447-3256',2000,'','2001-02-02','여자',2007);

commit;

select * from 사원;

desc 사원;

select 사원명, 직급, 급여  from 사원 where 사원번호=2001;

select * from custom;

----------------------------------------------------

create table test_pro
(id number(10),
name varchar2(10),
ipsa date default sysdate);

desc test_pro;

insert into test_pro(id,name) values (111,'kim');

select * from test_pro;

select * from custom;

select * from custom where userid = '444';

desc custom;

mg5700
--------------------------------------------------------

--고객번호를 입력받아서 해당고객이 지금까지 주문한 총 횟수 구하기

select count(*) from sales
where userid='mg5700'

group by userid

--------------------------------------------------------
--직책을 입력받아 그직책이 급여의 총액, 평균월급, 인원수를 출력

select * from company;

select SUM(PAY), AVG(PAY), COUNT(*) into A, B, C
from company where POSIT=JIK;


------------------------------------------------------------
--20141021

 select f_cubvol(2,6,9) bupi from dual;

------------------------------------------------------------

select MONTHS_RETURN(SYSDATE,'2002-04-01')/12 FROM DUAL;

SELECT MOD(10,3) FROM DUAL;


------------------------------------------------------------

--10

SELECT PAY, F_PAYDEUN(PAY) FROM COMPANY;

------------------------------------------------------------
--11

 CREATE TABLE LOOP1(NO NUMBER, NAME VARCHAR2(6) DEFAULT '홍길동');

 SELECT * FROM LOOP1;

---------------------------------------------------------------------------
--12

EXEC FOR_TEST;

SELECT * FROM LOOP1;

---------------------------------------------------------------------------
--13

EXEC BANBOK(1,100);

---------------------------------------------------------------------------
--14

EXEC BANBOK1(1,100);

---------------------------------------------------------------------------
--15

EXEC EXP_TEST;
BEGIN EXP_TEST; END;

---------------------------------------------------------------------------
--18


EXEC P_DEPTNO(20);


---------------------------------------------------------------------------
--19

EXEC P_DEPTNO1(10);

---------------------------------------------------------------------------
--20


EXEC P_jepum('na4477');