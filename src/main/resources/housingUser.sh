#!/bin/sh
mysqladmin -u root --password=Tommijgqb#19 drop housinguserdb
mysqladmin -u root --password=Tommijgqb#19 create housinguserdb
mysql -u root --password=Tommijgqb#19 housingdb < ./housingUser.sql
mysqlshow -u root --password=Tommijgqb#19
mysqlshow -u root --password=Tommijgqb#19 housinguserdb