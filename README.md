Simple TestCase for Docker
==========================

* [Install Docker](https://docs.docker.com/installation/)
* Run Docker in daemon mode
 * Linux: ```bash 
  sudo docker -H 0.0.0.0:5555 -d &``` 
where `5555` is arbitrary tcp port
 * Windows: Docker is already started in boot2docker vm, all you need is to set environment variables:
  `DOCKER_CERT_PATH={USER_HOME}\.boot2docker\certs\boot2docker-vm`
  `DOCKER_TLS_VERIFY=1`

* Create envirement variables `DOCKER_HOST` (example: `tcp://localhost:5555`)
