#!/bin/sh
mysqladmin -h localhost -P 3306 --protocol=tcp -u root --password=Tommijgqb#19 drop database hc_userdb
mysqladmin -h localhost -P 3306 --protocol=tcp -u root --password=Tommijgqb#19 create hc_userdb
mysql -h localhost -P 3306 --protocol=tcp -u root --password=Tommijgqb#19 hc_userdb < ./housingUser.sql
mysqlshow -h localhost -P 3306 --protocol=tcp -u root --password=Tommijgqb#19
mysqlshow -h localhost -P 3306 --protocol=tcp -u root --password=Tommijgqb#19 hc_userdb