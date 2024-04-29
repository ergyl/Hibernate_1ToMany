

A simple school task that let's me practise mapping Java (domain) objects to database tables using the javax.persistence package while learning Hibernate.

## Domain classes
- se.yrgo.domain.Animal
- se.yrgo.domain.Zoo

*One Zoo can have many animals, but one animal can only be in one zoo.*

# How to run it
This task is made using Apache Derby as the database.

Download Apache Derby: https://db.apache.org/derby/derby_downloads.html

### Connect to Derby
First we need to connect to our database. There are two files in the bin folder of derby which are called NetworkServerControl.bat which will be used for windows system and `NetworkServerControl.sh` which will be used for linux and mac system:
`C:\>cd db-derby-10.12.1.1-bin/bin`

Windows:
`NetworkServerControl.bat -p 50000 start`

Linux:
`./NetworkServerControl -p 50000 start`

### Create a database in Derby
Then we need to create a database. To do that, open another terminal and open interactive shell ij:
`C:\>cd db-derby-10.12.1.1-bin/bin`

Run ij:
In Windows(cmd): Run `ij.bat`
In Linux and Mac: Run `./ij`

Create the database:
`connect 'jdbc:derby://localhost:50000/zoo_db; create=true' ;`

Run the code from main class: src/main/se/yrgo/test/App
