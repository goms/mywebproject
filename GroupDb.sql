create table groupTable(gid integer primary key, groupaccountnumber varchar(10));
create table groupPersonDetail(gid integer, pid integer primary key);

create table groupHead(gid integer primary key,pid integer );

select * from Personetails;

insert into groupHead values(1,12899);

select * from groupPersonDetail;
select * from groupTable;

select * from accountdetail;
select * from transactionDetail;

delete from groupTable;
delete from groupHead;
delete from groupPersonDetail;
delete from Personetails;
delete from accountdetail;
delete from transactionDetail;

create table selectedMember(gid integer primary key, pid integer);

select * from selectedMember;

create table selectedMemberHistory(gid integer primary key, pid integer,dateMemSel date,gno integer);

alter table selectedMemberHistory drop column gno;

select * from selectedMemHist;

create table selectedMemHist(gid integer primary key, pid integer,dateMemSel timestamp,gno integer);
alter table selectedMemHist drop column gno;



ALTER TABLE transactionDetail
  MODIFY tDate timestamp;
  
  ALTER TABLE selectedMemHist
disable CONSTRAINT primary key;





create table selMemHist(gid integer, pid integer,dateMemSel timestamp);
