##################
### SatDreamGR ###
##################

require ../../../meta-openpli/recipes-openpli/images/openpli-enigma2-image.bb

#PR = "r20180912"
#PR = "r${DATE}"
#PR[vardepsexclude] = "DATE"

ENIGMA2_PLUGINS_remove = "enigma2-plugin-softcams-oscam"

IMAGE_INSTALL_remove = "openpli-bootlogo"
IMAGE_INSTALL_remove = "enigma2-plugin-extensions-ppanel"
IMAGE_INSTALL_remove = "enigma2-plugin-softcams-oscam"

IMAGE_INSTALL += " \
	enigma2-plugin-extensions-backupsuite \
	enigma2-plugin-extensions-devicemanager \
	enigma2-plugin-extensions-epgimport \
	enigma2-plugin-extensions-foreca \
	enigma2-plugin-extensions-greeknetradio \
	enigma2-plugin-extensions-greekstreamtv \
	enigma2-plugin-extensions-sdgradio \
	enigma2-plugin-extensions-xmltvimport-greekepg \
	enigma2-plugin-extensions-xmltvimport-greekstreamtv \
	enigma2-plugin-extensions-youtube \
	enigma2-plugin-skins-satdreamgr-hd-transpba \
	enigma2-plugin-systemplugins-mphelp \
	glibc-gconv-iso8859-7 \
	glibc-gconv-utf-16 \
	livestreamersrv \
	rtl8192eu \
	satdreamgr-bootlogo \
	satdreamgr-extra-feed-configs \
	satdreamgr-panel \
	softcam-support \
"

DEPENDS += " \
	${@bb.utils.contains("MACHINE_FEATURES", "blindscan-dvbs", "enigma2-plugin-systemplugins-satscan" , "", d)} \
	\
	astra-sm \
	bluez-hidd \
	dreambox-buildimage \
	dvb-apps \
	dvb-usb-drivers-meta \
	dvblast \
	dvbsnoop \
	enigma2-plugin-extensions-bitrate \
	enigma2-plugin-extensions-btdevicesmanager \
	enigma2-plugin-extensions-hdmitest \
	enigma2-plugin-extensions-historyzapselector \
	enigma2-plugin-extensions-iptvplayer \
	enigma2-plugin-extensions-openmultiboot \
	enigma2-plugin-extensions-oscamstatus \
	enigma2-plugin-extensions-subssupport \
	enigma2-plugin-extensions-weathermsn \
	enigma2-plugin-skins-glamouraurafhd \
	enigma2-plugin-skins-octagoneightfhd \
	enigma2-plugin-skins-pli-hd \
	enigma2-plugin-skins-pli-hd-fullnight \
	enigma2-plugin-skins-satdreamgr-hd \
	enigma2-plugin-softcams-oscam-emu \
	enigma2-plugins \
	eti-tools \
	evtest \
	htop \
	inadyn-mt \
	iptables \
	libcec \
	meta-enigma2-dvdburn \
	minisatip \
	net-tools \
	ntp \
	oe-satipclient \
	ofgwrite \
	openvpn \
	pointercal \
	python-bluetool \
	python-cfscrape \
	python-dbus \
	python-js2py \
	python-mechanize \
	python-pycrypto \
	python-pycurl \
	python-pyexecjs \
	python-tcpbridge \
	redsea \
	rt8812au \
	rtl-sdr \
	satipclient \
	softcams-enigma2-meta \
	strace \
	tcpdump \
	tsniv2ni \
	v4l-utils \
	wscan \
"