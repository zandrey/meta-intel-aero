SUMMARY = "AirMap tools"
LICENSE = "MIT"

inherit packagegroup

PR = "r0"

RDEPENDS_${PN} = "\
		python-cryptography \
		airmap \
		python-paho-mqtt \
		"
