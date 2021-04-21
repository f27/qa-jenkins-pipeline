properties([pipelineTriggers([githubPush()])])

pipeline {
    agent any
    tools {
        gradle "6.8.3"
    }

    stages {
        stage('Checkout SCM') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/f27/qa-jenkins-pipeline/']]])
            }
        }
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
           deleteDir()
       }
   }
}