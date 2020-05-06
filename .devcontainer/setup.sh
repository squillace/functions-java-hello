#!/bin/bash

sudo apt-get -y install jq maven
curl https://deislabs.blob.core.windows.net/porter/latest/install-linux.sh | bash
export PATH=~/.porter/:$PATH
porter mixins install jq --url https://github.com/squillace/porter-jq/releases/download --version v0.1.0