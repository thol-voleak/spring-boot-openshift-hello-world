pipeline {
    tools{
        maven="MAVEN_HOME"
    }
    stages{
        stage('Build Maven'){
            step{
                sh 'maven clean package'
            }
        }
        stage('Deployment'){
            oc login -u$USER_NAME -p$USER_PASSWD --server=$OSO_SERVER --certificate-authority=$CERT_PATH
            oc project $DEVEL_PROJ_NAME
        }
    }
}
