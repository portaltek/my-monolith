#echo '===================================================================================='
#echo '          INSTALL JAVA16                                                            '
#echo '===================================================================================='
#
#echo '===================================================================================='
#echo '          INSTALL DOCKER                                                            '
#echo '===================================================================================='


echo '===================================================================================='
echo '          CREATE DOCKER CONTAINER FOR POSTGRES                                      '
echo '===================================================================================='

docker rm -f local-postgres
docker run --name local-postgres -p 15432:5432 \
      -e POSTGRES_USER=postgres \
      -e POSTGRES_PASSWORD=postgres \
      -e POSTGRES_DB=my_monolith_db \
      -d postgres:13.3-alpine

echo "=========================================================================================="
echo "   WAITING 15s TO LET CONTAINER TO START UP..."
echo "=========================================================================================="

sleep 15s # Waits 5 seconds.
docker cp ./postgres-setup.sql local-postgres:/postgres-setup.sql
docker exec -it local-postgres psql -Upostgres -a my_monolith_db -f /postgres-setup.sql


