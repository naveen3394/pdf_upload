/*pipeline {
    agent any 
tools{
maven "Maven 3.6.3"} 
    stages {
        stage ('Build') {
            steps {
               sh "mvn --version"
		sh "mvn clean install"
             }
           }
         }
      }
*/
pipeline {
    agent any
	tools{
maven "Maven 3.6.3"} 
    stages {
        stage ('git checkout') {
            steps {
               git credentialsId: 'github',url: 'https://github.com/naveen3394/pdf_upload.git'
            }
        }
         stage ('Build') {
            steps {
              sh "mvn --version"
              sh "mvn clean install"
            }
        }
        stage ('run') {
            steps {
            
               sshagent(['tomcat']) {
   sh 'scp -o StrictHostKeyChecking=no target/*.jar ec2-user@172.31.43.186:/apache-tomcat-8.5.35/webapps/ '
}
                 
               //  sh ' java -jar target/*.jar'
        
            }
        }
        }
    }
