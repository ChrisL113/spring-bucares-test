pipeline {
    agent any 
    stages{
        stages("test"){
            steps{
                echo "this is where sonarqube should go"
            }
        }
        stages("deploy"){
            steps {
                sh 'docker login -u admin -p strongpassword localhost:8083'
                sh 'docker push localhost:8083/bucarestest}'
                sh 'docker rmi $(docker images --filter=reference="localhost:8084/bucarestest*" -q)'
                sh 'docker logout loalchost:8083'
            }
        }
    }
}