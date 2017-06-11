#! /opt/csw/bin/perl -w
use DBI;

### USEFUL PERL CODE FOR DBI PROGRAMS ####################################
###
### 1) Lists the contents of studenta's test table 
### 2) Insert a new record
### 3) List contents again
###
###  V E R Y   I M P O R T A N T ! ! !
###  ===============================
###  You MUST replace studenta with your username and the mysql password with whatever your UWE mySQL password is.
###  You will also need to have previously created a table called 'test' in your mySQL database.  There should be four fields: name, email,phone and id.
###
###  See http://www.cems.uwe.ac.uk/supportweb/public/page.php?id=223 for CSCT mySQL information
###
################################################################

print "\'test\' contains:\n";
listDB();
print "Insert new record - now test contains:\n";
writestuff();
listDB();
print "Bye!\n";
exit(0);

#########################################
## EXAMPLE of executing a SELECT SQL statement
#########################################


sub listDB {
  openDB();  ### opens your mySQL database
  
  execSQL("SELECT \* FROM test");   ### A SELECT query  
                                                                                                           ### REPLACE ?????? with your table name
                                                                                                           ### REPLACE \'key\' and the condition
                                                                                                           ###   with your own fieldname and condition
   ###  NOTE THE '\' ESCAPE CHARACTERS - SAFER TO PUT THESE IN IF YOU ARE IN DOUBT!!

  while($sth->fetch()) {   ### loops over all selected rows
    ### This is where you process the row data using the scalars you assigned the fields to in the execSQL funtion (see the utilities section below)
    print "$name\t$email\t$phone\t$id\n";
  }
  
  closeDB();  ### close these database
  
}

#########################################
## EXAMPLE of executing an INSERT INTO SQL statement
#########################################

sub writestuff {   

  openDB();  ### open the database
  
  execSQLwrite("INSERT INTO test VALUES (\'John 
Doe\',\'jdoe\@uwe.ac.uk\',2081234567,NULL)");    
### SQL INSERT STATEMENT - inserts 123,'ABC' into the first two fields 
                                                                                             ###     of a new row 
                                                                                             ### (REPLACE ??? with your table name and 123,'\ABC'\ with your data)
  closeDB();  ### close the database 

}

## mySQL DATABASE UTILITIES #####################
##
##  N.B.  Minimal error handling - assumes SQL queries work.  dies if fails to connect
##
######################################

# Open the database

sub openDB {
  # database information
  $db="studenta";  ## Your mysql Database name (NOT table name) goes here! SEE NOTE AT TOP
  $host="stocks.cems.uwe.ac.uk";  ## Your mysql URL goes here
  $userid="studenta";  ## your userid goes here  SEE NOTE AT TOP
  $passwd="mysql5";  ## your mysql password goes here SEE NOTE AT TOP
  $connectionInfo="dbi:mysql:$db;$host";    ## This is where you say which type of DB you are using (mySQL in this case)

  # make connection to database (effectively logging in)
  $dbh = DBI->connect($connectionInfo,$userid,$passwd, { AutoCommit => 0 }) || die "Could 
not connect to $connectionInfo\n";
}

#Close the database

sub closeDB {
  $dbh->disconnect;
}

# Performs SELECT-type queries on the database

sub execSQL {
  # prepare and execute query
  $qu = $_[0];                         ###  $_[0] is the parameter passed from the call to execSQL (in this case the SQL to execute)
  $sth = $dbh->prepare($qu);
  $sth->execute();

  ### assign fields to Perl scalar variables
  ###  This binds the four columns in the table used for the last SELECT to the four Perl scalars
  ###   N.B. THERE MUST BE A VARIABLE LISTED HERE FOR EACH COLUMN IN THE TABLE OR YOU WILL GET AN ERROR!!  
  $sth->bind_columns(\$name,\$email,\$phone,\$id);  
}

# Performs UPDATE/INSERT-type queries

sub execSQLwrite {
  # prepare and execute query
  $qu = $_[0];
  $sth = $dbh->prepare($qu);
  $sth->execute();
  $dbh->commit();    ### commit forces the database to carry out the transaction
}

########## END ############################
