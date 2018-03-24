pipeline {
  agent any
    tools {
        maven 'M3'
    }
    stages{
        stage('Build Maven'){
            steps{
              sh 'mvn clean package'
            }
        }
        stage('Deployment'){
            steps{ 
              sh 'oc login -u$USER_NAME -p$USER_PASSWD --server=$OSO_SERVER --certificate-authority=$CERT_PATH'
              sh 'oc project $DEVEL_PROJ_NAME'
            }
        }
    }
}
