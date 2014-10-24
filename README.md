docker-rabbitmq-mvn-example
===========================

### Common setup
[Install Docker](https://docs.docker.com/installation/) (for Windows use the latest version of Oracle VM VirtualBox and verify that `git_folder\bin` is included in `Path`).

Note: installation boot2docker on Windows will delete generated ssh keys in home/.ssh folder.

### Linux setup
1. Run Docker in daemon mode:

  `$ sudo docker -H 0.0.0.0:5555 -d &` where `5555` - arbitrary tcp port.

2. Set environment variable:

  `DOCKER_HOST=tcp://<server_host>:5555` where `server_host` - server which runs Docker.

### Windows setup
1. Set environment variables:

  `DOCKER_CERT_PATH={USER_HOME}\.boot2docker\certs\boot2docker-vm`

  `DOCKER_TLS_VERIFY=1`

  `DOCKER_HOST=tcp://192.168.59.103:2376` (default values used by boot2docker).

### Run tests
Run `mvn verify` to run integration tests. Maven-docker plugin will download & install all Docker's dependencies during 1st run.
Note: maven-docker plugin requires at least Java 7.
