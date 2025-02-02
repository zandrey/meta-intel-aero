SUMMARY = "Development and verification tools"
LICENSE = "MIT"

inherit packagegroup

PR = "r0"

RDEPENDS:${PN} = "\
		python-pip \
		i2c-tools \
		devmem2 \
		screen \
		lsof \
		strace \
		tar \
		procps \
		"
