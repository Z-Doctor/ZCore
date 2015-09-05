0.0.9
    - Fixed bugs with easy crops and seeds
    - Updated mcmod info and gradle
    - Created some Helper Functions
        - getBlock returns the block at a pos in specified world
        - checkSurrondingsFor checks all 8 spaces around he block for a specific block

0.0.8
    - Removed DEV
    - Cleaned/Fixed code
    - Everything seems stable

0.0.7-DEV
    - Updated Common proxy (each class now handles each event on its own)
    - Cleaned up/updated all class code
    - Created Easy Crop
    - Created Example Crop
        - diamondcrop (drops diamond, planted with diamond seed)
        - Grows like wheat and drops diamond seed
    - Created Texture for diamondcrop
    - Cleared some unused/unimplemented code
    - Updated build.gradle
    - Updated en_US.lang
    - Updated plannedfeatures, renamed to PlannedFeatures
    - Easy Seed now drops seed when farmland is destroyed
    - EasySeed example moved to EasyCropExample. In favor of creating both at the same time.
    - Add language support for Pirate Speak, because I couldn't resist when I found it.
    - Added Update Notes

0.0.6-DEV
    - Created EasySeed
    - Created EasySeed Example, diamondseed
        - diamondseed currently plants as wheat seed
        - diamondseed texture added
        - created a seed folder in models and textures
    - Removed some unused code in Easy block, item, and food
    - Added default hardness, set sound, and blast resistance to easy block (same as stone) 

0.0.5-DEV
    - Specified MOD as in development
    - Removed fields from easy block, item and food
        - Changed code and structure
    - Added easy plants and crop classes (in development)

0.0.4
    - Added set recipes to easy block, food, and item
    - Fixed small bugs in registration
    - Added recipes for debugtool, hamburger, and dawnstone
    - Added language file
    - Added planned features file
    - Updated to latest forge - 1506 (for now anyway)

0.0.3
    - Added hamburger texture and model
    - Fixed easy food
    - Changed debugblock to dawnstone
    - dawnstone now sets time to day when broken by a player
    - Added texture for dawn stone
    - Added change log

0.0.2
    - Added easy food
    - Fixed self item registration
    - Added easy food example, hamburger
    - Added FMLConstruction event (called before preinit)

0.0.1
    - Added easy items
    - Added easy blocks
    - Easy items self register during fmlinit event
    - Added easy item example, debugtool
    - Added texture to debugtool
    - Added example block, debug block
    - Created ISubEvent (used to subscribe to fmlstateevents.

0.0.0
    - Created mod file and proxies