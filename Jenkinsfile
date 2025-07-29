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
              sh "docker build -t=pronoydas/automation-selenium-docker ."
            }
        }
        stage("Push Image"){
             environment {
                DOCKER_HUB = credentials('dockerHub-creds')
            }
            steps{
               sh '''
                    docker push pronoydas/automation-selenium-docker:latest
                    docker tag  pronoydas/automation-selenium-docker:latest pronoydas/automation-selenium-docker:${BUILD_NUMBER}
                    docker push pronoydas/automation-selenium-docker:${BUILD_NUMBER}

               '''
            }
        }
    }
    // post{
    //     always{
    //         sh "docker logout"
    //     }
    // }
}