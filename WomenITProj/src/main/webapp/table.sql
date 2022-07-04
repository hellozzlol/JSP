create table book (
  book_code varchar2(10) primary key,
  book_name varchar2(30) not null,
  book_auth varchar2(30),
  book_pres varchar2(30),
  book_amt  number
)