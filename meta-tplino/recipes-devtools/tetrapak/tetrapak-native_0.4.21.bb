DESCRIPTION = "tetrapak is an extensible build system for Erlang/OTP applications."
SCTION = "devel"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://src/tetrapak.erl;beginline=1;endline=19;md5=300d83493c235b71e1a4d58e25379bc5"
SRCREV="af93d58a25175e13dc6309b3cbe5b1d4340f5787"

PR = "r1"

SRC_URI = "git://github.com/travelping/tetrapak.git;protocol=ssh"

S = "${WORKDIR}/git"

inherit native erlangnative

do_install() {
    install -d -m755 ${D}${libdir}/erlang/lib/tetrapak
    install -d -m755 ${D}${bindir}
    cp -a ${S}/* ${D}${libdir}/erlang/lib/tetrapak
    ln -sf ../lib/erlang/lib/tetrapak/bin/tetrapak ${D}${bindir}/tetrapak
}
