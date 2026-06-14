def call(String id, String image){
  withCredentials([usernamePassword(
                    credentialsId: "$id",
                    usernameVariable: "user",
                    passwordVariable: "pass"
                    
                    )]) {
                        sh " docker login -u ${env.user} -p ${env.pass}"
                        sh " docker image tag $image ${env.user}/$image"
                        sh "docker push ${env.user}/$image"
                    }
}
