require mesa-common.inc
require mesa-git.inc
require mesa-dri.inc

# this needs to be lower than -1 because all mesa-dri have -1 and git version has highest PV, but shouldn't be default
DEFAULT_PREFERENCE = "-2"

PR = "${INC_PR}.0"
