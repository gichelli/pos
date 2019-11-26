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
                sh 'mvn spring-boot:run'
                
            }
        }
        stage('Test') { 
            agent{
                docker{

   		    image 'mysql:5.7'
		    args '--name mydatabase -e MYSQL_ROOT_PASSWORD=password -e MYSQL_ROOT_HOST=% -e MYSQL_DATABASE=pos -e MYSQL_USER=gichelli -e MYSQL_PASSWORD=password -d'
                }
            }
        
            steps {
                sh 'mvn test'  
            }
            post{
            	always{
            		junit 'target/surefire-reports/*.xml'
            	}
            
            
            }
        }
        
    }
    
    
}