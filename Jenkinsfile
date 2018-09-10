pipeline {
    agent any
    tools {
        maven 'Maven 3.5.4'
        jdk 'jdk'
    }

    stages {
        stage('Compute build switches') {
            steps {
                echo "computing"
            }
        }

        stage('Build') {
            steps {
                echo 'build'
            }
        }

        stage('ATH') {
            parallel {
                stage('CJOC ATH') {
                    steps {
                        echo 'cjoc'
                    }
                }

                stage ('Master ATH') {
                    steps {
                        echo 'master'
                    }
                }

            }
        }

        stage('Second ATH') {
            steps {
                script {
                    def splits = splitTests parallelism: [$class: 'CountDrivenParallelism', size: 4], generateInclusions: true, estimateTestsFromFiles: true
                    def testGroups = [:]
                    for (int i = 0; i < splits.size(); i++) {
                        def split = splits[i]
                        def ii = i
                        testGroups["split-${i}"] = {
                            node {
                                scm checkout

                                def mavenInstall = 'test -Dmaven.test.failure.ignore=true'

                                /* Write includesFile or excludesFile for tests.  Split record provided by splitTests. */
                                /* Tell Maven to read the appropriate file. */
                                if (split.includes) {
                                  sh "echo includes"
                                  echo split.list.join("\n")
                                  writeFile file: "target/parallel-test-includes-${ii}.txt", text: split.list.join("\n")
                                  mavenInstall += " -Dsurefire.includesFile=target/parallel-test-includes-${ii}.txt"
                                } else {
                                  sh "echo excludes"
                                  echo split.list.join("\n")
                                  writeFile file: "target/parallel-test-excludes-${ii}.txt", text: split.list.join("\n")
                                  mavenInstall += " -Dsurefire.excludesFile=target/parallel-test-excludes-${ii}.txt"
                                }

                                /* Call the Maven build with tests. */
                                sh "mvn ${mavenInstall}"

                                junit '**/target/surefire-reports/TEST-*.xml'
                            }
                        }
                    }

                    parallel testGroups
                }
            }

        }
    }
}