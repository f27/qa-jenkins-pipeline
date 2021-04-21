pipeline {
    agent any
    properties([pipelineTriggers([githubPush()])])
    environment {
        CHOICE_BOOLEAN = true
        TELEGRAM_TOKEN = credentials('c05-fattaft-Telegram_token')
    }
    stages {
        stage('Test') {
            steps {
                sh './gradlew clean test -Dtelegram.token=${TELEGRAM_TOKEN} -Dpar.boolean=${CHOICE_BOOLEAN}'
            }
        }
    }
    post {
        always {
            allure includeProperties: false, jdk: '', results: [[path: 'build/allure-results']]
        }
    }

}

