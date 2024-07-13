# BooksApplication
This repository contains the source code and configuration files for the application. The application is built with Spring Boot and packaged with Docker, with orchestration handled by Kubernetes.

### Table of Contents
1. [Project Description](#project-description)
2. [Prerequisites](#prerequisites)
3. [Local Development](#local-development) 
4. [Continuous Integration](#continuous-integration)
5. [Kubernetes Deployment](#kubernetes-deployment)
6.  [Technologies Used](#technologies-used)
   
## Project Description
This application functions as an online library and offers features like book management, creating copies of books and managing reviews for the same books. The application enables CRUD oprations on books which return server-rendered views. Additionally, it also enables actions to manage reviews for a particular book. It includes Docker setup, CI pipeline using GitHub Actions, and Kubernetes configuration for deployment. This project is made for the DevOps (KIII) course at FCSE. 

## Prerequisites
- Docker and Docker Compose
- Kubernetes cluster 
- kubectl 
- GitHub Account 

## Local Development

1. **Building and Running with Docker Compose**
   Docker Compose to build and run the application and the database locally:

   ```bash
   docker-compose up --build
This command will start both the application and the database containers. The application will be available at http://localhost:9090.

2. **Environment Variables**
The application uses the following environment variables for database connections, which are specified in the Docker Compose file:
  - `SPRING_DATASOURCE_URL`
  - `SPRING_DATASOURCE_USERNAME`
  - `SPRING_DATASOURCE_PASSWORD`

## Continuous Integration
1. **GitHub Actions**
The GitHub Actions workflow is set up to automatically build the Docker image and push it to Docker Hub upon any commits to the master branch. The following GitHub Secrets are configured:
- `DOCKER_USERNAME: Docker Hub username`
- `DOCKER_PASSWORD: Docker Hub password`

## Kubernetes Deployment

  **Kubernetes** To deploy the application:

```bash
k3d cluster create bookstore-cluster -p '9090:9090@loadbalancer' --agents 2
kubectl apply -f kubernetes/
```
**Accessing the Application**
Once deployed, the application is accessible via the Kubernetes ingress at the /books path.

## Technologies Used
- **Spring Boot Application**
- **PostgreSQL Database** 
- **Docker**
- **Kubernetes** 
- **GitHub Actions** 


