pipeline {

    agent any 

    stages{
        stage("Build Jar"){

            steps{
                bat "mvn clean package -DskipsTest "
            }
        }

        stage("Build Image"){

            steps{
              bat "docker build -tpronoydas/selenium-docker"
            }
        }
        stage("Push Image"){

            steps{
               bat "docker push pronoydas/selenium-docker"
            }
        }
    }
}