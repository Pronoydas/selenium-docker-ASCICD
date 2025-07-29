#!/bin/bash
echo "-------------------------------------------"                                                                                             
echo "HUB_IP     : ${HUB_IP:-13.126.22.235}"   # AWS MC IP Address                                                                                                  
echo "BROWSER       : ${BROWSER:-chrome}"                                                                                                      
echo "THREAD_COUNT  : ${THREAD_COUNT:-1}"                                                                                                      
echo "TEST_SUITE    : ${TEST_SUITE}"                                                                                                           
echo "IS_ENABLE    : ${IS_ENABLE:-true}"                                                                                                       
echo "-------------------------------------------"                                                                                                          
echo "Checking If Hub is ready...!"                                                                                                                         
count=0
while [ "$( curl -s http://${HUB_IP:-13.126.22.235}:4444/status | jq -r .value.ready )" != "true" ]
do
  count=$((count+1))
  echo "Attempt: ${count}"
  if [ "$count" -ge 30 ]
  then
      echo "**** HUB IS NOT READY WITHIN 30 SECONDS ****"
      exit 1
  fi
  sleep 1
done
echo "Selenium Grid is up and running. Running the test...."
java -cp 'libs/*' \
     -Dselenium.grid.enabled=true \
     -Dselenium.grid.urlFormat="http://${HUB_IP:-13.126.22.235}:4444/wd/hub" \
     -Dbrowser="${BROWSER:-chrome}" \
     org.testng.TestNG ${TEST_SUITE} -threadcount "${THREAD_COUNT:-1}"