pipeline {
    agent any

    stages {
        
        stage('Build') {
            steps {
                withGradle {
                    sh 'chmod +x ./gradlew'
                    sh './gradlew assemble'
                }
            }
        }
        
        
        
        stage('Test') {
            steps {
                withGradle {
                    sh './gradlew clean check'
                }
            }
  
            post {
                 always {
                    recordIssues enabledForFailure: true, tool: spotBugs(pattern: 'build/reports/spotbugs/*.xml')
                 }
            }

        }
        
    }
}

