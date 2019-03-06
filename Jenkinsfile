println "Hello"

node {
   stage('Checkout'){

          checkout scm
       }
    
    stage("maven"){
        def maven = tool name: 'mvn-354', type: 'maven'
        sh "pwd"
        sh "echo ${PATH}"
        sh "${maven}/bin/mvn -B -DskipTests clean package"
    }
}
