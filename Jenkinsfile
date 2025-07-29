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
              sh "docker build -t=pronoydas/automation-docker ."
            }
        }
        stage("Push Image"){
             environment {
                DOCKER_HUB = credentials('dockerHub-creds')
            }
            steps{
               sh '''
                    docker login -u ${DOCKER_HUB_USR} -p ${DOCKER_HUB_PSW}
                    docker push pronoydas/automation-docker:latest
                    docker tag  pronoydas/automation-docker:latest pronoydas/automation-docker:${BUILD_NUMBER}
                    docker push pronoydas/automation-docker:${BUILD_NUMBER}

               '''
            }
        }
    }
    post{
        always{
            sh "docker logout"
        }
    }
}