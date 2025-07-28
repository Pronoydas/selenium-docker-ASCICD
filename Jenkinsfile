pipeline {

    agent any 

    stages{
        stage("Build Jar"){

            steps{
                sh "mvn clean package -DskipTests"
            }
        }

        stage("Build Image"){

            steps{
              sh "docker build -tpronoydas/selenium-docker . "
            }
        }
        stage("Push Image"){

            steps{
               sh '''
                    docker push pronoydas/selenium-docker:latest
                    docker tag  pronoydas/selenium-docker:latest pronoydas/selenium-docker:${BUILD_NUMBER}
                    docker push pronoydas/selenium-docker:${BUILD_NUMBER}

               '''
            }
        }
    }
}