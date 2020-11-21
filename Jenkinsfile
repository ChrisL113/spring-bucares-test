pipeline {
    agent any
    stages{
        stage ("build"){
            steps{
                echo 'building the application...'
                sh scripts 'mvn clean package'
            }
        }

        stage ("test"){
            steps{

                echo 'testing the application...'
            }
        }

        stage('upload war to nexus'){
            steps{
                nexusArtifactUploader artifacts: [
                    [
                        artifactId: 'bucarestest',
                        classifier: '',
                        file: 'target/bucarestest.jar', 
                        type: 'jar'
                    ]
                ], 
                credentialsId: 'kristo_nexus', 
                groupId: 'com.example', 
                nexusUrl: 'btc02.dev.lab.plugbox.io:8081/', 
                nexusVersion: 'nexus3', 
                protocol: 'http', 
                repository: 'http://btc02.dev.lab.plugbox.io:8081/repository/index_sys/', 
                version: '0.0.2-SNAPSHOT'
            }
        }

        stage ("deploy"){
            steps{
                echo 'deploying the application...'
            }
        }
    }
}