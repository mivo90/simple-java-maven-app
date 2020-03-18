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
		stage('SonarQube analysis') {
			steps{
				def scannerHome = tool 'SonarScanner 4.0';
				withSonarQubeEnv('SonarQube') {
                    // Optionally use a Maven environment you've configured already
                    sh "${scannerHome}/bin/sonar-scanner"
				}
			}
		}
    }
}