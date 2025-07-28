FROM bellsoft/liberica-openjdk-alpine:17.0.16-12
RUN apk add curl jq
RUN apk add dos2unix
WORKDIR /home/docker-selenium
COPY /target/docker-resources /home/docker-selenium
COPY /script/script.sh  /home/docker-selenium/grid_runner.sh
ENTRYPOINT  sh grid_runner.sh 
 
