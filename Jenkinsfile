#!/usr/bin/env groovy

pipeline {
    agent none
    stages {
        stage('Build') {
            agent {
                docker { image 'maven:3-alpine' }
            }
            steps {
                
                sh 'mvn -B -DskipTests clean package' 
            
            }
        }
        stage('mysql') {
            agent {
                docker { image 'mysql:latest'
                args '--name pos -e MYSQL_ROOT_PASSWORD=password -d'

                 }
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