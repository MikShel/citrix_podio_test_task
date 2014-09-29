citrix_podio_test_task
======================

Test task for Podio team in denmark

## How to run tests

### On Mac
 <pre>
 ./gradlew cucumber
 </pre> 

Also, few parameters can be changed using -Pkey="value"


 Keys    |  Default value  | Comment
 ------- | -------- | -------
 login   | 'no' | email, that will be used for tests
 pass    | 'no' | pass, that will be used for tests
 cred    | '/tmp/users.properties'     | run tests with specified login/pass property file, can be used without login/pass parameters
 tags    | '@Test'   | run scenarios with specific tag
 feature | '' | run specific feature
 url     | 'https://nextpodio.dk' | run tests on custom url
 browser | 'ghm'  |run tests in specific  browser ghm - Chrome, ff - firefox, pjs - PhantomJs
 
#### Credentials example 
 users.properties
<pre>
 # valid user
 login=login@user.com
 pass=pass
 </pre>
 

### On Linux
Change binaries of drivers in drivers folder
 <pre>
 ./gradlew cucumber
 </pre>

