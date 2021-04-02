#!/bin/bash

my_dir="$(cd "$(dirname "$0")" >/dev/null 2>&1 ; pwd -P)"

java -Dserver.port=8858 \
     -Dcsp.sentinel.api.port=8719 \
     -Dcsp.sentinel.dashboard.server=127.0.0.1:12345 \
     -Dproject.name=sentinel-dashboard \
     -jar ${my_dir}/sentinel-dashboard-1.8.1.jar
