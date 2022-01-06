# docker-spring-boot

This project is demo project for buiding spring boot app with docker 
and expose 8080 port for access


######  remove taint 
 kubectl taint nodes $(hostname) node-role.kubernetes.io/master:NoSchedule-


 kubeadm init --apiserver-advertise-address $(hostname -i) --pod-network-cidr 10.5.0.0/16

 kubectl apply -f https://raw.githubusercontent.com/cloudnativelabs/kube-router/master/daemonset/kubeadm-kuberouter.yaml

###### Install Helm
 export VERIFY_CHECKSUM=false
 curl https://raw.githubusercontent.com/helm/helm/main/scripts/get-helm-3 | bash

-  kubectl create deployment docker-spring-boot --image=rksharma1401/docker-spring-boot:v2.1 --dry-run -o=yaml > deployment.yaml
-  echo --- >> deployment.yaml
- kubectl create service nodeport docker-spring-boot --tcp=8080:8080 --dry-run=client -o=yaml >> deployment.yaml
- kubectl apply -f deployment.yaml
-  kubectl port-forward [tab] 8080:8080

 curl -v http://localhost:8080/getMessage

######  helm create chart and Deploy
-   helm create docker-spring 
-  -- replace port  with 8080 and service image
-  helm install docker-spring --debug ./docker-spring --set service.type=NodePort
-     export NODE_PORT=$(kubectl get --namespace default -o jsonpath="{.spec.ports[0].nodePort}" services docker-spring)
-   export NODE_IP=$(kubectl get nodes --namespace default -o jsonpath="{.items[0].status.addresses[0].address}")
-   echo http://$NODE_IP:$NODE_PORT
-   curl http://$NODE_IP:$NODE_PORT/getMessage2

