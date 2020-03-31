pipeline {
    agent any
    stages {
	    stage('Test') {
	        steps {
	            bat 'mvn -B clean verify'
	        }
	    }
    }
    post {
        always {
            junit 'build/reports/**/*.xml'
        }
    }
//         stage('Build') {
//             steps {
//                 bat 'mvn -B clean verify package'
//             }
//             post {
//                 success {
//                     echo 'Now Archiving...'
//                     archiveArtifacts artifacts: 'target/*.war'
//                 }
//             }
//         }
		
// 		stage('Deploy to Staging'){
// 			steps {
// 				build job: 'Deploy-to-staging'
// 			}
// 		}
//
// 		stage ('Deploy to Production'){
//             steps{
//                 timeout(time:5, unit:'DAYS'){
//                     input message:'Approve PRODUCTION Deployment?'
//                 }
//
//                 build job: 'Deploy-to-Prod'
//             }
//
//             post {
//                 success {
//                     echo 'Code deployed to Production.'
//                 }
//
//                 failure {
//                     echo ' Deployment failed.'
//                 }
//             }
//         }
		
}
