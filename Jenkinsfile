node("docker") {
    docker.withRegistry('https://docker-registry-default.apps.master-ocp.truemoney.com.kh', 'docker-credentials') {
        stage "build"
        def app = docker.build "your-project-name"
    
        stage "publish"
        app.push 'master'
        app.push "${commit_id}"
    }
}
