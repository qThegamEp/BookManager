# Project Plan

## Project Structure
* [BookManager](https://github.com/qThegamEp/BookManager)
    * [src](src)
        * [main](src/main)
            * [java](src/main/java)
                * [com](src/main/java/com)
                    * [qthegamep](src/main/java/com/qthegamep)
                        * [bookmanager](src/main/java/com/qthegamep/bookmanager)
                            * [dao](src/main/java/com/qthegamep/bookmanager/dao)
                                * [BookDAO.java](src/main/java/com/qthegamep/bookmanager/dao/BookDAO.java)
                                * [BookDAOImpl.java](src/main/java/com/qthegamep/bookmanager/dao/BookDAOImpl.java)
                            * [entity](src/main/java/com/qthegamep/bookmanager/entity)
                                * [Book.java](src/main/java/com/qthegamep/bookmanager/entity/Book.java)
                            * [exception](src/main/java/com/qthegamep/bookmanager/exception)
                                * [LoadDBPropertiesException.java](src/main/java/com/qthegamep/bookmanager/exception/LoadDBPropertiesException.java)
                            * [service](src/main/java/com/qthegamep/bookmanager/service)
                                * [BookService.java](src/main/java/com/qthegamep/bookmanager/service/BookService.java)
                                * [BookServiceImpl.java](src/main/java/com/qthegamep/bookmanager/service/BookServiceImpl.java)
                            * [util](src/main/java/com/qthegamep/bookmanager/util)
                                * [PropertiesUtil.java](src/main/java/com/qthegamep/bookmanager/util/PropertiesUtil.java)
                                * [SessionUtil.java](src/main/java/com/qthegamep/bookmanager/util/SessionUtil.java)
                            * [Application.java](src/main/java/com/qthegamep/bookmanager/Application.java)
            * [resources](src/main/resources)
                * [db](src/main/resources/db)
                    * [h2](src/main/resources/db/h2)
                        * [DB.properties](src/main/resources/db/h2/DB.properties)
                        * [initDB.sql](src/main/resources/db/h2/initDB.sql)
                    * [mysql](src/main/resources/db/mysql)
                        * [DB.properties](src/main/resources/db/mysql/DB.properties)
                        * [initDB.sql](src/main/resources/db/mysql/initDB.sql)
                    * [populateDB.sql](src/main/resources/db/populateDB.sql)
                * [logback.xml](src/main/resources/logback.xml)
        * [test](src/test)
            * [java](src/test/java)
                * [com](src/test/java/com)
                    * [qthegamep](src/test/java/com/qthegamep)
                        * [bookmanager](src/test/java/com/qthegamep/bookmanager)
                            * [dao](src/test/java/com/qthegamep/bookmanager/dao)
                                * [BookDAOImplTest.java](src/test/java/com/qthegamep/bookmanager/dao/BookDAOImplTest.java)
                            * [entity](src/test/java/com/qthegamep/bookmanager/entity)
                                * [BookTest.java](src/test/java/com/qthegamep/bookmanager/entity/BookTest.java)
                            * [exception](src/test/java/com/qthegamep/bookmanager/exception)
                                * [LoadDBPropertiesExceptionTest.java](src/test/java/com/qthegamep/bookmanager/exception/LoadDBPropertiesExceptionTest.java)
                            * [service](src/test/java/com/qthegamep/bookmanager/service)
                                * [BookServiceImplTest.java](src/test/java/com/qthegamep/bookmanager/service/BookServiceImplTest.java)
                            * [testhelper](src/test/java/com/qthegamep/bookmanager/testhelper)
                                * [rule](src/test/java/com/qthegamep/bookmanager/testhelper/rule)
                                    * [Rules.java](src/test/java/com/qthegamep/bookmanager/testhelper/rule/Rules.java)
                                * [util](src/test/java/com/qthegamep/bookmanager/testhelper/util)
                                    * [IOUtil.java](src/test/java/com/qthegamep/bookmanager/testhelper/util/IOUtil.java)
                                    * [ResetDBUtil.java](src/test/java/com/qthegamep/bookmanager/testhelper/util/ResetDBUtil.java)
                            * [util](src/test/java/com/qthegamep/bookmanager/util)
                                * [PropertiesUtilTest.java](src/test/java/com/qthegamep/bookmanager/util/PropertiesUtilTest.java)
                                * [SessionUtilTest.java](src/test/java/com/qthegamep/bookmanager/util/SessionUtilTest.java)
                            * [ApplicationTest.java](src/test/java/com/qthegamep/bookmanager/ApplicationTest.java)
            * [resources](src/test/resources)
                * [logback-test.xml](src/test/resources/logback-test.xml)
    * [.appveyor.yml](.appveyor.yml)
    * [.gitignore](.gitignore)
    * [.travis.yml](.travis.yml)
    * [LICENSE](LICENSE)
    * [PLAN.md](PLAN.md)
    * [pom.xml](pom.xml)
    * [README.md](README.md)

## Fix In Future

## Bugs && Messages
