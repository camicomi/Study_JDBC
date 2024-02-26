-- 오라클 가서 쿼리를 짜고 이클립스에서 복사

-- 주소록 테이블
drop table tblAddress;

create table tblAddress (

seq number primary key,
name varchar2(30) not null,
age number(3) not null check (age between 0 and 150),
gender char(1) not null check (gender in ('m', 'f')),
tel varchar2(15) not null,
address varchar2(300) not null,
regdate date default sysdate not null

);

create sequence seqAddress;

-- CRUD + 추가 업무
insert into tblAddress (seq, name, age, gender, tel, address, regdate)
values (seqAddress.nextVal, '홍길동', 20, 'm', '010-1234-5678', '서울시 강남구 역삼동 한독빌딩', default);

update tblAddress set age = age + 1 where seq = 1;

delete from tblAddress where seq = 1;

select * from tblAddress;

commit; -- 필수