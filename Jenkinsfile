properties([pipelineTriggers([githubPush()])])

pipeline {
    agent any

    stages {
        stage('Test') {
            steps {
                sh './gradlew clean test'
            }
        }
    }
}

post {
    always {
        allure includeProperties: false, jdk: '', results: [[path: 'build/allure-results']]
    }
}