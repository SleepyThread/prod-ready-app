docker stop create-react-app
docker rm create-react-app
docker run --name create-react-app -p 18080:80 -d sleepythred/do/react-frontend:$1