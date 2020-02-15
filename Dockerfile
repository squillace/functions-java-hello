
FROM mcr.microsoft.com/azure-functions/java:3.0

ENV AzureWebJobsScriptRoot=/home/site/wwwroot \
    AzureFunctionsJobHost__Logging__Console__IsEnabled=true

COPY target/azure-functions/java-function /home/site/wwwroot   