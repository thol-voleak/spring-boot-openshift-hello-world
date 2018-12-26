pipeline {
    agent any
    stages {
        stage('Build Package'){
            steps{ 
                sh "mvn clean install -Dregistry=${REGISTRY_URL}"
            }
        }
        stage('docker test'){
            agent { 
                label 'docker-agent'
            }
            steps{
                sh "docker --version"
            }
        }

    }
}
