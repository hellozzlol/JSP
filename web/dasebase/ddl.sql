drop table reply;

create table reply(
no number primary key,
writer varchar2(20),
wdate date,
content varchar2(200),
notice_id number
);

insert into   reply values(1,'영웅이',sysdate,'댓글1',14);
insert into   reply values(2,'하늘이',sysdate,'댓글2',14);