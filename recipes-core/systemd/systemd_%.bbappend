FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PACKAGECONFIG:append = " networkd"

SRC_URI += "file://99-usb0.network"

do_install:append() {
    install -D -m 0644 ${WORKDIR}/99-usb0.network ${D}${sysconfdir}/systemd/network/99-usb0.network
    sed -i -e 's/ForwardToSyslog=yes/#ForwardToSyslog=yes/' ${D}${sysconfdir}/systemd/journald.conf
}
