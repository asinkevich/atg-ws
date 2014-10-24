Simple TestCase for Docker
==========================

* [Install Docker](https://docs.docker.com/installation/)
* Pull Docker's RabbitMQ image with command ```sudo docker pull mikaelhg/docker-rabbitmq```
* Run Docker in detach mode: ```sudo <path to>/docker -H 0.0.0.0:5555 -d &``` where 5555 is arbitrary tcp port
* Create envirement variables `DOCKER_HOST` (example: `tcp://localhost:5555`)
