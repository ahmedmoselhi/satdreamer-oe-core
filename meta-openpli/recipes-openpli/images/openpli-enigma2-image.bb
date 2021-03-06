require openpli-image.bb

WIFI_DRIVERS += "\
	firmware-rt2870 \
	firmware-rt73 \
	firmware-rtl8192cu \
	firmware-rtl8188eu \
	firmware-rtl8192eu \
        firmware-rt73 \
        firmware-mt7601u \
	\
	kernel-module-rt2500usb \
	kernel-module-rt2800usb \
        kernel-module-mt7601usta \
	kernel-module-rt73usb \
	kernel-module-r8188eu \
	rtl8192cu \
        rt3070 \
	"

ENIGMA2_PLUGINS = " \
	enigma2-plugin-extensions-audiosync \
	enigma2-plugin-extensions-autobackup \
        enigma2-plugin-extensions-cacheflush \
	enigma2-plugin-extensions-cutlisteditor \
	enigma2-plugin-extensions-graphmultiepg \
	enigma2-plugin-extensions-mediaplayer \
	enigma2-plugin-extensions-mediascanner \
	enigma2-plugin-extensions-moviecut \
	enigma2-plugin-extensions-openwebif \
	enigma2-plugin-extensions-pictureplayer \
        enigma2-plugin-systemplugins-extnumberzap \
	\
	enigma2-plugin-systemplugins-fastscan \
	enigma2-plugin-systemplugins-hotplug \
	enigma2-plugin-systemplugins-networkbrowser \
	enigma2-plugin-systemplugins-positionersetup \
	enigma2-plugin-systemplugins-satfinder \
	enigma2-plugin-systemplugins-softwaremanager \
	enigma2-plugin-systemplugins-videomode \
	enigma2-plugin-systemplugins-videotune \
	enigma2-plugin-systemplugins-osdpositionsetup \
        enigma2-plugin-systemplugins-skinselector \
        enigma2-plugin-systemplugins-wirelesslan \
	\
	${@bb.utils.contains("MACHINE_FEATURES", "3dtv", "enigma2-plugin-systemplugins-osd3dsetup" , "", d)} \
	${@bb.utils.contains("MACHINE_FEATURES", "dvb-c", "enigma2-plugin-systemplugins-cablescan" , "", d)} \
	${@bb.utils.contains("MACHINE_FEATURES", "hdmicec", "enigma2-plugin-systemplugins-hdmicec" , "", d)} \
	\
	${@bb.utils.contains('OPENPLI_FEATURES', 'ci', 'enigma2-plugin-systemplugins-commoninterfaceassignment', '', d)} \
	${@bb.utils.contains('OPENPLI_FEATURES', 'dvd', 'enigma2-plugin-extensions-cdinfo enigma2-plugin-extensions-dvdplayer', '', d)} \
	${@bb.utils.contains('OPENPLI_FEATURES', 'fan', 'enigma2-plugin-systemplugins-tempfancontrol', '', d)} \
	${@bb.utils.contains('OPENPLI_FEATURES', '7seg', 'enigma2-plugin-systemplugins-vfdcontrol', '', d)} \
	enigma2-plugin-extensions-dlnabrowser \
	enigma2-plugin-extensions-dlnaserver \
	enigma2-plugin-extensions-subssupport \
	enigma2-plugin-extensions-reconstructapsc \
	enigma2-plugin-extensions-install-ffmpeg \
	enigma2-plugin-systemplugins-systemtime \
	"

DEPENDS += " \
	enigma2 \
	enigma2-pliplugins \
	enigma2-plugins \
	"

IMAGE_INSTALL += " \
	aio-grab \
	enigma2 \
	libavahi-client \
	settings-autorestore \
	tuxbox-common \
	ofgwrite \
	${ENIGMA2_PLUGINS} \
	\
	${WIFI_DRIVERS} \
	\
        enigma2-plugin-extensions-raedquicksignal \
        enigma2-plugin-extensions-youtube-dl \
        enigma2-plugin-extensions-keyadder \
	enigma2-plugin-systemplugins-serviceapp \
	${@bb.utils.contains('MACHINE_FEATURES', 'ctrlrc', "enigma2-plugin-systemplugins-remotecontrolcode", "", d)} \
	\
	${@bb.utils.contains('OPENPLI_FEATURES', 'dvd', 'cdtextinfo', '', d)} \
	"

export IMAGE_BASENAME = "openpli-enigma2"
