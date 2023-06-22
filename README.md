# 📅 Custom-Persian-Calendar

[![JitPack](https://jitpack.io/v/nazzanin/custom-persian-calendar.svg)](https://jitpack.io/#nazzanin/custom-persian-calendar)

<br>

## 🚀 Introduction

This project is a custom calendar based on the [Persian Calendar View by Roojin](https://github.com/Roojin/persian-calendar-view). Although the original project is no longer maintained, it provided an excellent base for this modified version.

In this version, I have added a new feature that allows users to underline a specific day by long pressing on it. This can help you mark important dates in your Persian calendar.
<br>
<br>
<br>
## 📚 Original Library

The original library provided a Persian calendar view for Android, based on ebraminio's DroidPersianCalendar open-source project. The usage, styling, functions, events, and listeners can be found in the [original documentation](https://github.com/Roojin/persian-calendar-view). 
<br>
<br>
<br>
## 🎁 New Feature: Day Underlining

In this custom version, you can now underline a day in the calendar by long pressing on it. 

```java
    // Sample code for underlining a day on long press
    calendarView.setOnDayLongClickedListener(new OnDayLongClickedListener() {
        @Override
        public void onDayLongClicked(PersianDate persianDate) {
            // Your underline logic here
        }
    });
```
<br>

## 🏁 Conclusion

Feel free to fork, use, and contribute to this project🍴. If you have any questions or issues, you can create an issue in this repository.


Remember to replace the sample code in "New Feature: Day Underlining" section with the actual implementation.
