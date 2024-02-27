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

select*from tblBonus;
create sequence seqBonus;

select m.name, v.name from tblMember m
inner join tblRent r
on m.seq = r.member
inner join tblVideo v
on v.seq = r.video;

-- Ex06

-- m1. 인자값 X, 반환값 x
create or replace procedure procM1
is
begin
insert into tblAddress (seq, name, age, gender, tel, address, regdate)
values (seqAddress.nextVal, '홍길동', 20, 'm', '010-1234-5678', '서울시 강남구 역삼동 한독빌딩', sysdate);
end procM1;
/

-- m2. 인자값 O, 반환값 x
create or replace procedure procM2 (
    pname varchar2,
    page number,
    pgender varchar2,
    ptel varchar2,
    paddress varchar2
)
is
begin
insert into tblAddress (seq, name, age, gender, tel, address, regdate)
values (seqAddress.nextVal, pname, page, pgender, ptel, paddress, default);
end procM2;
/

begin
    procM2('이름', 20, 'm', '010-1111-2222', '주소');
end;
/

-- m3. 인자값X, 반환값O
create or replace procedure procM3 (
    pcount out number
)
is
begin
    select count(*) into pcount from tblAddress;
end procM3;
/

set serveroutput on;

declare
    vcount number;
begin
    procM3(vcount);
    dbms_output.put_line(vcount);
end;
/

-- m4. 인자값O, 반환값O
-- 직원번호 > 이름, 부서, 직위, 지역 반환
create or replace procedure procM4 (
    pnum in number,
    pname out varchar2,
    pbuseo out varchar2,
    pjikwi out varchar2,
    pcity out varchar2
)
is
begin

    select name, buseo, jikwi, city into pname, pbuseo, pjikwi, pcity
    from tblInsa where num = pnum;

end procM4;
/

-- m5. 커서 반환 (직원 전체 명단 반환)
create or replace procedure procM5 (
    pbuseo in varchar2,
    pcursor out sys_refcursor
)
is
begin
    open pcursor
    for
    select * from tblInsa where buseo = pbuseo;

end procM5;
/

declare
    vcursor sys_refcursor;
    vrow tblInsa%rowtype;
begin
    procM5('영업부', vcursor);
    
    loop
        fetch vcursor into vrow;
        exit when vcursor%notfound;
        
        dbms_output.put_line(vrow.name);
    end loop;
    
end;