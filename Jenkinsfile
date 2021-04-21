properties([pipelineTriggers([githubPush()])])

pipeline {
    agent any

    stages {
        try {
            stage('Test') {
                steps {
                    sh './gradlew clean test'
                }
            }
        } finally {

            stage('Allure reports') {
                steps {
                    allure includeProperties: false, jdk: '', results: [[path: 'build/allure-results']]
                }
            }
        }
    }
}

post {
    always {
        deleteDir()
    }
}