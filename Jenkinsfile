#!/usr/bin/env groovy
pipeline {
    agent any


    environment {
        SERVER = 'http://10.150.7.2:4444'
        BROWSER = 'firefox'
        HEADLESS_VALUE = 'false'



    }
    stages {
        
         stage('build') {
            steps {
               withGradle {
                sh 'chmod +x ./gradlew'
                sh './gradlew sonarqube'
             }
                
            }
        
         }
        
        /*
        stage('Test') {
            steps {
               withGradle {
                sh 'chmod +x ./gradlew'
                sh './gradlew test -Premote_server=${SERVER} -Pbrowser=firefox -Pheadless=${HEADLESS_VALUE}'
                sh './gradlew test -Premote_server=${SERVER} -Pbrowser=chrome -Pheadless=${HEADLESS_VALUE}'
                sh './gradlew test -Premote_server=${SERVER} -Pbrowser=opera -Pheadless=${HEADLESS_VALUE}'
             }
                
            }

        }*/
        
    }


}

