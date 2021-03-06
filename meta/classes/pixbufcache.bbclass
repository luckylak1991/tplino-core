#
# This class will generate the proper postinst/postrm scriptlets for pixbuf
# packages.
#

DEPENDS += "qemu-native"
inherit qemu

PIXBUF_PACKAGES ??= "${PN}"

#
# On host, the postinstall MUST return 1 because we do not know if the intercept
# hook will succeed. If it does succeed, than the packages will be marked as
# installed.
#
pixbufcache_common() {
if [ "x$D" != "x" ]; then
	$INTERCEPT_DIR/postinst_intercept update_pixbuf_cache ${PKG} libdir=${libdir} \
		bindir=${bindir} base_libdir=${base_libdir}
	exit 1
fi

# Update the pixbuf loaders in case they haven't been registered yet
GDK_PIXBUF_MODULEDIR=${libdir}/gdk-pixbuf-2.0/2.10.0/loaders gdk-pixbuf-query-loaders --update-cache

if [ -x ${bindir}/gtk-update-icon-cache ] && [ -d ${datadir}/icons ]; then
    for icondir in /usr/share/icons/*; do
        if [ -d ${icondir} ]; then
            gtk-update-icon-cache -t -q ${icondir}
        fi
    done
fi
}

python populate_packages_append() {
    pixbuf_pkgs = d.getVar('PIXBUF_PACKAGES', True).split()

    for pkg in pixbuf_pkgs:
        bb.note("adding pixbuf postinst and postrm scripts to %s" % pkg)
        postinst = d.getVar('pkg_postinst_%s' % pkg, True) or d.getVar('pkg_postinst', True)
        if not postinst:
            postinst = '#!/bin/sh\n'
        postinst += d.getVar('pixbufcache_common', True)
        d.setVar('pkg_postinst_%s' % pkg, postinst)

        postrm = d.getVar('pkg_postrm_%s' % pkg, True) or d.getVar('pkg_postrm', True)
        if not postrm:
            postrm = '#!/bin/sh\n'
        postrm += d.getVar('pixbufcache_common', True)
        d.setVar('pkg_postrm_%s' % pkg, postrm)
}
