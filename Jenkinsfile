pipeline {
    agent any
    stages {
        stage('Checkout GIT') {
            steps {
                // Get some code from a GitHub repository
                echo 'pulling ...';
                    git branch: 'Achraf',
                    url : 'https://github.com/Mehdi-ach/DevopsProject.git';
            }
        }
        stage('Test') {
            steps {
                bat """mvn test"""
            }
        }
        stage('Sonar') {
            steps {
                bat """mvn sonar:sonar"""
            }
        }
        stage('Livrable') {
            steps {
                bat """mvn clean package"""
            }
        }
        stage('Deploy') {
            steps {
                bat """mvn deploy"""
            }
        }
    }
}
