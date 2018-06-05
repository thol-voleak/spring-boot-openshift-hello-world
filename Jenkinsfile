pipeline {
  agent any
    tools {
        maven 'MAVEN_HOME'
    }
    stages{
        stage('Build'){
            steps{
              sh 'echo building'
            }
        }
        
        stage('Smoke Test & Docker Build'){
            steps{
              sh 'echo testing'
              //sh 'mvn clean install docker:build docker:push'
            }
        }
        
        stage('Deployment'){
            steps{ 
              sh '/var/lib/jenkins/oc version'
            }
        }
    }
}
