#!/bin/env bash



FILE="Smlouva.json"
# FILE="smlouvy/vodochody_aerospace_1310465.json"

PACKAGE="com.example.smlouvy.dto"
SUFFIX="Smlouva"

jsonschema2pojo-0.4.37/bin/jsonschema2pojo -s ${FILE} -t generated -a JACKSON2 -T JSON -N -D -E -c3 -p ${PACKAGE} 