CloudConverter by Model Metrics, Inc.
Converts dirt bound JDBC/ODBC to cloud based Force.com.

IMPORTANT: This software is provided AS IS without warranty or 
support of any kind. If you would like paid support, please
contact rcarlberg@modelmetrics.com.

Last Update: 2009-04-09 (See history below for details.)
dd

###################################################################
CONTACT:

Reid Carlberg, Model Metrics, Inc.
rcarlberg@modelmetrics.com
http://community.modelmetrics.com

###################################################################
INTRODUCTION:

Watch the intro video: http://www.youtube.com/watch?v=yGAuTzrf8OM

You should read AT LEAST the BASIC FLOW and IMPORTANT NOTES section.

Look in the package "com.modelmetrics.cloudconverter" for the classes you might want to run.

You can add this to your org using the following Salesforce.com Web Tab URL:

https://cloudconverter.modelmetrics.com/mmimport/home.action?s={!$Api.Session_ID}&u={!$Api.Partner_Server_URL_150}


###################################################################
PROJECT STATUS:

Undergoing active development.  Expect the code to continue to evolve in significant ways. 

Looking for contributors.

###################################################################
BASIC FLOW:

1. Inspect dirt based data store to grab metadata.
2. Create object in Force.com based on that metadata.  
2.1 - All fields
2.2 - Fields will be added to the default layout
2.3 - Will create a tab for this object
3. Move the data.

###################################################################
IMPORTANT NOTES: 

When complete, you will have to turn on access to the newly created tab for your profile. 
Do this in setup > manage users > profiles > edit - next to your profile.  Change visibility
to "Default On".  If you don't know how to do this, talk to your SFDC administrator.

(Hint - when logged in to SFDC, visit -- Setup > Administration > Manage Users > Profiles.  
Click "edit" next to the profile that should see the tab. Locate the tab.  Change from 
to "default on".)

CloudConverter will attempt to create an object based on the table name.  If this 
object already exists, it will fail. 

The sample script includes a few different database types -- Apache Derby, MySQL, 
and Notes.  Derby is included with the distribution.  Notes requires some additional
client configuration.

###################################################################
HOW TO:

Learn More -- Search YouTube for Cloud Converter to see the latest demos and instructional
videos.

Get Started -- use a toy database (for example, use the one included in this) and a 
dev org to get used to the general flow of the app.  


###################################################################
HISTORY:

2009-06-16

* Explore your metadata includes more field detail and greater ability to find the object you need.
* Import from Excel includes the ability to import to an existing object.

2009-06-01

* Extensive work around a Web Based interface for importing data from Excel files.
* Added Explore Your Metadata
* Updates support libs from Spring 2.0 to 2.5.
* Summer 09 integration

2009-02-17

* updated to version 15 of both the standard and metadata API.
* refactored database connection to be parameter driven.  See script and app for an example.
* added support for Lookup fields, external id fields and picklists.
* added support for automatic external id based foreign key resolution for lookup relationships.
* added a larger sample database with more robust sample data.
* split the CloudConverterScript into a Script with dummy setup and a template for your own use.
* expanded test coverage.

2009-01-10

* minor changes for improved logging

2009-01-05

* Intial upload.
* If you checkout into Eclipse, you should have you classpath, etc., all set for you.
* Everything is text based.  Run com.modelmetrics.cloudconverter.CloudConverter.main.
* If you want to convert something other than MySQL or Notes, you'll need to configure it.

###################################################################
ROAD MAP:

* Update to Spring 09 APIs (after all pods are updated)
* Test with larger sample data sets
* Use "Profile Tab Visibility" to make the custom tab visible by default.
* Record ownership rule engine
* Automate configuration
* Add a UI