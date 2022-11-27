#!/bin/sh
mysqladmin -h 192.168.0.8 -P 3306 --protocol=tcp -u root --password=Tommijgqb#19 drop database hc_userdb
mysqladmin -h 192.168.0.8 -P 3306 --protocol=tcp -u root --password=Tommijgqb#19 create hc_userdb
mysql -h 192.168.0.8 -P 3306 --protocol=tcp -u root --password=Tommijgqb#19 hc_userdb < ./housingUser.sql
mysqlshow -h 192.168.0.8 -P 3306 --protocol=tcp -u root --password=Tommijgqb#19
mysqlshow -h 192.168.0.8 -P 3306 --protocol=tcp -u root --password=Tommijgqb#19 hc_userdb