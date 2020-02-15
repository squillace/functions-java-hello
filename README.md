# Azure Functions Java Bundle Sample

## Pre-requisites
* Docker
* Porter

## Deploying the bundle

```bash
# Clone the repo
git clone https://github.com/jeffhollan/azure-functions-porter
# Generate credentials
porter credentials generate AzFunctionEnvironment --file .porter/infra/porter.yaml
# Install the infra
porter install -f .porter/infra/porter.yaml --param-file ./params.txt -c AzFunctionEnvironment
# Install the app
```

## Building the bundle

Before building you'll need to install the helm3 mixing:

```bash
porter mixins install helm3 --url https://github.com/squillace/porter-helm3/releases/download --version  v0.1.helm3-beta4
```