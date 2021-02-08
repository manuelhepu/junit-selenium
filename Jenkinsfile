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
                configFileProvider([configFile(fileId: 'sonar.gradle.properties', targetLocation: 'gradle.properties')]) {
                               sh './gradlew clean sonarqube  -Premote_server=${SERVER} -Pbrowser=firefox -Pheadless=${HEADLESS_VALUE}'
                }
               
             }
                
                withSonarQubeEnv(credentialsId: 'c8c23d90-c1f4-4828-910a-97bfca0f6944') {
                    sh './gradlew clean sonarqube'
                }
                
            }
        
         }
        
        
        stage('Test') {
            steps {
               withGradle {
                sh 'chmod +x ./gradlew'
                sh './gradlew test -Premote_server=${SERVER} -Pbrowser=firefox -Pheadless=${HEADLESS_VALUE}'
                sh './gradlew test -Premote_server=${SERVER} -Pbrowser=chrome -Pheadless=${HEADLESS_VALUE}'
                sh './gradlew test -Premote_server=${SERVER} -Pbrowser=opera -Pheadless=${HEADLESS_VALUE}'
             }
                
            }

        }
        
         
        
        
        
        
    }


}

