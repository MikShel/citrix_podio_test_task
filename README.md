citrix_podio_test_task
======================

Test task for Podio team in denmark

How to run tests

On Mac
 ./gradlew cucumber 

Also, few parameters can be changed using -Pkey="value"
 Keys    |   Value
 login   | default 'no' //email, that will be used for tests
 pass    | default 'no' //pass, that will be used for tests
 cred    | default '/tmp/users.properties'     //(run tests with specified login/pass property file)
 ======================
 example
 users.properties
 # valid user
 login=professor@ngcblusqdbkptlwhkkge.com
 pass=professor_$ecur3Pwd
 
 ======================
 tags    | default ''   //run scenarios with specific tag
 feature | default '' //run specific feature
 url     | default 'https://nextpodio.dk' //run tests on custom url
 browser | default 'ghm'  //run tests in specific  browser ghm - Chrome, ff - firefox, pjs - PhantomJs

On Linux
Change binaries of drivers in drivers folder

 ./gradlew cucumber

