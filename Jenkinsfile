pipeline {
  agent any
    tools {
        maven 'MAVEN_HOME'
    }
    parameters {
        string(name: 'PRO_NAME', defaultValue: 'test1', description: 'Name of project in OCP')
        string(name: 'APP_NAME', defaultValue: 'service-1', description: 'Name of application in OCP')
    }
    stages{
        stage('Build'){
            steps{
              sh "echo ${PRO_NAME} & ${APP_NAME}"
              sh "echo build"
              //sh 'mvn clean install -DskipTests'
            }
        }
        
        stage('Smoke Test+Push'){
            steps{
              sh "echo test"
              /*
              sh '$OC login -u$OCP_USER_NAME -p$OCP_PWD --server=$OCP_SERVER --certificate-authority=$OCP_CERT_PATH'
              script{
                try{
                  sh '$OC get project test1'
                }catch(Exception ex) {
                  sh '$OC new-project test1'
                }
              }
              sh 'mvn clean install docker:build docker:push'
              */
            }
        }
        
        stage('Deployment'){ 
            steps{ 
              sh "echo deployment"
              /*
              script{
                sh '$OC project test1'
                try{
                  sh '$OC get svc service-a'
                  sh '$OC rollout latest dc/service-a -n test1'
                  sh '$OC rollout status dc/service-a'
                }catch(Exception ex){
                  sh '$OC new-app test1/helloworld:latest name=service-a'
                  sh '$OC expose svc/service-a --hostname=service-a-test1.apps.master-ocp.truemoney.com.kh'
                }
              }
              */
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
