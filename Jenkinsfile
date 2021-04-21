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
        allure([
                includeProperties: true,
                jdk              : '',
                properties       : [],
                reportBuildPolicy: 'ALWAYS',
                results          : [[path: 'ui-tests/build/allure-results']]
            ])
        deleteDir()
    }
}