pipeline {
    agent any
    tools {
        maven 'MAVEN_HOME'
    }
    stages {
        stage('Build Package'){
            steps{ 
                sh "mvn clean install"
            }
        }
        stage('docker test'){
            agent { 
                label 'docker-agent'
            }
            steps{
                sh "docker --version"
                sh "docker pull docker-registry-default.cicd.ascendmoney-dev.internal/test-qa/tts:latest"
                sh "docker build -t myapps:latest ."
            }
        }

    }
}
