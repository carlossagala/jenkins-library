#!groovy
@Library('saga93-library@master')_

def anything = 'nothing';

pipeline {
    agent none 
    stages {
        stage("1"){
            steps{
                script{
                   functions.ExecPipe 1;
                }
            }
        }
        stage("2"){
            steps{
                script{
                   functions.ExecPipe 2;
                }
            }
        }
        stage("3"){
            steps{
                script{
                   functions.ExecPipe 3;
                }
            }
        }
        stage("SUCCESS"){
            steps{
                script{
                  echo("######SUCCESS#######")
                }
            }
        }
        
    }
}


