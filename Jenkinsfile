pipeline {
  agent any

  tools {
    maven "M3"
  }

  stages {
    stage('Build') {
      steps {
        checkout scm
        sh "mvn  -Dstyle.color=always -Dfaker.count=2 -Dfaker.sleepMin=1 -Dfaker.sleepMax=10 -Dfailure.odd=0.5 -Dskipping.odd=0.2 -Dmaven.test.failure.ignore=true clean package"
        junit '**/target/surefire-reports/TEST-*.xml'
      }
    }
  }
}
