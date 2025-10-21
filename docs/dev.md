# Development Notes

## FXGL GameApp Methods

| Phase              | Method                                   | When it runs                            | Purpose                                     |
| ------------------ | ---------------------------------------- | --------------------------------------- | ------------------------------------------- |
| **Initialization** | `initSettings(GameSettings settings)`    | First, before the app window opens      | Configure title, width, height, etc.        |
| **Pre-load**       | `onPreInit()`                            | Before assets and game world are loaded | Setup global configs, variables             |
| **Game setup**     | `initInput()`                            | Once, before the game starts            | Bind keys, mouse, etc.                      |
|                    | `initGameVars(Map<String, Object> vars)` | Before the game world loads             | Initialize global variables (e.g., “score”) |
|                    | `initGame()`                             | When the game starts                    | Create entities, load level, etc.           |
|                    | `initUI()`                               | After the game starts                   | Build custom UI overlays, HUDs              |
|                    | `initPhysics()`                          | Once                                    | Setup collision handlers, physics logic     |
| **Game loop**      | `onUpdate(double tpf)`                   | Every frame                             | Your per-frame logic (movement, AI, etc.)   |


## FXGL Key Shortcuts/Debug Tools while running App
- `Press 1`: opens dev menu (for viewing hitboxes and others)
- `Press Esc`: opens in-game menu  or pauses the game