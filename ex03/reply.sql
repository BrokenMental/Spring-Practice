CREATE TABLE reply (
  rno int(11) NOT NULL AUTO_INCREMENT,
  bno int(11) DEFAULT 0,
  replytext varchar(1000) DEFAULT NULL,
  replyer varchar(50) DEFAULT NULL,
  regdate timestamp NOT NULL DEFAULT current_timestamp(),
  updatedate timestamp NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (rno),
  KEY fk_board (bno),
  CONSTRAINT fk_board FOREIGN KEY (bno) REFERENCES tbl_board (bno)
);