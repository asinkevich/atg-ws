Simple TestCase for Docker
==========================

## Common setup
1. [Install Docker](https://docs.docker.com/installation/)
2. Set environment variable:
`DOCKER_HOST=tcp://<host>:<port>`

## Linux setup
1. Run Docker in daemon mode:

  `$ sudo docker -H 0.0.0.0:5555 -d &` where `5555` - arbitrary tcp port which

2. Set evnironemnt variable:

  `DOCKER_HOST=tcp://<server_host>:5555` where `server_host` - server which runs Docker

## Windows setup
Set environment variables:

`DOCKER_CERT_PATH={USER_HOME}\.boot2docker\certs\boot2docker-vm`

`DOCKER_TLS_VERIFY=1`

`DOCKER_HOST=tcp://192.168.59.103:2376` (default values used by boot2docker)



* [Install Docker](https://docs.docker.com/installation/)
* Set environment variable `DOCKER_HOST=tcp://<host>:<port>`
* Run Docker in daemon mode
 * Linux: `sudo docker -H 0.0.0.0:5555 -d &` where `5555` is arbitrary tcp port
 * Windows: Docker is already started in boot2docker VM, all you need is to set environment variables:
  `DOCKER_CERT_PATH={USER_HOME}\.boot2docker\certs\boot2docker-vm`
  `DOCKER_TLS_VERIFY=1`

* Create envirement variables `DOCKER_HOST` (example: `tcp://localhost:5555`)
