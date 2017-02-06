# AndroidLibraries
Shared Android Libraries of SWARM

There are three libraries now.

- core : Shared Non-UI code.

```gradle
compile 'com.swarmnyc:core:0.1'
```

- ui : Shared UI code.

```gradle
compile 'com.swarmnyc:ui:0.1'
```

- test : Shared code for Test.

```gradle
compile 'com.swarmnyc:test:0.1'
```

**mavenLocal and jCenter**

when you run 
```bash
$ gradlew bintrayUpload
```
These libraries will be uploaded to jCenter, if you just want to update them locally, you can use
```gradle
$ gradlew install
```
install task will upload libraries to mavenLocal (~/.m2/), so remember to add it in build.gradle like
```language
allprojects {
    repositories {
        mavenLocal()
        jcenter()
    }
}
```


