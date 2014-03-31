IIN Learning Center Automation Test Suite
==========================================

Description:
------------

Project is a maven project which means that it must follow maven directory structure. 
The project is flexible and being developed should take into consideration the fact that it 
will be used to drive all automation tests for the IIN Learning Center Project. The project
will include the following platforms:
		- Web
		- iOS Hybrid (Mobile, Tablet)
		- Andriod Hybrid (Mobile, Tablet)

Parameter:
----------

In order to acchive execution of test on several platforms, we introduced parameters that must be passed in order for tests to execute.
Below are the parameters you must provide:

		* -DappPath (ex. -DappPath="/Users/Alex/SourceCode/Next-Gen-iOS_App/DerivedData/IIN/Build/Products/Debug-iphonesimulator/IIN.app")
		* -DbrowserName (ex. -DbrowserName=iOS )
		* -DbrowserVersion (ex. -DbrowserVersion=7.1)
		* -DbrowserPlatform (ex. -DbrowserPlatform=Mac)
		* -DtestURL (ex. -DtestURL="http://0.0.0.0:4723/wd/hub")
		* -Dgroups (ex. -Dgroups=ios,critical) [NOTE: You must pass it either ios, android, web, crossplatform in groups in order to ensure that test only for those devices get executed.]
		* -DforkMode (ex. -DforkMode=never) [NOTE: This is only needed if you are attempting to hook up an ide to mvn goal execution]
		* -DappPackage [ANDROID ONLY] (ex. -DappPackage="com.integrativenutrition.android.nextgen")
        * -DappActivity [ANDROID ONLY] (ex. -DappActivity="com.integrativenutrition.android.nextgen.activity.SplashActivity")

Example:
--------

iOS:

- mvnDebug clean test -DappPath="/Users/Alex/SourceCode/Next-Gen-iOS_App/DerivedData/IIN/Build/Products/Debug-iphonesimulator/IIN.app" -DbrowserName=iOS -DbrowserVersion=7.1 -DbrowserPlatform=Mac -DtestURL="http://0.0.0.0:4723/wd/hub" -DforkMode=never -Dgroups=ios,critical

- mvn clean test -DappPath="/Users/Alex/SourceCode/Next-Gen-iOS_App/DerivedData/IIN/Build/Products/Debug-iphonesimulator/IIN.app" -DbrowserName=iOS -DbrowserVersion=7.1 -DbrowserPlatform=Mac -DtestURL="http://0.0.0.0:4723/wd/hub" -Dgroups=ios,critical


Android:

- mvnDebug clean test -DappPath="/Users/Alex/SourceCode/Next-Gen-Android_App/IIN/NextgenApp/build/apk/NextgenApp-defaultFlavor-debug-unaligned.apk" -DbrowserName=Android -DbrowserVersion=4.4.2 -DbrowserPlatform=Mac -DtestURL="http://0.0.0.0:4723/wd/hub" -DappPackage="com.integrativenutrition.android.nextgen" -DappActivity="com.integrativenutrition.android.nextgen.activity.SplashActivity" -DforkMode=never -Dgroups=android,critical

- mvn clean test -DappPath="/Users/Alex/SourceCode/Next-Gen-Android_App/IIN/NextgenApp/build/apk/NextgenApp-defaultFlavor-debug-unaligned.apk" -DbrowserName=Android -DbrowserVersion=4.4.2 -DbrowserPlatform=Mac -DtestURL="http://0.0.0.0:4723/wd/hub" -DappPackage="com.integrativenutrition.android.nextgen" -DappActivity="com.integrativenutrition.android.nextgen.activity.SplashActivity" -Dgroups=android,critical


Future Features:
----------------

- Generate test data in drupal backend from suite to use in test
- Create common scripts that can be used across platforms. (This may prove to be difficult but it is something we should explore)
- Provide ability to record test as they are being executed
- Enable email notification at certain milestones with test results, screenshots and videos (if available).