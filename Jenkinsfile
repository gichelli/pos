pipeline {
    agent none
    stages {
        stage('Build') {
            agent {
                docker { image 'maven:3-alpine' }
            }
            steps {
                sh 'mvn --version'
                sh 'mvn -B -DskipTests clean package' 
                sh 'pwd'
                sh 'mvn spring-boot:run'
            }
        }
        stage('mysql') {
            agent {
                docker { image 'mysql:5.7'
                args '--name mydatabase -e MYSQL_ROOT_PASSWORD=password -d'
                 }
            }
            steps {
                sh 'pwd'
                
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