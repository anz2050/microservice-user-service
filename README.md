This is sample Service Registry sample project.

You can deploy this project on Cloud Foundry.

Pre-requisites: Service Registry instance should be created on Cloud Foundry, first. Then update the application.services name as followed:

applications: 
   - name: user-service 
     services: 
       - <your service registry name>
