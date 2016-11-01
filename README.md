# Spring Boot Multi Module Property Files 

This is an example project for the blog post [Spring Boot & Multi module projects - Adding module specific property files](http://wp.me/p2ZfgW-j5)

## Requirements

 * Java 1.8+
 
## Usage

After cloning the project execute

    ./gradlew bootRun
    
for the default profile case

For the *dev* profile case comment the first line out and uncomment the fourth line in  _src/main/application.properties_
Now run again
    
    ./gradlew bootRun