pipeline {
    tools{
        maven 'MAVEN_HOME'
    }
    stages{
        stage('Build Maven'){
            step{
                sh 'maven clean package'
            }
        }
        stage('Deployment'){
            sh 'oc login -u$USER_NAME -p$USER_PASSWD --server=$OSO_SERVER --certificate-authority=$CERT_PATH'
            sh 'oc project $DEVEL_PROJ_NAME'
        }
    }
}
