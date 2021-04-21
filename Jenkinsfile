pipeline {
    agent any
    parameters {
        choice(name: 'TASK',
                choices: ['test', 'selenide', 'jsoup'],
                description: 'test - run all tests\n' +
                        'selenide - run tests with selenide\n' +
                        'jsoup - run tests with jsoup parser')
        string(name: 'SELENOID_URL', defaultValue: 'selenoid.autotests.cloud')
        string(name: 'THREADS', defaultValue: '1')
        choice(name: 'ENV_URL', choices: ['https://ya.ru', 'http://PREPROD.url'])
        string(name: 'TELEGRAM_CHAT_ID', defaultValue: '-548005165')
        credentials(name: 'TELEGRAM_BOT_TOKEN',
                description: 'Telegram bot token for sending notifications in telegram chat',
                defaultValue: '',
                credentialType: "jenkins_secret_text_credentials",
                required: true)
    }
    stages {
        stage('Test') {
            steps {
                withCredentials([string(credentialsId: 'c05-fattaft-telegram-token', variable: 'TELEGRAM_BOT_TOKEN')]) {
                    sh 'echo ${TASK} ${TELEGRAM_BOT_TOKEN}'
                    sh './gradlew clean test -Dtelegram.token=${TELEGRAM_TOKEN} -Dpar.boolean=${CHOICE_BOOLEAN}'
                }
                sh 'echo ${TASK} ${TELEGRAM_BOT_TOKEN}'
            }
        }
    }
    post {
        always {
            allure includeProperties: false, jdk: '', results: [[path: 'build/allure-results']]
        }
    }

}

