# ESL Play Framework Template Minimal v2

Encentral Solutions Play Framework Minimal Project Template

## Necessary Files to be edited

### entities Module

#### - /src/main/resources/META-INF/persistence.xml
```xml
<property name="javax.persistence.jdbc.url" value="jdbc:postgresql://localhost:5432/{YOUR_DB_NAME}"/>
<property name="javax.persistence.jdbc.user" value="{YOUR_DB_USERNAME}"/>
<property name="javax.persistence.jdbc.password" value="{YOUR_DB_PASSWORD}"/>
```

### service-gateway Module

#### - /conf/META-INF/persistence.xml
```xml
<property name="javax.persistence.jdbc.url" value="jdbc:postgresql://localhost:5432/{YOUR_DB_NAME}"/>
<property name="javax.persistence.jdbc.user" value="{YOUR_DB_USERNAME}"/>
<property name="javax.persistence.jdbc.password" value="{YOUR_DB_PASSWORD}"/>
```

#### - /conf/application.conf
```
db.default.url="jdbc:postgresql://localhost:5432/{YOUR_DB_NAME}"

db.default.username={YOUR_DB_USERNAME}
db.default.password="{YOUR_DB_PASSWORD}"
```

NOTE: This project works well only with java 11. So to successfully run this project, be sure to have these installed on your computer.
Java 11 (Be sure to have the Oracle distribution of the Java version installed, not AdoptJdk or Correto or any other distribution).

  Next up, navigate here https://drive.google.com/file/d/1WERXVZ-SHA_uX9Gbl0KI9Z3J3_1OUn2Z/view , download the settings.xml file and place it in the .m2 maven folder of your filesystem. Make sure you delete any one you have previously so they don’t clash.

