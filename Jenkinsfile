properties([pipelineTriggers([githubPush()])])
parameters { choice(name: 'CHOICES', choices: ['one', 'two', 'three'], description: '') }

pipeline {
    agent any
    environment {
        CHOICE_BOOLEAN = ${CHOICE_BOOLEAN}
    }

    stages {

        stage('Test') {
            steps {
                sh './gradlew clean test'
            }
        }
    }
    post {
        always {
            allure includeProperties: false, jdk: '', results: [[path: 'build/allure-results']]
        }
    }

}

