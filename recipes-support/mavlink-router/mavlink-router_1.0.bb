DESCRIPTION = "Route Mavlink packets between endpoints"
DEPENDS = "python python-future"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=93888867ace35ffec2c845ea90b2e16b"

SRCREV = "a4fbeb5008ccb36c8aee2616deedc39f70e93efc"
SRC_URI = "gitsm://git@github.com/intel/mavlink-router.git;protocol=https"
SRC_URI += "file://mavlink-routerd.sh"
SRC_URI += "file://main.conf"
SRC_URI += "file://0001-Set-rx-trigger-on-ttyS1.patch"

S = "${WORKDIR}/git"
PR = "r1"

inherit autotools pythonnative pkgconfig systemd

PACKAGECONFIG ??= "${@bb.utils.filter('DISTRO_FEATURES', 'systemd', d)}"
PACKAGECONFIG[systemd] = "--enable-systemd --with-systemdsystemunitdir=${systemd_unitdir}/system/,--disable-systemd"

do_compile:prepend () {
    export PYTHONPATH="${PKG_CONFIG_SYSROOT_DIR}/usr/lib/python2.7/site-packages/"
}

do_install:append () {
    install -D -m 0755 ${WORKDIR}/mavlink-routerd.sh ${D}${sysconfdir}/init.d/mavlink-routerd.sh

    install -d ${D}${sysconfdir}/mavlink-router/config.d
    install -m 0644 ${WORKDIR}/main.conf ${D}${sysconfdir}/mavlink-router/main.conf

    install -d ${D}/var/lib/mavlink-router/
}

# we don't want to remove init script to retain backward compatibility since this is
# called from external scripts
python rm_sysvinit_initddir (){
}

SYSTEMD_SERVICE:${PN} = "mavlink-router.service"
