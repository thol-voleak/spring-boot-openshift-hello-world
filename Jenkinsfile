pipeline {
  agent any
    tools {
        maven 'M3'
    }
    stages{
        stage('Build'){
            steps{
              sh 'mvn clean package'
            }
        }
        stage('Test Docker'){
            steps{
              sh 'docker --version'
            }
        }
        stage('Test Connect OCP'){
            steps{ 
              sh 'oc login -u$USER_NAME -p$USER_PASSWD --server=$OCP_SERVER --certificate-authority=$CERT_PATH'
              sh 'oc project ads'
              sh 'oc get projects'
            }
        }
    }
}
