#!/bin/bash -e
# Sets up environment for SOCI/p6psy backend DB2 at travis-ci.org
#
# Copyright (c) 2013 Brian R. Toonen <toonen@alcf.anl.gov>
# Copyright (c) 2013 Mateusz Loskot <mateusz@loskot.net>
#
# Modified by Peter Butkovic <butkovic@gmail.com> for p6spy project
#
# source ${TRAVIS_BUILD_DIR}/bin/ci/common.sh

sudo -u db2inst1 -i db2 "CREATE DATABASE p6spy"
sudo -u db2inst1 -i db2 "ACTIVATE DATABASE p6spy"
