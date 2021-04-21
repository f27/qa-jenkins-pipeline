properties([pipelineTriggers([githubPush()])])

pipeline {
    agent any

    stages {
        stage('Test') {
            steps {
                  withGradle {
                    sh "echo ${SECRET}"
                  }
            }
        }
    }

    post {
       always {
           cleanWs()
       }
   }
}