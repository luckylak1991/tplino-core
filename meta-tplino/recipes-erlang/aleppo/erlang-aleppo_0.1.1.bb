DESCRIPTION = "Aleppo: ALternative Erlang Pre-ProcessOr"
SECTION = "devel"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://Emakefile;md5=df5da8c3142fc783e2ddc3695068f02e"

SRCREV = "ba218778f1d10480466319c7d8729314a99de5e0"
PR = "r1"

SRC_URI = "git://github.com/ChicagoBoss/aleppo;protocol=ssh"

S = "${WORKDIR}/git"

inherit tetrapak

python () {
    erlang_def_package("aleppo", "aleppo*", "ebin priv", "Emakefile src include tetrapak", d)
}
