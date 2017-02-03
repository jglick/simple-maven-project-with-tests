node {
    stage 'checkout'
        checkout scm
    
    stage 'build'
        def mvnHome = tool 'M3'
        bat "${mvnHome}\\bin\\mvn -B verify"
}
