pipeline {
    agent any
    
    stages {
        stage('Checkout Source Code') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], userRemoteConfigs: [[url: 'https://github.com/Mathenryx/eng-software-ac2']]])
            }
        }
        
        stage('Build') {
            steps {
                bat "mvn clean package"
            }
        }
        
        stage('Deploy Dev') {
            steps {
                build job: "Dev", wait: true
            }
        }
        
        stage('Deploy Hom') {
            steps {
                build job: "Hom", wait: true
            }
        }
        
        stage('Deploy Prod') {
            steps {
                build job: "Prod", wait: true
            }
        }
        
        stage('Start container') {
            steps {
                bat 'docker compose up -d'
            }
        }
        
    }
    
    post {
        success {
            echo 'Pipeline succeeded! Application deployed to prod.'
        }
        failure {
            echo 'Pipeline failed! Application deployment unsuccessful.'
        }
    }
}
