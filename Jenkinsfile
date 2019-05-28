pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        powershell 'mvn clean install'
      }
    }
    stage('Test') {
      steps {
        powershell 'mvn build "-Dsurefire.suiteXmlFiles=src/main/resources/Suite.xml"'
      }
    }
  }
}