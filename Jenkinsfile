
node ('master') { 
  checkout scm 
  stage('Building') { 
    withMaven(maven: 'M3') { 
      if (isUnix()) { 
        sh 'mvn -Dmaven.test.failure.ignore clean package' 
      }  
      else { 
        bat 'mvn -Dmaven.test.failure.ignore clean package' 
      } 
    } 
  }   
  stage('Results') { 
    junit '**/target/surefire-reports/TEST-*.xml' 
    archive 'target/*.jar' 
  } 
}

