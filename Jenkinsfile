pipeline {
  agent any

  stages {
    stage('Test') {
      parallel {
        stage('Maven') {
          steps {
            echo 'Running from Jenkins file'
            sh(script: 'mvn compile', label: 'maven')
          }
        }

        stage('Cucumber') {
          steps {
            cucumber '**/*.json'
          }
        }
      }
      post {
        success {
          sh '''
          curl -X POST "https://api.telegram.org/bot8001450512:AAH70LpPeuFNjfJ2TpJrXHh9TTexfV82KIg/sendMessage" \
              -H "Content-Type: application/json" \
              -d '{"chat_id": "2020319127", "text": "[SUCCESS] Test run successful!", "disable_notification": false}'
          '''
        }
        failure {
          sh '''
          curl -X POST "https://api.telegram.org/bot8001450512:AAH70LpPeuFNjfJ2TpJrXHh9TTexfV82KIg/sendMessage" \
              -H "Content-Type: application/json" \
              -d '{"chat_id": "2020319127", "text": "[FAILED] Test run failed!", "disable_notification": false}'
          '''
        }
      }
    }
  }
}