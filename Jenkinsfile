pipeline {
  agent any
    tools {
        maven 'MAVEN_HOME'
    }
    stages{
        stage('Build'){
            steps{
              sh 'mvn clean install -DskipTests'
            }
        }
        
        stage('Smoke Test & Docker Build'){
            steps{
              sh 'mvn clean install docker:build docker:push'
            }
        }
        
        stage('Deployment'){
            steps{ 
              sh '/var/lib/jenkins/oc login -u$OCP_USER_NAME -p$OCP_PWD --server=$OCP_SERVER --certificate-authority=$OCP_CERT_PATH'
              sh '/var/lib/jenkins/oc project test1'
              sh '/var/lib/jenkins/oc get dc'
              sh '/var/lib/jenkins/oc rollout latest dc/helloworld -n test1'
            }
        }
    }
}
