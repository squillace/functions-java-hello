#!/bin/bash

HOST=$1
IMAGE_NAME=$2

cat deploy.yaml |
sed "s|<<<host>>>|$HOST|g" |
sed "s|<<<image_name>>>|$IMAGE_NAME|g" \
> generated-deploy.yaml