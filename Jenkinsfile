pipeline {
environment
{
registry = "mohannadk5/devopsproject" 
registryCredential = 'dockerHub' 
dockerImage = ''
}
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
        stage('Unit Test') {
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
        stage('Nexus') {
            steps {
                bat """mvn deploy"""
            }
            }
            stage('Building our image') {
steps { 
    script { 
        dockerImage= docker.build registry + ":$BUILD_NUMBER" 
    } 
    
}
}
stage('Deploy our image') {
steps { script { docker.withRegistry( '', registryCredential) { dockerImage.push() } } }
}
stage('Cleaning up') {
steps { bat "docker rmi $registry:$BUILD_NUMBER" }
}
        stage('email') {
    steps {
        mail bcc: '', body: 'Your build was done successfully and the image is on docker', cc: '', from: '', replyTo: '', subject: 'The build is done successfully', to: 'mohannad.khadhraoui@esprit.tn'
    }
}
        
    }
}
