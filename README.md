# react-native-date
React Native date and time pickers for Android

## Installation and How to use

#### Step 1 - NPM Install

```shell
npm install --save react-native-date
```
#### Step 2 - Update Gradle Settings

```gradle
// file: android/settings.gradle
...

include ':reactdate', ':app'
project(':reactdate').projectDir = new File(rootProject.projectDir, '../node_modules/react-native-date')
```

#### Step 3 - Update app Gradle Build

```gradle
// file: android/app/build.gradle
...

dependencies {
    ...
    compile project(':reactdate')
}
```

#### Step 4 - Register React Package

```java
// file: android/app/source/main/java/com/{projectName}.MainActivity.java
...
import me.nucleartux.date.ReactDatePackage; // import

public class MainActivity extends ReactActivity {
...
    @Override
    protected List<ReactPackage> getPackages() {
      return Arrays.<ReactPackage>asList(
        new MainReactPackage()
      , new ReactDatePackage() // register react date package here
      );
    }

...

```

#### Step 5 - Require and use in Javascript

```js
// file: index.android.js

import React, { AppRegistry, StyleSheet, Text, View, TouchableOpacity } from 'react-native';
import DateAndroid from 'react-native-date';

const AwesomeProject = React.createClass({
  handleTimeClick: function () {
    DateAndroid.showTimepicker(function() {}, function(hour, minute) {
      console.log(`${hour}:${minute+1}`);
    });
  },
  handleDateClick: function () {
    DateAndroid.showDatepicker(function() {}, function(year, month, day) {
      console.log(`${year}/${month+1}/${day}`);
    });
  },
  render: function() {
    return (
      <View style={styles.container}>
        <TouchableOpacity onPress={this.handleDateClick}>
          <Text style={styles.instructions}>
            Click me to select Date
          </Text>
        </TouchableOpacity>
        <TouchableOpacity onPress={this.handleTimeClick}>
          <Text style={styles.instructions}>
            Click me to select Time
          </Text>
        </TouchableOpacity>
      </View>
    );
  }
});

const styles = StyleSheet.create({
  instructions: {
    textAlign: 'center',
    color: '#333333',
    margin: 5,
  },
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  }
});

AppRegistry.registerComponent('AwesomeProject', () => AwesomeProject);
```


## Notes
- Please report any issues or send patches to get fixes in
