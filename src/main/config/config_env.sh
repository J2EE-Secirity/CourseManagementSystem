# This script is for configuring dev. environment.
# * creates domain "domain1" within glassfish
# * creates db scheme from the ddl file
# * fills tables with data from sql dump file with inserts

#!/bin/bash

#creating domain..
if [ -z "$GLASSFISH_HOME" ]
then
  echo "Enter ./glassfish home location:" 
  read glassfishLocation
else 
  glassfishLocation=$GLASSFISH_HOME
fi

echo -e "\nList of existing domains:"
listOfExistDomains=$(eval $glassfishLocation/bin/asadmin list-domains)
#seems that eval loses newlines O.o
$glassfishLocation/bin/asadmin list-domains

domainName="domain1"

if [[ "$listOfExistDomains" == *$domainName* ]] 
then
  echo -e "\nDomain already exists";
  echo "Stopping domain '$domainName'.."
  $glassfishLocation/bin/asadmin stop-domain $domainName	
  echo -e "\nDeleting domain '$domainName'.."	
  $glassfishLocation/bin/asadmin delete-domain $domainName	
fi

echo -e "\nCreating domain '$domainName'.."	
$glassfishLocation/bin/asadmin create-domain $domainName

echo -e "\nAdding 'domain.xml' config file to '$domainName'.."
cp -fv ./domain.xml $glassfishLocation/glassfish/domains/$domainName/config

driverPath="./postgresql-9.1-901.jdbc4.jar"
echo -e "\nAdding JDBC driver to domain libs.."
cp -fv $driverPath $glassfishLocation/glassfish/domains/$domainName/lib/ext

echo -e "\nStarting domain '$domainName'.."	
$glassfishLocation/bin/asadmin start-domain $domainName

#creating database..

dbName="postgres"
dbUser="postgres"
dbPass="postgres"
hostname="localhost"
port="5432"
ddl_file="./ddl_generated.sql"
inserts_file="./inserts_generated.sql"
log_file="/tmp/psql_server.log"
echo -e "\n\nUsing next properties to create and fill in the database"
echo "hostname: $hostname"
echo "port: $port"
echo "dbname: $dbName"
echo "username: $dbUser"
echo "password: $dbPass"
echo "ddl file: $ddl_file"
echo "inserts file: $inserts_file"
echo "log file: $log_file"

echo -e "\nCreating databases scheme.."
read -p "Press [Enter] key to continue.."
# psql -f ./ddl_generated.sql -d postgres -U postgres -h localhost -p 5432 -a -L ./server.log -q
psql -f $ddl_file -d $dbName -U $dbUser -h $hostname -p $port -a -L $log_file -q

echo -e "\n\nFilling database.."
read -p "Press [Enter] key to continue.."
psql -f $inserts_file -d $dbName -U $dbUser -h $hostname -p $port -a -L $log_file -q










