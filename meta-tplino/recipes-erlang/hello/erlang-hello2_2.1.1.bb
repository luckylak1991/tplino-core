DESCRIPTION = "JSON-RPC API toolkit"
SECTION = "devel"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://src/hello2.erl;md5=e6593df4d48d0bffe419732c774a21d0"

SRCREV = "c64295cc036fa0c9c3fe5e8d1279f088f88f0a78"
PR = "r0"

SRC_URI = "git://github.com/travelping/hello2.git;protocol=ssh"

S = "${WORKDIR}/git"

inherit tetrapak

DEPENDS = "erlang-cowboy erlang-yang-native erlang-erlzmq erlang-ex-uri erlang-ibrowse"
RDEPENDS_${PN} = "erlang-cowboy erlang-yang erlang-erlzmq erlang-ex-uri erlang-ibrowse"

python () {
    erlang_def_package("hello2", "hello2-*", "ebin priv", "src include README.md examples NEWS.md", d)
}
