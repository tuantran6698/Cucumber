pipeline {
  agent any
tools {
    maven 'Maven 3.6.3'
  }
  stages {
    stage('Test') {
      parallel {
        stage('Maven') {
          steps {
            echo 'Running from Jenkins file'
            bat(script: 'mvn compile', label: 'maven')
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
          powershell '''
          Invoke-WebRequest -Uri "https://api.telegram.org/bot8001450512:AAH70LpPeuFNjfJ2TpJrXHh9TTexfV82KIg/sendMessage" `
              -Method POST `
              -Headers @{ "Content-Type" = "application/json" } `
              -Body '{"chat_id": "2020319127", "text": "[SUCCESS] Test run successful!", "disable_notification": false}'
          '''
        }
        failure {
          powershell '''
          Invoke-WebRequest -Uri "https://api.telegram.org/bot8001450512:AAH70LpPeuFNjfJ2TpJrXHh9TTexfV82KIg/sendMessage" `
              -Method POST `
              -Headers @{ "Content-Type" = "application/json" } `
              -Body '{"chat_id": "2020319127", "text": "[FAILED] Test run failed!", "disable_notification": false}'
          '''
        }
      }
    }
  }
}