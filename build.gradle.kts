plugins {
    java
}

group = "com.ebran.api"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testCompile("junit", "junit", "4.12")
    compile("com.fasterxml.jackson.core","jackson-databind","2.0.1")
    compile("com.fasterxml.jackson.dataformat","jackson-dataformat-xml","2.9.0")
    compile("com.fasterxml.jackson.dataformat","jackson-dataformat-csv","2.8.8")
    compile("mysql",  "mysql-connector-java","5.1.6")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}