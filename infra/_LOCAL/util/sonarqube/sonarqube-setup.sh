
echo "=========================================================================================="
echo "   CREATE DOCKER NETWORK"
echo "=========================================================================================="

docker network rm sonarnet
docker network create sonarnet
docker network ls

echo "=========================================================================================="
echo "   CREATE SONAR CONTAINER AND SONAR DB CONTAINER"
echo "=========================================================================================="

docker rm -f local-sonarqube8 local-sonarqube8-db
docker run --name local-sonarqube8-db --net sonarnet -p 5432:5432\
      -e POSTGRES_USER=sonar \
      -e POSTGRES_PASSWORD=sonar \
      -d postgres:13.3-alpine
docker run --name local-sonarqube8 --net sonarnet -p 9000:9000 \
      -e SONARQUBE_JDBC_USERNAME=sonar \
      -e SONARQUBE_JDBC_PASSWORD=sonar \
      -e SONARQUBE_JDBC_URL=jdbc:postgresql://local-sonarqube8-db:5432/sonar \
      -d sonarqube:8.9.1-community


echo "=========================================================================================="
echo "   OPEN http://localhost:9000/   CREDENTIALS: admin/admin"
echo "=========================================================================================="





