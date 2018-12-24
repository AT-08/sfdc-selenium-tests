# sfdc-selenium-tests

[![Build status](https://travis-ci.com/AT-08/sfdc-selenium-tests.svg?branch=develop)](https://travis-ci.com/AT-08/sfdc-selenium-tests) 

[![Quality Gate](https://sonarcloud.io/api/project_badges/measure?project=AT-08_sfdc-selenium-tests&metric=alert_status)](https://sonarcloud.io/dashboard/index/AT-08_sfdc-selenium-tests)


SALES FORCE TEST
-----------

The main objective of this framework is automate acceptance test cases of Sales Force Develop Web Page using testNG, cucumber.
The test cases executions are made using docker, browserStack and SauceLabs.
    

CONFIGURATIONS
-----------------------------------

    -Download Gradle 4.5 or superior: https://gradle.org/gradle-download/
    -IntelliJ idea IDE.
    -Clone/download the project from GitHub repository: https://github.com/AT-08/sfdc-selenium-tests.git

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
    -PurlLogin="https://login.salesforce.com/" -Puser="myusername@gmail.com" -Ppassword="mypassword" 
    -Pbrowser="CHROME" -PexplicitWait="60" -Pbrowser="CHROME" -Ptheme="CLASSIC"
