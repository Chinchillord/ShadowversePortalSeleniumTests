1. Add a logging system instead of System.outs (https://blog.scalyr.com/2018/07/started-quickly-spring-boot-logging/)
2. Have you considered making your "BasePage" class an abstract class? // I did it.
3. Ensure all imports are being used. Your IDE should have a setting to do this for you/alert you to unused imports. //Good!
4. Standardize white spacing //Good, but double check.
5. Take a look at inheritance vs composition (not sure how widely used composition is in test code though) //This was really cool and I want to have a discussion about it. I'm not sure it's a negative factor in my project though.
6. TODO: this is verging on "enterprise quality hello world" (https://gist.github.com/lolzballs/2152bc0f31ee0286b722), however you could have an
       enum defining this "constant"
       PS you know my thoughts on pausing -.-
7. You forgot about dependency injection :(. Become a spring! //Later
8. Instance variables are not evil - they make testing easier
    maybe in a performance based application you'd have reason to avoid Instance
    level variables, but in a java application, i think readability/reusablity are the focus
9. I would consider breaking your DAO into a config package or something, then just having your database objects in the databaseobjects package
10. This should be an enum
11. Your tests should probably assert/check some way a post-condition. It looks like you are just relying on a lack of exceptions to mean your test succeeded?

Questions for Andrew:
1. Discuss not Springing yet.
2. In LoginSelectionPage.to...Login(), you mentioned class variables?
4. Interfaces and overloads.
5. I hate my DAO interface
6. Discuss composition with Andrew.
7. What was the purpose of comment 8 regarding instance variables?
8. You mentioned not having my DAO classes in my databaseobjects package, which led me to question: how are packages supposed to be named in general?
9. Read about single responsibility principle.

