pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        powershell 'mvn clean install'
        powershell 'dir'
      }
    }
    stage('Test') {
      steps {
        powershell 'mvn test'
      }
    }
  }
}