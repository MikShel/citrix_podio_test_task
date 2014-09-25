citrix_podio_test_task
======================

Test task for Podio team in denmark

How to run tests

On Mac
 ./gradlew cucumber #"-Pparameters"

 login - default 'no' //email, that will be used for tests
 pass - default 'no' //pass, that will be used for tests
 cred - default '/tmp/users.properties'     //(run tests with specified login/pass property file)
 example
 users.properties{
 # valid user
 login=professor@ngcblusqdbkptlwhkkge.com
 pass=professor_$ecur3Pwd
 }
 tags - default ''   //run scenarios with specific tag
 feature - default '' //run specific feature
 url - default 'https://nextpodio.dk' //run tests on custom url
 browser - default 'pjs'  //run tests in specific  browser ff - firefox, ghm - Chrome

On Linux
Change binaries of drivers in drivers folder

 ./gradlew cucumber #"-Pparameters"

