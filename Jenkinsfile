properties([pipelineTriggers([githubPush()])])

pipeline {
    agent any

    stages {
        stage('Test') {
            steps {
                  withGradle {
                    withCredentials([string(credentialsId: 'c05-fattaft-telegram-token', variable: 'SECRET')]) {
                        sh 'echo "${SECRET}"'
                    }
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