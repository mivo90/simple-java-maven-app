pipeline {
    environment {
        registry = "kwieto/test"
        registryCredential = 'dockerhub_kwieto'
    }
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
        stage('Building and Push') {
            steps {
                script {
                    docker.withRegistry('', registryCredential) {
                        def dockerImage = docker.build registry + ":$BUILD_NUMBER"
                        dockerImage.push()
                        dockerImage.push('latest')
                    }
                }
            }
        }
        
        stage("Deploy on k8s") {
            steps {
                  withKubeConfig([credentialsId: 'Kubeconfig_file', serverUrl: 'https://atoscicd-dns-9d51d576.hcp.westeurope.azmk8s.io:443']){
                sh 'kubectl apply -f kwieto_deploy.yaml'
                      sh 'kubectl get pods'
                  }
            }
        }
            
                    
        stage('Remove Unused docker image') {
            steps {
                sh "docker rmi $registry:$BUILD_NUMBER"
            }
        }
    }
}
