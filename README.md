# ScreenRotationTest1
Rotating Exodux Box screen Demo 1

Mainly we get get the runtime and read 'persist.sys.app.rotation' property (we get 'middle-port' by default):

https://github.com/Javimetal/ScreenRotationTest1/blob/b01847a1cc058c5dff1c9dd487e30bace5fd7327/app/src/main/java/com/exodux/screenrotationtest1/MainActivity.java#L70

Or, by same way, we can set the 'persist.sys.app.rotation' property to 'original' or other:

https://github.com/Javimetal/ScreenRotationTest1/blob/b01847a1cc058c5dff1c9dd487e30bace5fd7327/app/src/main/java/com/exodux/screenrotationtest1/MainActivity.java#L89

Then we can rotate by

A) setRequestedOrientation( ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

or

B) setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);


By default, the value is 'middle-port', but we can change to 'original' by getting the runtime.
If we use 'original' value the behabiour will be as a mobile phone or tablet and your app will not be locked to landscape.

HOW TO USE THE APP:

Button 'Swap Rotation Mode' switches between 'original' and 'middle-port', the current value will be displayed.
Buttom 'Set Portrait Mode' will swap the screen orientation to portrait.
Button 'Set Landscape Mode' will swap the screen orientation to landscape.

If we want a properly portrait usage, first change mode to 'original', then set to portrait.

Compiled APK is available, just donwload the file: app-debug.apk
