#!/usr/bin/env groovy

pipeline {
    agent none
    stages {
        stage('Build') {
            agent {
                docker { image 'maven:3-alpine' }
            }
            
        }

        stage('test') {
            agent {
                docker { image 'maven:3-alpine'}
            }
            steps {
                sh 'mvn test'
                
            }
        }
        
    }
}