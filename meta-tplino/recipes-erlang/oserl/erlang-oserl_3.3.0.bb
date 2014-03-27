DESCRIPTION = "oserl"
SECTION = "net"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://src/gen_esme.erl;beginline=1;endline=28;md5=9ce15051e0553845ff2a71e49388ffcb"

SRCREV="229ab3d72c6e73b0e849ad3d601d1e46b302f7df"
PR = "r1"

SRC_URI = "git://github.com/iamaleksey/oserl.git;protocol=ssh"

S = "${WORKDIR}/git"

inherit tetrapak

DEPENDS = "erlang-common-lib"
RDEPENDS_${PN} = "erlang-common-lib"

python () {
    erlang_def_package("oserl", "oserl*", "ebin priv include", "NEWS.md README Makefile .arcconfig .gitignore app.mk src test doc", d)
}
