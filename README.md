# sfdc-tests

[![Build status](https://travis-ci.org/AT-06/sfdc-tests.svg?branch=develop)](https://travis-ci.org/AT-06/sfdc-tests) 

[![Quality Gate](https://sonarcloud.io/api/project_badges/measure?project=at-06-sfdc-tests&metric=alert_status)](https://sonarcloud.io/dashboard/index/at-06-sfdc-tests)


SALES FORCE TEST
-----------

The main objective of this framework is automate acceptance test cases of Sales Force Develop Web Page using testNG, cucumber.
The test cases executions are made using docker, browserStack and SauceLabs.
    

CONFIGURATIONS
-----------------------------------

    -Download Gradle 4.5 or superior: https://gradle.org/gradle-download/
    -IntelliJ idea IDE.
    -Clone/download the project from GitHub repository: https://github.com/AT-06/sfdc-tests.git

REQUIREMENTS
-----------------------------------
Open the project downloaded/cloned with the IntelliJ IDE.
Open the Gradle properties file e.g. gradle.properties file
Set the required parameters:


    #Tue May 08 16:10:57 GMT-04:00 2018
    urlLogin=   //Sales force login URL (e.g. https://login.salesforce.com/) 
    # USER CONFIGURATION
    user=       //Sales force user.
    password=   //Sales force Login.
    # THEME CONFIG {LIGHT,CLASSIC}
    theme=      //choose only one theme.
    
    #BROWSER AND DOCKER CONFIG {CHROME, FIREFOX, DOCKER_CHROME, DOCKER_FIREFOX,SAUCELABS,BROWSER_STACK}
    browser=    //Choose only one option.
    dockerURL=  //Put docker url (e.g. http://url:4444/wb/hub)
    
    #SAUCELABS AND BROWSER STACK
    remoteUserName=     //Is the username of Saucelabs or Browserstack.
    remoteAccessKey=    //Is the key provided.
    remoteBrowserName=  //Is The browser that you want to execute your test
    remoteBrowserVersion=
    remoteResolution=   //Screen resolution.
    
    #SAUCElABS CAPABILITIES
    remotePlatform=     //sauce labs plataform to be remote test.
    
    #BROWSER STACK CAPABILITIES
    remoteOS=
    remoteOSVersion=
    #EXPLICIT WAIT
    explicitWait= //time for wait elements.
    
    
  After executing those steps the frame should be executed.

To execute by command line you can use the following:
    
    gradle clean executeFeatures 
    -PurlLogin="https://login.salesforce.com/" -Puser="mariarenee.canqui@gmail.com" -Ppassword="HigurashI1994" 
    -Pbrowser="CHROME" -PexplicitWait="60" -Pbrowser="CHROME" -Ptheme="CLASSIC"



The project use a coreJavaProject located in https://github.com/AT-06/coreJavaProject that contains the DriverManager, 
browsers configurations and common actions related to web elements.
To use this go to releases section and search the last.
Open build.gradle and change the release version of the coreJavaProject
 
        compile 'com.github.AT-06:coreJavaProject:RELEASE'
