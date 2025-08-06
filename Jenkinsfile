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
            webhookURL: 'https://discord.com/api/webhooks/1402766368671006830/7T6gYZqw2Y0VLBAaUwR7iVfyc2bWjREybWujapooFCXyaueApBpHXH1QSVcfqXO8Y5MJ',
            successful: true
          )
        }
        failure {
          discordSend(
            description: 'Test run failed!',
            webhookURL: 'https://discord.com/api/webhooks/1402766368671006830/7T6gYZqw2Y0VLBAaUwR7iVfyc2bWjREybWujapooFCXyaueApBpHXH1QSVcfqXO8Y5MJ',
            successful: false
          )
        }
      }
  }
