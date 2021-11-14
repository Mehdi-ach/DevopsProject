pipeline {
    agent any
    stages {
        stage('Checkout GIT') {
            steps {
                // Get some code from a GitHub repository
                echo 'pulling ...';
                    git branch: 'Mohanned',
                    url : 'https://github.com/Mehdi-ach/DevopsProject.git';
            }
        }
        stage('Build, Test') {
            steps {
                bat """mvn -version"""
            }
        }
    }
}
