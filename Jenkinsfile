properties([pipelineTriggers([githubPush()])])

pipeline {
    agent any

    stages {
        stage('Checkout SCM') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/f27/qa-jenkins-pipeline/']]])
            }
        }
        stage('Test') {
            steps {
                  withGradle {
                    sh 'gradle --version'v
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