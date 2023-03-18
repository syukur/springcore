package com.elfathan.springcore.data.computer;

import java.util.Optional;

public class SoundCard {
    Optional<UsbPort> usbPort;

    public Optional<UsbPort> getUsbPort() {
        return usbPort;
    }
}
