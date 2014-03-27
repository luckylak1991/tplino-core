DESCRIPTION = "Chicago Boss web framework"
SECTION = "devel"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9445ab65d571cee0b2d6e3b4e35953cc"

SRCREV="f5a2576f72293e8ab06c621f641f08b7d232a29f"
PR = "r2"

SRC_URI = "git://github.com/ChicagoBoss/ChicagoBoss.git;protocol=ssh"

S = "${WORKDIR}/git"

inherit tetrapak

DEPENDS = "erlang-boss-db erlang-tinymq erlang-tiny-pq erlang-erlydtl erlang-jaderl erlang-dynamic-compile erlang-gen-smtp erlang-misultin erlang-mochiweb erlang-mimetypes erlang-pmod-transform erlang-poolboy erlang-cowboy erlang-simple-bridge"
RDEPENDS_${PN} = "erlang-boss-db erlang-tinymq erlang-tiny-pq erlang-erlydtl erlang-jaderl erlang-dynamic-compile erlang-gen-smtp erlang-misultin erlang-mochiweb erlang-mimetypes erlang-pmod-transform erlang-poolboy erlang-cowboy erlang-simple-bridge"

python () {
    erlang_def_package("boss", "boss*", "ebin priv", "LICENSE windows-make.bat skel.template src include doc-src skel", d)
}
