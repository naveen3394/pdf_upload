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
 		 // sh 'scp -o StrictHostKeyChecking=no target/*.jar ubuntu@13.233.155.207:~/'
		                sh 'scp -v -o StrictHostKeyChecking=no  -i /home/sunbeam/Downloads/gmk_key_pair.pem target/*.jar ubuntu@35.154.183.171:/home/ubuntu'
                              //   sh "sshpass -p password ssh -o StrictHostKeyChecking=no -i  /home/sunbeam/Downloads/gmk_key_pair.pem ubuntu@35.154.183.171 '/home/ubuntu/start.sh'"
sh "ssh -v -o StrictHostKeyChecking=no  -i /home/sunbeam/Downloads/gmk_key_pair.pem ubuntu@35.154.183.171 './start.sh'"
		       //        sh 'ssh -o StrictHostKeyChecking=no -l cloudbees 192.168.1.106 uname -a'

		}
                 
               //  sh ' java -jar target/*.jar'/
        
            }
        }
        }
    }
