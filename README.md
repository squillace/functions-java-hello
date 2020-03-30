# Azure Functions using Java template repository

[Clone](https://help.github.com/en/github/creating-cloning-and-archiving-repositories/creating-a-repository-from-a-template) this repository to start building Azure Functions in Java. 

## Using the CNAB bundle directly

You can deploy the bundle directly by creating the credentials needed to pass to the bundle and then installing the bundle. 

1. To view the bundle's parameter and credential requirements, you can type `porter explain --tag squillace/functions-java-hello:v0.5.2` 
2. To generate your local copy of credentials needed to install the bundle, type `porter creds generate functions --tag squillace/functions-java-hello:v0.5.2`
3. To install the bundle, type `porter install -c functions --tag squillace/functions-java-hello:v0.5.2 --param resource_group=java-functions --param function_name=mytestfunction`

To see the output of the `install` action, type `porter show azure-functions-java-hello`; the function's URL will be displayed along with the deployment log.

### Testing the function

This bundle has a custom CNAB action called `functions.java.hello.test`. To use the custom action, type `porter invoke azure-functions-java-hello --action functions.java.hello.test --param test_url=$(porter show azure-functions-java-hello -o json | jq -r '.outputs.HOSTNAME') -c functions`. (This assumes that you have `jq` installed; you might need to install it, or use another mechanism to capture and reuse the function's URL.)

## Development Environments

You can begin using this bundle without cloning it locally by using the VS Online button, which will launch a VS Code online workspace and load up all the extensions and requirements to build and run the application and then build the [CNAB](https://cnab.io) bundle using [Porter](https://porter.sh).

Alternatively, you can do this all yourself by cloning it to your organization, and then cloning locally and installing dependencies.



### VS Code Online

### Local 


