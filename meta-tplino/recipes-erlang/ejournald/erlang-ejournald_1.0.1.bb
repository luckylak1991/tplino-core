DESCRIPTION = "Erlang journal binding"
SECTION = "devel"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://src/journald_api.erl;beginline=1;endline=19;md5=300d83493c235b71e1a4d58e25379bc5"
SRCREV  = "aae6dc679cae3c55f5cb8a4a02a674d6750642eb"
PR = "r1"
SRC_URI = "git://github.com/travelping/ejournald.git;protocol=ssh" 

S = "${WORKDIR}/git"

DEPENDS = "systemd"

inherit tetrapak

python () {
    erlang_def_package("ejournald", "ejournald-*", "bin ebin priv", "c_src src include TODO.rst README.rst NEWS.md", d)
}
