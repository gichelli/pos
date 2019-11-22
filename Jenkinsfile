pipeline {
	agent {
        docker {
            image 'maven:3-alpine' 
            args '-v /root/.m2:/root/.m2' 
        }
        		
    }
    
    
    stages {
        stage('Build') { 
        
            steps {
                sh 'mvn -B -DskipTests clean package' 
                sh 'pwd'
                sh 'cd /var/jenkins_home/workspace/posJenkins'
                sh 'mvn spring-boot:run'
                
                sh 'ls'
                
            }
        }
        
        stage('Test') { 
        

        	
            steps {
                sh 'mvn test' 
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml' 
                }
            }
        }
        
    }
    
    
}