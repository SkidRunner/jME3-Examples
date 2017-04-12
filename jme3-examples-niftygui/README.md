# jME3 Examples for NiftyGUI
Quick NiftyGUI driven jME3 Application.

## Splash Screens
#### jMonkeyEngine
The jMonkeyEngine splash screen is actually two separate things. First being a Quad spatial with the jMonkeyEngine logo
as it's texture. This Spatial is attached directly to the Gui Node. Second a NiftyGUI splash screen is defined using XML
with the exact same image positioned the exact same way. Once jMonkeyEngine has initialized NiftyGUI the first splash is
replaced with the second.

> The purpose of this is to hide the presence of this empty viewport while NiftyGUI is being
initialized.
#### NiftyGUI
The NiftyGUI is shown for a short amount of time the time it is showed depends on whether or not the user hit the [Esc]
key during the jMonkeyEngine splash screen.
## Loading Screen
This screen is mainly to show off a progress bar but also shows a threaded initialization of a Scene. Another notable
act about the loading screen is that it uses both NiftyGUI and jMonkeyEngine classes.
#### BaseAppState
The base app state of the loading screen is responsible for hooking into jMonkeyEngine allowing for models in J3O
format to be loaded and attached to the scenegraph. Also it serves as an update method for smoothly advancing the
progress bars value.
#### ScreenController
The screen controller is responsible for enabling the the jMonkeyEngine app state and starting the loading thread.
> Loading should be actually started on the initialization method of the app state but then loading would be done before
you get to see my pretty progress bar.
## Main Screen
Not finished yet... it has a working exit popup and allows you to move to the game screen.
## Game Screen
right now only two progress bars set to Health and Energy

