CREATE TABLE tbl_board (
  bno int(11) NOT NULL AUTO_INCREMENT,
  title varchar(200) DEFAULT NULL,
  content text DEFAULT NULL,
  writer varchar(50) DEFAULT NULL,
  regdate timestamp NOT NULL DEFAULT current_timestamp(),
  viewcnt int(11) DEFAULT 0,
  PRIMARY KEY (bno)
);