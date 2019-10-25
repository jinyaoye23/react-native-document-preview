
# react-native-document-preview

## Getting started

`$ npm install react-native-document-preview --save`

### Mostly automatic installation

`$ react-native link react-native-document-preview`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-document-preview` and add `RNDocumentPreview.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNDocumentPreview.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.mg.documentPreview.RNDocumentPreviewPackage;` to the imports at the top of the file
  - Add `new RNDocumentPreviewPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-document-preview'
  	project(':react-native-document-preview').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-document-preview/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-document-preview')
  	```


## Usage
```javascript
import RNDocumentPreview from 'react-native-document-preview';

// TODO: What to do with the module?
RNDocumentPreview;
```
  