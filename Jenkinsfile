pipeline {
    agent any
    tools {
        gradle "Gradle 6.8.3"
    }
    parameters {
        choice(name: 'TASK',
                choices: ['test', 'selenide', 'jsoup'],
                description: 'test - run all tests\n' +
                        'selenide - run tests with selenide\n' +
                        'jsoup - run tests with jsoup parser')
        string(name: 'SELENOID_URL', defaultValue: 'selenoid.autotests.cloud')
        string(name: 'THREADS', defaultValue: '2')
        choice(name: 'ENV_URL', choices: ['https://ya.ru', 'http://PREPROD.url'])
        string(name: 'TELEGRAM_CHAT_ID', defaultValue: '-548005165')
        credentials(name: 'TELEGRAM_BOT_TOKEN_ID',
                description: 'Telegram bot token for sending notifications in telegram chat',
                defaultValue: 'c05-fattaft-telegram-token',
                credentialType: "jenkins_secret_text_credentials",
                required: true)
    }
    stages {
        stage('Test') {
            steps {
                withAllureUpload(name: '${JOB_NAME} - #${BUILD_NUMBER}', projectId: '164', results: [[path: 'build/allure-results']], serverId: 'allure-server', tags: 'tags') {
                    sh 'gradle clean ${TASK} -Dthreads=${THREADS}'
                }
            }
        }
        stage('Test gradle') {
            steps {
                sh 'gradle clean ${TASK} -Dtelegram.token=${TELEGRAM_BOT_TOKEN} -Dthreads=${THREADS}'
            }
        }
    }

    post {
        always {
            allure includeProperties: false, jdk: '', results: [[path: 'build/allure-results']]
        }
    }

}

