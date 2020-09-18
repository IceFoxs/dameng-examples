
DROP TABLE "SYSDBA"."f_user";

CREATE TABLE "SYSDBA"."f_user"
(
"id" VARCHAR2(50) NOT NULL,
"username" VARCHAR2(50),
"age" INTEGER,
"cjsj" TIMESTAMP(0) DEFAULT NOW NOT NULL,
"xgsj" TIMESTAMP(0) DEFAULT NOW NOT NULL,
CLUSTER PRIMARY KEY("id"),
UNIQUE("username", "age")) STORAGE(ON "MAIN", CLUSTERBTR) ;

UPDATE f_user set age=100 WHERE id='13213';

/***Manager***/create trigger "SYSDBA"."312321321"
before UPDATE of "id","username","age","cjsj","xgsj"
on "SYSDBA"."f_user"
for each row
BEGIN
	/*触发器体*/
 :NEW.xgsj=NOW;
END;

