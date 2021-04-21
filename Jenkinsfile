pipeline {
    agent any
    parameters {
        choice(name: 'TASK',
                choices: ['test', 'api', 'selenide'],
                description: 'test - run all tests\n' +
                        'selenide - run tests with selenide\n' +
                        'jsoup - run tests with jsoup parser')
        string(name: 'SELENOID_URL', defaultValue: 'selenoid.autotests.cloud')
        string(name: 'THREADS', defaultValue: '1')
        choice(name: 'ENV_URL', choices: ['https://ya.ru', 'http://PREPROD.url'])
        string(name: 'TELEGRAM_CHAT_ID', defaultValue: '-548005165')
        credentials(name: 'TELEGRAM_BOT_TOKEN',
                description: 'Telegram bot token for sending notifications in telegram chat',
                defaultValue: 'c05-fattaft-Telegram_token',
                credentialType: "Secret text",
                required: true )

        text(name: 'BIOGRAPHY', defaultValue: '', description: 'Enter some information about the person')

        booleanParam(name: 'TOGGLE', defaultValue: true, description: 'Toggle this value')


        password(name: 'PASSWORD', defaultValue: 'SECRET', description: 'Enter a password')
    }
    stages {
        stage('Test') {
            steps {
                sh 'echo ${CHOICE_BOOLEAN} ${TELEGRAM_TOKEN}'
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

