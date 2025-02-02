inherit systemd

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
SRC_URI += "file://rngd.service"

do_install:append() {
        install -d "${D}${sysconfdir}/systemd/system"
        install -m 0644 ${WORKDIR}/rngd.service ${D}${sysconfdir}/systemd/system/rngd.service
}

SYSTEMD_SERVICE:${PN} = "rngd.service"
