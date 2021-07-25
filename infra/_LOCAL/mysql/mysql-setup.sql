CREATE DATABASE sonar CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE USER sonar@localhost IDENTIFIED BY 'sonar';
CREATE USER sonar@'%' IDENTIFIED BY 'sonar';

GRANT ALL ON sonar.* TO sonar@localhost;
GRANT ALL ON sonar.* TO sonar@'%';

USE mysql
SELECT '==================   DB  ==================';
SHOW databases;
SELECT '================== USERS ==================';
SELECT user, host, authentication_string FROM mysql.user;
FLUSH PRIVILEGES;
QUIT

