properties([pipelineTriggers([githubPush()])])

pipeline {
    agent any

    stages {
        stage('Test') {
            steps {
                  withGradle {
                    sh "echo ${CHOICE_BOOLEAN} "
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