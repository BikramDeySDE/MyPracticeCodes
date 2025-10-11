# create a DB
CREATE DATABASE MyTestDB;

#------------------------------------------------------------------

# create a table
USE MyTestDB;
CREATE TABLE Employee(id INT(3) auto_increment primary key , fullname VARCHAR(25) not null, technology varchar(25) NOT null);

#------------------------------------------------------------------

# delete a table
USE MyTestDB;
DROP TABLE Employee;

#------------------------------------------------------------------

# insert a record

USE MyTestDB;
INSERT INTO Employee VALUES(1, 'Bikram Dey', 'Java');

INSERT INTO mytestdb.employee(fullname, technology) VALUES ('Arunima Ghosh', 'Data Analytics');

#------------------------------------------------------------------

# insert multiple records

INSERT INTO mytestdb.employee(fullname, technology) VALUES ('Manasi Dey', 'Political Science'), ('Bibekananda Dey', 'Business Management');

# -----------------------------------------------------

# read all records

USE MyTestDB;
SELECT * FROM employee;

SELECT * FROM mytestdb.employee;

#------------------------------------------------------------------

# read a particular record

SELECT * FROM mytestdb.employee where id>1;

#------------------------------------------------------------------

# delete a particular record

DELETE FROM mytestdb.employee WHERE id=3;

#------------------------------------------------------------------

# update a record

UPDATE mytestdb.employee SET fullname='Bibekananda Dey', technology='Business Management' WHERE id=4;

UPDATE mytestdb.employee SET fullname='Manasi Dey', technology='Political Science' WHERE id=5;



