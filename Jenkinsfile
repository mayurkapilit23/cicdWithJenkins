pipeline {
    agent any

    environment {
        IMAGE = "mayurpawar17/cicdWithJenkins:latest"
    }

    stages {

        stage('Checkout') {
            steps {
                git 'https://github.com/mayurkapilit23/cicdWithJenkins.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t $IMAGE .'
            }
        }

        stage('Docker Push') {
            steps {
                sh 'docker push $IMAGE'
            }
        }

        stage('Deploy') {
            steps {
                sh '''
                ssh ec2-user@13.127.92.178 << EOF
                docker pull mayurpawar17/cicdWithJenkins:latest
                docker stop demo || true
                docker rm demo || true
                docker run -d -p 8080:8080 --name cicdWithJenkins mayurpawar17/cicdWithJenkins:latest
                EOF
                '''
            }
        }
    }
}