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
              sh 'oc project demonstration'
              sh 'oc tag docker-registry.default.svc:5000/demonstration/helloworld-db demonstration/helloworld-db:latest'
              sh 'oc push demonstration/helloworld-db:latest'
            }
        }
    }
}
