DESCRIPTION = "mimetypes"
SECTION = "devel"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://README.md;md5=f1c71ee46a40b96ff7d635ff987d5c5d"

SRCREV="ce955bc28cc4ebd34c0f3caebd458dc855c6606a"
PR = "r0"

SRC_URI = "git://git@git.tpip.net/mimetypes.git;protocol=ssh"

S = "${WORKDIR}/git"

inherit tetrapak

python () {
    erlang_def_package("mimetypes", "mimetypes*", "ebin priv", "src include test", d)
}

