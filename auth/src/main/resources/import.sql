Insert into users(username,password) value('admin', '$2y$12$gourdkS8AxWeN2ABhhN.4O6PbN1usK0afmg4XBuPRNeSgLdFw1oeC');
Insert into role(name, lv) value ('ADMIN',1);
Insert into user_role(user_id,role_id) value (1,1);
