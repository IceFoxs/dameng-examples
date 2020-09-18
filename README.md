# dameng_examples
springboot  集成mybatisplus（3.4.0） ,达梦数据库（DM7）


#创建数据库触发器示例
```
create or replace trigger your_tablename_update_time
before delete or update on your_tablename
referencing OLD AS "OLD" NEW AS "NEW"
for each row
BEGIN
  /*触发器体*/
 
  IF UPDATING THEN
:new.update_time = CURRENT_TIMESTAMP;
  END IF;
 
exception when others then
null;
 
END;
```
