pipeline {
  agent any
    tools {
        maven 'MAVEN_HOME'
    }
    parameters {
        string(name: 'PRO_NAME', defaultValue: 'test1', description: 'Name of project in OCP')
        string(name: 'APP_NAME', defaultValue: 'service-1', description: 'Name of application in OCP')
        string(name: 'IMG_NAME', defaultValue: 'helloworld', description: 'Name of image will deploy')
    }
    stages{
        stage('Build'){
            steps{
              sh "echo ${PRO_NAME} and ${APP_NAME} and ${IMG_NAME}"
              //sh "echo build"
              sh "mvn clean install -DskipTests"
            }
        }
        
        stage('Smoke Test+Push'){
            steps{
              //sh "echo test"
              sh "$OC login -u$OCP_USER_NAME -p$OCP_PWD --server=$OCP_SERVER --certificate-authority=$OCP_CERT_PATH"
              script{
                try{
                  sh "$OC get project ${PRO_NAME}"
                }catch(Exception ex) {
                  sh "$OC new-project ${PRO_NAME}"
                }
              }
              sh "mvn clean install docker:build docker:push"
            }
        }
        
        stage('Deployment'){ 
            steps{ 
              //sh "echo deployment"
              script{
                sh "$OC project ${PRO_NAME}"
                try{
                  sh "$OC get svc ${APP_NAME}"
                  sh "$OC rollout latest dc/${APP_NAME} -n test1"
                  sh "$OC rollout status dc/${APP_NAME}"
                }catch(Exception ex){
                  sh "$OC new-app test1/${IMG_NAME}:latest name=${APP_NAME}"
                  sh "$OC expose svc/${APP_NAME} --hostname=${APP_NAME}-${PRO_NAME}.apps.$BASE_URL"
                }
              }
            }
        }
    }
    post { 
        success{ 
            //sh 'echo sucessed'
            slackSend (color: '#33ff36', message: "Sucessed built: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]\nView Report: (${env.BUILD_URL})\nTest URL: (http://${APP_NAME}-${PRO_NAME}.apps.$BASE_URL/test)'")
        }
        failure {
          //sh 'echo fail'
          slackSend (color: '#ff9f33', message: "Failed build: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]\nView Report: (${env.BUILD_URL})'")
        }
    }
}
