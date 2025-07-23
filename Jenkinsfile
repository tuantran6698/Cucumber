pipeline {
  agent any
  stages {
    stage('Test') {
          steps {
            echo 'Running from Jenkins file'
            bat(script: 'mvn clean test', label: 'maven')
          }
    }
  }
      post {
         success {
          discordSend(
            description: 'Test run completed successfully!',
            webhookURL: 'https://discordapp.com/api/webhooks/1397652462956969984/LllxBfE0VaO6Ecb7l_ks565UJ79f9ZazfD8bpKUkFcD2IhSoIdFvucgWroF8AgxDx7O8',
            color: 'GREEN'
          )
        }
        failure {
          discordSend(
            description: 'Test run failed!',
            webhookURL: 'https://discordapp.com/api/webhooks/1397652462956969984/LllxBfE0VaO6Ecb7l_ks565UJ79f9ZazfD8bpKUkFcD2IhSoIdFvucgWroF8AgxDx7O8',
            color: 'RED'
          )
        }
      }
  }
