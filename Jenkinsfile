pipeline {
    agent any
    
    environment {
        // Store credentials securely (recommended approach)
        TELEGRAM_BOT_TOKEN = '8001450512:AAH70LpPeuFNjfJ2TpJrXHh9TTexfV82KIg'
        TELEGRAM_CHAT_ID = '2020319127'
    }
    
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
                always {
                    script {
                        sendTelegramNotification()
                    }
                }
                success {
                    echo 'Test stage completed successfully'
                }
                failure {
                    echo 'Test stage failed'
                }
            }
        }
    }
    
    post {
        always {
            script {
                sendFinalTelegramNotification()
            }
        }
    }
}

// Function to send notifications during test stage
def sendTelegramNotification() {
    def stageStatus = currentBuild.currentResult ?: 'SUCCESS'
    def buildNumber = env.BUILD_NUMBER
    def jobName = env.JOB_NAME
    def buildUrl = env.BUILD_URL
    
    def statusEmoji = stageStatus == 'SUCCESS' ? '✅' : '❌'
    def message = "[${statusEmoji}] Test Stage ${stageStatus}\\n\\nBuild: #${buildNumber}\\nJob: ${jobName}\\nURL: ${buildUrl}"
    
    try {
        def response = sh(
            script: """
                curl -s -w "HTTPSTATUS:%{http_code}" -X POST \\
                "https://api.telegram.org/bot${TELEGRAM_BOT_TOKEN}/sendMessage" \\
                -H "Content-Type: application/json" \\
                -d '{"chat_id": "${TELEGRAM_CHAT_ID}", "text": "${message}", "disable_notification": false}'
            """,
            returnStdout: true
        ).trim()
        
        def httpStatus = response.tokenize("HTTPSTATUS:")[1]
        def responseBody = response.tokenize("HTTPSTATUS:")[0]
        
        echo "Telegram API Response: ${responseBody}"
        echo "HTTP Status: ${httpStatus}"
        
        if (httpStatus != "200") {
            error "Failed to send Telegram notification. HTTP Status: ${httpStatus}"
        } else {
            echo "Telegram notification sent successfully!"
        }
        
    } catch (Exception e) {
        echo "Error sending Telegram notification: ${e.getMessage()}"
        echo "Attempting fallback notification method..."
        
        // Fallback method with simpler curl command
        sh """
            curl -X POST "https://api.telegram.org/bot${TELEGRAM_BOT_TOKEN}/sendMessage" \\
                -d "chat_id=${TELEGRAM_CHAT_ID}" \\
                -d "text=Test Stage ${stageStatus} - Build #${buildNumber}" \\
                -d "disable_notification=false"
        """
    }
}

// Function to send final build notification
def sendFinalTelegramNotification() {
    def buildStatus = currentBuild.currentResult
    def buildNumber = env.BUILD_NUMBER
    def jobName = env.JOB_NAME
    def buildUrl = env.BUILD_URL
    def buildDuration = currentBuild.durationString.replace(' and counting', '')
    
    def statusEmoji = ""
    switch(buildStatus) {
        case 'SUCCESS':
            statusEmoji = "✅"
            break
        case 'FAILURE':
            statusEmoji = "❌"
            break
        case 'UNSTABLE':
            statusEmoji = "⚠️"
            break
        default:
            statusEmoji = "ℹ️"
    }
    
    def message = """${statusEmoji} Jenkins Build ${buildStatus}

🏗️ Build: #${buildNumber}
📋 Job: ${jobName}
⏱️ Duration: ${buildDuration}
🔗 View: ${buildUrl}"""
    
    try {
        sh """
            curl -X POST "https://api.telegram.org/bot${TELEGRAM_BOT_TOKEN}/sendMessage" \\
                -H "Content-Type: application/json" \\
                -d '{
                    "chat_id": "${TELEGRAM_CHAT_ID}",
                    "text": "${message.replace('\n', '\\n').replace('"', '\\"')}",
                    "disable_notification": false
                }'
        """
        echo "Final Telegram notification sent successfully!"
    } catch (Exception e) {
        echo "Failed to send final Telegram notification: ${e.getMessage()}"
    }
}

// Alternative simple notification function (backup)
def sendSimpleTelegramMessage(String message) {
    sh """
        curl -s -X POST "https://api.telegram.org/bot${TELEGRAM_BOT_TOKEN}/sendMessage" \\
            -d "chat_id=${TELEGRAM_CHAT_ID}" \\
            -d "text=${message}" \\
            -d "disable_notification=false"
    """
}