pipeline {
    agent any
    tools {
        gradle "6.8.3"
    }
    parameters {
        booleanParam(name: 'RELEASE', defaultValue: false, description: 'Perform release?')
        string(name: 'RELEASE_VERSION', defaultValue: '', description: 'Release version')
        string(name: 'NEXT_VERSION', defaultValue: '', description: 'Next version (without SNAPSHOT)')
    }
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/f27/qa-jenkins-pipeline'
            }
        }
    }
    stages {
        stage('Test') {
            steps {
                  withGradle {
                    sh 'gradle --version'
                  }
            }
        }
    }
    stages {
        stage('Allure report') {
            steps {
                allure includeProperties: false, jdk: '', results: [[path: 'build/allure-results']]
            }
        }
    }
    post {
        always {
            deleteDir()
        }
    }
}