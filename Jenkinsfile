pipeline {
  agent any
  tools {
    maven 'MAVEN_HOME'
  }
  stages {
    stage('Build') {
      steps {
        sh 'mvn clean package'
      }
    }
    stage('Deploy to Development') {
      steps {
        sh 'oc login -u$USER_NAME -p$USER_PASSWD --server=$OSO_SERVER --certificate-authority=$CERT_PATH'
        
      }
    }
  }//end
}
