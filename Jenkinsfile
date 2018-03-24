pipeline {
  agent any
    tools {
        maven 'MAVEN_HOME'
    }
    stages{
        stage('Build Maven'){
            steps{
              sh 'maven clean package'
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
