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
              sh '$OC login -u$OCP_USER_NAME -p$OCP_PWD --server=$OCP_SERVER --certificate-authority=$OCP_CERT_PATH'
              script{
                try{
                  sh '$OC get project test1'
                }catch(Exception ex) {
                  sh '$OC new-project test1'
                }
              }
              sh 'mvn clean install docker:build docker:push'
            }
        }
        
        stage('Deployment'){ 
            steps{ 
              //sh '$OC login -u$OCP_USER_NAME -p$OCP_PWD --server=$OCP_SERVER --certificate-authority=$OCP_CERT_PATH'
              script{
                sh '$OC project test1'
                try{
                  sh '$OC get svc service-a'
                  sh '$OC rollout latest dc/service-a -n test1'
                  sh '$OC rollout status dc/service-a'
                }catch(Exception ex){
                  sh '$OC new-app test1/helloworld:latest'
                  sh '$OC expose svc/service-a --hostname=service-a-test1.apps.master-ocp.truemoney.com.kh'
                }
              }
            }
        }
    }
    post { 
        success{ 
            //sh 'echo sucessed'
            slackSend (color: '#33ff36', message: "Sucessed built: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]\nView Report: (${env.BUILD_URL})\nTest URL: (http://helloworld.apps.master-ocp.truemoney.com.kh/test)'")
        }
        failure {
          //sh 'echo fail'
          slackSend (color: '#ff9f33', message: "Failed build: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]\nView Report: (${env.BUILD_URL})'")
        }
    }
}
