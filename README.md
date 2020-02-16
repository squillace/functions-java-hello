# Azure Functions Java Bundle Sample

## Pre-requisites
* Docker
* Porter

## Building and deploying the bundle

```bash
# Clone the repo
git clone https://github.com/jeffhollan/azure-functions-porter

# Platform:
# Navigate to platform bundle
cd .porter/platform
# Generate credentials
porter credentials generate AzFunctionEnvironment
# Build the bundle
porter build
# Install the infra
porter install --param-file ../../params.txt -c AzFunctionEnvironment

# App:
# Navigate to app bundle
cd ../app
# Build the bundle
porter build
# Install the infra
porter install --param-file ../../params.txt -c AzFunctionEnvironment
```

## Building the bundle

Before building you'll need to install the helm3 mixing:

```bash
porter mixins install helm3 --url https://github.com/squillace/porter-helm3/releases/download --version  v0.1.helm3-beta4
```