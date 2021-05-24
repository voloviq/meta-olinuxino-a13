DESCRIPTION = "A QT5 image for Cubieboard 1"
LICENSE = "MIT"

NETWORK_APP = " \
    openssh openssh-keygen openssh-sftp-server \
"

IMAGE_LINGUAS = "pl-pl"

inherit core-image

IMAGE_FEATURES += " \
    splash \
"

SYSTEM_TOOLS_INSTALL = " \
    i2c-tools \
    memtester \
    sysbench \
    tzdata \
    devmem2 \
    minicom \
"

QT_TOOLS = " \
    qtbase \
    qtbase-plugins \
    qtserialport \
"

FONTS = " \
    fontconfig \
    fontconfig-utils \
    liberation-fonts \
"

QT_DEV_TOOLS = " \
    qtbase-dev \
    qtbase-mkspecs \
    qtbase-tools \
    qtserialport-dev \
    qtserialport-mkspecs \
"

KERNEL_EXTRA_INSTALL = " \
    kernel-devicetree \
    kernel-modules \
 "

DEV_TOOLS_INSTALL = " \
    mtd-utils \
"

NETWORK_TOOLS_INSTALL = " \
"

UTILITIES_INSTALL = " \
    coreutils \
    gdbserver \
    mtd-utils \
    ldd \
    libstdc++ \
    libstdc++-dev \
    openssh-sftp \
    ppp \
    tzdata \
"

TSLIB = " \
    tslib \
    tslib-calibrate \
    tslib-conf \
    tslib-dev \
    tslib-tests \
"

IMAGE_INSTALL += " \
  ${DEV_TOOLS_INSTALL} \
  ${SYSTEM_TOOLS_INSTALL} \
  ${UTILITIES_INSTALL} \
  ${NETWORK_APP} \
  ${FONTS} \
  ${QT_TOOLS} \
  ${KERNEL_EXTRA_INSTALL} \
  ${TSLIB} \
"

#Always add cmake to sdk
TOOLCHAIN_HOST_TASK_append = " nativesdk-cmake"

DISTRO_FEATURES_remove = " x11 wayland opengl pulseaudio opengles egl xcb "
PACKAGECONFIG_DISTRO_append_pn_qtbase = " linuxfb tslib "
IMAGE_INSTALL_append = " qtbase qtbase-plugins "
