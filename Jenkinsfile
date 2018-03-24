pipeline {
  agent any
    tools {
        maven 'MAVEN_HOME'
    }
    stages{
        stage('Build Maven'){
            steps{
                step(Buiding){
                    sh 'maven clean package'
                }
            }
        }
        stage('Deployment'){
            steps{
                step('Loging OSO'){
                     sh 'oc login -u$USER_NAME -p$USER_PASSWD --server=$OSO_SERVER --certificate-authority=$CERT_PATH'
                }
                step('Switch Project'){
                     sh 'oc project $DEVEL_PROJ_NAME'
                }   
            }
        }
    }
}
