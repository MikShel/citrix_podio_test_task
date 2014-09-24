citrix_podio_test_task
======================

Test task for Citrix team in denmark

How to run tests

On Mac
 ./gradlew cucumber #"-Dparameters"

 login - default 'no' //email, that will be used for tests
 pass - default 'no' //pass, that will be used for tests
 tags - default ''   //run scenarios with specific tag
 feature - default '' //run specific feature
 url - default 'https://nextpodio.dk' //run tests on custom url
 browser - default 'pjs'  //run tests in specific  browser ff - firefox, chm - Chrome

On Linux
Change binaries of drivers in drivers folder

 ./gradlew cucumber #"-Dparameters"

