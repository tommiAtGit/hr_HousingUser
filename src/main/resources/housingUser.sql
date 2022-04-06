USE hc_userdb;
DROP TABLE IF EXISTS housing_user;
DROP TABLE IF EXISTS housing_user_address;



CREATE TABLE housing_user_address
(
	id              BINARY(16) NOT NULL,
	firstname 	    CHAR(80)    NOT NULL,
    lastname        CHAR(50)    NOT NULL,
	email           CHAR(20)   NOT NULL,   
    phonenumber     BINARY(16),
	PRIMARY KEY (id)
)ENGINE=INNODB;

CREATE TABLE housing_user
(
	id              BINARY(16) NOT NULL,
	username 	    CHAR(80)    NOT NULL,
    password        CHAR(50)    NOT NULL,  
    useraddress     BINARY(16),
	PRIMARY KEY (id),
    INDEX user_ind(useraddress),
            FOREIGN KEY (useraddress) REFERENCES housing_user_address(id)
              ON DELETE NO ACTION
              ON UPDATE NO ACTION
)ENGINE=INNODB;

DESCRIBE housing_user;
DESCRIBE housing_user_address;

SELECT * FROM housing_user;
SELECT * FROM housing_user_address;
