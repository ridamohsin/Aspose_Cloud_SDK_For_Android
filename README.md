<p align="center" >
  <img src="https://cloud.githubusercontent.com/assets/8667577/5695121/1b955b8e-99b3-11e4-928f-5c5a27cd6249.png" alt="AsposeCloudSDK" title="Aspose">
</p>

This SDK makes it easy for Android app developers to work with Word documents, Spreadsheets, Presentations, Adobe PDFs, OpenDocument formats, barcodes, OCR and email formats and protocols in their apps.

## Common Uses
- Convert Microsoft Word, Excel, PowerPoint, Acrobat PDF, OpenDocument and many other formats
- Convert documents to images
- Perform mail merge
- Generate reports using mail merge
- Excel reporting - build dynamic Excel reports on the fly
- High-fidelity Excel rendering
- Create new PDF documents using the product API
- Transform an XML document into PDF file
- Convert an image file to PDF
- Create new slides
- Add text to shapes
- Replace or extract text from PDF files
- Remove, replace or extract images from PDF files
- Generate barcode images and save to stream or image file
- Recognize barcodes from stream or image file
- Extract text from images

## How To Get Started
You can add AsposeCloudSDK to your Android Studio project as an external Aspose Cloud Maven dependency or as an external library via Gradle files.

#### 1. Aspose Cloud Maven Dependency
You can add AsposeCloudSDK to your Android Studio project by adding following lines of code in your app/build.gradle file. (Please note that these modifications go in the build.gradle file in your module’s directory, not the build file in the project root directory).

First, set up the repository where it can find the dependency.
```ruby
repositories {
    maven {  url 'http://maven.aspose.com/artifactory/simple/ext-release-local/'  }
}
```
and then add the dependency itself by adding this line to your dependencies block:
```ruby
dependencies {
    ...
    compile 'com.aspose:aspose-cloud-android:1.1.0'
}
```
AsposeCloudSDK library itself has following dependencies:  
1. **google-gson** A Java library to convert JSON to Java objects and vice-versa.  
2. **org.apache.commons.io** Commons IO is a library of utilities to assist with developing IO functionality.  
3. **org.apache.commons.codec** Apache Commons Codec (TM) software provides implementations of common encoders and decoders such as Base64, Hex, Phonetic and URLs.  
4. **httpclient-android** This project represents an effort to provide an implementation of Apache HttpClient, which can be deployed on Google Android in parallel to the outdated version shipped with the platform while remaining partially API compatible with Apache HttpClient 4.3.  
5. **httpmime** Apache HttpComponents - MIME coded entities   

You can add these dependencies by adding following lines to your dependencies block:  
```ruby
dependencies {
   ...
   compile 'com.google.code.gson:gson:2.3.1'
   compile 'org.apache.directory.studio:org.apache.commons.io:2.4'
   compile 'org.apache.directory.studio:org.apache.commons.codec:1.8'
   compile group: 'org.apache.httpcomponents' , name: 'httpclient-android' , version: '4.3.5.1'
   compile ('org.apache.httpcomponents:httpmime:4.3.6') {
     exclude group: 'org.apache.httpcomponents', module: 'httpclient'
   }
}
```
This is a recommended approach because it won’t mess in your project structure.
#### 2. Adding the library via Gradle files
As an alternative approach, following is the complete process  of adding AsposeCloudSDK as an external library to your project.

1. Create new project via Android Studio creator and name it HelloWorld
2. Here is the original project structure created by Android Studio:

  ```ruby
  HelloWorld/
      app/
          - build.gradle  // local gradle config (for app only)
          ...
      - build.gradle // global gradle config (for whole project)
      - settings.gradle 
      - gradle.properties
      ...
  ```
3. In root directory (HelloWorld/) create new folder: /libs in which we’ll place our external libraries (this step is not required – only for keeping cleaner project structure).
4. Download AsposeCloudSDK from [Github](https://github.com/asposeforcloud/Aspose_Cloud_SDK_For_Android), unzip it and paste **asposecloudsdk** folder in newly created /libs folder. Here is the new structure of our project:

  ```ruby
  HelloWorld/
      app/
          - build.gradle  // local gradle config (for app only)
          ...
      libs/
          asposecloudsdk/
              - build.gradle // local gradle config (for library only)
      - build.gradle // global gradle config (for whole project)
      - settings.gradle 
      - gradle.properties
      ... 
  ``` 
5. Edit settings.gradle by adding your library to include. Whole settings.gradle should look like below:

  ```ruby
  include ':app', ':asposecloudsdk'
  project(':asposecloudsdk').projectDir = new File('libs/asposecloudsdk')
  ```
6. In app/build.gradle add our library project as an dependency:

  ```ruby
  dependencies {
      compile fileTree(dir: 'libs', include: ['*.jar'])
      compile 'com.android.support:appcompat-v7:21.0.3'
      compile project(":asposecloudsdk")
  }
  ```
7. That’s all. **asposecloudsdk** library should be available in your project.

#### Error:duplicate files during packaging of APK
In case you face this error, just add the following lines of code in your app/build.gradle file under android block.
```ruby
packagingOptions {
    exclude 'META-INF/LICENSE.txt'
    exclude 'META-INF/NOTICE.txt'
    exclude 'META-INF/DEPENDENCIES'
    exclude 'META-INF/LICENSE'
    exclude 'META-INF/NOTICE'
}
```
#### Working with Aspose APIs
1. Sign up with Aspose for Cloud service at: [https://cloud.aspose.com/SignUp](https://cloud.aspose.com/SignUp)
2. [Create a new App and get your App SID and App Key](http://www.aspose.com/docs/display/totalcloud/Creating+a+New+App+and+Getting+App+Key)
3. Call the **AsposeApp.setAppKeyAndAppSID(String appKey, String appSID)** method in the onCreate() method of your Main Activity and pass your App SID and App Key as arguments to this method.

Now you are ready to work with Aspose REST APIs.

## Unit Tests
AsposeCloudSDK includes a suite of unit tests within the [androidTest](https://github.com/asposeforcloud/Aspose_Cloud_SDK_For_Android/tree/master/asposecloudsdk/src/androidTest/java/com/aspose/cloud/sdk) subdirectory. These Unit Tests also serves as examples of how to use the AsposeCloudSDK.

## Documentation

Check out the [documentation](http://asposeforcloud.github.io/android-sdk-docs/) for a comprehensive look at all of the APIs available in AsposeCloudSDK. For SDK Usage Examples, please go through [wiki](http://www.aspose.com/docs). For Aspose Cloud APIs related help, please go through [Aspose.Total for Cloud](http://www.aspose.com/cloud/total-api.aspx).

## Contact

Your feedback is very important to us. Please email us all your queries and feedback at marketplace@aspose.com.

## License
AsposeCloudSDK is available under the MIT license. See the [LICENSE](https://github.com/asposeforcloud/Aspose_Cloud_SDK_For_Android/blob/master/LICENSE) file for more info.
