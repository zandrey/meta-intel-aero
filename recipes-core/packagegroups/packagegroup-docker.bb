SUMMARY = "Docker related packages"
DESCRIPTION = "This packagegroup lists dependencies and packages needed \
		for docker related functionality"
LICENSE = "MIT"

inherit packagegroup

PR = "r0"

RDEPENDS:${PN} = "docker"
RDEPENDS:${PN} += "docker-contrib"
