podTemplate(containers: [containerTemplate(name: 'maven', image: 'maven', command: 'sleep', args: 'infinity')]) {
  node(POD_LABEL) {
  echo ('hello')
    checkout scm
    container('maven-1') {
      sh 'mvn -B -ntp -Dmaven.test.failure.ignore verify'
    }
    junit '**/target/surefire-reports/TEST-*.xml'
  }
} 

