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
        
        stage('Smoke Test+Push'){
            steps{
              //sh 'echo Test'
              sh 'mvn clean install docker:build docker:push'
            }
        }
        
        stage('Deployment'){ 
            steps{ 
              sh '$OC version'
              sh '$OC login -u$OCP_USER_NAME -p$OCP_PWD --server=$OCP_SERVER --certificate-authority=$OCP_CERT_PATH'
              sh '$OC project test1'
              //sh '$OC rollout latest dc/helloworld -n test1'
            }
        }
    }
    post { 
        success{ 
          slackSend (color: 'FF8933', message: "Sucessed built: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'")
        }
        failure {
          slackSend (color: 'FF8933', message: "Fail build: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'")
        }
    }
}
