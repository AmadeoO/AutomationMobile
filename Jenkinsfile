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
        powershell 'mvn test -Dmaven.test.failure.ignore=true -Dsurefire.suiteXmlFiles=src/main/resources/Suite.xml'
      }
    }
  }
}