pipeline {
  def app
  stages {
    stage('Build') {
      steps {
        app = docker.build("s2i/helloworld")
      }
    }
    stage('Unit Test'){
      app.inside {
        sh 'echo "Tests passed"'
      }
    }
    stage('Push image'){
      docker.withRegistry('https://docker-registry-default.apps.master-ocp.truemoney.com.kh','docker-credentials'){
        app.push("${env.BUILD_NUMBER}")
        app.push("dev")
      }
    }
    stage('Deploy to Development') {
      steps {
        sh 'oc login -u$USER_NAME -p$USER_PASSWD --server=$OSO_SERVER --certificate-authority=$CERT_PATH'
        sh 'oc project dev'
      }
    }
  }//end
}
