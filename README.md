Timetools GUI is a simple, user-friendly Java application that provides tools for generating and converting Unix timestamps through a GUI. Uses Java Swing to offer a clean experience for working with Unix time.

This is used internally within our projects to help us.
## Features
### Generate Unix Timestamps:
Input a specific date and time (in UTC) and convert it to a Unix timestamp.
### Convert Unix Timestamps:
Convert a given Unix timestamp back into a human-readable date and time (in UTC).

## Usage

1. **Generating a Timestamp:**
   - Select the "Generate Unix Timestamp" option.
   - Enter the date in `yyyy-MM-dd` format and the time in `HH:mm:ss` format (both in UTC).
   - Click the "Generate Timestamp" button to see the corresponding Unix timestamp.

2. **Converting a Timestamp:**
   - Select the "Convert Unix Timestamp" option.
   - Enter the Unix timestamp you want to convert.
   - Click the "Convert to Date/Time" button to see the date and time in `yyyy-MM-dd HH:mm:ss` format (UTC).

3. **Returning to Menu:**
   - Each mode has a "Back to Menu" button that allows you to return to the main menu.

## Attribution

This project includes the following third-party libraries:

- **FlatLaf:** A modern open-source cross-platform Look and Feel for Java Swing applications.
   - Licensed under the Apache License, Version 2.0. You may obtain a copy of the License at [http://www.apache.org/licenses/LICENSE-2.0](http://www.apache.org/licenses/LICENSE-2.0).
   - [FlatLaf GitHub Repository](https://github.com/JFormDesigner/FlatLaf)

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
