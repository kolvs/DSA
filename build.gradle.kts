plugins {
    id("java")
}

group = "com.laychv"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation ("com.eclipsesource.minimal-json:minimal-json:0.9.5")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}