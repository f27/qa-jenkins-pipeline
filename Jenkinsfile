properties([pipelineTriggers([githubPush()])])

pipeline {
    agent any

    stages {
        stage('Test') {
            steps {
                  withGradle {
                    sh 'gradle --version'
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