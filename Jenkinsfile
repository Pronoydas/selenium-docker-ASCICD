pipeline {

    agent any 

    stages{
        stage("Build Jar"){

            steps{
                sh "mvn clean package -DskipsTest "
            }
        }

        stage("Build Image"){

            steps{
              sh "docker build -tpronoydas/selenium-docker"
            }
        }
        stage("Push Image"){

            steps{
               sh "docker push pronoydas/selenium-docker"
            }
        }
    }
}