# Auto AP

Starts WiFi hotspot on your rooted Android phone upon connecting to charger while the phone is not connected to WiFi. Automatically shuts off WiFi hotspot when disconnected from charger.

The use case is an automatic portable hotspot when you're on the go (in other words, when you're not near your home WiFi). Set and forget!

Designed for:

- rooted phone using Magisk. Magisk may be significant because the hardcoded `su` commands may not work with other `su` binaries.
- Android 10. Hacks are used to turn WiFi hotspot on and off. The hardcoded command was designed to work on Android 10 because that's what I have. See the source code to figure out how to modify the command for other Android versions.

Note that I'm not an Android developer, this is a bucket of hacks.
