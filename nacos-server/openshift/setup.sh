#!/bin/bash

my_dir="$(cd "$(dirname "$0")" >/dev/null 2>&1 ; pwd -P)"

oc apply -f ${my_dir}/mysql.yaml
oc apply -f ${my_dir}/nacos.yaml
