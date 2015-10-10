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
...
import me.nucleartux.date.ReactDatePackage; // import
import android.support.v4.app.FragmentActivity;

public class MainActivity extends FragmentActivity implements DefaultHardwareBackBtnHandler { // ! extends from FragmentActivity

    private ReactInstanceManager mReactInstanceManager;
    private ReactRootView mReactRootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mReactRootView = new ReactRootView(this);
        mReactInstanceManager = ReactInstanceManager.builder()
                .setApplication(getApplication())
                .setBundleAssetName("index.android.bundle")
                .setJSMainModuleName("index.android")
                .addPackage(new MainReactPackage())
                .addPackage(new ReactDatePackage()) // register react date package here
                .setUseDeveloperSupport(BuildConfig.DEBUG)
                .setInitialLifecycleState(LifecycleState.RESUMED)
                .build();
        mReactRootView.startReactApplication(mReactInstanceManager, "AwesomeProject", null);
        setContentView(mReactRootView);
    }
...

```

#### Step 5 - Require and use in Javascript

```js
// file: index.android.js

var React = require('react-native');
var { AppRegistry,StyleSheet,Text,View,TouchableOpacity,NativeModules } = React;

var AwesomeProject = React.createClass({
    handleClick: function () {
      NativeModules.DateAndroid.showTimepicker(function() {}, function(date) {
        console.log(date);
      });
    },
    render: function() {
        return (
            <View style={styles.container}>
              <TouchableOpacity onPress={this.handleClick}>
                <Text style={styles.instructions}>
                  Click me
                </Text>
              </TouchableOpacity>
            </View>
        );
    }
});

var styles = StyleSheet.create({
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
