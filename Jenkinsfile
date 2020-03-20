pipeline {
    agent any
	tools {
        maven 'Maven'
        jdk 'jdk8'
    }
    stages {
		stage('Maven') {
            steps {
                 sh 'mvn -Dmaven.test.failure.ignore=true install'
				 sh 'mvn compile'
				 
            }
        }
        stage('Sonarqube') {
            environment {
                    scannerHome = tool 'SonarQube Scanner'
                    
            }
            steps {
                withSonarQubeEnv('Sonarqube Service') {
                    sh "${scannerHome}/bin/sonar-scanner"
                }
                timeout(time: 10, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }
        stage("Quality Gate") {
            steps {
                timeout(time: 1, unit: 'HOURS') {
                    // Parameter indicates whether to set pipeline to UNSTABLE if Quality Gate fails
                    // true = set pipeline to UNSTABLE, false = don't
                    waitForQualityGate abortPipeline: true
                }
            }
        }
    }
}