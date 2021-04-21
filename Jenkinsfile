pipeline {
    agent any
    environment {
        CHOICE_BOOLEAN = true

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

