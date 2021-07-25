##############################################################################################################
#
#           IMPORTANT:
#           OPEN TERMINAL ON THIS FILE FOLDER AND EXECUTE COMMANDS.
#
##############################################################################################################

echo "=========================================================================================="
echo "   REMOVE OLD CONTAINER / START NEW CONTAINER"
echo "=========================================================================================="
docker rm -f local-mysql8
docker run --name local-mysql8 \
      -e MYSQL_ROOT_PASSWORD=password \
      -p 13306:3306 \
      -d mysql:8.0.25

# OPTIONAL: LOGIN INTO CONTAINER.
# docker exec -it local-mysql8 /bin/sh

# OPTIONAL: LOGIN INTO MYSQL DIRECTLY.
# docker exec -it local-mysql8 mysql -u root -ppassword

# OPTIONAL: COPY/IMPORT DB SCRIPT
# docker cp ./mysql-setup.sql local-mysql8:/docker-entrypoint-initdb.d/mysql-setup.sql

echo "=========================================================================================="
echo "   WAITING 15s TO LET CONTAINER TO START UP..."
echo "=========================================================================================="

sleep 15s # Waits 5 seconds.
docker exec -i local-mysql8 \
  mysql -u root -ppassword <./mysql-setup.sql


