println "BRANCH 2a"
properties([buildDiscarder(logRotator(artifactDaysToKeepStr: '', artifactNumToKeepStr: '', daysToKeepStr: '10', numToKeepStr: '10'))])
node {
   stage('Checkout'){

          checkout scm
       }
    
    stage("maven"){
        def maven = tool name: 'mvn-354', type: 'maven'
        sh "${maven}/bin/mvn -B -DskipTests clean package"
    }
}
