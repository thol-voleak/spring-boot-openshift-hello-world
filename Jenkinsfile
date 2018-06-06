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
        // send build started notifications
        slackSend (color: 'FF8933', message: "Sucessed built: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'")

        // send to HipChat
        /*hipchatSend (color: 'YELLOW', notify: true,
            message: "STARTED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' (${env.BUILD_URL})"
          )
        */
        // send to email
        /*emailext (
            subject: "STARTED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
            body: """<p>STARTED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]':</p>
              <p>Check console output at &QUOT;<a href='${env.BUILD_URL}'>${env.JOB_NAME} [${env.BUILD_NUMBER}]</a>&QUOT;</p>""",
            recipientProviders: [[$class: 'DevelopersRecipientProvider']]
          )
          */
        }
    }
}
