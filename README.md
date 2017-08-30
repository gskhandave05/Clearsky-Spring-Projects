# Clearsky-Spring-Projects

The repository consists of SpringMVC and SpringBoot with Docker containers. These are simple RESTful microservices for weather reports of different cities in Unites States. 

## Directory Structure :

* rest : contains SpringMVC based REST API 

* container : contains SpringBoot version of the same API with Docker configuration

### Launch EC2 instance :
1.  Login to AWS management console and create free tier EC2 instance(Amazon Linux AMI).
2.  Add security group to the instance and allow all inboud traffic (For public access).
3.  Create and attach a static IP address to this instance so that every time you restart the instance, you will get same IP address.

### Install Docker on EC2 instance :
1.  Install recent Docker community edition using 'sudo yum install -y docker'.
2.  Start docker service using 'sudo service docker start'.
3.  Add the ec2-user to the docker group so you can execute Docker commands without using sudo. Use 'sudo usermod -a -G docker ec2-user'.
4.  Log out and log back in again to pick up the new docker group permissions.
5.  Verify that the ec2-user can run Docker commands without sudo. Use 'docker info'.

### Install Jenkins on EC2 instance :
1.  Connect to your EC2 instance from terminal through ssh (Help for connecting to EC2 can be seen on EC2 dashboard).
2.  Get updates using 'sudo yum -y update' on EC2 instance.
3.  Install latest version of Java. Use 'sudo yum install java-1.8.0-openjdk-devel' to install Java 1.8.
4.  Amazon Linux AMI comes with default java version 1.7. Change default java version to 1.8 using 'sudo alternatives --config java'.
5.  Add Jenkins repository to available packages. Use below lines of commands:

> sudo wget -O /etc/yum.repos.d/jenkins.repo http://pkg.jenkins-ci.org/redhat/jenkins.repo 

> sudo rpm --import http://pkg.jenkins-ci.org/redhat/jenkins-ci.org.key

> sudo yum install jenkins

6.  Up the Jenkins service using 'sudo service jenkins start'.

### *Jenkins console will at below location on EC2 instance:*

**Jenkins console URL: http://'your-elastic-ip-address'.compute-1.amazonaws.com:8080**

*Note: Jenkins asks for password if you are accessing it for the first time since installation. The initial password can be found using 'sudo cat /var/lib/jenkins/secrets/initialAdminPassword'*

Now, we will need to configure Jenkins for builds and deployments.

1.  Install suggested plugins in Jenkins. Then install Maven Integration plugin and Cloudbees Docker plugin for Docker integration.
2.  Configure JDK version, Maven and Docker in Jenkins Global tools configuration menu.
3.  Now, create new job and add build steps. Add Git source url and credentials to allow Jenkins to checkout your source code into its workspace.
4.  Add Maven build step and specify maven goals.
5.  Copy generated jar file to deployments folder using build step with execute sh.
6.  Build and run Dockerfile using Docker Integration build step. (Make sure to give port for your micrservice. I gave port 81)
7.  Click on build. Jenkins will checkout source from git, build jar/war using maven and deploy on Docker container.

### Deployed application can be found on :

Swagger URL: *_http://'your-elastic-ip-address'.compute-1.amazonaws.com:8081/api/swagger-ui.html#/_*
