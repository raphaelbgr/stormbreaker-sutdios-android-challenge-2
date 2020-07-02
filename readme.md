# SP-1
- Epic: Layout Test
- Status: To Do
- Labels: Android
- Priority: Medium
- Reporter: Marcos Silva

## Delivery
- Delivery instructions:
    1. Create a new GitHub repo exclusively for the test
        - You may not reuse your previous repo
    2. Make commits as you normally would
    3. At the end of the 3h, give access to mediumhotcoffee (msilva@fastmail.com) 
        - The delivery time is counted as the time of the invite; if the invite is sent when the repo is created and contains no relevant files, the applicant will be disqualified
        - Any commits past the deadline will not be considered
- Reminders:
    - The test started when you downloaded the project from the Dropbox Transfer
    - The test must compile when received (warnings are OK, but try to minimize them)
        - If the project doesn't compile on the most recent Android Studio stable build, the applicant will be disqualified

## Requirements
- Reimplement the previous test in another language:
    - Java -> Kotlin
    - Kotlin -> Java
- You may use your time to make fixes to your previous submission as well
    - Fixes must be made on the new repo to be considered
- Both need to be uploaded to the same repo
    - Using the old repo disqualifies the applicant

## Originals

### Info
- We have a new client and they want a basic app they can see on their phone
- Client requested that this app runs on medium sized devices and up
- Fonts:
    - Robot, Medium
- Colors:
    - Black: `#000`
    - White: `#FFF`
    - Purple: `#605B70`
    - Light purple: `#605B70`, alpha 70%
    - Green: `#76999D`
    - Red: `#D51236`
    - Light gray: `#BABABA`
    - Yellow: `#FFFF8C`

### Requirements
- Match screens as close as possible to the prototype
- Launch screen
    - Using the _graphic-launcher_ asset, add a launcher theme to the app
- **Onboarding** screen:
    - For the icons, use the following assets:
        - _icon-calendar_
        - _icon-clock_
        - _icon-globe_
        - Update the colors to match the prototype
    - Must be first screen of the app
    - Use the following components for entering dates and times:
        - `DatePickerDialog`
        - `TimePickerDialog`
    - Dialogs' values are to be used as input
    - All fields must have information before the user can continue to the next screen
    - For the **Time Zone** option, just use a couple of time zones to demonstrate functionality (use at least 5)
    - If the user tries to go to the **Home** screen without the three values, notify the user of the error and do not allow them to move forward until they have all three fields filled up
- **Home** screen:
    - Should open after the **Onboarding** screen has the 3 values
    - The 3 rows in the prototype must scroll horizontally, and the main screen should scroll vertically
        - Use at least 3 items in each row (you can repeat images if you wish)
        - Tapping any cell should take the user to the **Playlist** screen in **Articles** mode
        - For each cell's title, use random names, but for the cells on the last row use times in minutes that start with "5 min" and add 5 on each cell to the right
- **Playlist** screen:
    - Client wants to be able to scroll through
    - Provide at least 3 placeholder articles
    - Give each article a reading time (this will come from the API later, but no need to implement the functionality now)
- **About the Playlist** screen:
    - Use any sort of Lorem Ipsum for now as a placeholder
    - For the icons, use the following assets:
        - _icon-bulb_
        - _icon-share_
- General:
    - Client must be able to interact with all screens
        - Client wants to test all fields, so all must be functional
    - Client wants to see the icon for the app implemented (it was provided in a single size in the assets folder)