echo "Cleaning the Build Dir"
rm -rf build/

echo "Buidling the production package"
yarn build 

echo "Building the Nginx Image $1"

docker build -t sleepythred/do/react-frontend:$1 .