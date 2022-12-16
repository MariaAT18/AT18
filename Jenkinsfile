pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh './gradlew assemble'
            }
        }

        stage('Test') {
            steps {
                sh './gradlew test'
            }
            post {
                always {
                    junit 'build/test-results/test/**/*.xml'
                    archiveArtifacts 'build/reports/test/**/*'
                }
            }
        }
        stage('SonarQube') {
            steps {
                withSonarQubeEnv('sonar-jenkins') {
                    sh './gradlew sonarqube'
                }
            }
        }
        stage("Quality Gate") {
            steps {
              timeout(time: 2, unit: 'MINUTES') {
                waitForQualityGate abortPipeline: true
              }
            }
          }

        stage('Publish') {
            steps {
                sh './gradlew publish'
            }
        }
    }
}